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
        Product newProduct = new Product(ID, name, price);
        System.out.print("Quantity: ");
        quantity = Validate.getAInteger();
        newProduct.setQuanity(quantity);
        System.out.println("\n=*=ADDED SUCCESSFULLY=*=\n");
        data.add(newProduct);
        IOFileMenu.writeToFile(data, MENU_FILE);
    }

    public void viewProduct() {
        data.clear();
        System.out.println("\n=*=MENU=*=\n");
        data = IOFileMenu.readFromFile(MENU_FILE);
        System.out.printf(ColorText.ANSI_BLUE + "|%-3s|%-10s|%-5s|\n", "ID", "Name", "Price");
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
                System.out.printf(ColorText.ANSI_BLUE + "\n|%-3s|%-10s|%-5s|\n", "ID", "Name", "Price");
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
                System.out.printf(ColorText.ANSI_BLUE + "\n|%-3s|%-10s|%-5s|\n", "ID", "Name", "Price");
                System.out.println(data.get(i).toString());
                System.out.print("Input new name: ");
                name = sc.nextLine();
                data.get(i).setName(name);
                System.out.print("Input new price: ");
                price = Validate.getADouble();
                data.get(i).setPrice(price);
                found = true;
                System.out.println("\n=*=UPDATE SUCCESSFULLY=*=");
                System.out.printf(ColorText.ANSI_BLUE + "\n|%-3s|%-10s|%-5s|\n", "ID", "Name", "Price");
                System.out.println(data.get(i).toString());
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
        boolean found = false;
        System.out.print("\n---Input ID need delete: ");
        ID = Validate.getAInteger();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getID() == ID) {
                int choice;
                System.out.printf(ColorText.ANSI_BLUE + "\n|%-3s|%-10s|%-5s|\n", "ID", "Name", "Price");
                System.out.println(data.get(i).toString());
                System.out.println("\nAre you SURE ?");
                System.out.println("1. I'm sure.");
                System.out.println("2. Return.");
                System.out.print("\n---Please choose: ");
                choice = Validate.getAInteger();
                switch (choice) {
                    case 1:
                        data.remove(i);
                        System.out.println("=*=DELETE SUCCESSFULLY=*=");
                        break;
                    case 2:
                        return;
                }
                IOFileMenu.writeToFile(data, MENU_FILE);
            }
        }
        if (!found) {
            System.out.println("\n=*=Not Found ID=*=");
        }
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
                System.out.print("\n1. Please choose DRINK by input ID: ");
                ID = Validate.getAInteger();
                for (i = 0; i < data.size(); i++) {
                    if (data.get(i).getID() == ID) {
                        found = true;
                        System.out.print("Input quantity: ");
                        quantity = Validate.getAInteger();
                        if (quantity > data.get(i).getQuantity()) {
                            System.out.printf("The product %s just only have %d ones!, please input again or choose another!\n", data.get(i).getName(), data.get(i).getQuantity());
                            choiceAgain = 0;
                        } else {
                            data.get(i).setQuanity(data.get(i).getQuantity() - quantity);
                            subTotal = quantity * data.get(i).getPrice();
                            Bill newBill = new Bill(data.get(i).getID(), data.get(i).getName(), data.get(i).getPrice(), quantity, subTotal);
                            info.add(newBill);
                            System.out.printf("\n|%-3s|%-10s|%-5s|%-7s|%-5s\n", "ID", "Name", "Price", "Quantity", "Total" + ColorText.ANSI_BLUE);
                            System.out.println(newBill.toString());
                            sum = sum + subTotal;
                            choiceAgain = 1;
                        }
                    }
                }
                if (!found) {
                    System.out.println("\nNot found ID." + ColorText.ANSI_RED);
                }

            } while (found == false);
            System.out.print("\nEnter '1' to finish or Press other number to continue: ");
            choice = Validate.getAInteger();
        } while (choice != 1 || choiceAgain == 0);
        IOFileMenu.writeToFile(data, MENU_FILE);
        System.out.println("Are you a member? ");
        System.out.print("Press '1' If You're Member OR Other Numbers To Finish: ");
        if (Validate.getAInteger() == 1) {
            int number, answer = 0;
            do {
                System.out.print("Enter Your ID: ");
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
                    System.out.printf("Total: %.1f, off: %.1f\n", info.get(info.size() - 1).getSum(), info.get(info.size() - 1).getOff());
                    IOFileMenu.writeToFile(info, BILL_FILE);
                    answer = 2;
                    valid++;
                } else {
                    System.out.println(ColorText.ANSI_RED + "Sorry But You're Not Member!\n");
                    System.out.print("Press '1' To Continue Or Other Numbers To Finish: ");
                    answer = Validate.getAInteger();
                }
            } while (answer == 1);
        } else {
            info.get(info.size() - 1).setSum(sum);
            info.get(info.size() - 1).setDate(date.getTime());
            System.out.printf("\nTotal: %.1f, off: %.1f\n", info.get(info.size() - 1).getSum(), info.get(info.size() - 1).getOff());
            IOFileMenu.writeToFile(info, BILL_FILE);
        }

        if (subTotal >= 100 && valid == 0) {
            System.out.print("Enter 1 if you want to add member: ");
            if (Validate.getAInteger() == 1) {
                dataMember.addNewMember();
            }
        }
    }

    public void viewAllBills() {
        info.clear();
        info = IOFileMenu.readFromFile(BILL_FILE);
        System.out.println("----------------------------NEW BILL---------------------------------------");
        System.out.printf(ColorText.ANSI_BLUE + "|%-3s|%-10s|%-5s|%-7s|%-5s\n", "ID", "Name", "Price", "Quantity", "Total");
        for (int i = 0; i < info.size(); i++) {
            if (info.get(i).getSum() == 0) {
                System.out.println(info.get(i).toString());
            }
            if (info.get(i).getSum() > 0) {
                System.out.println(info.get(i).toString());
                System.out.println("__________________________________________________________________");
                System.out.printf("Total: %.1f, off: %.1f\n", info.get(i).getSum(), info.get(i).getOff());
                if (info.get(i).getOff() > 0) {
                    System.out.printf("Member: %s, ID: %d, Star: %d\n", info.get(i).getMemberName(), info.get(i).getMemberID(), info.get(i).getMemberStar());
                }
                System.out.println(info.get(i).getDate() + "\n");
                if (i != info.size() - 1) {
                    System.out.println("----------------------------NEW BILL---------------------------------------");
                    System.out.printf(ColorText.ANSI_BLUE + "|%-3s|%-10s|%-5s|%-7s|%-5s\n", "ID", "Name", "Price", "Quantity", "Total");
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
