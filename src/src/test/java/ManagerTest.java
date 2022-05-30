import org.junit.jupiter.api.Assertions;
import org.store.CashierApplicant;
import org.store.Manager;
import org.storeEnum.Gender;
import org.storeEnum.Position;
import org.storeEnum.Qualification;

public class ManagerTest {
    @org.junit.jupiter.api.Test
    void  main() {
        Manager manager = new Manager("Uchechi", "08067907142", Position.SENIOR_STAFF,
                "obemeuchechi@gmail.com", Gender.MALE);

        CashierApplicant cashierApplicant = new CashierApplicant("Cynthia", "0809567452", Gender.FEMALE, 25,
                Qualification.BSC_ACCOUNTING, 72);

        boolean status = manager.hireCashier(cashierApplicant, manager);

        Assertions.assertTrue(status);

    }

}

