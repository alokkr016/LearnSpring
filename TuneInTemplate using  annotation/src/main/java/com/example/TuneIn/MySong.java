package com.example.TuneIn;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
 * 1. Add class attributes.
 * 2. Override all the interface methods.
 * 3. Implement setter injection
 */

@Component
@Scope("prototype")
public class MySong implements Song {
  String name;

  @Override
  public String getSongName() {
    // TODO Auto-generated method stub
    return this.name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

}
