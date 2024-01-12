package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Song;
import com.example.demo.repository.SongRepository;

@Service
public class SongServiceImplementation implements SongService 
{
	@Autowired
	SongRepository sr;
	
	@Override
	public void addSong(Song song) {
		sr.save(song);
	}

	@Override
	public List<Song> fetchAllSongs() {
		return sr.findAll();
	}

	@Override
	public boolean songExist(String songName) {
		if(sr.findByName(songName) == null)
		{
			return false;
		}
		return true;
	}

	@Override
	public void updateSong(Song s) {
		sr.save(s);
		
	}
	
	
	
	
}
