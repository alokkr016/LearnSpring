package com.example.TuneIn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * 1. Add class attributes.
 * 2. Override all the interface methods.
 * 3. Implement setter injection
 */

 @Component
public class MyPlaylist implements Playlist {
    Integer count = 0;
    @Autowired
    Song mySong;
    List<Song> songsList = new ArrayList<>();
    @Override
    public void addSong(Song song) {
       songsList.add(song);
       count++;
    }

    @Override
    public List<Song> getPlaylistSongs() {
        return this.songsList;

    }

    @Override
    public Integer getCount() {
        
       return this.count;
    }

    

}