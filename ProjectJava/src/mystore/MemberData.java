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
        System.out.print("Input New Member Name: ");
        name = sc.nextLine();
        do {
            System.out.print("Input ID: ");
            id = Validate.getAInteger();
            if (aMember(id)) {
                System.out.println("ID has already existed!");
            }
        } while (aMember(id));
        phone = Validate.getPhone();
        System.out.println("\n=*=ADDED SUCCESSFUL=*=\n");
        newMember = new VipMember(id, name, phone);
        data.add(newMember);
        IOFileMenu.writeToFile(data, MEMBER_FILE);
    }

    public void viewAllMember() {
        data.clear();
        System.out.println("\n=*=LIST MEMBER=*=\n");
        data = IOFileMenu.readFromFile(MEMBER_FILE);
        System.out.printf("%-5s|%-7s|%-12s|%-5s\n", "ID", "Name", "Phone", "Star");
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

    public void setMemberStar(int number) {
        data.clear();
        data = IOFileMenu.readFromFile(MEMBER_FILE);
        for (int i = 0; i < data.size(); i++) {
            if (number == data.get(i).getId()) {
                data.get(i).setStar(data.get(i).getStar() + 1);
            }
        }
        IOFileMenu.writeToFile(data, MEMBER_FILE);

    }

    public void findMember() {
        System.out.print("Enter ID: ");
        int number = Validate.getAInteger();
        boolean found = false;
        data.clear();
        data = IOFileMenu.readFromFile(MEMBER_FILE);
        for (int i = 0; i < data.size(); i++) {
            if (number == data.get(i).getId()) {
                System.out.printf("%-5s|%-7s|%-12s|%-5s\n", "ID", "Name", "Phone", "Star");
                System.out.println(data.get(i).toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Not found Member @@.");
        }
    }

    public void updateMember() {
        String name, phone;
        int star;
        boolean found = false;
        data.clear();
        data = IOFileMenu.readFromFile(MEMBER_FILE);
        System.out.print("Enter ID: ");
        int number = Validate.getAInteger();
        for (int i = 0; i < data.size(); i++) {
            if (number == data.get(i).getId()) {
                System.out.printf("%-5s|%-7s|%-12s|%-5s\n", "ID", "Name", "Phone", "Star");
                System.out.println(data.get(i).toString());
                System.out.print("Input Member's Name: ");
                name = sc.nextLine();
                phone = Validate.getPhone();
                System.out.print("Input Member's Star: ");
                star = Validate.getAInteger();
                newMember = new VipMember(data.get(i).getId(), name, phone);
                newMember.setStar(star);
                data.set(i, newMember);
                System.out.printf("%-5s|%-7s|%-12s|%-5s\n", "ID", "Name", "Phone", "Star");
                System.out.println(data.get(i).toString());
                System.out.println("CHANGED SUCCESSFULLY");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Not found Member @@.");
        }
        IOFileMenu.writeToFile(data, MEMBER_FILE);

    }

    public boolean aMember(int number) {
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
