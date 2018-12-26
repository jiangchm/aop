package jcm.bo;

public class User {
	
	private int id ;
	
	private String username ;
	
	private String phone ;

	public int getId() {
		return id;
	}

	public User() {
		super();
	}

	public void setId(int id) {
		this.id = id;
	}

	public User(String username, String phone) {
		this.username = username;
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", phone=" + phone
				+ "]";
	}
	
	

}
