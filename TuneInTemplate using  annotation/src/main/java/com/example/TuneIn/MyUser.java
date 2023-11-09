package com.example.TuneIn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * 1. Add class attributes.
 * 2. Override all the interface methods.
 * 3. Implement setter injection
 */

@Component
public class MyUser implements User {
    String name;
    Integer age;
    @Autowired
    Playlist playlist;

    @Override
    public void setUserDetail(String name, Integer age) {
        // TODO Auto-generated method stub
        this.age = age;
        this.name = name;
    }

    @Override
    public Playlist getPlaylist() {
        // TODO Auto-generated method stub
        return playlist;
    }

}
