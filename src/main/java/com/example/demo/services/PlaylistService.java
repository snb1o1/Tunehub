package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Playlist;

public interface PlaylistService 
{
	public String addPlayList(Playlist playlist);

	public List<Playlist> fetchAllPlaylists();
}
