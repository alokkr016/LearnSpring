package com.example.TastyTrove;

import com.example.TastyTrove.Ingredients;
import com.example.TastyTrove.Recipe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("chinese")
public class Chinese implements Recipe {
    private String name = "Chinese";
    private String userName;
    private Ingredients ingredients;

    @Autowired
    @Qualifier("lentils")
    private Ingredients chineseLentils;

    @Autowired
    @Qualifier("rice")
    private Ingredients chineseRice;

    @Autowired
    @Qualifier("wheat")
    private Ingredients chineseWheat;

    @Override
    public void setIngredients(String ingredients) {
        if (ingredients.equals("Lentils"))
            this.ingredients = this.chineseLentils;
        else if (ingredients.equals("Rice"))
            this.ingredients = this.chineseRice;
        else
            this.ingredients = this.chineseWheat;
    }

    @Override
    public void setUserName(String name) {
        this.userName = name;
    }

    @Override
    public void getDetails() {
        this.ingredients.setIngredient(name);
        String dishName = this.ingredients.getDishDetail();
        List<String> ingredients = this.ingredients.getIngredientsDetail();
        System.out.println("Hello user " + this.userName + " we suggest you to make " + dishName
                + " you can use the following ingredients:");
        for (int i = 0; i < ingredients.size(); i++) {
            System.out.println(i + 1 + ". " + ingredients.get(i));
        }
    }

}