package org.store;

import org.storeDto.PurchaseDto;
import org.storeEnum.Gender;
import org.storeEnum.Position;
import org.storeInterface.CashierService;

public class Cashier extends Staff implements CashierService {



    public Cashier(String name, String phoneNumber, Position position, String emailAddress, Gender gender) {
        super(name, phoneNumber, position, emailAddress, gender);
    }


    @Override
    public void sellProduct(PurchaseDto purchaseDto, Customers customer) {
        if ((customer.getWallet() >= purchaseDto.getTotalAmountOfAvailableItems()) && this.getPosition()==(Position.JUNIOR_STAFF)) {
            System.out.println("Hello " + " " + customer.getName() + "," + " your purchase of " + " " + customer.getCustomerCartOfItems()
                    + " " + " has been successful! Please hold on while we print your receipt.");
        } else {
            throw new RuntimeException("Insufficient funds");
        }
    }


    @Override
    public void issueReceipt(PurchaseDto purchaseDto, Customers customer) {
        if ((customer.getWallet() == purchaseDto.getTotalAmountOfAvailableItems()) && this.getPosition()==(Position.JUNIOR_STAFF)) {
            System.out.println("Here is your receipt: " + "\n" +
                     "Wallet = " + " " + customer.getWallet() + "\n" +
                    "Item Cost = " + " " + purchaseDto.getTotalAmountOfAvailableItems() + "\n" +
                    "Balance = " + " " + (customer.getWallet() - purchaseDto.getTotalAmountOfAvailableItems()));
        }
        else if ((customer.getWallet() > purchaseDto.getTotalAmountOfAvailableItems()) && this.getPosition()==(Position.JUNIOR_STAFF)) {
            System.out.println("Here is your receipt: " + "\n" +
                    "Wallet = " + " " + customer.getWallet() + "\n" +
                    "Item Cost = " + " " + purchaseDto.getTotalAmountOfAvailableItems() + "\n" +
                    "Balance = " + " " + (customer.getWallet() - purchaseDto.getTotalAmountOfAvailableItems()));
        }
        else {
            throw new RuntimeException("Insufficient Balance");
        }
    }



}
