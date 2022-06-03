package org;

import org.fileReader.ReadFromFile;
import org.store.*;
import org.storeDto.PurchaseDto;
import org.storeEnum.Gender;
import org.storeEnum.Position;
import org.storeEnum.Qualification;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        // Instantiating the CashierApplicant class
        CashierApplicant cashierApplicant = new CashierApplicant("Cynthia", "0809567452", Gender.FEMALE, 25,
                Qualification.BSC_ACCOUNTING, 80);

        // Instantiating the Manager class
         Manager manager = new Manager("Uchechi", "08067907142", Position.SENIOR_STAFF,
                "obemeuchechi@gmail.com", Gender.MALE);

         System.out.println("***************Manager Hiring Cashier********************");
         manager.hireCashier(cashierApplicant, manager);

        System.out.println();

        // Instantiating the Product class
        Products product = new Products("milk", 20.20, 2);
        Products product1 = new Products("burger", 5.10, 6);
        Products product2 = new Products("bread", 10.00, 4);


        System.out.println();
        System.out.println("************************Items read into the store***************************");
        ReadFromFile readFromFile = new ReadFromFile();
        System.out.println(readFromFile.fileReader());
        System.out.println("Store size: " + readFromFile.fileReader().size());

        System.out.println();


        // Instantiating Store
        Store store = new Store();

         System.out.println("***************Manager Updating Product********************");
         manager.updateProduct(product);
         manager.updateProduct(product1);
         manager.updateProduct(product2);

        System.out.println();

        System.out.println("*******************Items in Store After Manager Updated***********************");
        System.out.println(store.getItems());
        System.out.println("Store size " + store.getItems().size());


        // Instantiating the Cashier class
        Cashier cashier = new Cashier("Cynthia", "08043456790", Position.JUNIOR_STAFF,
               "iamcynthia@gmail.com", Gender.FEMALE);




    }
}
