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
import starting.Chef;
import starting.ChefLoginWindow;
import starting.OwnerLoginWindow;
import starting.RoleLoginForm;
import starting.RoleSignUpForm;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sreyasborra
 */
public class Owner extends User{
    private String username;
	private String password;
	private String mobilePhone;

	Owner() {
		
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

	public Owner(String username, String password, String mobilePhone) {
		this.username = username;
		this.password = password;
		this.mobilePhone = mobilePhone;
	}
	public boolean login(String username, String password) {
		boolean loggedIn = false;
		PreparedStatement ps;
		ResultSet rs;
		String query = "SELECT * FROM owner WHERE owner_username=? AND  owner_password=?";
		try {
			String encrypted = User.encryptThisString(password);
			ps = MyConnection.getConnection().prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, encrypted);
			rs = ps.executeQuery();
			if (rs.next()) {
				String phone = rs.getString("owner_phone");
				Owner owner = new Owner(username, password, phone);
				OwnerLoginWindow ownLoginWin = new OwnerLoginWindow(owner);
				ownLoginWin.setVisible(true);
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
		String query = "SELECT * FROM owner WHERE username =?";
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
					Owner owner = new Owner(this.userName, this.password, this.mobilePhone);
					OwnerLoginWindow ownLoginWin = new OwnerLoginWindow(owner);
					registered = true;
					ownLoginWin.setVisible(true);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
		}
		return registered;
	}
}
