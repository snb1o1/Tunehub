package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Playlist;
import com.example.demo.repository.PlaylistRepository;

@Service
public class PlaylistServiceImplementation implements PlaylistService
{
	@Autowired
	PlaylistRepository pr;

	@Override
	public String addPlayList(Playlist playlist) {
		pr.save(playlist);
		return null;
	}

	@Override
	public List<Playlist> fetchAllPlaylists() {
		return pr.findAll();
	}
	
	
	

}
