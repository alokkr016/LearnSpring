package com.example.TuneIn;

/*
 * 1. Add class attributes.
 * 2. Override all the interface methods.
 * 3. Implement setter injection
 */

public class MyUser implements User {
    String name;
    Integer age;
    Playlist playlist;
    public void setPlaylist(Playlist playlist){
        this.playlist = playlist;
    }

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
