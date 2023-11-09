package com.example.TuneIn;

import java.util.List;

import org.springframework.stereotype.Component;
 @Component
public interface Playlist {

    void addSong(Song song);

    List<Song> getPlaylistSongs();

    Integer getCount();

}


