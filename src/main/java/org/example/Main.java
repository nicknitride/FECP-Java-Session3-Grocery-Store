package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static void displayGroceryMenu(){
        System.out.println("---- Grocery Inventory Menu ----");
        System.out.println("1. View Inventory");
        System.out.println("2. Add Product");
        System.out.println("3. Check Product");
        System.out.println("4. Update Stock");
        System.out.println("5. Remove Product");
        System.out.println("6. Exit\n");
    }


    static String viewInventory(HashMap<String, Integer> inventoryHash){
        String outputString;
        if(!inventoryHash.isEmpty()){
            System.out.println("------- Inventory List ----------");
            inventoryHash.forEach((key, val) ->
                    System.out.println("Product: " + key + ", Value: " + val)
            );
            System.out.println("------------------------");
        }
        else{
            System.out.println("-------EMPTY INVENTORY---------");
        }
        outputString = "Inventory Size: "+inventoryHash.size();
        return outputString;
    }

    static String addProduct(String key, int stockValue, HashMap<String, Integer> inventoryHash){
        String outputString = "";
        inventoryHash.put(key,stockValue);
        if (inventoryHash.get(key)==stockValue){
            outputString="Added "+key+" ("+stockValue+")";
        }else{
            outputString ="Failed to add."; //Likely not possible, as it will fail elsewhere
        }
        return outputString;
    }

    static String checkProduct(String key, HashMap<String, Integer>inventoryHash){
        System.out.println("Checking product: "+key);
        String output;
        if(inventoryHash.get(key)==null){
            System.out.println("Product may not exist.");
            output = "null";
        }
        else{
            System.out.println("Quantity: "+inventoryHash.get(key));
            output = "Product: "+key+", Quantity: "+inventoryHash.get(key);
        }
        return output;
    }

    static String updateProduct(String key, int newVal,HashMap<String, Integer>inventoryHash){
        String output;
        if(inventoryHash.get(key)==null){
            System.out.println("Didn't find the item. Please add "+key+" to the inventory");
            output ="Didn't find the item. Please add "+key+" to the inventory";
        }
        else{
            inventoryHash.replace(key,newVal);
            output = "key: "+key+" stock: "+inventoryHash.get(key);
            System.out.println("Updated "+key+", new quantity: "+inventoryHash.get(key));
        }
        return output;
    }

    static String removeProduct(String key, HashMap<String, Integer> inventoryHash){
        if(!inventoryHash.containsKey(key)){
            return key+" not found. Nothing to be removed";
        }else{
            int removedValue = inventoryHash.remove(key);
            return "Removed: "+removedValue;
        }
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
                    break;
                case "1":
                    System.out.println("Displaying inventory");
                    System.out.println(viewInventory(inventoryHashMap));
                    break;
                case "2":
                    System.out.print("Enter product name: ");
                    String userKey = userInput.nextLine();
                    System.out.print("Enter quantity: ");
                    int userStockVal = userInput.nextInt();
                    userInput.nextLine();
                    System.out.println(addProduct(userKey, userStockVal,inventoryHashMap));
                    break;
                case "3":
                    System.out.print("Enter a product to check: ");
                    userKey = userInput.nextLine();
                    checkProduct(userKey,inventoryHashMap);
//                    System.out.println(checkProduct(userKey,inventoryHashMap));
                    break;
                case "4":
                    System.out.print("Enter a product to update: ");
                    userKey = userInput.nextLine();
                    System.out.print("Enter new stock quantity: ");
                    userStockVal = userInput.nextInt();
                    userInput.nextLine();
                    updateProduct(userKey,userStockVal,inventoryHashMap);
                    break;
                case "5":
                    System.out.print("Enter a product to remove: ");
                    userKey = userInput.nextLine();
                    if(inventoryHashMap.containsKey(userKey)){
                        System.out.println("Removed "+userKey+" from inventory list");
                        removeProduct(userKey,inventoryHashMap);
                    }else{
                        System.out.println("Product doesn't exist.");
                    }
                    break;
                default:
                    System.out.println("Enter a number between [1-6]");
                    break;
            }
        }
        }
    }
