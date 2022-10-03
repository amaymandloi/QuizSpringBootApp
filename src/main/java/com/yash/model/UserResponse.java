package com.yash.model;


import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserResponse {

	@Id
	private int userId;
	private String email;
	private String password;
	private String firstName;
	private String lastName;

	private UserError userError;

	public UserError getUserError() {
		return userError;
	}

	public void setUserError(UserError userError) {
		this.userError = userError;
	}

	public UserResponse() {
	}

	public UserResponse(int userId, String password, String firstName, String lastName, String email) {
			super();
			this.userId = userId;
			this.email = email;
			this.password = password;
			this.firstName = firstName;
			this.lastName = lastName;
		}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "UserRequest [userId=" + userId + ", email=" + email + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + "]";
	}

}
