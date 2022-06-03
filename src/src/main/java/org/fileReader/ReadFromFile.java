package org.fileReader;

import org.store.Products;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFromFile {
    //static Store store = new Store();
//    Cashier cashier = new Cashier();

    public static ArrayList<Products> fileReader() throws IOException {
        ArrayList<Products> products = new ArrayList<>();

        try{
            File file = new File("src/src/main/resources/ConvenienceStore.csv");
            BufferedReader reader = new BufferedReader(new java.io.FileReader(file));

            String line = " ";

            while ((line = reader.readLine()) != null) {
                Products product = new Products();
                String[] values = line.split(",");
                for (int j = 0; j < values.length; j++) {
                    //String i = values[j];
                    product.setId(values[0]);
                    product.setProductName(values[1]);
                    product.setCategory(values[2]);
                    product.setPrice(Double.parseDouble(values[3]));
                    product.setQuantity(Integer.parseInt(values[4]));
                }
                    products.add(product);

            }

        } catch (IOException e){

        }

        return products;
    }





}
