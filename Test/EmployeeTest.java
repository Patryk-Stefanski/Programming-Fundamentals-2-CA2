import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class for the abstract class Employee
 * <p>
 * Note that we are testing via the AdminWorker class, but we are
 * only testing methods that reside in the Employee class
 *
 * @author Siobhan Drohan & Mairead Meagher
 * @version 03/20
 */

public class EmployeeTest {

    private AdminWorker empNormal1, empNormal2;
    private AdminWorker empTestValidation;

    /**
     * Method to set up data for testing.
     *
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        //todo: Add your own employee fields into the constructor call here
        empNormal1 = new AdminWorker("John", "Donm", "j@d.com", "0876895510", "1231234IE", 10, 20, 0);
        empNormal2 = new AdminWorker("tom", "murphy", "t@m.com", "0876885510", "1234567DE", 10, 40.5, 0);
        empTestValidation = new AdminWorker("Dominic123456789101112", "species", "dominicspecies.com", "0886895510A", "765432IRA", 9.70, 0, 0);
    }

    /**
     * Test method for Employee constructor
     */
    @Test
    public void testConstructor() {
        //test on valid data
        //todo: Validate your own employee fields in here
        assertEquals(20, empNormal1.getHoursWorked(), 0.01);
        assertEquals(10, empNormal1.getHourlyRate(), 0.01);
        assertEquals("JOHN", empNormal1.getEmployeeFirstName());
        assertEquals("DONM", empNormal1.getEmployeeLastName());
        assertEquals("j@d.com", empNormal1.getEmployeeEmail());
        assertEquals("0876895510", empNormal1.getEmployeePhone());
        assertEquals("1231234IE", empNormal1.getEmployeePPS());
        assertEquals(0, empNormal1.getAdminWorkerBonusPercentage(), 0.01);


        assertEquals(40.5, empNormal2.getHoursWorked(), 0.01);
        assertEquals(10, empNormal2.getHourlyRate(), 0.01);
        assertEquals("TOM", empNormal2.getEmployeeFirstName());
        assertEquals("MURPHY", empNormal2.getEmployeeLastName());
        assertEquals("t@m.com", empNormal2.getEmployeeEmail());
        assertEquals("0876885510", empNormal2.getEmployeePhone());
        assertEquals("1234567DE", empNormal2.getEmployeePPS());
        assertEquals(0, empNormal2.getAdminWorkerBonusPercentage(), 0.01);

        //test on invalid data
        //todo: Test the invalid data that was passed to the Employee constructor here
        assertEquals(0, empTestValidation.getHoursWorked(), 0.01);
        assertEquals(9.80, empTestValidation.getHourlyRate(), 0.01);
        assertEquals("DOMINIC1234567891011", empTestValidation.getEmployeeFirstName());
        assertEquals("SPECIES", empTestValidation.getEmployeeLastName());
        assertEquals("invalid format email. Needs to contain . and @", empTestValidation.getEmployeeEmail());
        assertEquals("unknown", empTestValidation.getEmployeePhone());
        assertEquals("INVALID", empTestValidation.getEmployeePPS());
        assertEquals(0, empTestValidation.getAdminWorkerBonusPercentage(), 0.01);
    }

    /**
     * Test method for getSalary(), testing for employees with and without overtime.
     */
    @Test
    public void testgetSalary() {
        //employee under NORMAL_WORKING_WEEKS hours
        assertEquals(200, empNormal1.getSalary(), 0.01);
        //employee with overtime + fixed bonus
        assertEquals(415, empNormal2.getSalary(), 0.01);
        empNormal1.setHourlyRate(0);
        assertEquals(200, empNormal1.getSalary(), 0.01);
        empNormal1.setHourlyRate(20);
        assertEquals(400, empNormal1.getSalary(), 0.01);
        empNormal1.setHourlyRate(20);
        assertEquals(400, empNormal1.getSalary(), 0.01);
        empNormal1.setHoursWorked(40.5);
        empNormal1.setHourlyRate(20);
        assertEquals(830, empNormal1.getSalary(), 0.01);
    }

    /**
     * Test method for getters and setters.
     */
    @Test
    public void testSettersGetters() {
        //todo: add tests for the setters and getters for your Employee fields
        assertEquals(20, empNormal1.getHoursWorked(), 0.01);
        empNormal1.setHoursWorked(40);
        assertEquals(40, empNormal1.getHoursWorked(), 0.01);
        empNormal1.setHoursWorked(-1);
        assertEquals(40, empNormal1.getHoursWorked(), 0.01);
        empNormal1.setHourlyRate(40);
        assertEquals(40, empNormal1.getHourlyRate(), 0.01);
        empNormal1.setHourlyRate(9.79);
        //ensure no change when invalid data used
        assertEquals(40, empNormal1.getHourlyRate(), 0.01);
        assertEquals("JOHN", empNormal1.getEmployeeFirstName());
        empNormal1.setEmployeeFirstName("patryk");
        assertEquals("PATRYK", empNormal1.getEmployeeFirstName());
        empNormal1.setEmployeeFirstName("Patryk123456789101112");
        assertEquals("PATRYK12345678910111", empNormal1.getEmployeeFirstName());
        empNormal1.setEmployeeLastName("stefanski");
        assertEquals("STEFANSKI", empNormal1.getEmployeeLastName());
        empNormal1.setEmployeeLastName("stefanski123456789101112");
        assertEquals("STEFANSKI12345678910", empNormal1.getEmployeeLastName());
        empNormal1.setEmployeeEmail("p@s.com");
        assertEquals("p@s.com", empNormal1.getEmployeeEmail());
        empNormal1.setEmployeeEmail("ps.com");
        assertEquals("p@s.com", empNormal1.getEmployeeEmail());
        empNormal1.setEmployeePhone("0876895510");
        assertEquals("0876895510", empNormal1.getEmployeePhone());
        empNormal1.setEmployeePhone("08768i5510");
        assertEquals("0876895510", empNormal1.getEmployeePhone());
        empNormal1.setEmployeePPS("1234568IE");
        assertEquals("1234568IE", empNormal1.getEmployeePPS());
        empNormal1.setEmployeePPS("123456IRA");
        assertEquals("1234568IE", empNormal1.getEmployeePPS());
    }

    /**
     * Test method for getOverTime (= hourly-rate*2 * (the number of hours overtime))
     */
    @Test
    public void getOverTime() {
        assertEquals(0, empNormal1.getOverTime(), 0.01);
        assertEquals(20, empNormal2.getOverTime(), 0.01);
        empNormal2.setHourlyRate(20);
        assertEquals(40, empNormal2.getOverTime(), 0.01);
    }

    /**
     * Test method for toString - checks that all data fields are present.
     */
    @Test
    public void testToString() {
        assertTrue(empNormal1.toString().contains("Hours Worked"));
        assertTrue(empNormal1.toString().contains("20"));
        assertTrue(empNormal1.toString().contains("per hour"));
        assertTrue(empNormal1.toString().contains("10"));
    }
}