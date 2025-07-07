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

    static String viewInventory(HashMap<String, Integer> inventoryHash){
        String outputString= "";
        System.out.println("------- Inventory List ----------");
        inventoryHash.forEach((key, val) ->
                System.out.println("Product: " + key + ", Value: " + val)
        );
        outputString = "Inventory Size: "+inventoryHash.size();
        System.out.println("------------------------");
        return outputString;
    }

    static String addProduct(String key, int stockValue, HashMap<String, Integer> inventoryHash){
        String outputString = "";
        inventoryHash.put(key,stockValue);
        outputString="Added "+key+" ("+stockValue+")";
        return outputString;
    }
    public static void main(String[] args) {
        HashMap<String, Integer> inventoryHashMap = new HashMap<>();

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
                    System.out.println(viewInventory(inventoryHashMap));
                case "2":
                    System.out.print("Enter product name: ");
                    String userKey = userInput.nextLine();
                    System.out.print("Enter quantity: ");
                    int userStockVal = userInput.nextInt();
                    userInput.nextLine();
                    System.out.println(addProduct(userKey, userStockVal,inventoryHashMap));
                default:
                    System.out.println("Enter a number between [1-6]");
            }
        }
        }
    }
