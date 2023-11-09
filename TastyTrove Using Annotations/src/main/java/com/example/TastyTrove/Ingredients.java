package com.example.TastyTrove;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface Ingredients {

    void setIngredient(String ingredient);

    String getDishDetail();

    List<String> getIngredientsDetail();
}
