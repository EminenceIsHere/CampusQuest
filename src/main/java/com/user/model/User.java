package com.user.model;

public class User {
	
	private int id;
	private String uname;
	private String email;
	private long year;
	private String passwd;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String uname, String email, long year, String passwd) {
		super();
		this.id = id;
		this.uname = uname;
		this.email = email;
		this.year = year;
		this.passwd = passwd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return uname;
	}

	public void setName(String uname) {
		this.uname = uname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getYear() {
		return year;
	}

	public void setYear(long l) {
		this.year = l;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + ", email=" + email + ", year=" + year + ", passwd=" + passwd
				+ "]";
	}
	
	
	

}
