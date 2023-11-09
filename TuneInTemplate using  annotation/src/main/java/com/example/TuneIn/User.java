package com.example.TuneIn;


import org.springframework.stereotype.Component;

import com.example.TuneIn.Playlist;
 @Component
public interface User {

    void setUserDetail(String name,Integer age);

    Playlist getPlaylist();
}

