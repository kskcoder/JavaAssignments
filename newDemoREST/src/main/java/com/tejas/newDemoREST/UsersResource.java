 package com.tejas.newDemoREST;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("users")
public class UsersResource {
	private static UsersRepository ur = new UsersRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Users> getUsers() {
		return ur.getUsers();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("user/{id}")
	public Users getUser(@PathParam("id")int id) {
		return ur.getUser(id);
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("user")
	public Users addUser(Users user) {
		ur.addUser(user);
		
		return user;
	}
	
}
