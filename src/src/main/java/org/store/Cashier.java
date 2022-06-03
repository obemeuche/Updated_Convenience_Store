package org.store;

import org.storeDto.PurchaseDto;
import org.storeEnum.Gender;
import org.storeEnum.Position;
import org.storeInterface.CashierService;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Cashier extends Staff implements CashierService {



    public Cashier(String name, String phoneNumber, Position position, String emailAddress, Gender gender) {
        super(name, phoneNumber, position, emailAddress, gender);
    }


    @Override
    public void sellingViaPriorityQueue(List<CustomerOrder> customerOrders, Store store) throws IOException {
        List<Products> productStore = store.getItems();
        LinkedList<CustomerOrder> newCustomerOrderList = store.getNewCustomerOrderList();

        for(int i = 0; i < newCustomerOrderList.size(); i++) {
            for (int j = 0; j < productStore.size(); j++) {

                if(productStore.get(j).getProductName().equals(newCustomerOrderList.get(i).getItem())) {
                    if (productStore.get(j).getQuantity() < newCustomerOrderList.get(i).getQuantity()) {
                        throw new RuntimeException("OUT OF STOCK");
                    }
                    else if (productStore.get(j).getQuantity() > 0) {
                        productStore.get(j).setQuantity(productStore.get(j).getQuantity() - newCustomerOrderList.get(i).getQuantity());
                        Receipts.issueReceipt(newCustomerOrderList.get(i).getName(), productStore.get(j).getProductName(),
                                productStore.get(j).getPrice(), newCustomerOrderList.get(i).getQuantity(), newCustomerOrderList.get(i).getWallet());
                    }
                }
            }
        }
    }


    @Override
    public void sellProduct(PurchaseDto purchaseDto, Customers customer) {
        if ((customer.getWallet() >= purchaseDto.getTotalAmountOfAvailableItems()) && this.getPosition()==(Position.JUNIOR_STAFF)) {
            System.out.println("Hello " + " " + customer.getName() + "," + " your purchase of " + " " + purchaseDto.getItemsAvailable()
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
