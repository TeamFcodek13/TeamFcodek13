/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mystore;

import java.io.Serializable;

/**
 *
 * @author IMMORTALITY IPOS
 */
public class Bill implements Serializable {

    private String name;
    private double price;
    private int ID;
    private int quantity;
    private double subTotal;
    private double sum = 0;
    private double off = 0;

    Bill(int ID, String name, double price, int quantity, double subTotal) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }

    public String toString() {
        return String.format("|%-3d|%-10s|%-5.1f|%-8d|%-5.1f", ID, name, price, quantity, subTotal);
    }

    public double getSum() {
        return sum;
    }

    public double getOff() {
        return off;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public void setOff(double off) {
        this.off = off;
    }
}
