/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customerPackage;

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
import starting.MusicBand;
import starting.RoleLoginForm;
import starting.RoleSignUpForm;

/**
 *
 * @author sriha
 */
public class MusicBandModel extends User {

	private String username;
	private String password;
	private String phoneNumber;
	private String name;

	public MusicBandModel(String name, String username, String password, String phoneNumber) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

	public MusicBandModel() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public boolean login(String username, String password) {
		boolean loggedIn = false;
		PreparedStatement ps;
		ResultSet rs;
		String query = "SELECT * FROM music_band WHERE username=? AND  password=?";
		try {
			String encrypted = User.encryptThisString(password);
			ps = MyConnection.getConnection().prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, encrypted);
			rs = ps.executeQuery();
			if (rs.next()) {
				String mobilePhone = rs.getString("phone_number");
				MusicBandModel band = new MusicBandModel(name, username, password, mobilePhone);
				MusicBand musicband = new MusicBand(band, username);
				musicband.setVisible(true);
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
		String query = "SELECT * FROM music_band WHERE username =?";
		try {
			ps = MyConnection.getConnection().prepareStatement(query);
			ps.setString(1, this.userName);
			rs = ps.executeQuery();
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "This Username Already Exists");
				RoleSignUpForm.setTextField();
			} else {
				query = "INSERT INTO `music_band`(`username`, `password`, `band_name`, 'phone_number') VALUES (?,?,?.?)";
				ps = MyConnection.getConnection().prepareStatement(query);

				String encrypted = User.encryptThisString(this.password);
				this.password = encrypted;
				ps.setString(1, this.username);
				ps.setString(2, this.password);
				ps.setString(3, this.name);
				ps.setString(3, this.mobilePhone);

				if (ps.executeUpdate() > 0) {
					//JOptionPane.showMessageDialog(null, "New User Add");
					MusicBandModel mbModel = new MusicBandModel(this.name, this.userName, this.password, this.mobilePhone);
					MusicBand mb = new MusicBand(mbModel, userName);
					registered = true;
					mb.setVisible(true);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
		}
		return registered;
	}
}
