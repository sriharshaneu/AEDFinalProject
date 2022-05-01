package starting;

import khakejaorestaurant.MyConnection;
import khakejaorestaurant.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import managerPackage.Manager;
import managerPackage.ManagerWelcomeForm;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author sreyasborra
 */
public class Chef extends User {

	private String username;
	private String password;
	private String mobilePhone;

	private int chef_order_id;
	private int order_id;
	private int status;

	public Chef(String username, String password, String mobilePhone) {
		this.username = username;
		this.password = password;
		this.mobilePhone = mobilePhone;
	}

	Chef() {
	}

	public int getChef_order_id() {
		return chef_order_id;
	}

	public void setChef_order_id(int chef_order_id) {
		this.chef_order_id = chef_order_id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public boolean updateDispatchStatusInChef(int order_id) {

		PreparedStatement ps;
		ResultSet rs;
		String query = "SELECT * FROM chef_orders WHERE order_id=(?);";
		try {
			ps = MyConnection.getConnection().prepareStatement(query);
			ps.setInt(1, order_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				String orderType = rs.getString("order_type");
				return confirmOrderDispatch(order_id);
			}
		} catch (SQLException ex) {
			System.out.println("fail");
			Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
		}

		return false;
	}

	public boolean confirmOrderDispatch(int order_id) {

		PreparedStatement ps;
		ResultSet rs;
		String QUERY = "UPDATE chef_orders SET status = 1 WHERE order_id = (?);";
		try {
			ps = MyConnection.getConnection().prepareStatement(QUERY);
			ps.setInt(1, order_id);
			int update = ps.executeUpdate();

			if (update >= 1) {
				return true;
			}

		} catch (SQLException ex) {
			Logger.getLogger(Chef.class.getName()).log(Level.SEVERE, null, ex);
		} catch (Exception e) {
			Logger.getLogger(Chef.class.getName()).log(Level.SEVERE, null, e);
		}
		return false;
	}

	@Override
	public boolean login(String username, String password) {
		boolean loggedIn = false;
		PreparedStatement ps;
		ResultSet rs;
		String query = "SELECT * FROM chef WHERE username=? AND  password=?";
		try {
			String encrypted = User.encryptThisString(password);
			ps = MyConnection.getConnection().prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, encrypted);
			rs = ps.executeQuery();
			if (rs.next()) {
				String mobilePhone = rs.getString("mobile_phone");
				Chef chef = new Chef(username, password, mobilePhone);
				ChefLoginWindow chefLoginWindow = new ChefLoginWindow(chef);
				chefLoginWindow.setVisible(true);
				loggedIn = true;
			} else {
				RoleLoginForm.setTextFields();
				JOptionPane.showMessageDialog(null, "Username or password incorrect.", "Login Failed", JOptionPane.ERROR_MESSAGE);
			}

		} catch (SQLException ex) {
			System.out.println("fail");
			Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
		}
		return loggedIn;
	}

	@Override
	public boolean register() {
		boolean registered = false;
		PreparedStatement ps;
		ResultSet rs;
		String query = "SELECT * FROM chef WHERE username =?";
		try {
			ps = MyConnection.getConnection().prepareStatement(query);
			ps.setString(1, this.userName);
			rs = ps.executeQuery();
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "This Username Already Exists");
				RoleSignUpForm.setTextField();
			} else {
				query = "INSERT INTO `chef`(`username`, `password`, `mobile_phone`) VALUES (?,?,?)";
				ps = MyConnection.getConnection().prepareStatement(query);

				String encrypted = User.encryptThisString(this.password);
				this.password = encrypted;
				ps.setString(1, this.userName);
				ps.setString(2, this.password);
				ps.setString(3, this.mobilePhone);

				if (ps.executeUpdate() > 0) {
					//JOptionPane.showMessageDialog(null, "New User Add");
					Chef chef = new Chef(this.userName, this.password, this.mobilePhone);
					ChefLoginWindow chefLoginWindow = new ChefLoginWindow(chef);
					registered = true;
					chefLoginWindow.setVisible(true);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
		}
		return registered;
	}

	/**
	 *
	 * @param username
	 * @param password
	 * @return
	 */
}
