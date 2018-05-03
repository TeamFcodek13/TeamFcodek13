/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mystore;

/**
 *
 * @author IMMORTALITY IPOS
 */
public class MyStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choice, choice1, choice2;
        ProductData dataProduct = new ProductData();
        MemberData dataMember = new MemberData();
        ProductQuantity dataQuanity = new ProductQuantity();
        do {
            System.out.println("==*==WELCOME TO MY PROGRAMMING==*==");
            System.out.println("\n1. Staff.");
            System.out.println("2. Manager.");
            System.out.println("3. Exit.");
            System.out.print("\n---Please choose: ");
            choice = Validate.getAInteger();
            switch (choice) {
                case 1:
                    do {
                        System.out.println("\n==*==WELCOM TO PAYING SYSTEM==*==");
                        System.out.println("\n1. Order And Paying.");
                        System.out.println("2. Add Vip Member.");
                        System.out.println("3. View All Vip Member.");
                        System.out.println("4. Find Member.");
                        System.out.println("5. Exit.");
                        System.out.print("\n---Please Choose: ");
                        choice2 = Validate.getAInteger();
                        switch (choice2) {
                            case 1:
                                dataProduct.orderDrink();
                                break;
                            case 2:
                                dataMember.addNewMember();
                                break;
                            case 3:
                                dataMember.viewAllMember();
                                break;
                            case 4:
                                dataMember.findMember();
                                break;
                            case 5:
                                return;
                        }
                    } while (choice2 != 5);
                    break;

                case 2:
                    do {
                        System.out.println("\n==*==PRODUCT MANAGEMENT==*==");
                        System.out.println("\n1. Add New Drink.");
                        System.out.println("2. View Menu.");
                        System.out.println("3. Find By Drink ID.");
                        System.out.println("4. Update By Drink ID.");
                        System.out.println("5. Delete By Drink ID.");
                        System.out.println("6. View All Bill.");
                        System.out.println("7. Manage Member.");
                        System.out.println("8. Manage Quantity.");
                        System.out.println("9. Exit!\n");
                        System.out.print("Your choose: ");
                        choice1 = Validate.getAInteger();
                        switch (choice1) {
                            case 1:
                                dataProduct.addNewProduct();
                                break;
                            case 2:
                                dataProduct.viewProduct();
                                break;
                            case 3:
                                dataProduct.findProduct();
                                break;
                            case 4:
                                dataProduct.updateProduct();
                                break;
                            case 5:
                                dataProduct.deleteProduct();
                                break;
                            case 6:
                                dataProduct.viewAllBills();
                                break;
                            case 7:
                                System.out.println("1. View All Vip Member.");
                                System.out.println("2. Find Member.");
                                System.out.println("3. Edit Member");
                                switch (Validate.getAnswer(1, 3)) {
                                    case 1:
                                        dataMember.viewAllMember();
                                        break;
                                    case 2:
                                        dataMember.findMember();
                                        break;

                                    case 3:
                                        dataMember.updateMember();
                                        break;
                                }

                                break;
                            case 8:
                                System.out.println("1. View quantity of all products");
                                System.out.println("2. Find quantity of a product");
                                System.out.println("3. Edit quantity of a product");
                                switch (Validate.getAnswer(1, 3)) {
                                    case 1:
                                        dataQuanity.viewAllQuantity();
                                        break;
                                    case 2:
                                        dataQuanity.findAQuanity();
                                        break;
                                    case 3:
                                        dataQuanity.updateQuantity();
                                        break;
                                }
                                break;

                            case 9:
                                return;
                        }
                    } while (choice != 9);
                    break;

                case 3:
                    return;
            }
        } while (choice != 3);
    }

}
