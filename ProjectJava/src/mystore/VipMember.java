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
public class VipMember implements Serializable{
    private String name;
    private int fiveLastPhoneNumbers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFiveLastPhoneNumbers() {
        return fiveLastPhoneNumbers;
    }

    public void setFiveLastPhoneNumbers(int fiveLastPhoneNumbers) {
        this.fiveLastPhoneNumbers = fiveLastPhoneNumbers;
    }

    public VipMember(String name, int fiveLastPhoneNumbers) {
        this.name = name;
        this.fiveLastPhoneNumbers = fiveLastPhoneNumbers;
    }

    public String toString() {
        return String.format("|%-10s|%-5d|", name, fiveLastPhoneNumbers);
    }
    
}
