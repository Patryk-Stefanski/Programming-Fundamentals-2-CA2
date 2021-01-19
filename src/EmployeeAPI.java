/**
 * @author Patryk Stefanski
 * @version 1.0 employeeAPP  10/04
 *
 * This employeeAPI class is responsible for storing and managing all the employees
 */
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.util.ArrayList;

import static java.lang.Double.compare;

public class EmployeeAPI {
    private ArrayList<Employee> employees;

    /**
     * Creates ArrayList employees of type Employee.
     */
    public EmployeeAPI() {
        employees = new ArrayList<Employee>();

    }

    /**
     * getEmployees()- This method returns all the employees of type Employee
     */
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    /**
     * setEmployees()-This method sets the arraylist of employees
     */
    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    /**
     * addEmployee()- This method adds an employee to the arraylist of Employees called employees
     */
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    /**
     * addEmployeeToDepartment()- This method adds an employee from the employees arraylist chosen by indexx
     * to the arraylist in manager(which is also chosen by index) of employees called managersEmployees
     *returns true when the employee is successfully added and false otherwise
     */
    public boolean addEmployeeToDepartment(int manager, int employee) {
       boolean value=false;
        if (Utilities.validIndex(employee, employees)) {
            if (Utilities.validIndex(manager, employees)) {
                if(employees.get(manager) instanceof Manager){
                    ((Manager) employees.get(manager)).addEmployeeToManager(employees.get(employee));
                    value = true;
                }
            }
        }
        return value;
    }

    /**
     *getEmployee()-This method return the employee at a given index in the arraylist of employees
     */
    public Employee getEmployee(int index) {
        if (Utilities.validIndex(index, employees)) {
            return employees.get(index);
        } else return null;
    }

    /**
     * removeEmployee()-This method removes the employee at a given index from the arraylist of employees
     * return the employee details if removed successfully and return null otherwise
     */
    public Employee removeEmployee(int index) {
        if (Utilities.validIndex(index, employees)) {
            employees.remove(index);
            return employees.get(index);
        } else return null;
    }

    /**
     * numberOfEmployees()-This method returns the number of employees in the employees arraylist
     */
    public int numberOfEmployees(){
        return employees.size();
    }

    /**
     *listOfEmployees()-This method adds each employee to the string listOfEmployees and then
     * returns the string
     * if the employees list is emoty it return the string "no employees in the list"
     */
    public String listOfEmployees() {
        if (employees.size() == 0) {
            return "no employees in the list";
        } else {
            String listEmployees = "";
            for (int i = 0; i < employees.size(); i++) {
                listEmployees = listEmployees + (i + ":" + employees.get(i)) + "\n";
            }
            return listEmployees;
        }
    }

    /**
     * listManagerEmployees(lastname)-This method creates a string listEmployees and adds each employee that is
     * in a given managers(chosen by lastname) department and return the string
     * if there is no employees in the managers department an empty string is returned
     */
    public String listManagerEmployees(String lastName){
        for(int i =0 ;i <employees.size();i++){
            if(employees.get(i) instanceof Manager) {
                if (employees.get(i).getEmployeeLastName() == lastName) {
                    String listEmployees = "";
                    for (int j = 0; i <  ((Manager) employees.get(i)).getManagerEmployees().size(); j++) {
                        listEmployees = listEmployees + (j + ":" + ((Manager) employees.get(i)).getManagerEmployees().get(j)) + "\n";
                    }
                }
            }
        }
        return listOfEmployees();
    }

    /**
     * listManagerEmployees()-This method creates an empty string listOfManagers and adds all employees of type manager
     * to the string and the returns it
     * if there are no managers the string "no managers in the system " is returned
     */
    public  String  listMangerEmployees(){
        if(employees.size()==0){
            return "no Managers in the system";
        }
        String listOfManagers="";
        for (int i=0;i<employees.size();i++) {
            if (employees.get(i) instanceof Manager) {
                listOfManagers = listOfManagers + (i + ":" + employees.get(i)) + "\n";
            }
        }
        return listOfManagers;
    }

