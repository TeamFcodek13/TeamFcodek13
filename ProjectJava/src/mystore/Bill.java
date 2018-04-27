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
    private double subTotal;
    private double saleOff;

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getSaleOff() {
        return saleOff;
    }

    public void setSaleOff(double saleOff) {
        this.saleOff = saleOff;
    }
    
    
    Bill(double subTotal, double saleOff) {
        this.subTotal = subTotal;
        this.saleOff = saleOff;
    }

    public String toString() {
        return String.format("|%-8.1f|%-8.1f|", subTotal, saleOff);
    }
    
}
