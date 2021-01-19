import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {
    private EmployeeAPI empAPIPopulated;
    private AdminWorker empAdmin1;
    private SalesWorker empSales1;

    @BeforeEach
    public void setUp() {
        empAPIPopulated = new EmployeeAPI();

        empSales1 = new SalesWorker("Dominic", "species", "dominic@species.com", "0886895510", "7654321IR", 10, 20, 10);
        empAdmin1 = new AdminWorker("bill", "willmot", "b@willmot.com", "0886895510", "76rt321IR", 9.70, 20, 10);
    }

    @Test
    void validHourlyRate() {
        assertEquals(10,empSales1.getHourlyRate());
        assertEquals(9.8,empAdmin1.getHourlyRate());
    }

    @Test
    void validSalesWorkerBonus() {
        assertEquals(0.10 ,empSales1.getSalesWorkerBonusPercentage());
        empSales1.setSalesWorkerBonusPercentage(30);
        assertEquals(0,empSales1.getSalesWorkerBonusPercentage());
    }

    @Test
    void validAdminWorkerBonus() {
        assertEquals(0.10,empAdmin1.getAdminWorkerBonusPercentage());
        empAdmin1.setAdminWorkerBonusPercentage(-15);
        assertEquals(0,empAdmin1.getAdminWorkerBonusPercentage());
    }

    @Test
    void validPPS() {
        assertEquals("7654321IR",empSales1.getEmployeePPS());
        empSales1.setEmployeePPS("12rt123yryry");
        assertEquals("7654321IR",empSales1.getEmployeePPS());
        assertEquals("INVALID",empAdmin1.getEmployeePPS());
    }
}