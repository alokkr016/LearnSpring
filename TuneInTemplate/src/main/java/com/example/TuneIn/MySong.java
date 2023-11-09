package com.example.TuneIn;

/*
 * 1. Add class attributes.
 * 2. Override all the interface methods.
 * 3. Implement setter injection
 */

public class MySong implements Song {
    String name;
    @Override
    public String getSongName() {
        // TODO Auto-generated method stub
       return this.name ;
    }

    @Override
    public void setName(String name) {
      this.name = name;
    }

}
