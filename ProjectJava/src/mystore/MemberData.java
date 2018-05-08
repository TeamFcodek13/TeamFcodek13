/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mystore;

import java.util.ArrayList;
import java.util.Scanner;
import mystore.IOFileMenu;

/**
 *
 * @author IMMORTALITY IPOS
 */
public class MemberData {

    Scanner sc = new Scanner(System.in);
    VipMember newMember;

    ArrayList<VipMember> data = new ArrayList<VipMember>();
    static final String MEMBER_FILE = "ListMember.txt";

    public void addNewMember() {
        String name, phone;
        int id;
        System.out.print("\t\t\t\t\tInput New Member Name: ");
        name = sc.nextLine().trim().toUpperCase();
        do {
            System.out.print("\t\t\t\t\tInput ID: ");
            id = Validate.getAInteger();
            if (isAMember(id)) {
                System.out.println(ColorText.ANSI_RED + "\t\t\t\t\t~~~ID HAS ALREADY EXISTED!" + ColorText.ANSI_RED);
            }
        } while (isAMember(id));
        phone = Validate.getPhone();
        System.out.println(ColorText.ANSI_GREEN + "\n\t\t\t\t\t~~~ADDED SUCCESSFUL.\n" + ColorText.ANSI_GREEN);
        newMember = new VipMember(id, name, phone);
        data.add(newMember);
        IOFileMenu.writeToFile(data, MEMBER_FILE);
    }

    public void viewAllMember() {
        data.clear();
        System.out.println(ColorText.ANSI_RED + "\n\t\t\t\t\t\t=*=LIST MEMBER=*=\n" + ColorText.ANSI_RED);
        data = IOFileMenu.readFromFile(MEMBER_FILE);
        System.out.printf("\t\t\t\t\t\t%-5s|%-7s|%-12s|%-5s\n", "ID", "Name", "Phone", "Star");
        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i).toString());
        }
    }

    public int getMemberID(int number) {
        data.clear();
        data = IOFileMenu.readFromFile(MEMBER_FILE);
        for (int i = 0; i < data.size(); i++) {
            if (number == data.get(i).getId()) {
                return number;
            }
        }
        return -1;
    }

    public String getMemberName(int number) {
        data.clear();
        data = IOFileMenu.readFromFile(MEMBER_FILE);
        for (int i = 0; i < data.size(); i++) {
            if (number == data.get(i).getId()) {
                return data.get(i).getName();
            }
        }
        return null;
    }

    public int getMemberStar(int number) {
        data.clear();
        data = IOFileMenu.readFromFile(MEMBER_FILE);
        for (int i = 0; i < data.size(); i++) {
            if (number == data.get(i).getId()) {
                return data.get(i).getStar();
            }
        }
        return -1;

    }

    public void setMemberStar(int number, int sum) {
        data.clear();
        data = IOFileMenu.readFromFile(MEMBER_FILE);
        for (int i = 0; i < data.size(); i++) {
            if (number == data.get(i).getId()) {
                data.get(i).setStar(data.get(i).getStar() + sum);
            }
        }
        IOFileMenu.writeToFile(data, MEMBER_FILE);

    }

    public void findMember() {
        System.out.print("\t\t\t\t\tEnter ID: ");
        int number = Validate.getAInteger();
        boolean found = false;
        data.clear();
        data = IOFileMenu.readFromFile(MEMBER_FILE);
        for (int i = 0; i < data.size(); i++) {
            if (number == data.get(i).getId()) {
                System.out.printf("\t\t\t\t\t\t%-5s|%-7s|%-12s|%-5s\n", "ID", "Name", "Phone", "Star");
                System.out.println(data.get(i).toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println(ColorText.ANSI_RED + "\t\t\t\t\t~~~NOT FOUND MEMBER." + ColorText.ANSI_RED);
        }
    }

    public void updateMember() {
        String name, phone;
        int star;
        boolean found = false;
        data.clear();
        data = IOFileMenu.readFromFile(MEMBER_FILE);
        System.out.print("\t\t\t\t\tEnter ID: ");
        int number = Validate.getAInteger();
        for (int i = 0; i < data.size(); i++) {
            if (number == data.get(i).getId()) {
                System.out.printf("\t\t\t\t\t\t%-5s|%-7s|%-12s|%-5s\n", "ID", "Name", "Phone", "Star");
                System.out.println(data.get(i).toString());
                System.out.print("\t\t\t\t\tInput Member's Name: ");
                name = sc.nextLine().trim().toUpperCase();
                phone = Validate.getPhone();
                do {
                    System.out.print("\t\t\t\t\tInput Member's Star: ");
                    star = Validate.getAInteger();
                    if (star > 100) {
                        System.out.println("\t\t\t\tSTAR MUSTN'T BE BIGGER THAN 100!");
                    }
                } while (star > 100);
                newMember = new VipMember(data.get(i).getId(), name, phone);
                newMember.setStar(star);
                data.set(i, newMember);
                System.out.printf("\t\t\t\t\t\t%-5s|%-7s|%-12s|%-5s\n", "ID", "Name", "Phone", "Star");
                System.out.println(data.get(i).toString());
                System.out.println(ColorText.ANSI_GREEN + "\t\t\t\t\t~~~CHANGED SUCCESSFULLY" + ColorText.ANSI_GREEN);
                found = true;
            }
        }
        if (!found) {
            System.out.println(ColorText.ANSI_RED + "\t\t\t\t\t~~~NOT FOUND MEMBER." + ColorText.ANSI_RED);
        }
        IOFileMenu.writeToFile(data, MEMBER_FILE);
    }

    public boolean isAMember(int number) {
        data.clear();
        data = IOFileMenu.readFromFile(MEMBER_FILE);
        if (data.size() == 0) {
            return false;
        }
        for (int i = 0; i < data.size(); i++) {
            if (number == data.get(i).getId()) {
                return true;
            }
        }
        return false;
    }
}
