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
public class LoginData {

    Scanner sc = new Scanner(System.in);

    AccountManager account;

    ArrayList<AccountManager> data = new ArrayList<AccountManager>();

    static final String ACCOUNT_FILE = "Account.txt";

    public void changePassword() {

        String password1;
        String password2;
        String newPassword;

        System.out.print("\nEnter Current Password: ");
        password1 = sc.nextLine();
        System.out.print("Enter Current Password Again: ");
        password2 = sc.nextLine();
        System.out.print("Enter New Password: ");
        newPassword = sc.nextLine();
        if (data.get(0).getPassword().equals(password1)) {
            if (password1.equals(password2)) {
                System.out.println("\nCHANGE PASSWORD SUCCESSFULLY.");
                data.get(0).setPassword(newPassword);
                IOFileMenu.writeToFile(data, ACCOUNT_FILE);
            } else {
                System.out.println("\nENTER CURRENT PASSWORD AGAIN INCORRECT. ");
            }
        }
        else {
            System.out.println("\nINCORRECT CURRENT PASSWORD.");
        }
    }

    public void createNewAccount() {
        String userName;
        String password;

        System.out.print("\nInput NEW User Name: ");
        userName = sc.nextLine();
        System.out.print("Input NEW Password: ");
        password = sc.nextLine();
        System.out.println("\nCREATE NEW ACCOUNT SUCCESSFULLY.");
        
        account = new AccountManager(userName, password);
        data.clear();
        data.add(account);

        IOFileMenu.writeToFile(data, ACCOUNT_FILE);
    }

    public void login() {
        int i = 1;
        boolean match = false;
        String userName;
        String password;
        int lastIndex;
        do {
            data.clear();
            data = IOFileMenu.readFromFile(ACCOUNT_FILE);
            System.out.println("\n==*==LOGIN==*==");
            System.out.print("\nInput User Name: ");
            userName = sc.nextLine();
            System.out.print("Input Password: ");
            password = sc.nextLine();

            account = new AccountManager(userName, password);
            data = IOFileMenu.readFromFile(ACCOUNT_FILE);
            data.add(account);
            lastIndex = data.size() - 1;
            if ((data.get(lastIndex).getUserName().equals(data.get(0).getUserName()))
                    && (data.get(lastIndex).getPassword().equals(data.get(0).getPassword()))) {
                match = true;

            } else {
                match = false;
                System.out.println("\nINCORRECT USERNAME OR PASSWORD.");
                System.out.println("PLEASE INPUT AGAIN.\n");
            }
        } while (match == false);

    }

}
