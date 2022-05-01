/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customerPackage;

import customerPackage.BestSellerForm;
import customerPackage.BillForm;
import customerPackage.WaiterOrderForm;
import customerPackage.Order;
import khakejaorestaurant.MyConnection;
import khakejaorestaurant.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import managerPackage.Manager;
import menuItems.Inventory;
import menuItems.MainMenu;
import menuItems.MenuItem;
import starting.RoleLoginForm;
import starting.RoleLoginForm;
import starting.RoleSignUpForm;
import starting.RoleSignUpForm;

/**
 *
 * @author sriha
 */
public class Waitor extends User {

	private String address, wname, wusername,wphone;

	public String getWphone() {
		return wphone;
	}

	public void setWphone(String wphone) {
		this.wphone = wphone;
	}

	public String getWname() {
		return wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

	public String getWusername() {
		return wusername;
	}

	public void setWusername(String wusername) {
		this.wusername = wusername;
	}
	private int id;
	private ArrayList<Order> orders = new ArrayList<>(); //list of all customer's orders
	private Order tempOrder = new Order(); //to be able to access class order, current order
//	public static final String orderType = "dinein";

	public int getId() {
		return id;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public Waitor(int id, String name, String username, String password, String mobilePhone, ArrayList<Order> o) {
		super(name, username, password, mobilePhone);
		this.id = id;
		this.address = address;
		this.orders = o;
	}

	public Waitor(int id, String name, String username, String mobilePhone, String password, String address) {
		super(name, username, mobilePhone, password);
		this.id = id;
		this.address = address;
		System.out.println("Test Logging1");
	}

	public void placeOrders(Order order) {
		tempOrder = order; //it contains the current order of the customer(the order being processed)
		orders.add(order);
	}

	public void complain(String message) {
		tempOrder.setComplainMessage(message);
	}

	public void rating(String foodItem, double rate) {
		tempOrder.ratings.put(foodItem, rate);
	}

	public void returnOrder(Order order) //a search in jframe with order id then send the order itself to the function
	{
		orders.remove(order);
	}

	public void cancelOrder() {
		//Date currentTime = new Date();
		long currentTime = System.currentTimeMillis();
		//check if 5 minutes or less has passed
		Date cancellationTime = new Date(tempOrder.getCanelTimeInMillis());
		System.out.println(cancellationTime);
		/*currentTime.equals(cancellationTime) || currentTime.before(cancellationTime)*/
		if (tempOrder.getCanelTimeInMillis() > currentTime && !BillForm.delivered) {
			returnOrder(tempOrder);
			BillForm.returned = true;
			JOptionPane.showMessageDialog(null, "The order has been cancelled\nThank you for your visit", "Cancel", JOptionPane.INFORMATION_MESSAGE);
		} //more than 5 minutes has passed
		else {
			JOptionPane.showMessageDialog(null, "Unfortunately you can't cancel the order now", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public String getAddress() {
		return address;
	}

	public Order getTempOrder() {
		return tempOrder;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public String getName() {
		return name;
	}

	public void setTempOrder(Order tempOrder) {
		this.tempOrder = tempOrder;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static int getNoWaitors() //for genearting id numbers of new customers
	{
		int count = 0;
		try {
			PreparedStatement preparedStmt = MyConnection.getConnection().prepareStatement("SELECT count(*) FROM menu_item.customer");
			ResultSet rs = preparedStmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count(*)");
			}
		} catch (SQLException ex) {
			Logger.getLogger(Waitor.class.getName()).log(Level.SEVERE, null, ex);
		}
		return count;

	}

	public Waitor() {
	}

	@Override
	public boolean register() {
		boolean registered = false; //to hide signup form if successfully signed in
		PreparedStatement ps = null;
		ResultSet rs;
		String query = "SELECT * FROM customer WHERE customer_username = ?";
		try {
			ps = MyConnection.getConnection().prepareStatement(query);
			ps.setString(1, this.userName);
			rs = ps.executeQuery();
			if (rs.next()) //check if username already exists to prevent duplicate entries
			{
				JOptionPane.showMessageDialog(null, "This Username Already Exists");
				RoleSignUpForm.setTextField();
				return registered;
			} else {
				query = "INSERT INTO `customer`(`customer_username`, `customer_mobile`, `customer_password`, `customer_name`, `customer_address`, `customer_id`, `customer_listOfOrders`) VALUES (?,?,?,?,?,?,?)";
				ps = MyConnection.getConnection().prepareStatement(query);

				String encrypted = User.encryptThisString(this.password);
				ps.setString(1, this.userName);
				ps.setString(2, this.mobilePhone);
				ps.setString(3, encrypted);
				ps.setString(4, this.name);
				ps.setString(5, this.address);
				ps.setInt(6, this.id);
				ps.setString(7, null);
				this.password = encrypted;
				if (ps.executeUpdate() > 0) {
					WaiterOrderForm cf = new WaiterOrderForm(this, null, orderType);
					cf.setVisible(true);
					registered = true;
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(Waitor.class.getName()).log(Level.SEVERE, null, ex);
		}
		return registered;
	}

	
	@Override
	public boolean login(String username, String password) {
		boolean loggedIn = false;
		PreparedStatement ps;
		ResultSet rs;
		String query = "SELECT * FROM waitors WHERE username=? AND  password=?";
		try {
			ps = MyConnection.getConnection().prepareStatement(query);
			String encrypted = User.encryptThisString(password);
			ps.setString(1, username);
			ps.setString(2, encrypted);
			rs = ps.executeQuery();
			if (rs.next()) {
				String wphone = rs.getString("waitor_contact");
				String wname = rs.getString("waitor_name");
				String waddress = rs.getString("waitor_address");
				int wid = rs.getInt("waitor_id");
				String ordersString = rs.getString("waitor_listOfOrders");
				if (ordersString != null) {
					this.orders = convertStringtoOrders(ordersString);
				} else {
					ordersString = null;
				}
				Waitor w = new Waitor(wid, wname, username, wphone, password, waddress);
				System.out.println("idena moddalodi"+w.getId());
				OrderForm of = new OrderForm(w, ordersString);
				of.setVisible(true);
				loggedIn = true;
			} else {
				RoleLoginForm.setTextFields();
				JOptionPane.showMessageDialog(null, "Username or password incorrect.", "Login Failed", JOptionPane.ERROR_MESSAGE);
			}

		} catch (SQLException ex) {
			Logger.getLogger(Waitor.class.getName()).log(Level.SEVERE, null, ex);
		}
		return loggedIn;
	}

	public int checkDispatchStatusInWaitor(int order_id) {

		PreparedStatement ps;
		ResultSet rs;
		String query = "SELECT * FROM waitors WHERE order_id=(?);";
		try {
			String encrypted = User.encryptThisString(password);
			ps = MyConnection.getConnection().prepareStatement(query);
			ps.setInt(1, order_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				int status = rs.getInt("status");
				return status;
			}
		} catch (SQLException ex) {
			System.out.println("fail");
			Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
		}
		return -1;

	}

	private ArrayList<Order> convertStringtoOrders(String s) //converts order ids read from db to objects of order
	{
		ArrayList<Order> OrderItems = new ArrayList<>();
		Order o;
		String[] order = s.split("/");
		for (String a : order) {
			int x = Integer.valueOf(a);
			PreparedStatement ps = null;
			ResultSet rs;
			String query = "SELECT * FROM order_info WHERE order_id = ?";
			try {
				ps = MyConnection.getConnection().prepareStatement(query);
				ps.setInt(1, x); //order id
				rs = ps.executeQuery();
				if (rs.next()) {
					String wid = String.valueOf(this.id);
					String wname = this.name;
					String oid = String.valueOf(x);
					String caddress = this.address;
					String cmobile = this.mobilePhone;
					String oname = rs.getString("order_cutomerName");
//                    String oboy = rs.getString("order_deliveryBoy");
//                    String ocomplain = rs.getString("order_complainMessage");

					//String ostatus = rs.getString("order_receivedStatus");
					boolean status = rs.getBoolean("order_receivedStatus");
					//boolean status = /*Boolean.valueOf(*/ostatus/*)*/;

					DateFormat dateFormat = new SimpleDateFormat("h:mm aa");
					//Date orderStartTime = dateFormat.parse(rs.getString("order_StartTime"));
					//Date deliveryTime = dateFormat.parse(rs.getString("order_deliveryTime"));
//                    long startinMillis = rs.getLong("order_startTime");
//                    long deliveryinMillis = rs.getLong("order_deliveryTime");

					HashMap<String, Integer> orderList = new HashMap<>();

					String menuString = rs.getString("order_menuItemList");
					String[] allOrders = menuString.split("&");
					for (String z : allOrders) {
						String[] specific = z.split("#");
						for (String aa : specific) {
							int q = Integer.valueOf(specific[1]);
							orderList.put(specific[0], q);
						}
					}
					o = new Order(oid, wid, wname, caddress, cmobile);
					//o.setOrderStartTime(orderStartTime);
//                    o.setComplainMessage(ocomplain);
					//o.setDeliveryTime(deliveryTime);
//                    o.setStartTimeInMillis(startinMillis);
//                    o.setDeliveryTimeInMillis(deliveryinMillis);
					o.setStatus(status);
					System.out.println(o.getId() + " " + status + " " + o.getStatus() + " in reading orders_info in customer class");
//                    o.setAssociatedDeliveryBoyId(oboy);
					o.setOrderList(orderList);
					OrderItems.add(o);
				} else {
					JOptionPane.showMessageDialog(null, "Order not found");
				}

			} catch (SQLException ex) {
				Logger.getLogger(Waitor.class
					.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return OrderItems;
	}

	public static void viewBestSellers() {
		ArrayList<MenuItem> orderedList;
		for (String category : MainMenu.categoryList.keySet()) {

			orderedList = MainMenu.categoryList.get(category);
			Collections.sort(orderedList, Collections.reverseOrder());

			String bestItem = orderedList.get(0).getItemName();
			String rate = String.valueOf(orderedList.get(0).getItemRate());
			String numberOfRates = String.valueOf(Inventory.inventoryList.get(orderedList.get(0).getItemName()).getNumberOfRates());

			BestSellerForm.jTextArea1.append("From " + category + ": \n");
			BestSellerForm.jTextArea1.append(bestItem + ",  ");
			BestSellerForm.jTextArea1.append("rated " + rate + "/5  by " + numberOfRates + " users.");
			BestSellerForm.jTextArea1.append("\n\n");
		}
	}

}
