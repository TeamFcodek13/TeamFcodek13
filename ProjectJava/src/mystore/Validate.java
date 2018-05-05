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
                number = Double.parseDouble(sc.nextLine());
                return number;
            } catch (Exception ex) {
                System.out.println("\n\t\t\t\t\t~~~Input Again: ");
            }
        }
    }

    public static int getAInteger() {
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            try {
                number = Integer.parseInt(sc.nextLine());
                if (number > 0) {
                    return number;
                } else {
                    System.out.println("\n\t\t\t\t\t~~~Input Again: ");
                }
            } catch (Exception e) {
                System.out.println("\n\t\t\t\t\t~~~Input Again: ");
            }
        }
    }

    public static String getPhone() {
        Scanner sc = new Scanner(System.in);
        String rePhone = "0\\d{9,10}", phone;
        do {
            System.out.print("\t\t\t\t\tEnter Your Phone Number: ");
            phone = sc.nextLine();
            if (phone.matches(rePhone)) {
                return phone;
            } else {
                System.out.println("\n\t\t\t\t\t~~~ERROR PLEASE INPUT AGAIN!\n");
            }
        } while (!phone.matches(rePhone));
        return null;
    }

    public static int getAnswer(int num1, int num2) {
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            try {
                System.out.print("\t\t\t\t\tYour Answer: ");
                number = Integer.parseInt(sc.nextLine());
                if (number >= num1 && number <= num2) {
                    return number;
                } else {
                    System.out.println("\t\t\t\t\t~~~ERROR.\n");
                }
            } catch (Exception e) {
                System.out.println("\t\t\t\t\t~~~ERROR.\n");
            }
        }
    }
}
