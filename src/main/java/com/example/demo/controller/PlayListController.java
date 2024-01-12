package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Playlist;
import com.example.demo.entity.Song;
import com.example.demo.services.PlaylistService;
import com.example.demo.services.SongService;

@Controller
public class PlayListController 
{
	@Autowired
	SongService ss;
	
	@Autowired
	PlaylistService ps;
	
	@GetMapping("/createPlaylist")
	public String createPlayList(Model model)
	{
		List<Song> songList = ss.fetchAllSongs();
		model.addAttribute("songs",songList);
		return "createPlaylist";
	}
	
	@PostMapping("/addPlaylist")
	public String addPlayList(@ModelAttribute Playlist playlist)
	{
		ps.addPlayList(playlist);
		System.out.println(playlist);
		List<Song> songList = playlist.getSong();
		for(Song s : songList)
		{
			s.getPlaylists().add(playlist);
			ss.updateSong(s);
		}
		return "adminHome";
	}
	
	@GetMapping("/viewPlaylists")
	public String viewPlaylist(Model model)
	{
		List<Playlist> allPlaylists = ps.fetchAllPlaylists();
		model.addAttribute("allPlaylists",allPlaylists);
		return "displayPlaylist";
	}
}
