package starting;

// code here


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

	
	/**
	 *
	 * @param username
	 * @param password
	 * @return
	 */
}
