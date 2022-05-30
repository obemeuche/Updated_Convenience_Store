package org.storeInterface;

import org.store.Customers;
import org.storeDto.PurchaseDto;

public interface CashierService {
    void sellProduct (PurchaseDto purchaseDto, Customers customer);

    void issueReceipt(PurchaseDto purchaseDto, Customers customer);
}
