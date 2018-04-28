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

    Scanner sc = new Scanner(System.in);
    MemberData dataMember = new MemberData();
    ArrayList<Product> data = new ArrayList<Product>();
    ArrayList<Bill> info = new ArrayList<Bill>();
    static final String MENU_FILE = "Menu.txt";
    static final String BILL_FILE = "Bill.txt";

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
        System.out.println("\n=*=ADDED SUCCESSFULLY=*=\n");
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
        System.out.print("\nInput ID need find: ");
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
            System.out.println("\nNot found ID.");
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
                System.out.println("Press any key to continue");
                sc.next();
                return;
            }
        }
        if (!found) {
            System.out.println("\n=*=Not Found ID=*=");
            System.out.println("Press any key to continue");
            sc.next();
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
        double sum = 0;
        int quantity = 0;
        int choice = 0;
        int choice1;
        double subTotal = 0;
        int i;
        data = IOFileMenu.readFromFile(MENU_FILE);
        info = IOFileMenu.readFromFile(BILL_FILE);
        viewProduct();
        do {
            boolean found = false;
            do {
                System.out.print("\n1. Please choose DRINK by input ID: ");
                ID = Validate.getAInteger();
                for (i = 0; i < data.size(); i++) {
                    if (data.get(i).getID() == ID) {
                        found = true;
                        System.out.print("Input quantity: ");
                        quantity = Validate.getAInteger();
                        subTotal = quantity * data.get(i).getPrice();
                        Bill newBill = new Bill(data.get(i).getID(), data.get(i).getName(), data.get(i).getPrice(), quantity, subTotal);
                        info.add(newBill);
                        System.out.printf("\n|%-3s|%-10s|%-5s|%-7s|%-5s\n", "ID", "Name", "Price", "Quantity", "Total");
                        System.out.println(newBill.toString());
                        sum = sum + subTotal;
                    }
                }
                if (!found) {
                    System.out.println("\nNot found ID.");
                }

            } while (found == false);
            System.out.print("\nEnter '1' to finish or Press other number to continue: ");
            choice1 = Validate.getAInteger();
        } while (choice1 != 1);
        System.out.println("Are you a member? ");
        System.out.print("Press '1' If You're Member OR Other Numbers To Finish: ");
        if (Validate.getAInteger() == 1) {
            int number, answer = 0;
            do {
                System.out.print("Enter Your ID: ");
                number = Validate.getAInteger();
                if (dataMember.aMember(number)) {
                    sum = sum * 0.8;
                    info.get(info.size() - 1).setSum(sum);
                    info.get(info.size() - 1).setOff(20);
                    System.out.printf("Total: %.1f, off: %.1f\n", info.get(info.size() - 1).getSum(), info.get(info.size() - 1).getOff());
                    IOFileMenu.writeToFile(info, BILL_FILE);
                    answer = 2;
                } else {
                    System.out.println("Sorry But You're Not Member!\n");
                    System.out.print("Press '1' To Continue Or Other Numbers To Finish: ");
                    answer = Validate.getAInteger();
                }
            } while (answer == 1);
        } else {
            info.get(info.size() - 1).setSum(sum);
            IOFileMenu.writeToFile(info, BILL_FILE);
            System.out.printf("\nTotal: %.1f, off: %.1f\n", info.get(info.size() - 1).getSum(), info.get(info.size() - 1).getOff());
        }

        if (subTotal >= 100) {
            System.out.print("Enter 1 if you want to add member: ");
            if (Validate.getAInteger() == 1) {
                dataMember.addNewMember();
            }
        }
    }

    public void viewAllBills() {
        info.clear();
        info = IOFileMenu.readFromFile(BILL_FILE);
        System.out.printf("|%-3s|%-10s|%-5s|%-7s|%-5s\n", "ID", "Name", "Price", "Quantity", "Total");
        for (int i = 0; i < info.size(); i++) {
            System.out.println(info.get(i).toString());
            if (info.get(i).getSum() != 0) {
                System.out.println("__________________________________________________________________");
                System.out.printf("Total: %.1f, off: %.1f\n\n", info.get(i).getSum(), info.get(i).getOff());
            }

        }

    }

    boolean isDuplicate(int ID) {
        data = IOFileMenu.readFromFile(MENU_FILE);
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