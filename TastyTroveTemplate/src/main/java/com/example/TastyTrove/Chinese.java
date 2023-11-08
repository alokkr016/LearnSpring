package com.example.TastyTrove;

import java.util.List;

/**
 
  This class is an implementation of a Recipe Interface based on the selection 
  done in the console for Recipe type.You need to complete this class 
  based on the following tasks.
   
    Tasks:
  a. Override the methods of Recipe Interface.
  b. Add common attributes:
      1. String name
      2. String userName
      3. Ingredients ingredients
  c. Build the logic for all the methods based on the description mentioned in the Recipe Interface.
  d. Create a setter injection mentioned named as "setIngredients(Ingredients ingredients)" this method 
     injects the "ingredient" attribute as  a dependency into this class using Setter Injection approach.
     
**/

public class Chinese implements Recipe {
  String name;
  String userName;
  Ingredients ingredients;

  public void setIngredients(Ingredients ingredients) {
    this.ingredients = ingredients;
  }
  
// Method to print details of the recipe
  @Override
  public void getDetails() {
    // Assuming getIngredientsDetail returns the ingredients for Chinese Fried Rice
    List<String> ingredientList = ingredients.getIngredientsDetail();
    StringBuilder details = new StringBuilder("Hello user ");
    details.append(userName);
    details.append(" we suggest you to make ");
    details.append(ingredients.getDishDetail());
    details.append(" you can use the following ingredients:\n");
    
    int counter = 1;
    for (String ingredient : ingredientList) {
      details.append(counter).append(". ").append(ingredient).append("\n");
      counter++;
    }
    
    // Print the details to the console
    System.out.println(details.toString());
  }

  @Override
  public void setUserName(String userName) {
    this.userName = userName;
    
  }



}