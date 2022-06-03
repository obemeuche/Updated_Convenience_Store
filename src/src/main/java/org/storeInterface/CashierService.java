package org.storeInterface;

import org.store.CustomerOrder;
import org.store.Customers;
import org.store.Store;
import org.storeDto.PurchaseDto;

import java.io.IOException;
import java.util.List;

public interface CashierService {
    void sellingViaPriorityQueue(List<CustomerOrder> customerOrders, Store store) throws IOException;

    void sellProduct (PurchaseDto purchaseDto, Customers customer);

    void issueReceipt(PurchaseDto purchaseDto, Customers customer);
}
