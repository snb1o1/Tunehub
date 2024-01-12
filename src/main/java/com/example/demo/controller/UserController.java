package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Users;
import com.example.demo.services.UsersServices;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController 
{
	@Autowired
	UsersServices us;
	
	@PostMapping("/view")
	public String addUsers(@ModelAttribute Users user)
	{
		boolean status = us.emailExists(user.getEmail());
		if(status == false)
		{
			us.addUsers(user);
		}
		else
		{
			System.out.println("User already exist");
		}
		return "view";
	}
	
	@PostMapping("/validate")
	public String validateUser(@ModelAttribute Users user,HttpSession session)
	{
		if(us.validateUser(user.getEmail(),user.getPassword()) == true)
		{
			String role = us.getUserRole(user.getEmail());
			session.setAttribute("email", user.getEmail());
			if(role.equals("admin"))
			{
				return "adminHome";
			}
			else 
			{
				return "customerHome";
			}
		}
		else
		{
			return "login";
		}
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "login";
	}
}
