package com.yash.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Comment;

import com.yash.validation.UserIdConstraint;

@XmlRootElement
public class UserRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@UserIdConstraint
	private int userId;
	
		@Email(message="email is not valid")
		private String email;
		@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,25}$",message="password must contain at least 1 small letter, 1 CAPITAL letter, 1 numeric value and 1 speical character")
		@Size(min=8,max=25,message="password length must be greater than 8 and less than 25")
		private String password;
		@NotBlank(message="{com.yash.model.UserRequest.firstName.blank}")
		private String firstName;
		private String lastName;
			
		public UserRequest() {}

	

		public UserRequest(int userId, String email, String password,
				@NotBlank(message = "{com.yash.model.UserRequest.firstName.blank}") String firstName, String lastName) {
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
