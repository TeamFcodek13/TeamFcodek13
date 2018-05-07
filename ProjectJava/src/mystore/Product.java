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
public class Product implements Serializable {

    private String name;
    private double price;
    private int ID, quantity;

    public Product(int ID, String name, double price) {
        this.ID = ID;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return String.format("\t\t\t\t\t\t|%-3d|%-10s|%-5.1f|", ID, name, price);
    }
    public String toStringQ() {
        return String.format("|%-3d|%-10s|%-5.1f|%-9s|", ID, name, price, quantity);
    }

    public String toStringwithQuantity() {
        return String.format("\t\t\t\t\t\t|%-3d|%-10s|%-5.1f|%-9d", ID, name, price, quantity);
    }
}
