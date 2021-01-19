import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeAPITest {
    private EmployeeAPI empAPIPopulated,empAPIEmpty;
    private Manager manNormal1;
    private AdminWorker empAdmin1,empAdmin2;
    private SalesWorker empSales1, empSales2;


    @BeforeEach
    public void setUp() {
        empAPIPopulated = new EmployeeAPI();
        empAPIEmpty = new EmployeeAPI();

        empSales1 = new SalesWorker("Dominic", "species", "dominic@species.com", "0886895510", "7654321IR", 10, 20, 10);
        empSales2 = new SalesWorker("Mick", "Scott", "m@scott.com", "0886895510", "7654321IR", 10, 20, 15);
        manNormal1 = new Manager("John", "Donm", "j@d.com", "0876895510", "1231234IE", 20, 30);
        empAdmin1 = new AdminWorker("bill", "willmot", "b@willmot.com", "0886895510", "7654321IR", 11, 20, 10);
        empAdmin2 = new AdminWorker("Nigel", "short", "n@short.com", "0886895510", "7654321IR", 10, 20, 15);


        empAPIPopulated.addEmployee(manNormal1);
        empAPIPopulated.addEmployee(empSales1);
        empAPIPopulated.addEmployee(empAdmin1);





    }



    @Test
    public void getEmployees() {
        assertEquals(3,empAPIPopulated.getEmployees().size());
        assertEquals(0,empAPIEmpty.getEmployees().size());
        assertTrue(empAPIPopulated.getEmployees().contains(manNormal1));
        assertTrue(empAPIPopulated.getEmployees().contains(empSales1));
        assertTrue(empAPIPopulated.getEmployees().contains(empAdmin1));

    }

    @Test
    public void setEmployees() {
        ArrayList<Employee> employees2= new ArrayList<>();
        employees2.add(empSales2);
        employees2.add(empAdmin2);

        empAPIEmpty.setEmployees(employees2);
        assertEquals(2,empAPIEmpty.numberOfEmployees());
        assertTrue(empAPIEmpty.getEmployees().contains(empSales2));
        assertTrue(empAPIEmpty.getEmployees().contains(empAdmin2));
    }

    @Test
    public  void addEmployee() {
        assertEquals(3,empAPIPopulated.getEmployees().size());
        assertFalse(empAPIPopulated.getEmployees().contains(empSales2));
        empAPIPopulated.getEmployees().add(empSales2);
        assertEquals(4,empAPIPopulated.getEmployees().size());
        assertTrue(empAPIPopulated.getEmployees().contains(empSales2));
    }

    @Test
    public  void addEmployeeToDepartment() {
        assertEquals(0,manNormal1.numberOfEmployees());
        manNormal1.addEmployeeToManager(empSales2);
        assertEquals(1,manNormal1.numberOfEmployees());
        assertTrue(manNormal1.getManagerEmployees().contains(empSales2));
    }

    @Test
    public  void getEmployee() {
        assertEquals(3,empAPIPopulated.getEmployees().size());
        assertEquals(manNormal1,empAPIPopulated.getEmployees().get(0));
        assertEquals(empSales1,empAPIPopulated.getEmployees().get(1));
        assertEquals(empAdmin1,empAPIPopulated.getEmployees().get(2));
    }

    @Test
    public  void removeEmployee() {
        assertEquals(3,empAPIPopulated.getEmployees().size());
        assertEquals(empAdmin1,empAPIPopulated.getEmployees().get(2));
        empAPIPopulated.getEmployees().remove(2);
        assertEquals(2,empAPIPopulated.getEmployees().size());
        assertFalse(empAPIPopulated.getEmployees().contains(empAdmin1));
    }

    @Test
    public  void numberOfEmployees() {
        assertEquals(3,empAPIPopulated.getEmployees().size());
        empAPIPopulated.getEmployees().add(empSales2);
        assertEquals(4,empAPIPopulated.getEmployees().size());
        empAPIPopulated.getEmployees().remove(empSales2);
        empAPIPopulated.getEmployees().remove(empSales1);
        assertEquals(2,empAPIPopulated.getEmployees().size());
        empAPIPopulated.getEmployees().add(empSales2);
        assertEquals(3,empAPIPopulated.getEmployees().size());
        assertEquals(0,empAPIEmpty.getEmployees().size());
    }

    @Test
    public void listOfEmployees() {
        empAPIPopulated.addEmployee(empSales1);
        empAPIPopulated.addEmployee(empSales2);

        assertTrue(empAPIPopulated.listOfEmployees().contains("DOMINIC"));
        assertTrue(empAPIPopulated.listOfEmployees().contains("MICK"));



    }

    @Test
    public void listManagerEmployees() {
        manNormal1.addEmployeeToManager(empSales1);

        assertTrue(empAPIPopulated.listManagerEmployees("DONM").contains("DOMINIC"));
    }

    @Test
    public  void listMangerEmployees() {
        empAPIPopulated.addEmployee(manNormal1);

        assertTrue(empAPIPopulated.listMangerEmployees().contains("DONM"));
    }

    @Test
    public void searchEmployees() {
        assertEquals(1,empAPIPopulated.searchEmployees("SPECIES"));
    }

    @Test
    public  void totalSalariesOwed() {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(empSales1);
        employees.add(empSales2);

        assertEquals(1062,empAPIPopulated.totalSalariesOwed());
    }

    @Test
    public  void averageSalaryOwed() {

        assertEquals(1062,empAPIPopulated.totalSalariesOwed());


    }

    @Test
    public  void employeeWithHighestSalary() {

        assertEquals(manNormal1,empAPIPopulated.employeeWithHighestSalary());
    }

    @Test
    public void sortEmployeesByFirstName() {
        empAPIPopulated.sortEmployeesByFirstName();
        assertEquals(empAdmin1,empAPIPopulated.getEmployees().get(0));
        assertEquals(empSales1,empAPIPopulated.getEmployees().get(1));
        assertEquals(manNormal1,empAPIPopulated.getEmployees().get(2));

    }

    @Test
    public  void sortEmployeesByLastName() {
        empAPIPopulated.sortEmployeesByLastName();
        assertEquals(manNormal1,empAPIPopulated.getEmployees().get(0));
        assertEquals(empSales1,empAPIPopulated.getEmployees().get(1));
        assertEquals(empAdmin1,empAPIPopulated.getEmployees().get(2));
    }

    @Test
    public  void sortEmployeesByHourlyRate() {
        empAPIPopulated.sortEmployeesByHourlyRate();
        assertEquals(empSales1,empAPIPopulated.getEmployees().get(0));
        assertEquals(empAdmin1,empAPIPopulated.getEmployees().get(1));
        assertEquals(manNormal1,empAPIPopulated.getEmployees().get(2));
    }


}