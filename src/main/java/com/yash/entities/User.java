package com.yash.entities;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.NamedQueries;

@Entity
@Table(name="userrecords")
@NamedQueries(
		{   
			@NamedQuery(name = "FindUsers", query = "select o from User o"),
			@NamedQuery(name = "FindUserByUserId", query = "select o from User o where o.userId=:id"),
			@NamedQuery(name = "FindUserByEmail", query = "select o from User o where o.email=:email"),
        //	@NamedQuery(name = "UpdatePassword", query = "update User o set o.password=?1 where o.email=?2"),
			@NamedQuery(name = "DeleteUser", query = "delete from User o where o.userId= :id"),
			@NamedQuery(name = "checkUserIdQuery", query = "select o from User o where o.userId=?1")
		}
		)
public class User {
	
	public User() {}
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="user_id")
	    private int userId;
		@Column(name="email")
		private String email;  
		@Column(name="password")
		private String password;
		@Column(name="first_name")
		private String firstName;
		@Column(name="last_name")
		private String lastName;
			
		

		public User(int userId, String password, String firstName, String lastName, String email) {
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
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((email == null) ? 0 : email.hashCode());
			result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
			result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
			result = prime * result + ((password == null) ? 0 : password.hashCode());
			result = prime * result + userId;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			if (email == null) {
				if (other.email != null)
					return false;
			} else if (!email.equals(other.email))
				return false;
			if (firstName == null) {
				if (other.firstName != null)
					return false;
			} else if (!firstName.equals(other.firstName))
				return false;
			if (lastName == null) {
				if (other.lastName != null)
					return false;
			} else if (!lastName.equals(other.lastName))
				return false;
			if (password == null) {
				if (other.password != null)
					return false;
			} else if (!password.equals(other.password))
				return false;
			if (userId != other.userId)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "User [userId=" + userId + ", email=" + email + ", password=" + password + ", firstName=" + firstName
					+ ", lastName=" + lastName + "]";
		}

		

		

}
