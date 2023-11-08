package com.example.TastyTrove;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
  This class is an implementation of a Ingredients Interface based on the selection 
  done in the console for the ingredient.You need to complete this class based on
  the following tasks.
    
    Tasks:
        1. Override the methods of Ingredients Interface.
        2. Create the constructor for this class and add your choice of ingredients in the list based on
           the type of recipe for example

                  public Wheat() {
                    Collections.addAll(southIndianRiceRecipes, "Rice", "Salt", "Black Gram");
                    }
 */

public class Wheat implements Ingredients {

  /**
   * Given below are the 3 booleans based on the recipe type.These booleans
   * bydefault will be false however
   * based on recipe type selected ( setIngredient(String ingredient) ) this
   * boolean will become true accordingly.
   **/
  private boolean isChinese = false;
  private boolean isNorthIndian = false;
  private boolean isSouthIndian = false;

  /**
   * Given below are 3 ArrayList which are used to store the ingredients of your
   * choice based
   * on the recipe type.Refer to point number 2 above.
   **/

  public Wheat() {
    // southIndianWheatRecipes.add(new Recipe("Godhuma Dosa", Arrays.asList("Whole
    // Wheat Flour", "Salt", "Water", "Cumin Seeds", "Onion", "Green Chilies",
    // "Curry Leaves")));

    // // Adding North Indian wheat recipe - Aloo Paratha
    // northIndianWheatRecipes.add(new Recipe("Aloo Paratha", Arrays.asList("Whole
    // Wheat Flour", "Potatoes", "Garam Masala", "Red Chili Powder", "Cumin Seeds",
    // "Coriander Leaves", "Salt", "Ghee")));

    // // Adding Chinese wheat recipe - Scallion Pancakes
    // chineseWheatRecipes.add(new Recipe("Scallion Pancakes",
    // Arrays.asList("All-Purpose Flour", "Boiling Water", "Scallions", "Sesame
    // Oil", "Salt", "Vegetable Oil")));

    Collections.addAll(northIndianWheatRecipe, "Whole Wheat Flour", "Potatoes", "Garam Masala", "Red Chili Powder",
        "Cumin Seeds", "Coriander Leaves", "Salt", "Ghee");
    Collections.addAll(southIndianWheatRecipe, "Whole Wheat Flour", "Salt", "Water", "Cumin Seeds", "Onion",
        "Green Chilies", "Curry Leaves");
    Collections.addAll(chineseWheatRecipe, "All-Purpose Flour", "Boiling Water", "Scallions", "Sesame Oil", "Salt",
        "Vegetable Oil");
  }

  private List<String> chineseWheatRecipe = new ArrayList<String>();
  private List<String> northIndianWheatRecipe = new ArrayList<String>();
  private List<String> southIndianWheatRecipe = new ArrayList<String>();

  @Override
  public void setIngredient(String ingredient) {
    if (ingredient.equals("Chinese")) {
      this.isChinese = true;
    } else if (ingredient.equals("NorthIndian")) {
      this.isNorthIndian = true;
    } else if (ingredient.equals("SouthIndian")) {
      this.isSouthIndian = true;
    }
  }

  @Override
  public String getDishDetail() {
    if (isChinese) {
      return "Scallion Pancakes";
    } else if (isNorthIndian) {
      return "Aloo Paratha";
    } else if (isSouthIndian) {
      return "Godhuma Dosa";

    } else {
      return "";
    }
  }

  @Override
  public List<String> getIngredientsDetail() {
    if (isNorthIndian) {
      return northIndianWheatRecipe;
    } else if (isChinese) {
      return chineseWheatRecipe;
    } else if (isSouthIndian) {
      return southIndianWheatRecipe;
    } else {
      List<String> list = new ArrayList<>();
      return list;
    }

  }

}
