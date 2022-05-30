package org.store;

import org.fileReader.ReadFromFile;

import java.io.IOException;
import java.util.ArrayList;

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




    public Store() throws IOException {
        super();
    }

    public Store(String name, double price, int quantity) throws IOException {
        super(name, price, quantity);
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