    /**
     * searchEmployees()-This method searches the employees arraylist for an employee with the same lastname and
     * then returns the index number of that employee in the arraylist
     */
   public int searchEmployees(String lastname){
        int matchingEmployees=-1;
        for (int i=0;i<employees.size();i++){
            if(employees.get(i).getEmployeeLastName().toUpperCase().contains(lastname.toUpperCase())){
                matchingEmployees=i;
            }
        }
       return matchingEmployees;
   }

    /**
     * totalSalariesOwed()-This method adds the salaries of each employee and then returns the sum
     */
   public double totalSalariesOwed(){
        double totalSalaries=0;
       for (int i=0;i<employees.size();i++){
          totalSalaries= totalSalaries + employees.get(i).calculateSalary();
       }
        return totalSalaries;
   }

    /**
     * averageSalaryOwed()-This method divides the totlal amount of salaries by the amount of employees
     * and returns the average salary owed
     */
   public double averageSalaryOwed(){
        return totalSalariesOwed()/employees.size();
   }

    /**
     * employeeWithHighestSalary()-This method find the employee with the highest salary and  then
     * returns the details of the employee
     */
   public Employee employeeWithHighestSalary(){
        if (employees.size()==0){
            return null;
        }
       int highestSalaryIndex= 0;
       for (int i=0;i<employees.size();i++){
           if(employees.get(i).calculateSalary()>employees.get(highestSalaryIndex).calculateSalary()){
               highestSalaryIndex=i;
           }
       }
       return employees.get(highestSalaryIndex);
   }

    /**
     * sortEmployeesByFirstName-This method arranges the employees in the employees arraylist in
     * alphabetical order by their first name
     */
   public void sortEmployeesByFirstName() {
       for (int i = employees.size() - 1; i >= 0; i--) {
           int highestIndex = 0;
           for (int j = 0; j <= i; j++) {
               if (employees.get(j).getEmployeeFirstName().compareTo(employees.get(highestIndex).getEmployeeFirstName()) > 0) {
                   highestIndex = j;
               }
           }
           swapEmployees(employees, i, highestIndex);
       }
   }

    /**
     * sortEmployeesByLastName-This method arranges the employees in the employees arraylist in
     * alphabetical order by their last  name
     */
    public void sortEmployeesByLastName() {
        for (int i = employees.size() - 1; i >= 0; i--) {
            int highestIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (employees.get(j).getEmployeeLastName().compareTo(employees.get(highestIndex).getEmployeeLastName()) > 0) {
                    highestIndex = j;
                }
            }
            swapEmployees(employees, i, highestIndex);
        }
    }

    /**
     * sortEmployeesByHourlyRate-This method arranges the employees in the employees arraylist in
     * alphabetical order by their hourly rate
     */
    public void sortEmployeesByHourlyRate() {
        for (int i = employees.size() - 1; i >= 0; i--) {
            int highestIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (compare(employees.get(j).getHourlyRate(),(employees.get(highestIndex).getHourlyRate())) > 0) {
                    highestIndex = j;
                }
            }
            swapEmployees(employees, i, highestIndex);
        }
    }

    /**
     *swapEmployees()-This method swaps the employees place in the arralist depening on the compare to value received from
     * the sortEmployee methods from above
     * this is the method that actually arranges the list in demanded order
     */
    private void swapEmployees(ArrayList<Employee> employees, int i, int j) {
        Employee smaller = employees.get(i);
        Employee bigger = employees.get(j);

        employees.set(i,bigger);
        employees.set(j,smaller);
    }


    /**
     * load()-This method loads the meployee.xml file using extreme and reads it
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public void load() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("employee.xml"));
        employees = (ArrayList<Employee>) is.readObject();
        is.close();
    }

    /**
     * save()-This method saves the employee.xml file  by writing to it
     * @throws Exception
     */
    public void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("employee.xml"));
        out.writeObject(employees);
        out.close();
    }








}
