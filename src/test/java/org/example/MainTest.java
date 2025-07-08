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
//    @Test
//    void checkProduct() {
//    }
//
//    @Test
//    void updateProduct() {
//    }
//
//    @Test
//    void removeProduct() {
//    }
}