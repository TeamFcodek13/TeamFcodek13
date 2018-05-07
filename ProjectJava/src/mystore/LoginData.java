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

        String password;
        String newPassword1;
        String newPassword2;
        
        data = IOFileMenu.readFromFile(ACCOUNT_FILE);
        System.out.print("\n\t\t\t\t\tEnter Current Password: ");
        password = sc.nextLine();
        System.out.print("\t\t\t\t\tEnter New Password: ");
        newPassword1 = Validate.inputPassword();
        System.out.print("\t\t\t\t\tEnter New Password Again: ");
        newPassword2 = Validate.inputPassword();
        if (data.get(0).getPassword().equals(password)) {
            if (newPassword1.equals(newPassword2)) {
                System.out.println(ColorText.ANSI_GREEN + "\n\t\t\t\t\t~~~CHANGE PASSWORD SUCCESSFULLY." + ColorText.ANSI_GREEN);
                data.get(0).setPassword(newPassword2);
                IOFileMenu.writeToFile(data, ACCOUNT_FILE);
            } else {
                System.out.println(ColorText.ANSI_RED + "\n\t\t\t\t\t~~~ENTER PASSWORD AGAIN INCORRECT. " + ColorText.ANSI_RED);
            }
        }
        else {
            System.out.println(ColorText.ANSI_RED + "\n\t\t\t\t\t~~~INCORRECT CURRENT PASSWORD." + ColorText.ANSI_RED);
        }
    }

    public void createNewAccount() {
        String userName;
        String password;

        System.out.print("\n\t\t\t\t\tInput NEW User Name: ");
        userName = sc.nextLine();
        System.out.print("\t\t\t\t\tInput NEW Password: ");
        password = Validate.inputPassword();
        System.out.println(ColorText.ANSI_GREEN + "\n\t\t\t\t\t~~~CREATE NEW ACCOUNT SUCCESSFULLY." + ColorText.ANSI_GREEN);
        
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
            System.out.println(ColorText.ANSI_RED + "\n\t\t\t\t\t\t\t==*==LOGIN==*==" + ColorText.ANSI_RED);
            System.out.print("\n\t\t\t\t\tInput User Name: ");
            userName = sc.nextLine();
            System.out.print("\t\t\t\t\tInput Password: ");
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
                System.out.println(ColorText.ANSI_RED + "\n\t\t\t\t\t~~~INCORRECT USERNAME OR PASSWORD." + ColorText.ANSI_RED);
                System.out.println(ColorText.ANSI_RED + "\t\t\t\t\t~~~PLEASE INPUT AGAIN.\n" + ColorText.ANSI_RED);
            }
        } while (match == false);

    }

}
