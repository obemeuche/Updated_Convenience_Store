package org.storeInterface;

import org.store.Store;
import org.storeDto.PurchaseDto;

import java.util.ArrayList;

public interface CustomerService {
    PurchaseDto customerCartSummary(ArrayList<String>  customerList, Store store);
}
