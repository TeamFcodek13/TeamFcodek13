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
public class VipMember implements Serializable {

    private String name, phone;
    private int id, star = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    VipMember(int id, String name, String phone) {
        this.name = name;
        this.id = id;
        this.phone = phone;
    }

    public String toString() {
        return String.format("%-5d|%-7s|%-12s|%-5d", id, name, phone, star);
    }

}
