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

                  public Lentils() {
                    Collections.addAll(southIndianRiceRecipes, "Rice", "Salt", "Black Gram");
                    }
 */

public class Lentils implements Ingredients {

   /**
    * Given below are the 3 booleans based on the recipe type.These booleans
    * bydefault will be false however
    * based on recipe type selected ( setIngredient(String ingredient) ) this
    * boolean will become true accordingly.
    **/

   private boolean isChinese;
   private boolean isNorthIndian;
   private boolean isSouthIndian;

   public Lentils() {

      // Adding South Indian lentils recipe ingredients, e.g., Sambar
      Collections.addAll(southIndianLentilsRecipes, "Toor Dal (Split Pigeon Peas)", "Tamarind", "Sambar Powder",
            "Mustard Seeds", "Cumin Seeds", "Fenugreek Seeds", "Curry Leaves", "Dry Red Chilies", "Assorted Vegetables",
            "Turmeric Powder", "Asafoetida (Hing)", "Salt", "Coriander Leaves", "Oil");

      // Adding North Indian lentils recipe ingredients, e.g., Dal Makhani
      Collections.addAll(northIndianLentilsRecipes, "Whole Black Lentils (Urad Dal)", "Kidney Beans (Rajma)",
            "Tomato Puree", "Ginger Garlic Paste", "Cream", "Butter", "Cumin Seeds", "Garam Masala", "Red Chili Powder",
            "Turmeric Powder", "Salt", "Kasuri Methi (Dried Fenugreek Leaves)");

      // Adding Chinese lentils recipe ingredients, e.g., Sichuan Braised Lentils
      Collections.addAll(chineseLentilsRecipes, "Brown Lentils", "Sichuan Peppercorns", "Soy Sauce", "Star Anise",
            "Ginger", "Garlic", "Green Onions", "Vegetable Stock", "Chili Oil", "Salt");
   }

   /**
    * Given below are 3 ArrayList which are used to store the ingredients of your
    * choice based
    * on the recipe type.Refer to point number 2 above.
    **/
   private List<String> chineseLentilsRecipes = new ArrayList<String>();
   private List<String> northIndianLentilsRecipes = new ArrayList<String>();
   private List<String> southIndianLentilsRecipes = new ArrayList<String>();

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
         return "Sichuan Braised Lentils";
      } else if (isNorthIndian) {
         return "Dal Makhani";
      } else if (isSouthIndian) {
         return "Sambar";

      } else {
         return "";
      }
   }

   @Override
   public List<String> getIngredientsDetail() {
      if (isNorthIndian) {
         return northIndianLentilsRecipes;
      } else if (isChinese) {
         return chineseLentilsRecipes;
      } else if (isSouthIndian) {
         return southIndianLentilsRecipes;
      } else {
         List<String> list = new ArrayList<>();
         return list;
      }

   }

}
