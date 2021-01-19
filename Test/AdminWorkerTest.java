import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminWorkerTest {
    private AdminWorker empAdmin1, empAdmin2, empAdmin3invalid;

    @BeforeEach
    void setUp() {
        empAdmin1 = new AdminWorker("Dominic", "species", "dominic@species.com", "0886895510", "7654321IR", 10, 20, 10);
        empAdmin2 = new AdminWorker("Mick", "Scott", "m@scott.com", "0886895510", "7654321IR", 10, 20, 15);
        empAdmin3invalid = new AdminWorker("John", "Murphy", "j@M.com", "0886895510", "7654321IR", 10, 20, 30);
    }

    @Test
    public void testAdminWorker() {
        assertEquals(20, empAdmin1.getHoursWorked(), 0.01);
        assertEquals(10, empAdmin1.getHourlyRate(), 0.01);
        assertEquals("DOMINIC", empAdmin1.getEmployeeFirstName());
        assertEquals("SPECIES", empAdmin1.getEmployeeLastName());
        assertEquals("dominic@species.com", empAdmin1.getEmployeeEmail());
        assertEquals("0886895510", empAdmin1.getEmployeePhone());
        assertEquals("7654321IR", empAdmin1.getEmployeePPS());
        assertEquals(.1, empAdmin1.getAdminWorkerBonusPercentage(), 0.01);


        assertEquals(20, empAdmin2.getHoursWorked(), 0.01);
        assertEquals(10, empAdmin2.getHourlyRate(), 0.01);
        assertEquals("MICK", empAdmin2.getEmployeeFirstName());
        assertEquals("SCOTT", empAdmin2.getEmployeeLastName());
        assertEquals("m@scott.com", empAdmin2.getEmployeeEmail());
        assertEquals("0886895510", empAdmin2.getEmployeePhone());
        assertEquals("7654321IR", empAdmin2.getEmployeePPS());
        assertEquals(.15, empAdmin2.getAdminWorkerBonusPercentage(), 0.01);

        assertEquals(20, empAdmin3invalid.getHoursWorked(), 0.01);
        assertEquals(10, empAdmin3invalid.getHourlyRate(), 0.01);
        assertEquals("JOHN", empAdmin3invalid.getEmployeeFirstName());
        assertEquals("MURPHY", empAdmin3invalid.getEmployeeLastName());
        assertEquals("j@M.com", empAdmin3invalid.getEmployeeEmail());
        assertEquals("0886895510", empAdmin3invalid.getEmployeePhone());
        assertEquals("7654321IR", empAdmin3invalid.getEmployeePPS());
        assertEquals(0.3, empAdmin3invalid.getAdminWorkerBonusPercentage(), 0.01);


    }


    @Test
    void getAdminWorkerBonusPercentage() {
        assertEquals(0.1, empAdmin1.getAdminWorkerBonusPercentage(), 0.01);
        assertEquals(0.15, empAdmin2.getAdminWorkerBonusPercentage(), 0.01);
        assertEquals(0.3, empAdmin3invalid.getAdminWorkerBonusPercentage(), 0.01);
    }



    @Test
    void calculateSalary() {
        assertEquals(220, empAdmin1.calculateSalary(), 0.01);
        assertEquals(230, empAdmin2.calculateSalary(), 0.01);
        assertEquals(260, empAdmin3invalid.calculateSalary(), 0.01);
    }

    @Test
    void setAdminWorkerBonusPercentage() {
        empAdmin1.setAdminWorkerBonusPercentage(16);
        assertEquals(0.16, empAdmin1.getAdminWorkerBonusPercentage(), 0.01);
        empAdmin2.setAdminWorkerBonusPercentage(9);
        assertEquals(0.09, empAdmin2.getAdminWorkerBonusPercentage(), 0.01);
        empAdmin3invalid.setAdminWorkerBonusPercentage(20);
        assertEquals(0.2, empAdmin3invalid.getAdminWorkerBonusPercentage(), 0.01);
    }
}