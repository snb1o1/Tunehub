package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Song;
import com.example.demo.services.SongService;

@Controller
public class SongController 
{
	@Autowired
	SongService ss;
	
	@PostMapping("/addSong")
	public String addSong(@ModelAttribute Song song)
	{
		boolean songStatus = ss.songExist(song.getName());
		if( songStatus == false )
		{
			ss.addSong(song);
			System.out.println("Song Added Successfully");
		}
		else
		{
			System.out.println("Song Already exist");
			return "adminHome";
		}
		return "adminHome";
	}
	
	@GetMapping("/viewSongs")
	public String viewSongs(Model model)
	{
		model.addAttribute("songs",ss.fetchAllSongs());
		return "viewSongs";
	}
	
	@GetMapping("/playSongs")
	public String playSongs(Model model)
	{
		boolean premiumUser = false;
		if(premiumUser == true)
		{
			model.addAttribute("songs",ss.fetchAllSongs());
			return "viewSongs";
		}
		else
		{
			return "makePayment";
		}
	}
}
