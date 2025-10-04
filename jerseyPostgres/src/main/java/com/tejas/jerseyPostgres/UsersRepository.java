package com.tejas.jerseyPostgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersRepository {
	String BASE_URL = "jdbc:postgresql://localhost:5432/JavaHibDB";
    String PASSWORD = "1234";
    String USER = "postgres";
	Connection con = null;
	
	
	public UsersRepository() {
	    try {
	    	Class.forName("org.postgresql.Driver");
	    	con = DriverManager.getConnection(BASE_URL, USER, PASSWORD);
	    } catch (Exception e) {
	        System.out.println("Error creating database connection: "+e.getMessage());
	    }
	}
	
	public List<Users> getUsers() {
		List<Users> users = new ArrayList<>();
		
		String statement = "select * from users_table1";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(statement);
			
			while(rs.next()) {
				Users user = new Users();
				
				user.setUid(rs.getInt(1));
				user.setName(rs.getString(2)+" "+rs.getString(3));
				
				users.add(user);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return users;
	}
	
	public Users getUser(int uid) {
		Users user = new Users();
		
		String statement = "select * from users_table1 where uid=?";
		PreparedStatement st;
		try {
			st = con.prepareStatement(statement);
			st.setInt(1, uid);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {				
				user.setUid(rs.getInt(1));
				user.setName(rs.getString(2)+" "+rs.getString(3));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return user;
	}	
	
	public void addUser(Users user) {
		String[] name = user.getName().split("  ");
		
		String insertSt = "insert into users_table1 values (?,?,?);";
		
		try (PreparedStatement st = con.prepareStatement(insertSt);) {
			st.setInt(1, user.getUid());
			st.setString(2, name[0]);
			st.setString(3, name[1]);
			
			st.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return;
	}
	
	public void updateUser(Users user) {
		String[] name = user.getName().split("  ");
		
		String updateSt = "update users_table1 set fname = ?, lname = ? where uid = ?";
		
		try (PreparedStatement st = con.prepareStatement(updateSt);) {
			st.setString(1, name[0]);
			st.setString(2, name[1]);
			st.setInt(3, user.getUid());
			
			st.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return;
	}
	
	public void deleteUser(int id) {
		
		String deleteSt = "delete from users_table1 where uid = ?;";
		
		try (PreparedStatement st = con.prepareStatement(deleteSt);) {
			st.setInt(1, id);
			
			st.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return;
	}
}
