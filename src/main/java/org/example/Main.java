package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static void displayGroceryMenu(){
        System.out.println("---- Grocery Inventory Menu ----");
        System.out.println("1. View Inventory");
        System.out.println("2. Add Product");
        System.out.println("3. Check Product");
        System.out.println("3. Update Stock");
        System.out.println("5. Remove Product");
        System.out.println("6. Exit\n");
    }

    public static void main(String[] args) {
        HashMap<String, Integer> inventoryHashMap;

        boolean exitCondition = false;
        Scanner userInput = new Scanner(System.in);
        while(!exitCondition){
            displayGroceryMenu();
            System.out.print("Choose an option: ");
            String userChoice = userInput.nextLine();
            switch (userChoice){
                case "6":
                    System.out.println("Quitting");
                    exitCondition=true;
                case "1":
                    System.out.println("Displaying inventory");
                default:
                    System.out.println("Enter a number between [1-6]");
            }
        }
        }
    }
