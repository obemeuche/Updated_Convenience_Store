package org.store;

import org.storeEnum.Gender;
import org.storeEnum.Position;
import org.storeEnum.Qualification;
import org.storeInterface.ManagerService;
import org.storeInterface.UpdateProduct;

public class Manager extends Staff implements ManagerService, UpdateProduct {


    public Manager(String name, String phoneNumber, Position position, String emailAddress, Gender gender) {
        super(name, phoneNumber, position, emailAddress, gender);
    }

    public boolean applicantStatus (CashierApplicant cashierApplicant) {
        return (cashierApplicant.getQualification() == Qualification.BSC_ACCOUNTING) && (cashierApplicant.getInterviewScore() > 70)
                && (cashierApplicant.getAge() >= 23 || cashierApplicant.getAge() <= 35);
    }

    @Override
    public boolean hireCashier(CashierApplicant cashierApplicant, Manager manager) {
        if((manager.getPosition().equals(Position.SENIOR_STAFF)) && applicantStatus(cashierApplicant)) {
            System.out.print("Hello " + cashierApplicant.getName() + ", ");
            System.out.print("You have been successfully employed for the position of a Cashier. Welcome onboard!");
            return true;
        } else if(!manager.getPosition().equals(Position.SENIOR_STAFF)) {
            System.out.println("Only Management is permitted to hire!");
            return false;
        } else {
            System.out.println("Hello " + " " + cashierApplicant.getName() + ", " + "we are sorry to inform you that you didn't " +
                    "meet the criteria for this position. Please try again later.");
            return false;
        }

    }



    @Override
    public void updateProduct(Products product) {
        Store.items.add(product);
        System.out.println("Manager updated product successfully!");
        // System.out.println(store);
    }



}
