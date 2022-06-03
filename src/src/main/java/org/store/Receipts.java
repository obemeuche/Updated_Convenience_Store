package org.store;

public class Receipts {
    public  static void issueReceipt(String name, String item, Double price, Integer quantity, Integer wallet) {
        System.out.println("************************* Receipt ***************************");
        System.out.println("Hello " + " " + name + " " + "your order of " + " " + item + " " + "with  quantity," + " " +
                quantity + ", " + "has been purchased successfully!");
        System.out.println("Here is your receipt: " + "\n" +
                "Wallet = " + " " + wallet + "\n" +
                "Item Cost = " + " " + ((price * quantity)) + "\n" +
                "Balance = " + " " + (wallet - (price * quantity)));
        System.out.println("Thanks for you patronage and we look forward to seeing you again");
        System.out.println();
    }
}
