package com.example.TastyTrove;

import com.example.TastyTrove.Ingredients;
import com.example.TastyTrove.Recipe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component("northIndian")
public class NorthIndian implements Recipe {
    private String name = "NorthIndian";
    private String userName;
    
    
    private Ingredients ingredients;

    @Autowired
    @Qualifier("lentils")
    private Ingredients northIndianLentils;

    @Autowired
    @Qualifier("rice")
    private Ingredients northIndianRice;

    @Autowired
    @Qualifier("wheat")
    private Ingredients northIndianWheat;

    @Override
    public void setIngredients(String ingredients) {
        if (ingredients.equals("Lentils"))
            this.ingredients = northIndianLentils;
        else if (ingredients.equals("Rice"))
            this.ingredients = northIndianRice;
        else
            this.ingredients = northIndianWheat;
    }

    @Override
    public void getDetails() {
        this.ingredients.setIngredient(name);
        String dishName = this.ingredients.getDishDetail();
        List<String> ingredients = this.ingredients.getIngredientsDetail();
        System.out.println("Hello user " + this.userName + " we suggest you to make " + dishName + " you can use the following ingredients:");
        for(int i = 0; i < ingredients.size(); i++){
            System.out.println(i + 1 + ". " + ingredients.get(i));
        }
    }

    @Override
    public void setUserName(String name) {
        this.userName = name;
    }

   
}
