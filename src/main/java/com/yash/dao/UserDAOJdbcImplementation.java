package com.yash.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.entities.User;
import com.yash.integrate.ConnectionManager;
import com.yash.helper.UserDBQuery;

@Repository("jdbcUserDAOImplementation")
public class UserDAOJdbcImplementation implements UserDAO {
	
	@Autowired
	private ConnectionManager connectionManager;
	
	@Autowired
	private UserDBQuery userDBQuery;

	public List<User> getAllUsers()  {
		List<User> listOfUsers=new ArrayList<User>();

		try {
			Connection connection=connectionManager.openConnection();
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(userDBQuery.getSelectUserQuery());
			
			while(resultSet.next()) {
				User user=new User();
				user.setUserId(resultSet.getInt("user_id"));
				user.setFirstName(resultSet.getString("first_name"));
				user.setLastName(resultSet.getString("last_name"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));

				//user.setIsAdmin(resultSet.getInt("is_admin"));
				listOfUsers.add(user);
				
			}
			connectionManager.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		for(User users:listOfUsers) {
			System.out.println(users);
		}
		return listOfUsers;
			
	}
	

	public User getUserByUserId(int userId)  {
		
		User user = new User();
		
		try {
			Connection connection=connectionManager.openConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(userDBQuery.getSelectUserByIdQuery());
			ResultSet resultSet=preparedStatement.executeQuery();
			preparedStatement.setInt(1, userId);
			
			while(resultSet.next()) {
			user.setUserId(resultSet.getInt("user_id"));
			user.setFirstName(resultSet.getString("first_name"));
			user.setLastName(resultSet.getString("last_name"));
			user.setEmail(resultSet.getString("email"));
			user.setPassword(resultSet.getString("password"));
			//user.setIsAdmin(resultSet.getInt("is_admin"));
		}
			connectionManager.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return user;
	}

	public boolean storeUserDetails(User user) {

		int rows=0;
		try {
		Connection connection=connectionManager.openConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(userDBQuery.getInsertUserQuery());
		
		preparedStatement.setInt(1, user.getUserId());
		preparedStatement.setString(2, user.getFirstName());
		preparedStatement.setString(3, user.getLastName());
		preparedStatement.setString(4, user.getEmail());
		preparedStatement.setString(5, user.getPassword());
		
		rows=preparedStatement.executeUpdate();
		connectionManager.closeConnection();
	} catch (SQLException e) {
		e.printStackTrace();
	} 
		if (rows>0)
		   return true;
		else
			return false;
	}

	public boolean updatePassword(String password, String email) {
		Connection connection=connectionManager.openConnection();
		int rows=0;
		try {
			PreparedStatement statement=connection.prepareStatement(userDBQuery.getUpdateUserQuery());
			statement.setString(1, password);
			statement.setString(2, email);
			
			rows=statement.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		connectionManager.closeConnection();
		if(rows>0)
		return true;
		else
		return false;	
		}
	public boolean deleteUserByUserId(int userId) {
		
		int rows=0;
		User userObjectForDeleteOperation = new User();
		try {
		Connection connection=connectionManager.openConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(userDBQuery.getDeleteUserQuery());
		preparedStatement.setInt(1, userObjectForDeleteOperation.getUserId());
		
		preparedStatement.executeUpdate();
		connectionManager.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
			if (rows>0)
			   return true;
			else
				return false;
			
			
	}

	@Override
	public boolean authUser(String userName, String password){
		boolean ifUserFound=false;
		try {
		Connection connection=connectionManager.openConnection();
		PreparedStatement statement=connection.prepareStatement(userDBQuery.getAuthUserQuery());
		statement.setString(1, userName);
		statement.setString(2, password);
		ResultSet resultSet=statement.executeQuery();
		while(resultSet.next()) {
			ifUserFound=true;
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return ifUserFound;
	}
	
	@Override
	public boolean updateUser(User user) {
		Connection connection=connectionManager.openConnection();
		int rows=0;
        try {
			PreparedStatement statement=connection.prepareStatement(userDBQuery.getUpdateUserQuery());
		    
			statement.setInt(1, user.getUserId());
			statement.setString(2, user.getEmail());;
			statement.setString(3, user.getPassword());
		    statement.setString(2, user.getFirstName());
		    statement.setString(5, user.getLastName());
		    
		     rows=statement.executeUpdate();
		     System.out.println(rows);
		  connectionManager.closeConnection();
        } catch (SQLException e) {
			e.printStackTrace();
		}
        if(rows>0)
        	return true;
        else
        	return false;
		
	}
	
	public boolean checkUserId(int userId) {
		Connection connection=connectionManager.openConnection();
		boolean result=false;
        try {
			PreparedStatement statement=connection.prepareStatement(userDBQuery.getCheckUserIdQuery());
		    statement.setInt(1, userId);
		    ResultSet resultSet=statement.executeQuery();
		    while(resultSet.next()) {
		    	result=true;
		    }
			  connectionManager.closeConnection();

        } catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

@Override
public User getUserByEmail(String email)  {
		
		User user = new User();
		
		try {
			Connection connection=connectionManager.openConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(userDBQuery.getUserByEmail());	
			preparedStatement.setString(1, email);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
			user.setUserId(resultSet.getInt("user_id"));
			user.setFirstName(resultSet.getString("first_name"));
			user.setLastName(resultSet.getString("last_name"));
			user.setEmail(resultSet.getString("email"));
			user.setPassword(resultSet.getString("password"));
			//user.setIsAdmin(resultSet.getInt("is_admin"));
		}
			connectionManager.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return user;
	}






	
}
