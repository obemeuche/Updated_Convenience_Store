package org.store;

import org.fileReader.ReadFromFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Store extends Products {
    public static ReadFromFile readFromFile = new ReadFromFile();
    public static ArrayList<Products> items;

    static {
        try {
            items = readFromFile.fileReader();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private LinkedList<CustomerOrder> customerOrderList = new LinkedList<>();

    private LinkedList<CustomerOrder>  newCustomerOrderList = new LinkedList<>();


    public Store() throws IOException {
        super();
    }

    public Store(String name, double price, int quantity) throws IOException {
        super(name, price, quantity);
    }

    public LinkedList<CustomerOrder> getCustomerOrderList() {
        return customerOrderList;
    }

    public void setCustomerOrderList(LinkedList<CustomerOrder> customerOrderList) {
        this.customerOrderList = customerOrderList;
    }

    public LinkedList<CustomerOrder> getNewCustomerOrderList() {
        return newCustomerOrderList;
    }

    public void setNewCustomerOrderList(LinkedList<CustomerOrder> newCustomerOrderList) {
        this.newCustomerOrderList = newCustomerOrderList;
    }

    public ArrayList<Products> getStore() {
        return items;
    }

    public void setStore(ArrayList<Products> store) {
        this.items = store;
    }

    public ArrayList<Products> getItems(){
        return items;
    }

    @Override
    public String toString() {
        return "Store{" +
                "items=" + items +
                '}';
    }
}
