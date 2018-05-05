/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mystore;

import java.util.ArrayList;
import java.util.Calendar;
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
        int ID, quantity;
        String name;
        double price;

        System.out.println(ColorText.ANSI_RED + "\n\t\t\t\t\t\t=*=ADD NEW DRINK=*=\n" + ColorText.ANSI_RED);
        do {
            System.out.print("\t\t\t\t\tInput ID: ");
            ID = Validate.getAInteger();
            if (isDuplicate(ID)) {
                System.out.println(ColorText.ANSI_RED + "\n\t\t\t\t\t~~~ID IS DUPLICATE.\n" + ColorText.ANSI_RED);
            }
        } while (isDuplicate(ID));

        System.out.print("\t\t\t\t\tInput Name: ");
        name = sc.nextLine();
        System.out.print("\t\t\t\t\tInput Price: ");
        price = Validate.getADouble();
        Product newProduct = new Product(ID, name, price);
        System.out.print("\t\t\t\t\tInput Quantity: ");
        quantity = Validate.getAInteger();
        newProduct.setQuanity(quantity);
        System.out.println(ColorText.ANSI_GREEN + "\n\t\t\t\t\t~~~ADDED SUCCESSFULLY\n" + ColorText.ANSI_GREEN);
        data.add(newProduct);
        IOFileMenu.writeToFile(data, MENU_FILE);
    }

    public void viewProduct() {
        data.clear();
        System.out.println(ColorText.ANSI_RED + "\n\t\t\t\t\t\t\t=*=MENU=*=\n" + ColorText.ANSI_RED);
        data = IOFileMenu.readFromFile(MENU_FILE);
        System.out.printf("\t\t\t\t\t\t|%-3s|%-10s|%-5s|\n", "ID", "Name", "Price");
        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i).toString());
        }

    }

    public void findProduct() {
        int ID = 0;
        boolean found = false;
        data = IOFileMenu.readFromFile(MENU_FILE);
        System.out.print("\n\t\t\t\t\tInput ID Need To Find: ");
        ID = Validate.getAInteger();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getID() == ID) {
                System.out.printf("\n\t\t\t\t\t\t|%-3s|%-10s|%-5s|\n", "ID", "Name", "Price");
                System.out.println(data.get(i).toString());
                found = true;

                return;
            }
        }
        if (!found) {
            System.out.println(ColorText.ANSI_RED + "\n\t\t\t\t\t~~~NOT FOUND ID." + ColorText.ANSI_RED);
        }

    }

    public void updateProduct() {
        int ID = 0;
        String name;
        String color;
        double price;
        boolean found = false;
        System.out.print("\n\t\t\t\t\tInput ID Need Update: ");
        ID = Validate.getAInteger();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getID() == ID) {
                System.out.print("\t\t\t\t\tInput New Name: ");
                name = sc.nextLine();
                data.get(i).setName(name);
                System.out.print("\t\t\t\t\tInput New Price: ");
                price = Validate.getADouble();
                data.get(i).setPrice(price);
                found = true;
                System.out.println(ColorText.ANSI_GREEN + "\n\t\t\t\t\t~~~UPDATE SUCCESSFULLY." + ColorText.ANSI_GREEN);
                IOFileMenu.writeToFile(data, MENU_FILE);
                return;
            }
        }
        if (!found) {
            System.out.println(ColorText.ANSI_RED + "\n\t\t\t\t\t~~~NOT FOUND ID." + ColorText.ANSI_RED);
        }
    }

    public void deleteProduct() {
        int ID = 0;
        System.out.print("\n\t\t\t\t\tInput ID Need Delete: ");
        ID = Validate.getAInteger();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getID() == ID) {
                int choice;
                System.out.println(ColorText.ANSI_RED + "\n\t\t\t\t\t~~~ARE YOU SURE ?" + ColorText.ANSI_RED);
                System.out.println("\t\t\t\t\t1. I'm Sure.");
                System.out.println("\t\t\t\t\t2. Return.");
                System.out.print("\n\t\t\t\t\t\t---Please Choose: ");
                choice = Validate.getAInteger();
                switch (choice) {
                    case 1:
                        data.remove(i);
                        System.out.println(ColorText.ANSI_GREEN + "\t\t\t\t\t~~~DELETE SUCCESSFULLY." + ColorText.ANSI_GREEN);
                        break;
                    case 2:
                        return;
                }
            }
        }
        IOFileMenu.writeToFile(data, MENU_FILE);
    }

    public void orderDrink() {
        int ID, quantity = 0, choice, i, valid = 0, choiceAgain = 0;
        double sum = 0, subTotal = 0;
        data = IOFileMenu.readFromFile(MENU_FILE);
        info = IOFileMenu.readFromFile(BILL_FILE);
        Calendar date = Calendar.getInstance();
        viewProduct();
        do {
            boolean found = false;
            do {
                System.out.print("\n\t\t\t\t\tChoose DRINK By Input ID: ");
                ID = Validate.getAInteger();
                for (i = 0; i < data.size(); i++) {
                    if (data.get(i).getID() == ID) {
                        found = true;
                        System.out.print("\t\t\t\t\tInput Quantity: ");
                        quantity = Validate.getAInteger();
                        if (quantity > data.get(i).getQuantity()) {
                            System.out.printf(ColorText.ANSI_RED + "\t\t\tTHE PRODUCT %s JUST ONLY HAVE %d ONES!, PLEASE INPUT AGAIN OR CHOOSE ANOTHER!\n" + ColorText.ANSI_RED + data.get(i).getName(), data.get(i).getQuantity());
                            choiceAgain = 0;
                        } else {
                            data.get(i).setQuanity(data.get(i).getQuantity() - quantity);
                            subTotal = quantity * data.get(i).getPrice();
                            Bill newBill = new Bill(data.get(i).getID(), data.get(i).getName(), data.get(i).getPrice(), quantity, subTotal);
                            info.add(newBill);
                            System.out.printf("\n\t\t\t\t|%-3s|%-10s|%-5s|%-7s|%-5s\n", "ID", "Name", "Price", "Quantity", "Total");
                            System.out.println(newBill.toString());
                            sum = sum + subTotal;
                            choiceAgain = 1;
                        }
                    }
                }
                if (!found) {
                    System.out.println(ColorText.ANSI_RED + "\n\t\t\t\t\t~~~NOT FOUND ID." + ColorText.ANSI_RED);
                }

            } while (found == false);
            System.out.print(ColorText.ANSI_CYAN + "\n\t\t\t\t\tEnter '1' To Finish Or Press Other Number To Continue: " + ColorText.ANSI_CYAN);
            choice = Validate.getAInteger();
        } while (choice != 1 || choiceAgain == 0);
        IOFileMenu.writeToFile(data, MENU_FILE);
        System.out.println(ColorText.ANSI_RED + "\n\t\t\t\t\t~~~ARE YOU MEMBER? " + ColorText.ANSI_RED);
        System.out.print(ColorText.ANSI_CYAN + "\n\t\t\t\t\tPress '1' If You Are Member OR Other Numbers To Finish: " + ColorText.ANSI_CYAN);
        if (Validate.getAInteger() == 1) {
            int number, answer = 0;
            do {
                System.out.print("\n\t\t\t\t\tEnter Your ID: ");
                number = Validate.getAInteger();
                if (dataMember.aMember(number)) {
                    if (dataMember.getMemberStar(number) < 100) {
                        sum = sum * 0.8;
                        info.get(info.size() - 1).setOff(20);
                    } else {
                        sum = sum * 0.7;
                        info.get(info.size() - 1).setOff(30);
                    }
                    info.get(info.size() - 1).setSum(sum);
                    info.get(info.size() - 1).setMemberName(dataMember.getMemberName(number));
                    dataMember.setMemberStar(number);
                    info.get(info.size() - 1).setMemberID(dataMember.getMemberID(number));
                    info.get(info.size() - 1).setStar(dataMember.getMemberStar(number));
                    info.get(info.size() - 1).setDate(date.getTime());
                    System.out.printf("\t\t\t\t\t~~~TOTAL: %.1f, OFF: %.1f\n", info.get(info.size() - 1).getSum(), info.get(info.size() - 1).getOff());
                    IOFileMenu.writeToFile(info, BILL_FILE);
                    answer = 2;
                    valid++;
                } else {
                    System.out.println("\n" + ColorText.ANSI_RED + "\t\t\t\t\t~~~SORRY BUT YOU ARE NOT MEMBER!\n" + ColorText.ANSI_RED);
                    System.out.print(ColorText.ANSI_CYAN + "\t\t\t\t\tPress '1' To Continue Or Other Numbers To Finish: " + ColorText.ANSI_CYAN);
                    answer = Validate.getAInteger();
                }
            } while (answer == 1);
        }
        info.get(info.size() - 1).setSum(sum);
        info.get(info.size() - 1).setDate(date.getTime());
        System.out.printf("\n\t\t\t\t\t~~~TOTAL: %.1f, OFF: %.1f\n", info.get(info.size() - 1).getSum(), info.get(info.size() - 1).getOff());
        IOFileMenu.writeToFile(info, BILL_FILE);

        if (subTotal >= 100 && valid == 0) {
            System.out.print(ColorText.ANSI_CYAN + "\t\t\t\t\tEnter 1 If You Want To Add Member: " + ColorText.ANSI_CYAN);
            if (Validate.getAInteger() == 1) {
                dataMember.addNewMember();
            }
        }
    }

    public void viewAllBills() {
        info.clear();
        info = IOFileMenu.readFromFile(BILL_FILE);
        System.out.println("\t\t\t\t----------------------------NEW BILL---------------------------------------");
        System.out.printf("\t\t\t\t|%-3s|%-10s|%-5s|%-7s|%-5s\n", "ID", "Name", "Price", "Quantity", "Total");
        for (int i = 0; i < info.size(); i++) {
            if (info.get(i).getSum() == 0) {
                System.out.println(info.get(i).toString());
            }
            if (info.get(i).getSum() > 0) {
                System.out.println(info.get(i).toString());
                System.out.println("\t\t\t\t__________________________________________________________________");
                System.out.printf("\t\t\t\tTOTAL: %.1f, OFF: %.1f\n", info.get(i).getSum(), info.get(i).getOff());
                if (info.get(i).getOff() > 0) {
                    System.out.printf("\t\t\t\tMember: %s, ID: %d, Star: %d\n", info.get(i).getMemberName(), info.get(i).getMemberID(), info.get(i).getMemberStar());
                }
                System.out.println("\t\t\t\t" + info.get(i).getDate() + "\n");
                if (i != info.size() - 1) {
                    System.out.println("\t\t\t\t----------------------------NEW BILL---------------------------------------");
                    System.out.printf("\t\t\t\t|%-3s|%-10s|%-5s|%-7s|%-5s\n", "ID", "Name", "Price", "Quantity", "Total");
                }
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
