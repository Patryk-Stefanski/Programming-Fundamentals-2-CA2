import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalesWorkerTest {
    private SalesWorker empSales1,empSales2,empSales3invalid;

    @BeforeEach
    void setUp() {
        empSales1 = new SalesWorker("Dominic", "species", "dominic@species.com", "0886895510", "7654321IR", 10, 20, 10);
        empSales2 = new SalesWorker("Mick", "Scott", "m@scott.com", "0886895510", "7654321IR", 10, 20, 15);
        empSales3invalid = new SalesWorker("John", "Murphy", "j@M.com", "0886895510", "7654321IR", 10, 20, 30);
    }

    @Test
    public void testSalesWorker() {
        assertEquals(20, empSales1.getHoursWorked(), 0.01);
        assertEquals(10, empSales1.getHourlyRate(), 0.01);
        assertEquals("DOMINIC", empSales1.getEmployeeFirstName());
        assertEquals("SPECIES", empSales1.getEmployeeLastName());
        assertEquals("dominic@species.com", empSales1.getEmployeeEmail());
        assertEquals("0886895510", empSales1.getEmployeePhone());
        assertEquals("7654321IR", empSales1.getEmployeePPS());
        assertEquals(.1,empSales1.getSalesWorkerBonusPercentage(),0.01);


        assertEquals(20, empSales2.getHoursWorked(), 0.01);
        assertEquals(10, empSales2.getHourlyRate(), 0.01);
        assertEquals("MICK", empSales2.getEmployeeFirstName());
        assertEquals("SCOTT", empSales2.getEmployeeLastName());
        assertEquals("m@scott.com", empSales2.getEmployeeEmail());
        assertEquals("0886895510", empSales2.getEmployeePhone());
        assertEquals("7654321IR", empSales2.getEmployeePPS());
        assertEquals(.15,empSales2.getSalesWorkerBonusPercentage(),0.01);

        assertEquals(20, empSales3invalid.getHoursWorked(), 0.01);
        assertEquals(10, empSales3invalid.getHourlyRate(), 0.01);
        assertEquals("JOHN", empSales3invalid.getEmployeeFirstName());
        assertEquals("MURPHY", empSales3invalid.getEmployeeLastName());
        assertEquals("j@M.com", empSales3invalid.getEmployeeEmail());
        assertEquals("0886895510", empSales3invalid.getEmployeePhone());
        assertEquals("7654321IR", empSales3invalid.getEmployeePPS());
        assertEquals(0,empSales3invalid.getSalesWorkerBonusPercentage(),0.01);



    }



    @Test
    public void getSalesWorkerBonusPercentage() {
        assertEquals(0.1,empSales1.getSalesWorkerBonusPercentage(),0.01);
        assertEquals(0.15,empSales2.getSalesWorkerBonusPercentage(),0.01);
        assertEquals(0,empSales3invalid.getSalesWorkerBonusPercentage(),0.01);
    }

    @Test
     public void setSalesWorkerBonusPercentage() {
        empSales1.setSalesWorkerBonusPercentage(16);
        assertEquals(0.16,empSales1.getSalesWorkerBonusPercentage(),0.01);
        empSales2.setSalesWorkerBonusPercentage(9);
        assertEquals(0.09,empSales2.getSalesWorkerBonusPercentage(),0.01);
        empSales3invalid.setSalesWorkerBonusPercentage(20);
        assertEquals(0.2,empSales3invalid.getSalesWorkerBonusPercentage(),0.01);
    }

    @Test
    public void calculateSalary() {
        assertEquals(220,empSales1.calculateSalary(),0.01);
        assertEquals(230,empSales2.calculateSalary(),0.01);
        assertEquals(200,empSales3invalid.calculateSalary(),0.01);
    }
}