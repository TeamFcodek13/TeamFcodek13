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
public class MemberData {

    Scanner sc = new Scanner(System.in);
    VipMember newMember;

    ArrayList<VipMember> data = new ArrayList<VipMember>();
    static final String MEMBER_FILE = "ListMember.txt";

    public void addNewMember() {
        String name;
        int phone;
        System.out.print("Input New Member Name: ");
        name = sc.nextLine();
        do {
            System.out.print("Input Five Last Phone Numbers: ");
            phone = Validate.getAInteger();
            if (aMember(phone)) {
                System.out.println("Phone number has already existed!");
            }
        } while (aMember(phone));
        System.out.println("\n=*=ADDED SUCCESSFUL=*=\n");
        newMember = new VipMember(name, phone);
        data.add(newMember);
        IOFileMenu.writeToFile(data, MEMBER_FILE);
    }

    public void viewAllMember() {
        data.clear();
        System.out.println("\n=*=LIST MEMBER=*=\n");
        data = IOFileMenu.readFromFile(MEMBER_FILE);
        System.out.printf("|%-10s|%-5s|\n", "Name", "Phone");
        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i).toString());
        }
    }

    public int getMemberID(int number) {
        data.clear();
        data = IOFileMenu.readFromFile(MEMBER_FILE);
        for (int i = 0; i < data.size(); i++) {
            if (number == data.get(i).getFiveLastPhoneNumbers()) {
                return number;
            }
        }
        return -1;
    }

    public String getMemberName(int number) {
        data.clear();
        data = IOFileMenu.readFromFile(MEMBER_FILE);
        for (int i = 0; i < data.size(); i++) {
            if (number == data.get(i).getFiveLastPhoneNumbers()) {
                return data.get(i).getName();
            }
        }
        return null;
    }

    public boolean aMember(int number) {
        data.clear();
        data = IOFileMenu.readFromFile(MEMBER_FILE);
        if (data.size() == 0) {
            return false;
        }
        for (int i = 0; i < data.size(); i++) {
            if (number == data.get(i).getFiveLastPhoneNumbers()) {
                return true;
            }
        }
        return false;
    }
}
