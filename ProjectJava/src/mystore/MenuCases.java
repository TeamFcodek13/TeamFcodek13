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
        System.out.println(ColorText.ANSI_PURPLE + "                                                                                                                                                  \n" + ColorText.ANSI_PURPLE
                + "                .@                              .@                                :                                                               \n" + ColorText.ANSI_PURPLE
                + " # .'@          '@#     `@     @@      . :@@@@  `@#       .@:    .#@@@:         `@@       `:;    ;#@@;                    '@`       '#        #   \n" + ColorText.ANSI_PURPLE
                + " @@@@+     @#    @@     :@#   .@'       @@@@` `  @@       @@#   @@@@` ` @@@@@@@@@@.@@@@@@@@:  ;@@'` ;@@@         '@@@@@@@@@,@@@@@@@@@       #@@   \n" + ColorText.ANSI_PURPLE
                + "   #@     @@     @@:     @#   +@.        `@#     '@.      @@'     @@    ,   @@    :  @@      @@`      :@@        +   #@    ,  @@    @       :@@@   \n" + ColorText.ANSI_PURPLE
                + "   @#     @@     @@@     @'   @@         :@,     #@#     '@@,     @@        @#       @#     '@ '@,     +@#           @@       @@           @ @@   \n" + ColorText.ANSI_PURPLE
                + "  '@`    .@+    ,@@@`    @,   @@         #@      @@@     @#@`    .@+       ,@:      :@:     :  #@       @@           @@       @@          @, @@   \n" + ColorText.ANSI_PURPLE
                + "  @@     +@.    #@ @@    @    @@         @@      @+@.   #@@@     '@.       #@`      #@  `'.    @@       @@          `@#      .@+  ,#@    @#  @@   \n" + ColorText.ANSI_PURPLE
                + "  @#     @@     @# @@    @   .@'         @@     :@ @@  .@ @@     @@        @@     `@@@@@@:     @@       @@          :@,     @@@@@@' @   '@   @@   \n" + ColorText.ANSI_PURPLE
                + " ,@:     @@     @, ,@+  `@   '@.         @#     @@ @@. @+ @@     @@        @@       @@         @#      `@,          #@       @@     @  @@;  .@@   \n" + ColorText.ANSI_PURPLE
                + " '@,    @@@    `@   @@  '#   @@         :@:     @#  @@@@  @@     @@        @#       @#        :@:      @@           @@       @@       `@@+@@'+@`  \n" + ColorText.ANSI_PURPLE
                + " '@'   :@@@    '@   :@' @,   @@         #@      @:   @:   @@    `@+       ,@:      :@:        #@      ;@            @@       @@       .@,    ,@'  \n" + ColorText.ANSI_PURPLE
                + " .@@  +@ @@    @@    @@ @    @@     ;   @@     :@`        @#    '@.       #@`      #@.        @@     #@            `@#      `@#     @ @@      @@  \n" + ColorText.ANSI_PURPLE
                + "  #@@@@  @@ @  @@    `@@@    @@@@@@@'`,`@@@@@  #@         @#  ' #@@@@     @@       +@@@@@@'   @@: .@@;             :@,       @@@@@@@@ @@      @@` \n" + ColorText.ANSI_PURPLE
                + "          @@   +@`    `@      #@@'`   @@@@, :  `;         @@  @@@@;```    @;        :@@'`     #@@@@`               +#        `#@+,  @ @.       @  " + ColorText.ANSI_PURPLE);
        System.out.println(ColorText.ANSI_RED + "\n\t\t\t\t\t\t==*==WELCOME TO MY PROGRAMMING==*==" + ColorText.ANSI_RED);
        System.out.println(ColorText.ANSI_GREEN + "\n\t\t\t\t\t1. Staff." + ColorText.ANSI_GREEN);
        System.out.println(ColorText.ANSI_GREEN + "\t\t\t\t\t2. Manager.");
        System.out.println(ColorText.ANSI_GREEN + "\t\t\t\t\t3. Exit.");
        System.out.print(ColorText.ANSI_CYAN + "\n\t\t\t\t\t\t---Please Choose: " + ColorText.ANSI_CYAN);
        choice = Validate.getChoice(0, 4);
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
            System.out.println(ColorText.ANSI_RED + "\n\t\t\t\t\t\t==*==WELCOM TO PAYING SYSTEM==*==" + ColorText.ANSI_RED);
            System.out.println(ColorText.ANSI_GREEN + "\n\t\t\t\t\t1. Order And Paying." + ColorText.ANSI_GREEN);
            System.out.println(ColorText.ANSI_GREEN + "\t\t\t\t\t2. Add Vip Member." + ColorText.ANSI_GREEN);
            System.out.println(ColorText.ANSI_GREEN + "\t\t\t\t\t3. View All Vip Member." + ColorText.ANSI_GREEN);
            System.out.println(ColorText.ANSI_GREEN + "\t\t\t\t\t4. Find Vip Member." + ColorText.ANSI_GREEN);
            System.out.println(ColorText.ANSI_GREEN + "\t\t\t\t\t5. Exit." + ColorText.ANSI_GREEN);
            System.out.print(ColorText.ANSI_CYAN + "\n\t\t\t\t\t\t---Please Choose: " + ColorText.ANSI_CYAN);
            choice = Validate.getChoice(0, 6);
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

        LoginData loginData = new LoginData();
        loginData.login();
        menuCases6();
    }

    public void menuCases4() {

        MemberData dataMember = new MemberData();
        int choice;

        do {
            System.out.println(ColorText.ANSI_RED + "\n\t\t\t\t\t\t==*==MEMBER MANAGMENT==*==" + ColorText.ANSI_RED);
            System.out.println("\n" + ColorText.ANSI_GREEN + "\t\t\t\t\t1. View All Vip Member." + ColorText.ANSI_GREEN);
            System.out.println(ColorText.ANSI_GREEN + "\t\t\t\t\t2. Find Member.");
            System.out.println(ColorText.ANSI_GREEN + "\t\t\t\t\t3. Edit Member.");
            System.out.println(ColorText.ANSI_GREEN + "\t\t\t\t\t4. Exit.\n");
            System.out.print(ColorText.ANSI_CYAN + "\t\t\t\t\t\t---Please Choose: " + ColorText.ANSI_CYAN);
            choice = Validate.getChoice(0, 5);
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
                    menuCases6();
                    break;
            }
        } while (choice != 4);
    }

    public void menuCases5() {
        int choice;
        ProductData dataProduct = new ProductData();
        do {
            System.out.println(ColorText.ANSI_RED + "\n\t\t\t\t\t\t==*==PRODUCT MANAGMENT==*==" + ColorText.ANSI_RED);
            System.out.println("\n" + ColorText.ANSI_GREEN + "\t\t\t\t\t1. Add New Product." + ColorText.ANSI_GREEN);
            System.out.println(ColorText.ANSI_GREEN + "\t\t\t\t\t2. View All Products." + ColorText.ANSI_GREEN);
            System.out.println(ColorText.ANSI_GREEN + "\t\t\t\t\t3. Find A Product.");
            System.out.println(ColorText.ANSI_GREEN + "\t\t\t\t\t4. Edit A Product.");
            System.out.println(ColorText.ANSI_GREEN + "\t\t\t\t\t5. Delete A Product.");
            System.out.println(ColorText.ANSI_GREEN + "\t\t\t\t\t6. Exit.\n");
            System.out.print(ColorText.ANSI_CYAN + "\t\t\t\t\t\t---Please Choose: " + ColorText.ANSI_CYAN);
            choice = Validate.getChoice(0, 7);
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
                    menuCases6();
                    break;
            }
        } while (choice != 6);
    }
    
    public void menuCases6() {
        
        ProductData dataProduct = new ProductData();
        LoginData loginData = new LoginData();
        
        int choice;

        do {
            System.out.println(ColorText.ANSI_RED + "\n\t\t\t\t\t\t==*==MANAGEMENT==*==" + ColorText.ANSI_RED);
            System.out.println(ColorText.ANSI_GREEN + "\t\t\t\t\t1. Manage Product.");
            System.out.println(ColorText.ANSI_GREEN + "\t\t\t\t\t2. Manage Member.");
            System.out.println(ColorText.ANSI_GREEN + "\t\t\t\t\t3. Change Password.");
            System.out.println(ColorText.ANSI_GREEN + "\t\t\t\t\t4. Create New Account.");
            System.out.println(ColorText.ANSI_GREEN + "\t\t\t\t\t5. View Bill.");
            System.out.println(ColorText.ANSI_GREEN + "\t\t\t\t\t6. Exit!");
            System.out.print(ColorText.ANSI_CYAN + "\n\t\t\t\t\t\t---Please Choose: " + ColorText.ANSI_CYAN);
            choice = Validate.getChoice(0, 7);
            switch (choice) {
                case 1:
                    menuCases5();
                    break;
                case 2:
                    menuCases4();
                    break;
                case 3:
                    loginData.changePassword();
                    break;
                case 4:
                    loginData.createNewAccount();
                    break;
                case 5:
                    dataProduct.viewAllBills();
                    break;
                case 6:
                    menuCases1();
                    break;
            }
        } while (choice != 1 && choice != 2 && choice != 6);
    }
}
