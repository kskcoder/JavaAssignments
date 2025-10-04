package com.tejas.springmvcboot;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tejas.springmvcboot.model.Users;

public interface UsersRepo extends JpaRepository<Users, Integer> {

	List<Users> getByFnameOrderByUseridDesc(String fname);
	
	@Query("from Users where fname = :uname")
	List<Users> getUsersByFname(@Param("uname") String uname);
}
