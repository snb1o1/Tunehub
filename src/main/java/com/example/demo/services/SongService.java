package com.example.demo.services;

import com.example.demo.entity.Song;
import java.util.*;

public interface SongService 
{

	public void addSong(Song song);

	public List<Song> fetchAllSongs();

	public boolean songExist(String name);

	public void updateSong(Song s);

}
