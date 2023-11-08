package com.example.TastyTrove;

import java.util.Scanner;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class TastyTroveApplication {

	public static void main(String[] args) {
		/*
		 * You need to complete this application as mentioned in the problem
		 * statement build your own logic and perform the following tasks.
		 * 
		 * 1. Fetch context from ApplicationContext.xml and initiate Scanner
		 * 2. Fetch User details from Console
		 * 3. Fetch Recipe selection from User
		 * 4. Fetch Ingredient Selection
		 * 5. Get the required bean from context.
		 * 6. Set user's name and display the recipe details
		 */

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Scanner in = new Scanner(System.in);

		// Recipe recipe = (Recipe) context.getBean("chineseLentils");
		System.out.println("Welcome to Tasty Trove Application\n" + //
				"Enter your name?");
		String name = in.nextLine();
		System.out.println("Select Recipe:\n" + //
				"1. North Indian\n" + //
				"2. South Indian\n" + //
				"3. Chinese");
		int selectRecipe = in.nextInt();
		Ingredients ingredients1 = (Ingredients) context.getBean("lentils");
		Ingredients ingredients2 = (Ingredients) context.getBean("rice");
		Ingredients ingredients3 = (Ingredients) context.getBean("wheat");
		switch (selectRecipe) {
			case 1: // Assuming 1 is for North Indian
				System.out.println("Select Ingredient:\n" +
						"1. Lentils\n" +
						"2. Rice\n" +
						"3. Wheat");
				int selectNorthIndianIngredient = in.nextInt();
				switch (selectNorthIndianIngredient) {
					case 1:
						Recipe recipe = (Recipe) context.getBean("northIndianLentils");
						recipe.setUserName(name);
						ingredients1.setIngredient("NorthIndian");
						recipe.getDetails();
						break;
					case 2:
						Recipe recipe2 = (Recipe) context.getBean("northIndianRice");
						recipe2.setUserName(name);
						ingredients2.setIngredient("NorthIndian");
						recipe2.getDetails();
						break;
					case 3:
						Recipe recipe3 = (Recipe) context.getBean("northIndianWheat");
						recipe3.setUserName(name);
						ingredients3.setIngredient("NorthIndian");
						recipe3.getDetails();
						break;
					default:
						System.out.println("Invalid ingredient selection.");
						break;
				}
				break;

			case 2: // Assuming 2 is for South Indian
				System.out.println("Select Ingredient:\n" +
						"1. Lentils\n" +
						"2. Rice\n" +
						"3. Wheat");
				int selectSouthIndianIngredient = in.nextInt();
				switch (selectSouthIndianIngredient) {
					case 1:
						Recipe recipe4 = (Recipe) context.getBean("southIndianLentils");
						recipe4.setUserName(name);
						ingredients1.setIngredient("SouthIndian");
						recipe4.getDetails();
						break;
					case 2:
						Recipe recipe5 = (Recipe) context.getBean("southIndianRice");
						recipe5.setUserName(name);
						ingredients2.setIngredient("SouthIndian");
						recipe5.getDetails();
						break;
					case 3:
						Recipe recipe6 = (Recipe) context.getBean("southIndianWheat");
						recipe6.setUserName(name);
						ingredients3.setIngredient("SouthIndian");
						recipe6.getDetails();
						break;
					default:
						System.out.println("Invalid ingredient selection.");
						break;
				}
				break;

			case 3: // Assuming 3 is for Chinese
				System.out.println("Select Ingredient:\n" +
						"1. Lentils\n" +
						"2. Rice\n" +
						"3. Wheat");
				int selectChineseIngredient = in.nextInt();
				switch (selectChineseIngredient) {
					case 1:
						Recipe recipe7 = (Recipe) context.getBean("chineseLentils");
						recipe7.setUserName(name);
						ingredients1.setIngredient("Chinese");
						recipe7.getDetails();
						break;
					case 2:
						Recipe recipe8 = (Recipe) context.getBean("chineseRice");
						recipe8.setUserName(name);
						ingredients2.setIngredient("Chinese");
						recipe8.getDetails();
						break;
					case 3:
						Recipe recipe9 = (Recipe) context.getBean("chineseWheat");
						recipe9.setUserName(name);
						ingredients3.setIngredient("Chinese");
						recipe9.getDetails();
						break;
					default:
						System.out.println("Invalid ingredient selection.");
						break;
				}
				break;

			default:
				System.out.println("Invalid recipe selection.");
				break;
		}

	}

}