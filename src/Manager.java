/**
 * @author Patryk Stefanski
 * @version 1.0 employeeAPP  10/04
 *
 * This Manager class is responsible for  managing all the employees of type Manager
 */
import java.util.ArrayList;

/**
 * Extends the class Employee and creates an arraylist of employees under the manager
 * called managerEmployees.
 */
public class Manager extends Employee {
    private ArrayList<Employee> ManagerEmployees;

    /**
     * constructor for  an object of Manager(which extends employee)
     */
    public Manager(String EmployeeFirstName, String EmployeeLastName, String EmployeeEmail, String EmployeePhone, String EmployeePPS, double hourlyRate, double hoursWorked) {
        super(EmployeeFirstName, EmployeeLastName, EmployeeEmail, EmployeePhone, EmployeePPS, hourlyRate, hoursWorked);
        ManagerEmployees = new ArrayList<Employee>();
    }

    /**
     * getManagerEmployees() - this method returns all the employees under a manager in
     * a arraylist format.
     */
    public ArrayList<Employee> getManagerEmployees() {
        return ManagerEmployees;
    }

    /**
     *searchManagerEmployeees() - this method searches the managers employees to find a
     * coressponding one by his/her last name
     */
    public int searchManagersEmployees(String lastname) {
        int matchingEmployees = -1;
        for (int i = 0; i < getManagerEmployees().size(); i++) {
            if (getManagerEmployees().get(i).getEmployeeLastName().toUpperCase().contains(lastname.toUpperCase())) {
                matchingEmployees = i;
            }
        }
        return matchingEmployees;
    }

    /**
     *setEmployees() - this method set the arraylist of managerEmployees
     */
    public void setEmployees(ArrayList<Employee> employees) {
        this.ManagerEmployees = employees;
    }

    /**
     *calculateSalary() - this method calculates a managers salary
     */
    public double calculateSalary() {
        double managerBonus = 0;
        for (int i = 0; i < ManagerEmployees.size(); i++) {
            managerBonus = (managerBonus + ((ManagerEmployees.get(i).getSalary()) / 100));
        }
        return (getSalary() + managerBonus);
    }

    /**
     * addEmployeeToManager() - this method adds an employee to a mangers
     * list of employees
     * @param employee
     */
    public void addEmployeeToManager(Employee employee) {
        ManagerEmployees.add(employee);
    }

    /**
     *removeEmployeeFromManager() - this method removes an employee from a managers list of employees
     */
    public boolean removeEmployeeFromManager(int index) {
        if (Utilities.validIndex(index, ManagerEmployees) == false) {
            return false;
        } else {
            ManagerEmployees.remove(index);
            return true;
        }
    }

    /**
     * numberOFEmployees() - this method returns number of employees in the managers list of employees
     * @return
     */
    public int numberOfEmployees() {
        return ManagerEmployees.size();
    }
}
