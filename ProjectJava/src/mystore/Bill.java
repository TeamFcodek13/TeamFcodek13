
package mystore;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author IMMORTALITY IPOS
 */
public class Bill implements Serializable {

    private String name, memberName;
    private Date date;
    private double price;
    private int ID, quantity, memberID, star;
    private double subTotal, sum = 0, off = 0;

    public Bill(int ID, String name, double price, int quantity, double subTotal) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }

    public double getSum() {
        return sum;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public double getOff() {
        return off;
    }

    public Date getDate() {
        return date;
    }

    public String getMemberName() {
        return memberName;
    }

    public int getMemberID() {
        return memberID;
    }
    
    public int getMemberStar() {
        return star;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public void setOff(double off) {
        this.off = off;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMemberName(String name) {
        this.memberName = name;
    }

    public void setMemberID(int id) {
        this.memberID = id;
    }
    public void setStar(int star) {
        this.star = star;
    }


    public String toString() {
        return String.format("\t\t\t\t|%-3d|%-10s|%-5.1f|%-8d|%-5.1f", ID, name, price, quantity, subTotal);
    }
}
