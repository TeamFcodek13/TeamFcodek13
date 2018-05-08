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
        name = sc.nextLine().trim().toUpperCase();
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
            if (data.get(i).getQuantity() != 0) {
                System.out.println(data.get(i).toString());
            }
        }

    }

    public void findProduct() {
        int id = 0;
        boolean found = false;
        data = IOFileMenu.readFromFile(MENU_FILE);
        System.out.printf("\t\t\t\t\t\t|%-3s|%-10s|%-5s|%-9s\n", "ID", "Name", "Price", "Quantity");
        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i).toStringwithQuantity());
        }
        System.out.print("\n\t\t\t\t\tInput ID Need To Find: ");
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

    public void updateProduct() {
        int ID = 0, quantity;
        String name;
        double price;
        boolean found = false;
        data = IOFileMenu.readFromFile(MENU_FILE);
        System.out.printf("\t\t\t\t\t\t|%-3s|%-10s|%-5s|%-9s\n", "ID", "Name", "Price", "Quantity");
        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i).toStringwithQuantity());
        }
        System.out.print("\n\t\t\t\t\tInput ID Need Update: ");
        ID = Validate.getAInteger();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getID() == ID) {
                System.out.printf("\t\t\t\t\t\t|%-3s|%-10s|%-5s|%-9s\n", "ID", "Name", "Price", "Quantity");
                System.out.println(data.get(i).toStringwithQuantity());
                System.out.print("\t\t\t\t\tInput New Name: ");
                name = sc.nextLine().trim().toUpperCase();
                data.get(i).setName(name);
                System.out.print("\t\t\t\t\tInput New Price: ");
                price = Validate.getADouble();
                data.get(i).setPrice(price);
                System.out.print("\t\t\t\t\tInput Quanity: ");
                quantity = Validate.getAInteger();
                data.get(i).setQuanity(quantity);
                found = true;
                System.out.printf("\t\t\t\t\t\t|%-3s|%-10s|%-5s|%-9s\n", "ID", "Name", "Price", "Quantity");
                System.out.println(data.get(i).toStringwithQuantity());
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
        boolean found = false;
        data = IOFileMenu.readFromFile(MENU_FILE);
        System.out.print("\n\t\t\t\t\tInput ID Need Delete: ");
        ID = Validate.getAInteger();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getID() == ID) {
                found = true;
                int choice;
                System.out.println(ColorText.ANSI_RED + "\n\t\t\t\t\t~~~ARE YOU SURE ?" + ColorText.ANSI_RED);
                System.out.println("\t\t\t\t\t1. I'm Sure.");
                System.out.println("\t\t\t\t\t2. Return.");
                System.out.print("\n\t\t\t\t\t\t---Please Choose: ");
                choice = Validate.getChoice(0, 3);
                switch (choice) {
                    case 1:
                        data.remove(i);
                        System.out.println(ColorText.ANSI_GREEN + "\t\t\t\t\t~~~DELETE SUCCESSFULLY." + ColorText.ANSI_GREEN);
                        break;
                    case 2:
                        return;
                }
                found = true;
                IOFileMenu.writeToFile(data, MENU_FILE);
            }
        }
        if (!found) {
            System.out.println(ColorText.ANSI_RED + "\n\t\t\t\t\t~~~NOT FOUND ID." + ColorText.ANSI_RED);
        }
        IOFileMenu.writeToFile(data, MENU_FILE);
    }

    public void orderDrink() {
        final int minBillOrStar = 100;
        final int minTotal = 300;
        final int bigBillSmallStar = 20;
        final int smallBillBigStar = 10;
        final int bigBillBigStar = 25;
        int ID, quantity = 0, choice, i, valid = 0, billID;
        double sum = 0, subTotal = 0;
        data = IOFileMenu.readFromFile(MENU_FILE);
        info = IOFileMenu.readFromFile(BILL_FILE);
        billID = info.get(info.size() - 1).getbillID() + 1;
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
                            System.out.printf(ColorText.ANSI_RED + "\t\t\tTHE PRODUCT %s JUST ONLY HAVE %s ONES!, PLEASE INPUT AGAIN OR CHOOSE ANOTHER!\n", data.get(i).getName(), data.get(i).getQuantity());
                        } else {
                            data.get(i).setQuanity(data.get(i).getQuantity() - quantity);
                            subTotal = quantity * data.get(i).getPrice();
                            Bill newBill = new Bill(data.get(i).getID(), data.get(i).getName(), data.get(i).getPrice(), quantity, subTotal);
                            info.add(newBill);
                            System.out.printf("\n\t\t\t\t|%-3s|%-10s|%-5s|%-7s|%-5s\n", "ID", "Name", "Price", "Quantity", "Total");
                            System.out.println(newBill.toString());
                            sum = sum + subTotal;
                        }
                    }
                }
                if (!found) {
                    System.out.println(ColorText.ANSI_RED + "\n\t\t\t\t\t~~~NOT FOUND ID." + ColorText.ANSI_RED);
                }
            } while (found == false);
            System.out.print(ColorText.ANSI_CYAN + "\n\t\t\t\t\tEnter '1' To Finish Or Press Other Number To Continue: " + ColorText.ANSI_CYAN);
            choice = Validate.getAInteger();
        } while (choice != 1);
        if (sum == 0) {
            System.out.println("\t\t\t\t\tOK BYE!!");
        } else {
            IOFileMenu.writeToFile(data, MENU_FILE);
            System.out.println(ColorText.ANSI_RED + "\n\t\t\t\t\t~~~ARE YOU MEMBER? " + ColorText.ANSI_RED);
            System.out.print(ColorText.ANSI_CYAN + "\n\t\t\t\t\tPress '1' If You Are Member OR Other Numbers To Finish: " + ColorText.ANSI_CYAN);
            if (Validate.getAInteger() == 1) {
                int number, answer = 0;
                do {
                    System.out.print("\n\t\t\t\t\tEnter Your ID: ");
                    number = Validate.getAInteger();
                    if (dataMember.isAMember(number)) {
                        if (dataMember.getMemberStar(number) < minBillOrStar) {
                            if (sum < minTotal) {
                                dataMember.setMemberStar(number, minTotal / minTotal);
                            } else {
                                dataMember.setMemberStar(number, minTotal / 100);
                            }
                        }
                        if (dataMember.getMemberStar(number) < minBillOrStar) {
                            if (sum < minTotal) {
                                System.out.printf("\t\t\tBILL MUSTN'T LESS THAN %d TO GET OFF!\n", minTotal);
                            } else {
                                sum = sum * 0.8;
                                info.get(info.size() - 1).setOff(bigBillSmallStar);
                            }
                        } else {
                            if (sum < minTotal) {
                                sum = sum * 0.9;
                                info.get(info.size() - 1).setOff(smallBillBigStar);
                            } else {
                                sum = sum * 0.75;
                                info.get(info.size() - 1).setOff(bigBillBigStar);
                            }
                        }
                        info.get(info.size() - 1).setMemberName(dataMember.getMemberName(number));
                        info.get(info.size() - 1).setMemberID(dataMember.getMemberID(number));
                        info.get(info.size() - 1).setStar(dataMember.getMemberStar(number));
                        answer = 2;
                        valid++;
                    } else {
                        System.out.println("\n" + ColorText.ANSI_RED + "\t\t\t\t\t~~~SORRY BUT YOU ARE NOT MEMBER!\n" + ColorText.ANSI_RED);
                        System.out.print(ColorText.ANSI_CYAN + "\t\t\t\t\tPress '1' To Continue Or Other Numbers To Finish: " + ColorText.ANSI_CYAN);
                        answer = Validate.getAInteger();
                    }
                } while (answer == 1);
            }
            info.get(info.size() - 1).setbillID(billID);
            info.get(info.size() - 1).setSum(sum);
            info.get(info.size() - 1).setDate(date.getTime());
            System.out.printf("\n\t\t\t\t\t~~~TOTAL: %.1f, OFF: %.1f\n", info.get(info.size() - 1).getSum(), info.get(info.size() - 1).getOff());
            IOFileMenu.writeToFile(info, BILL_FILE);
            if (subTotal >= minBillOrStar && valid == 0) {
                System.out.print(ColorText.ANSI_CYAN + "\t\t\t\t\tEnter 1 If You Want To Add Member: " + ColorText.ANSI_CYAN);
                if (Validate.getAInteger() == 1) {
                    dataMember.addNewMember();
                }
            }
        }
    }

    public void viewAllBills() {
        info.clear();
        info = IOFileMenu.readFromFile(BILL_FILE);
        System.out.println("\t\t\t\t\t1. View All Bills");
        System.out.println("\t\t\t\t\t2. Find Bills In A Space ");
        System.out.println("\t\t\t\t\t3. Find A Bill ");
        System.out.print("\t\t\t\t\tYour choice: ");
        int choose = Validate.getAInteger();
        switch (choose) {
            case 1:
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
                        System.out.printf("\t\t\t\tBill ID: %d\n", info.get(i).getbillID());
                        System.out.println("\t\t\t\t" + info.get(i).getDate() + "\n");
                        if (i != info.size() - 1) {
                            System.out.println("\t\t\t\t----------------------------NEW BILL---------------------------------------");
                            System.out.printf("\t\t\t\t|%-3s|%-10s|%-5s|%-7s|%-5s\n", "ID", "Name", "Price", "Quantity", "Total");
                        }
                    }

                }
                break;
            case 2:
                int max,
                 min,
                 j;
                do {
                    System.out.print("\t\t\t\tEnter max ID: ");
                    max = Validate.getAInteger();
                    System.out.print("\t\t\t\tEnter min ID: ");
                    min = Validate.getAInteger();
                    if (max < min) {
                        System.out.println("\t\t\tThe Max ID Must Be Bigger Than The Min ID!!");
                    }
                } while (max < min);
                info.clear();
                info = IOFileMenu.readFromFile(BILL_FILE);
                if (info.get(info.size() - 1).getbillID() < min) {
                    System.out.printf("\n\t\t\t\tERROR, MAX ID IS %d \n", info.get(info.size() - 1).getbillID());
                } else {
                    for (int i = 0; i < info.size(); i++) {
                        if (info.get(i).getbillID() >= min && info.get(i).getbillID() <= max) {
                            System.out.println("\t\t\t\t----------------------------NEW BILL---------------------------------------");
                            System.out.printf("\t\t\t\t|%-3s|%-10s|%-5s|%-7s|%-5s\n", "ID", "Name", "Price", "Quantity", "Total");
                            j = i - 1;
                            if (j >= 0) {
                                do {
                                    if (info.get(j).getSum() == 0) {
                                        System.out.println(info.get(j).toString());
                                    } else {
                                        break;
                                    }
                                    j--;
                                } while (j >= 0 && info.get(j).getSum() == 0);
                            }
                            System.out.println(info.get(i).toString());
                            System.out.println("\t\t\t\t__________________________________________________________________");
                            System.out.printf("\t\t\t\tTOTAL: %.1f, OFF: %.1f\n", info.get(i).getSum(), info.get(i).getOff());
                            if (info.get(i).getOff() > 0) {
                                System.out.printf("\t\t\t\tMember: %s, ID: %d, Star: %d\n", info.get(i).getMemberName(), info.get(i).getMemberID(), info.get(i).getMemberStar());
                            }
                            System.out.printf("\t\t\t\tBill ID: %d\n", info.get(i).getbillID());
                            System.out.println("\t\t\t\t" + info.get(i).getDate() + "\n");
                        }
                    }
                }
                break;
            case 3:
                int id;
                boolean found = false;
                System.out.print("\t\t\t\t\tEnter ID: ");
                id = Validate.getAInteger();
                info.clear();
                info = IOFileMenu.readFromFile(BILL_FILE);
                for (int i = 0; i < info.size(); i++) {
                    if (info.get(i).getbillID() == id) {
                        found = true;
                        System.out.println("\t\t\t\t----------------------------NEW BILL---------------------------------------");
                        System.out.printf("\t\t\t\t|%-3s|%-10s|%-5s|%-7s|%-5s\n", "ID", "Name", "Price", "Quantity", "Total");

                        j = i - 1;
                        if (j >= 0) {
                            do {
                                if (info.get(j).getSum() == 0) {
                                    System.out.println(info.get(j).toString());
                                } else {
                                    break;
                                }
                                j--;
                            } while (j >= 0 && info.get(j).getSum() == 0);
                        }
                        System.out.println(info.get(i).toString());
                        System.out.println("\t\t\t\t__________________________________________________________________");
                        System.out.printf("\t\t\t\tTOTAL: %.1f, OFF: %.1f\n", info.get(i).getSum(), info.get(i).getOff());
                        if (info.get(i).getOff() > 0) {
                            System.out.printf("\t\t\t\tMember: %s, ID: %d, Star: %d\n", info.get(i).getMemberName(), info.get(i).getMemberID(), info.get(i).getMemberStar());
                        }
                        System.out.printf("\t\t\t\tBill ID: %d\n", info.get(i).getbillID());
                        System.out.println("\t\t\t\t" + info.get(i).getDate() + "\n");
                    }
                }
                if (!found) {
                    System.out.println("\n\t\t\t\t\tNOT FOUND ID!");
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
