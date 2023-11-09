package com.example.TuneIn;

import org.springframework.stereotype.Component;

@Component
public interface Song {

    String getSongName();

    void setName(String name);

}

