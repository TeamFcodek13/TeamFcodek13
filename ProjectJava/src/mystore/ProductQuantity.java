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
public class ProductQuantity {

    ArrayList<Product> data = new ArrayList<Product>();
    static final String PRODUCT = "Menu.txt";

    public void viewAllQuantity() {
        data.clear();
        data = IOFileMenu.readFromFile(PRODUCT);
        System.out.printf("\t\t\t\t\t\t|%-3s|%-10s|%-5s|%-9s\n", "ID", "Name", "Price", "Quantity");
        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i).toStringwithQuantity());
        }
    }

    public void findAQuanity() {
        boolean found = false;
        int id;
        data.clear();
        data = IOFileMenu.readFromFile(PRODUCT);
        System.out.print("\nInput ID Need To Find: ");
        id = Validate.getAInteger();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getID() == id) {
                System.out.printf("\t\t\t\t\t\t|%-3s|%-10s|%-5s|%-9s\n", "ID", "Name", "Price", "Quantity");
                System.out.println(data.get(i).toStringwithQuantity());
                found = true;
                return;
            }
        }
        if (!found) {
            System.out.println(ColorText.ANSI_RED + "\n\t\t\t\t\t~~~NOT FOUND ID." + ColorText.ANSI_RED);
        }
    }

    public void updateQuantity() {
        int ID = 0, quantity;
        boolean found = false;
        System.out.print("\n\t\t\t\t\tInput ID Need To Update: ");
        ID = Validate.getAInteger();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getID() == ID) {
                System.out.printf("\t\t\t\t\t\t|%-3s|%-10s|%-5s|%-9s\n", "ID", "Name", "Price", "Quantity");
                System.out.println(data.get(i).toStringwithQuantity());
                System.out.print("\t\t\t\t\tInput Quanity: ");
                quantity = Validate.getAInteger();
                data.get(i).setQuantity(quantity);
                found = true;
                System.out.println(ColorText.ANSI_GREEN + "\n\t\t\t\t\t~~~UPDATE SUCCESSFULLY." + ColorText.ANSI_GREEN);
                System.out.printf("\t\t\t\t\t\t|%-3s|%-10s|%-5s|%-9s\n", "ID", "Name", "Price", "Quantity");
                System.out.println(data.get(i).toStringwithQuantity());
                IOFileMenu.writeToFile(data, PRODUCT);
                return;
            }
        }
        if (!found) {
            System.out.println(ColorText.ANSI_RED + "\n\t\t\t\t\t~~~NOT FOUND ID." + ColorText.ANSI_RED);
        }
    }
}
