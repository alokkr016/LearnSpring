package com.example.TastyTrove;

import java.util.ArrayList;
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

                  public Rice() {
                    Collections.addAll(southIndianRiceRecipes, "Rice", "Salt", "Black Gram");
                    }
 */

public class Rice implements Ingredients {

  /**
   * Given below are the 3 booleans based on the recipe type.These booleans
   * bydefault will be false however
   * based on recipe type selected ( setIngredient(String ingredient) ) this
   * boolean will become true accordingly.
   **/

  private boolean isChinese;
  private boolean isNorthIndian;
  private boolean isSouthIndian;

  /**
   * Given below are 3 ArrayList which are used to store the ingredients of your
   * choice based
   * on the recipe type.Refer to point number 2 above.
   **/

  public Rice() {

    // Adding South Indian rice recipe ingredients, e.g., Lemon Rice
    Collections.addAll(southIndianRiceRecipes, "Basmati Rice", "Lemons", "Mustard Seeds", "Chana Dal", "Green Chilies",
        "Turmeric Powder", "Curry Leaves", "Salt", "Peanuts", "Oil");

    // Adding North Indian rice recipe ingredients, e.g., Biryani
    Collections.addAll(northIndianRiceRecipes, "Basmati Rice", "Chicken", "Yogurt", "Onions", "Tomatoes",
        "Ginger Garlic Paste", "Mint Leaves", "Coriander Leaves", "Biryani Masala", "Saffron", "Ghee");

    // Adding Chinese rice recipe ingredients, e.g., Fried Rice
    Collections.addAll(chineseRiceRecipes, "Jasmine Rice", "Eggs", "Green Peas", "Carrots", "Soy Sauce",
        "Spring Onions", "Garlic", "Salt", "Vegetable Oil", "Sesame Oil");
  }

  private List<String> chineseRiceRecipes = new ArrayList<String>();
  private List<String> northIndianRiceRecipes = new ArrayList<String>();
  private List<String> southIndianRiceRecipes = new ArrayList<String>();

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
      return "Fried Rice";
    } else if (isNorthIndian) {
      return "Biryani";
    } else if (isSouthIndian) {
      return "Lemon Rice";

    } else {
      return "";
    }
  }

  @Override
  public List<String> getIngredientsDetail() {
    if (isNorthIndian) {
      return northIndianRiceRecipes;
    } else if (isChinese) {
      return chineseRiceRecipes;
    } else if (isSouthIndian) {
      return southIndianRiceRecipes;
    } else {
      List<String> list = new ArrayList<>();
      return list;
    }

  }

}
