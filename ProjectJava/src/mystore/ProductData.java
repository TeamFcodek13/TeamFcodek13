/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mystore;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author IMMORTALITY IPOS
 */
public class ProductData {
    
    static final String MENU_FILE = "Menu.txt";
    static final String BILL = "Bill.txt";

    Scanner sc = new Scanner(System.in);
    MemberData memData = new MemberData();
    Bill bills;

    ArrayList<Product> data = new ArrayList<Product>();
    ArrayList<Bill> bill = new ArrayList<Bill>();

    public void addNewProduct() {
        int ID;
        String name;
        double price;

        System.out.println("\n=*=ADD NEW DRINK=*=\n");
        do {
            System.out.print("Input ID: ");
            ID = Validate.getAInteger();
            if (isDuplicate(ID)) {
                System.out.println("\nID is DUPLICATE.\n");
            }
        } while (isDuplicate(ID));

        System.out.print("Name: ");
        name = sc.nextLine();
        System.out.print("Price: ");
        price = Validate.getADouble();
        System.out.println("\n=*=ADDED SUCCESSFUL=*=\n");
        Product newProduct = new Product(ID, name, price);
        data.add(newProduct);
        IOFileMenu.writeToFile(data, MENU_FILE);
    }

    public void viewProduct() {
        data.clear();
        System.out.println("\n=*=MENU=*=\n");
        data = IOFileMenu.readFromFile(MENU_FILE);
        System.out.printf("|%-3s|%-10s|%-5s|\n", "ID", "Name", "Price");
        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i).toString());
        }

    }

    public void findProduct() {
        int ID = 0;
        boolean found = false;
        data = IOFileMenu.readFromFile(MENU_FILE);
        System.out.print("\nInput ID Need To Find: ");
        ID = Validate.getAInteger();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getID() == ID) {
                System.out.printf("\n|%-3s|%-10s|%-5s|\n", "ID", "Name", "Price");
                System.out.println(data.get(i).toString());
                found = true;
                return;
            }
        }
        if (!found) {
            System.out.println("\nNot Found ID.");
        }

    }

    public void updateProduct() {
        int ID = 0;
        String name;
        String color;
        double price;
        boolean found = false;
        System.out.print("\nInput ID need update: ");
        ID = Validate.getAInteger();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getID() == ID) {
                System.out.print("Input new name: ");
                name = sc.nextLine();
                data.get(i).setName(name);
                System.out.print("Input new price: ");
                price = Validate.getADouble();
                data.get(i).setPrice(price);
                found = true;
                System.out.println("\n=*=UPDATE SUCCESSFUL=*=");
                IOFileMenu.writeToFile(data, MENU_FILE);
                return;
            }
        }
        if (!found) {
            System.out.println("\n=*=Not Found ID=*=");
        }
    }

    public void deleteProduct() {
        int ID = 0;
        System.out.print("\n---Input ID need delete: ");
        ID = Validate.getAInteger();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getID() == ID) {
                int choice;
                System.out.println("\nAre you SURE ?");
                System.out.println("1. I'm sure.");
                System.out.println("2. Return.");
                System.out.print("\n---Please choose: ");
                choice = Validate.getAInteger();
                switch (choice) {
                    case 1:
                        data.remove(i);
                        System.out.println("=*=DELETE SUCCESSFUL=*=");
                        break;
                    case 2:
                        return;
                }
            }
        }
        IOFileMenu.writeToFile(data, MENU_FILE);
    }

    public void orderDrink() {
        int ID;
        int quantity = 0;
        int choice = 0;
        int choice1;
        int memberID;
        double sale;

        double subTotal = 0;
        int i;
        data = IOFileMenu.readFromFile(MENU_FILE);
        bill = IOFileMenu.readFromFile(BILL);
        viewProduct();
        do {
            boolean found = false;
            do {
                System.out.print("\n1. Please choose DRINK by input ID: ");
                ID = Validate.getAInteger();
                for (i = 0; i < data.size(); i++) {
                    if (data.get(i).getID() == ID) {
                        found = true;
                        System.out.print("Input Quantity: ");
                        quantity = Validate.getAInteger();
                        subTotal += quantity * data.get(i).getPrice();
                    }
                }
                if (!found) {
                    System.out.println("\nNot found ID.");
                    found = false;
                }

            } while (found == false);
            System.out.print("\nEnter '1' To Finish Input Drink OR Press Any Key To Continue: ");
            choice1 = Validate.getAInteger();
        } while (choice1 != 1);
        System.out.println("\nPress '1' If You Are Not Vip Member.");
        if (memData.findVipMember() == true) {
            sale = 0.1;
            subTotal = subTotal * (1 - sale);
            System.out.print("\nYour Total Bill Payment Is: ");
            System.out.println(subTotal);
        } else {
            sale = 0.0;
            System.out.print("\nYour Total Bill Payment Is: ");
            System.out.println(subTotal);
        }
        bills = new Bill(subTotal, sale);
        bill.add(bills);
        IOFileMenu.writeToFile(bill, BILL);
    }

    public void viewAllBills() {
        bill.clear();
        bill = IOFileMenu.readFromFile(BILL);
        System.out.println("\n=*=LIST BILL=*=\n");
        System.out.printf("|%-8s|%-8s|\n", "Subtotal", "Sale Off");
        for (int i = 0; i < bill.size(); i++) {
            System.out.println(bill.get(i).toString());
        }
    }

    boolean isDuplicate(int ID) {
        if (data.size() == 0) {
            return false;
        }
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getID() == ID) {
                return true;
            }
        }
        return false;
    }

}
