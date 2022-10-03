package com.yash.helper;

public class UserDBQuery {
	
	private String selectUserQuery;
	private String UpdateUserQuery;
	private String deleteUserQuery;
	private String insertUserQuery;
	private String selectUserByIdQuery;
	private String authUserQuery;
	private String checkUserIdQuery;
	private String userByEmail;
	public UserDBQuery() {
		super();
		
	}



	public UserDBQuery(String selectUserQuery, String updateUserQuery, String deleteUserQuery, String insertUserQuery,
			String selectUserByIdQuery, String authUserQuery, String checkUserIdQuery, String userByEmail) {
		super();
		this.selectUserQuery = selectUserQuery;
		this.UpdateUserQuery = updateUserQuery;
		this.deleteUserQuery = deleteUserQuery;
		this.insertUserQuery = insertUserQuery;
		this.selectUserByIdQuery = selectUserByIdQuery;
		this.authUserQuery = authUserQuery;
		this.checkUserIdQuery = checkUserIdQuery;
		this.userByEmail = userByEmail;
	}

	public String getUserByEmail() {
		return userByEmail;
	}



	public void setUserByEmail(String userByEmail) {
		this.userByEmail = userByEmail;
	}



	public String getSelectUserQuery() {
		return selectUserQuery;
	}

	public void setSelectUserQuery(String selectUserQuery) {
		this.selectUserQuery = selectUserQuery;
	}

	public String getUpdateUserQuery() {
		return UpdateUserQuery;
	}

	public void setUpdateUserQuery(String updateUserQuery) {
		UpdateUserQuery = updateUserQuery;
	}

	public String getDeleteUserQuery() {
		return deleteUserQuery;
	}

	public void setDeleteUserQuery(String deleteUserQuery) {
		this.deleteUserQuery = deleteUserQuery;
	}

	public String getInsertUserQuery() {
		return insertUserQuery;
	}

	public void setInsertUserQuery(String insertUserQuery) {
		this.insertUserQuery = insertUserQuery;
	}

	public String getSelectUserByIdQuery() {
		return selectUserByIdQuery;
	}

	public void setSelectUserByIdQuery(String selectUserByIdQuery) {
		this.selectUserByIdQuery = selectUserByIdQuery;
	}
	
	

	public String getAuthUserQuery() {
		return authUserQuery;
	}

	public void setAuthUserQuery(String authUserQuery) {
		this.authUserQuery = authUserQuery;
	}
	

	public String getCheckUserIdQuery() {
		return checkUserIdQuery;
	}

	public void setCheckUserIdQuery(String checkUserIdQuery) {
		this.checkUserIdQuery = checkUserIdQuery;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((UpdateUserQuery == null) ? 0 : UpdateUserQuery.hashCode());
		result = prime * result + ((authUserQuery == null) ? 0 : authUserQuery.hashCode());
		result = prime * result + ((checkUserIdQuery == null) ? 0 : checkUserIdQuery.hashCode());
		result = prime * result + ((deleteUserQuery == null) ? 0 : deleteUserQuery.hashCode());
		result = prime * result + ((insertUserQuery == null) ? 0 : insertUserQuery.hashCode());
		result = prime * result + ((selectUserByIdQuery == null) ? 0 : selectUserByIdQuery.hashCode());
		result = prime * result + ((selectUserQuery == null) ? 0 : selectUserQuery.hashCode());
		result = prime * result + ((userByEmail == null) ? 0 : userByEmail.hashCode());
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
		UserDBQuery other = (UserDBQuery) obj;
		if (UpdateUserQuery == null) {
			if (other.UpdateUserQuery != null)
				return false;
		} else if (!UpdateUserQuery.equals(other.UpdateUserQuery))
			return false;
		if (authUserQuery == null) {
			if (other.authUserQuery != null)
				return false;
		} else if (!authUserQuery.equals(other.authUserQuery))
			return false;
		if (checkUserIdQuery == null) {
			if (other.checkUserIdQuery != null)
				return false;
		} else if (!checkUserIdQuery.equals(other.checkUserIdQuery))
			return false;
		if (deleteUserQuery == null) {
			if (other.deleteUserQuery != null)
				return false;
		} else if (!deleteUserQuery.equals(other.deleteUserQuery))
			return false;
		if (insertUserQuery == null) {
			if (other.insertUserQuery != null)
				return false;
		} else if (!insertUserQuery.equals(other.insertUserQuery))
			return false;
		if (selectUserByIdQuery == null) {
			if (other.selectUserByIdQuery != null)
				return false;
		} else if (!selectUserByIdQuery.equals(other.selectUserByIdQuery))
			return false;
		if (selectUserQuery == null) {
			if (other.selectUserQuery != null)
				return false;
		} else if (!selectUserQuery.equals(other.selectUserQuery))
			return false;
		if (userByEmail == null) {
			if (other.userByEmail != null)
				return false;
		} else if (!userByEmail.equals(other.userByEmail))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserDBQuery [selectUserQuery=" + selectUserQuery + ", UpdateUserQuery=" + UpdateUserQuery
				+ ", deleteUserQuery=" + deleteUserQuery + ", insertUserQuery=" + insertUserQuery
				+ ", selectUserByIdQuery=" + selectUserByIdQuery + ", authUserQuery=" + authUserQuery
				+ ", checkUserIdQuery=" + checkUserIdQuery + ", userByEmail=" + userByEmail + "]";
	}
	
	
}
	