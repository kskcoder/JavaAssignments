package com.tejas.SpringJDBC.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tejas.SpringJDBC.model.Users;

@Repository
public class UserRepo {
	
	private JdbcTemplate template;
	
	public void save(Users user) {
		String statement = "insert into users (userid, fname, lname) values (?, ?, ?)";
		template.update(statement, user.getUserid(), user.getFname(), user.getLname());
	}
	
	public List<Users> findAll() {
		
		String insertSt = "select * from users;";
		
		RowMapper<Users> rm = new RowMapper<Users>() {

			@Override
			public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
				Users user = new Users();
				user.setUserid(rs.getInt(1));
				user.setFname(rs.getString(2));
				user.setLname(rs.getString(3));
				
				return user;
			}
			
		};
				
		List<Users> users = template.query(insertSt, rm);
		
		return users;
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	
}
