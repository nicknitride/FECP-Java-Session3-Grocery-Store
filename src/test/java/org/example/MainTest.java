package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    HashMap<String, Integer> emptyInventory = new HashMap<>();
    HashMap<String, Integer> inventoryWithContent;

    @BeforeEach
    void setup(){
        inventoryWithContent = new HashMap<>();
        inventoryWithContent.put("Milk",20);
        inventoryWithContent.put("Cheese",45);
    }

    @Test
    void viewEmptyInventory(){
       String actual = Main.viewInventory(emptyInventory);
        Assertions.assertTrue(actual.contains("Inventory Size: 0"));
    }
    @Test
    void viewInventory() {
    String actual = Main.viewInventory(inventoryWithContent);
    Assertions.assertTrue(actual.contains("Inventory Size: 2"));
    }

    @Test
    void addProduct() {
    String required = Main.addProduct("Banana",30,inventoryWithContent);
    Assertions.assertTrue(required.contains("Added Banana (30)"));
    String second = Main.addProduct("Fresh Milk",400,inventoryWithContent);
    Assertions.assertTrue(second.contains("Added Fresh Milk (400)"));
    }

    @Test
    void addProductQuantZero() {
        String required = Main.addProduct("Mango",0,inventoryWithContent);
        Assertions.assertTrue(required.contains("Added Mango (0)"));
        String second = Main.addProduct("Milk",400,inventoryWithContent);
        Assertions.assertTrue(second.contains("Added Milk (400)"));
    }
    @Test
    void checkProduct() {
        //Check Existing
        String existing = Main.checkProduct("Cheese", inventoryWithContent);
        Assertions.assertTrue(existing.contains("Product: Cheese, Quantity: 45"));
        // Check Milk 20
        String actual = Main.checkProduct("Milk",inventoryWithContent);
        Assertions.assertTrue(actual.contains("Product: Milk, Quantity: 20"));
        String nonExistent = Main.checkProduct("Ice Cream",emptyInventory);
        Assertions.assertTrue(nonExistent.contains("null"));
    }

    @Test
    void updateProduct(){
        inventoryWithContent.put("Bread",12);
        //Existing, valid
        String actual = Main.updateProduct("Milk",4200,inventoryWithContent);
        Assertions.assertTrue(actual.contains("key: Milk stock: 4200"));
        // Update Bread
        String bread = Main.updateProduct("Bread",25,inventoryWithContent);
        Assertions.assertTrue(bread.contains("key: Bread stock: 25"));
        // Non-existing product
        String nonExistent = Main.updateProduct("Ice Cream",40,inventoryWithContent);
        Assertions.assertTrue(nonExistent.contains("Didn't find the item. Please add Ice Cream to the inventory"));
    }

    @Test
    void removeProduct(){
        //Remove existing
        String actualMethod = Main.removeProduct("Milk",inventoryWithContent);
        String inventorySize = Main.viewInventory(inventoryWithContent);
        Assertions.assertTrue(inventorySize.contains("Inventory Size: 1"));
        Assertions.assertTrue(actualMethod.contains("Removed: 20"));
        //Remove Non-Existent
        String nonExistent = Main.removeProduct("Pizza",inventoryWithContent);
       Assertions.assertTrue(nonExistent.contains("Pizza not found. Nothing to be removed"));
    }
}