package com.example.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.repository.UsersRepository;

@Service
public class UsersServicesImplementation implements UsersServices
{
	@Autowired
	UsersRepository ur;
	
	@Override
	public String addUsers(Users user) {
		ur.save(user);
		return null;
	}

	@Override
	public boolean emailExists(String email) {
		if(ur.findByEmail(email) == null)
		{
			return false;
		}
		return true;
	}

	@Override
	public boolean validateUser(String email, String password) 
	{
		Users user = ur.findByEmail(email);
		if(password.equals(user.getPassword()))
		{
			return true;
		}
		return false;
	}

	@Override
	public String getUserRole(String email) {
		Users user = ur.findByEmail(email);
		return user.getRole();
	}

	@Override
	public Users getUser(String email) {
		return ur.findByEmail(email);
	}

	@Override
	public void updateUser(Users user) {
		ur.save(user);
		
	}	
	
	
	
}
