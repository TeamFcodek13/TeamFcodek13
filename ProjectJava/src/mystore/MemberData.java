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
        System.out.print("Input Five Last Phone Numbers: ");
        phone = Validate.getAInteger();
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
    
    public boolean findVipMember() {
        int i;
        int memberID;
        boolean found = false;
        data = IOFileMenu.readFromFile(MEMBER_FILE);
        do {
            System.out.print("\nInput Your Vip Member ID: ");
            memberID = Validate.getAInteger();
            for (i = 0; i < data.size(); i++) {
                if (data.get(i).getFiveLastPhoneNumbers()== memberID) {
                    System.out.println("\nHello " + data.get(i).getName() + " !");
                    found = true;
                }
            }
            if (!found && memberID != 1) {
                System.out.println("\nNot Found ID.");               
            }
            
        } while(found == false && memberID != 1);
        return found;
    }

}
