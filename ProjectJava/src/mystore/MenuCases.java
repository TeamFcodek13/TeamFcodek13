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
public class MenuCases {

    public void menuCases1() {
        int choice;

        System.out.println(ColorText.ANSI_RED + "\n\t\t\t==*==WELCOME TO MY PROGRAMMING==*==" + ColorText.ANSI_RED);
        System.out.println(ColorText.ANSI_GREEN + "\n\t1. Staff." + ColorText.ANSI_GREEN);
        System.out.println(ColorText.ANSI_GREEN + "\t2. Manager.");
        System.out.println(ColorText.ANSI_GREEN + "\t3. Exit.");
        System.out.print(ColorText.ANSI_BLUE + "\n\t\t---Please Choose: " + ColorText.ANSI_BLUE);
        choice = Validate.getAInteger();
        switch (choice) {
            case 1:
                menuCases2();
                break;
            case 2:
                menuCases3();
                break;
            case 3:
                return;
        }
    }

    public void menuCases2() {

        ProductData dataProduct = new ProductData();
        MemberData dataMember = new MemberData();
        int choice;

        do {
            System.out.println(ColorText.ANSI_YELLOW + "\n\t\t\t==*==WELCOM TO PAYING SYSTEM==*==" + ColorText.ANSI_YELLOW);
            System.out.println(ColorText.ANSI_GREEN + "\n\t1. Order And Paying." + ColorText.ANSI_GREEN);
            System.out.println(ColorText.ANSI_GREEN + "\t2. Add Vip Member." + ColorText.ANSI_GREEN);
            System.out.println(ColorText.ANSI_GREEN + "\t3. View All Vip Member." + ColorText.ANSI_GREEN);
            System.out.println(ColorText.ANSI_GREEN + "\t4. Find Vip Member." + ColorText.ANSI_GREEN);
            System.out.println(ColorText.ANSI_GREEN + "\t5. Exit." + ColorText.ANSI_GREEN);
            System.out.print(ColorText.ANSI_BLUE + "\n\t\t---Please Choose: " + ColorText.ANSI_BLUE);
            choice = Validate.getAInteger();
            switch (choice) {
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
                    menuCases1();
                    break;
            }
        } while (choice != 5);
    }

    public void menuCases3() {

        ProductData dataProduct = new ProductData();
        LoginData loginData = new LoginData();
        int choice;

        loginData.login();
        do {
            System.out.println("\n==*==PRODUCT MANAGEMENT==*==");
            System.out.println("\n1. Add New Drink.");
            System.out.println("2. View Menu.");
            System.out.println("3. Find By Drink ID.");
            System.out.println("4. Update By Drink ID.");
            System.out.println("5. Delete By Drink ID.");
            System.out.println("6. View All Bill.");
            System.out.println("7. Create New Account.");
            System.out.println("8. Change Password.");
            System.out.println("9. Manage Member.");
            System.out.println("10. Manage Quantity.");
            System.out.println("11. Exit!\n");
            System.out.print("Your choose: ");
            choice = Validate.getAInteger();
            switch (choice) {
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
                    loginData.createNewAccount();
                    break;
                case 8:
                    loginData.changePassword();
                    break;
                case 9:
                    menuCases4();
                    break;
                case 10:
                    menuCases5();
                    break;
                case 11:
                    menuCases1();
                    break;
            }
        } while (choice != 11);
    }

    public void menuCases4() {

        MemberData dataMember = new MemberData();
        int choice;

        do {
            System.out.println("\n==*==MEMBER MANAGMENT==*==");
            System.out.println("\n1. View All Vip Member.");
            System.out.println("2. Find Member.");
            System.out.println("3. Edit Member.");
            System.out.println("4. Exit.\n");
            System.out.print("Your choose: ");
            choice = Validate.getAInteger();
            switch (choice) {
                case 1:
                    dataMember.viewAllMember();
                    break;
                case 2:
                    dataMember.findMember();
                    break;
                case 3:
                    dataMember.updateMember();
                    break;
                case 4:
                    menuCases3();
                    break;
            }
        } while (choice != 4);
    }

    public void menuCases5() {
        
        ProductQuantity dataQuanity = new ProductQuantity();
        int choice;
        
        do {
            System.out.println("\n==*==PRODUCT MANAGMENT==*==");
            System.out.println("1. View Quantity Of All Products.");
            System.out.println("2. Find Quantity Of A Product.");
            System.out.println("3. Edit Quantity Of A Product.");
            System.out.println("4. Exit.\n");
            System.out.print("Your choose: ");
            choice = Validate.getAInteger();
            switch (choice) {
                case 1:
                    dataQuanity.viewAllQuantity();
                    break;
                case 2:
                    dataQuanity.findAQuanity();
                    break;
                case 3:
                    dataQuanity.updateQuantity();
                    break;
                case 4:
                    menuCases3();
                    break;
            }
        } while (choice != 4);
    }
}
