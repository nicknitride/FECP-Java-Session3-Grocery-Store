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
    String actual = Main.addProduct("Potato",363,inventoryWithContent);
    Assertions.assertTrue(actual.contains("Added Potato (363)"));
    }
//
    @Test
    void checkProduct() {
        String actual = Main.checkProduct("Milk",inventoryWithContent);
        Assertions.assertTrue(actual.contains("Product: Milk, Quantity: 20"));
    }
    @Test
    void nonExistentProduct(){
        String actual = Main.checkProduct("RTX 4060",emptyInventory);
        Assertions.assertTrue(actual.contains("null"));
    }

    @Test
    void updateProduct(){
        String actual = Main.updateProduct("Milk",4200,inventoryWithContent);
        Assertions.assertTrue(actual.contains("key: Milk stock: 4200"));
    }
    @Test
    void updateNonExistentProduct(){
        String actual = Main.updateProduct("R5 5600x",100,inventoryWithContent);
        Assertions.assertTrue(actual.contains("Didn't find the item. Please add R5 5600x to the inventory"));
    }

    @Test
    void removeProduct(){
        String actualMethod = Main.removeProduct("Milk",inventoryWithContent);
        String inventorySize = Main.viewInventory(inventoryWithContent);
        Assertions.assertTrue(inventorySize.contains("Inventory Size: 1"));
        Assertions.assertTrue(actualMethod.contains("Removed: 20"));
    }
}