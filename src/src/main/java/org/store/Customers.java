package org.store;

import org.storeDto.PurchaseDto;
import org.storeEnum.Gender;
import org.storeInterface.CustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customers implements CustomerService {
    ArrayList<Products> customerList = new ArrayList<>();
    ArrayList<String> customerCartOfItems = new ArrayList<>();


    private String name;
    private String phoneNumber;
    private Gender gender;
    private String emailAddress;

    private double wallet;


    public Customers(String name, String phoneNumber, Gender gender, String emailAddress, double wallet) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.emailAddress = emailAddress;
        this.wallet = wallet;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getCustomerCartOfItems() {
        return customerCartOfItems;
    }

    public double getWallet() {
        return wallet;
    }

    public ArrayList<Products> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(ArrayList<Products> customerList) {
        this.customerList = customerList;
    }

    @Override
    public PurchaseDto customerCartSummary(ArrayList<String>  customerList, Store store) {
        List<Products> itemsInStore = store.getItems();
        Double totalOfAvailableItems = 0.00;
        List<String> itemsNotAvailable = new ArrayList<>();
        List<String> itemsToBuy = new ArrayList<>();
        PurchaseDto purchaseDto = new PurchaseDto();

        for(int i=0; i<itemsInStore.size(); i++){
            for(int j=0; j<customerList.size(); j++) {

                if(Objects.equals(itemsInStore.get(i).getName(), customerList.get(j))){
                    //System.out.println("cus list " + customerList.get(j));
                  if(itemsInStore.get(i).getQuantity()<=0) {
                    itemsNotAvailable.add(customerList.get(j));
                  } else {
                    itemsToBuy.add(itemsInStore.get(i).getName());
                    totalOfAvailableItems+=itemsInStore.get(i).getPrice();
                    itemsInStore.get(i).setQuantity(itemsInStore.get(i).getQuantity()-1);
                  }
                }
                else {
                    throw new RuntimeException(itemsNotAvailable + " OUT OF STOCK");
                }
            }
        }
        purchaseDto.setCustomerName(this.name);
        purchaseDto.setItemsAvailable(itemsToBuy);
        purchaseDto.setItemsNotAvailable(itemsNotAvailable);
        purchaseDto.setTotalAmountOfAvailableItems(totalOfAvailableItems);

    return purchaseDto;
    }


    @Override
    public String toString() {
        return "Customers{" +
                "customerList=" + customerList +
                ", customerCartOfItems=" + customerCartOfItems +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender=" + gender +
                ", emailAddress='" + emailAddress + '\'' +
                ", wallet=" + wallet +
                '}';
    }
}


