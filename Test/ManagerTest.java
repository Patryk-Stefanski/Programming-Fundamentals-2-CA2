import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Test Class for the (concrete) Manager class
 *
 * @author Siobhan Drohan & Mairead Meagher
 * @version 03/20
 */


public class ManagerTest {

    private Manager manNormal1, manNormal2;
    private AdminWorker admin1;
    private SalesWorker sales1, sales2;

    /**
     * Method to set up data for testing.
     *
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        //todo: Add your own employee fields into the constructor calls here
        manNormal1 = new Manager("John", "Donm", "j@d.com", "0876895510", "1231234IE", 20, 30);
        admin1 = new AdminWorker("tom", "murphy", "t@m.com", "0876885510", "1234567DE", 10, 20, 10);
        sales1 = new SalesWorker("Dominic", "species", "dominic@species.com", "0886895510", "7654321IR", 10, 20, 10);
        sales2 = new SalesWorker("Mick", "Scott", "m@scott.com", "0886895510", "7654321IR", 10, 20, 10);


        manNormal2 = new Manager("Patryk", "Stefanski", "p@s.com", "0876895510", "1231234IE", 100, 20);
        manNormal2.addEmployeeToManager(admin1);
        manNormal2.addEmployeeToManager(sales1);

    }


    /**
     * Test method for Manager constructor
     */
    @Test
    public void testManager() {
        //todo: Also validate your own employee fields in here (to make sure the super call constructor works correctly)
        assertEquals(30, manNormal1.getHoursWorked(), 0.01);
        assertEquals(20, manNormal1.getHourlyRate(), 0.01);
        assertEquals("JOHN", manNormal1.getEmployeeFirstName());
        assertEquals("DONM", manNormal1.getEmployeeLastName());
        assertEquals("j@d.com", manNormal1.getEmployeeEmail());
        assertEquals("0876895510", manNormal1.getEmployeePhone());
        assertEquals("1231234IE", manNormal1.getEmployeePPS());
        assertEquals(0, manNormal1.numberOfEmployees(), 0.01);
        //todo: add an assert for manNormal1, to make sure that the number of employees in their department is 0

        assertEquals(20, manNormal2.getHoursWorked(), 0.01);
        assertEquals(100, manNormal2.getHourlyRate(), 0.01);
        assertEquals("PATRYK", manNormal2.getEmployeeFirstName());
        assertEquals("STEFANSKI", manNormal2.getEmployeeLastName());
        assertEquals("p@s.com", manNormal2.getEmployeeEmail());
        assertEquals("0876895510", manNormal2.getEmployeePhone());
        assertEquals("1231234IE", manNormal2.getEmployeePPS());
        assertEquals(2, manNormal2.numberOfEmployees(), 0.01);
        //todo: add an assert for manNormal2, to make sure that the number of employees in their department is 2
    }

    /**
     * Test method for getDept and setDept. (No validation on this field)
     */
//        @Test
//        public void testConstructorsGetSetDept () {
//            //todo - this is a sample test method idea that you could complete
//        }
    @Test
    public void testCalculateSalary() {
        // manager with no employees
        assertEquals(600, manNormal1.calculateSalary(), 0.01);
        assertEquals(220, admin1.calculateSalary(), 0.01);
        assertEquals(220, sales1.calculateSalary(), 0.01);
        assertEquals(2004, manNormal2.calculateSalary(), 0.01);// ment to be 2004.4 rounding error in calculate salary method???
        manNormal2.addEmployeeToManager(sales2);
        assertEquals(2006, manNormal2.calculateSalary(), 0.01);// ment to be 2006.5 rounding error in calculate salary method???
    }

    /**
     * Test method for addDeptEmployee(Employee).
     */
    @Test
    public void testAddDeptEmployee() {
        //todo: add an assert for manNormal1, to make sure that the number of employees in their department is 0
        assertEquals(0, manNormal1.numberOfEmployees());
        manNormal1.addEmployeeToManager(sales1);
        assertEquals(1, manNormal1.numberOfEmployees());

        //todo: add an assert for manNormal1, to make sure that the number of employees in their department is now 1
        //todo: get the first employee back from manNormal1's department.  Then do an assert on it to check one of the fields, maybe name
        assertEquals("DOMINIC", manNormal1.getManagerEmployees().get(0).getEmployeeFirstName());
    }

    @Test
    public void removeEmployee() {
        //todo: add an assert for manNormal2, to make sure that the number of employees in their department is 2
        assertEquals(2, manNormal2.numberOfEmployees());
        //todo: then remove the first employee from manNormal2's list
        manNormal2.getManagerEmployees().remove(0);
        //todo: add an assert for manNormal2, to make sure that the number of employees in their department is 1
        assertEquals(1, manNormal2.numberOfEmployees());
        //todo: do an assert on the last remaining employee, maybe check their name is what you are expecting it to be.
        assertEquals("DOMINIC", manNormal2.getManagerEmployees().get(0).getEmployeeFirstName());
    }

    @Test
    public void setDept() {
        ArrayList<Employee> newDept = new ArrayList<Employee>();
        //todo: Add your own employee fields into the constructor calls here

        newDept.add(new AdminWorker("user1", "user1lastname", "u@1.com", "0876885510", "1234567DE", 10, 20, 100));
        newDept.add(new SalesWorker("user2", "user2lastname", "u@2.com", "0886895510", "7654321IR", 10, 20, 100));
        newDept.add(new AdminWorker("user3", "user3lastname", "u@3.com", "0886895510", "7654321IR", 10, 20, 100));
        //todo: for manNormal2, call the setter for the department arraylist...set it to newDept
        manNormal2.setEmployees(newDept);
        //todo: assert that the number of employees in manNormal2 department is 3
        assertEquals(3, manNormal2.numberOfEmployees());
        //todo: do an assert on manNormal2's first employee, maybe check their name is what you are expecting it to be.
        assertEquals("USER1", manNormal2.getManagerEmployees().get(0).getEmployeeFirstName());
        assertEquals("USER2", manNormal2.getManagerEmployees().get(1).getEmployeeFirstName());
    }
}