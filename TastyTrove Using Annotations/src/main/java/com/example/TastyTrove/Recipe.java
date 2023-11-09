package com.example.TastyTrove;

import org.springframework.stereotype.Component;

@Component
public interface Recipe {
    
  void setIngredients (String ingredients);
    void getDetails();

    void setUserName(String userName);
}
