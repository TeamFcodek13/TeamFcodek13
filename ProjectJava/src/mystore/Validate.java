/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mystore;

import java.util.Scanner;

/**
 *
 * @author IMMORTALITY IPOS
 */
public class Validate {

    public static double getADouble() {
        Scanner sc = new Scanner(System.in);
        double number;
        while (true) {
            try {
                number = Double.parseDouble(sc.nextLine().trim());
                if (number > 0) {
                    return number;
                } else {
                    System.out.print("\n" + ColorText.ANSI_RED + "\t\t\t\t\t~~~YOU MUST ENTER A POSITIVE NUMBER!");
                    System.out.print("\n\t\t\t\t\t~~~Input Again: ");
                }
            } catch (Exception ex) {
                System.out.println(ColorText.ANSI_RED + "\n\t\t\t\t\t~~~YOU MUST ENTER A REAL NUMBER!" + ColorText.ANSI_RED);
                System.out.print("\n\t\t\t\t\t~~~Input Again: ");
            }
        }
    }

    public static int getAInteger() {
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            try {
                number = Integer.parseInt(sc.nextLine().trim());
                if (number > 0) {
                    return number;
                } else {
                    System.out.print("\n" + ColorText.ANSI_RED + "\t\t\t\t\t~~~YOU MUST ENTER A POSITIVE INTEGER!");
                    System.out.print("\n\t\t\t\t\t~~~Input Again: ");
                }
            } catch (Exception e) {
                System.out.println(ColorText.ANSI_RED + "\n\t\t\t\t\t~~~YOU MUST ENTER AN INTEGER!" + ColorText.ANSI_RED);
                System.out.print("\n\t\t\t\t\t~~~Input Again: ");
            }
        }
    }

    public static int getChoice(int num1, int num2) {
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            try {
                number = Integer.parseInt(sc.nextLine().trim());
                if (number > num1 && number < num2) {
                    return number;
                } else {
                    System.out.printf("\n" + ColorText.ANSI_RED + "\t\t\t\t\t~~~YOU MUST ENTER A POSITIVE INTEGER (%d < n < %d)!", num1, num2);
                    System.out.print("\n\n\t\t\t\t\t~~~Input Again: ");
                }
            } catch (Exception e) {
                System.out.println(ColorText.ANSI_RED + "\n\t\t\t\t\t~~~YOU MUST ENTER AN INTEGER!" + ColorText.ANSI_RED);
                System.out.print("\n\t\t\t\t\t~~~Input Again: ");
            }
        }
    }

    public static String getPhone() {
        Scanner sc = new Scanner(System.in);
        String rePhone = "0\\d{9,10}", phone;
        do {
            System.out.print("\t\t\t\t\tEnter Phone Number: ");
            phone = sc.nextLine().trim();
            if (phone.matches(rePhone)) {
                return phone;
            } else {
                System.out.println("\n\t\t\t\t\t~~YOU MUST ENTER 10 OR 11 NUMBERS BEGIN WITH 0 VÀ PHẢI VIẾT LIỀN NHAU!\n");
            }
        } while (!phone.matches(rePhone));
        return null;
    }

    public static String inputPassword() {
        Scanner sc = new Scanner(System.in);
        boolean found = false;
        String password;
        int i;
        do {
            password = sc.nextLine();
            for (i = 0; i < password.length(); i++) {
                if (Character.isWhitespace(password.charAt(i))) {
                    found = true;
                    System.out.println("\n" + ColorText.ANSI_RED + "\t\t\t\t\tPASSWORD IS NOT ALLOWED TO ENTER BLANK CHARACTERS!");
                    System.out.print("\n\t\t\t\t\tEnter Your Password Number Again: ");
                    break;
                } else {
                    found = false;
                }
            }
        } while (found == true);
        return password;
    }
}
