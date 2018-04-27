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
                System.out.print("\nError. Input Again! ");
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
                }
                else System.out.print("\nError. Input Again!\n ");
            } catch (Exception e) {
                System.out.println("\nError. Input Again!\n ");
            }
        }
    }

}
