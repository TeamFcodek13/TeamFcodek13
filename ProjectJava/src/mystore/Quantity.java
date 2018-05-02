/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mystore;

import java.util.ArrayList;

/**
 *
 * @author Thanh
 */
public class Quantity {
    
    ArrayList<Product> data = new ArrayList<Product>();
    static final String PRODUCT = "Menu.txt";
    
    public void viewQuantity() {
        data.clear();
        System.out.println("\n=*=MENU=*=\n");
        data = IOFileMenu.readFromFile(PRODUCT);
        System.out.printf("|%-3s|%-10s|%-5s|%-9s|\n", "ID", "Name", "Price", "Quantity");
        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i).toStringQ());
        }
        
    }
    
    public void findQuantity() {
        int ID = 0;
        boolean found = false;
        data = IOFileMenu.readFromFile(PRODUCT);
        System.out.print("\nInput ID need find: ");
        ID = Validate.getAInteger();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getID() == ID) {
                System.out.printf("|%-3s|%-10s|%-5s|%-9s|\n", "ID", "Name", "Price", "Quantity");
                System.out.println(data.get(i).toStringQ());
                found = true;
                return;
            }
        }
        if (!found) {
            System.out.println("\nNot found ID.");
        }
    }
    
    public void UpdateQuantity() {
        int ID = 0, quantity;
        boolean found = false;
        data = IOFileMenu.readFromFile(PRODUCT);
        System.out.print("\nInput ID need find: ");
        ID = Validate.getAInteger();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getID() == ID) {
                System.out.printf("|%-3s|%-10s|%-5s|%-9s|\n", "ID", "Name", "Price", "Quantity");
                System.out.println(data.get(i).toStringQ());
                System.out.print("Enter Quantity: ");
                quantity = Validate.getAInteger();
                data.get(i).setQuantity(quantity);
                System.out.println("UPDATE SUCCESSFULLY");
                System.out.printf("|%-3s|%-10s|%-5s|%-9s|\n", "ID", "Name", "Price", "Quantity");
                System.out.println(data.get(i).toStringQ());
                found = true;
                return;
            }
        }
        if (!found) {
            System.out.println("\nNot found ID.");
        }
        IOFileMenu.writeToFile(data, PRODUCT);
    }
    
}
