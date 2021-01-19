/**
 * @author Patryk Stefanski
 * @version 1.0 employeeAPP  10/04
 *
 * This driver class runs the application and handles the employee I/O,
 * the class uses Scanner input to read input and generates the output to the
 * user through the terminal.
 */

import java.util.ArrayList;
import  java.util.Scanner;


/**
 * Creates ArrayList employees of type Employee.
 * empAPI is an object of the EmployeeAPI class.
 * input is an object of the scanner class, used to read in input.
 */
public class Driver {
    private  Scanner input;
    private  EmployeeAPI empAPI;
    private ArrayList<Employee> employees;

    /**
     * This is the constructor for ArrayList of employees,
     * empAPI object of EmployeeAPI class,input of the Scanner class.
     */
    public Driver(){
        input=new Scanner(System.in);
        empAPI=new EmployeeAPI();
        employees = new ArrayList<Employee>();
     }

    /**
     * The main method of the Driver class.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Driver app = new Driver();
        app.run();
    }


    /**
     * mainMenu() - This method displays the menu for the application,
     * reads the menu option that the user entered and returns it
     */
    private int mainMenu() {
        System.out.println("  1) Add an employee (Manager) ");
        System.out.println("  2) Add an employee (Sales worker)");
        System.out.println("  3) Add an employee (Admin worker)");
        System.out.println("  4 )Add an existing employee to a department");
        System.out.println("  5) Delete an employee");
        System.out.println("  --------------------");
        System.out.println("  6) Find the total of the salaries owed to all the employees");
        System.out.println("  7) Find the average of the salaries owed to all the employees");
        System.out.println("  8) Print the mployee with the highest pay");
        System.out.println("  --------------------");
        System.out.println("  Party Menu");
        System.out.println("  9) List all employees in the company in ascending alphabetical order(first name)");
        System.out.println("  10) List all employees in the company in ascending alphabetical order(last name)");
        System.out.println("  11)List all employees in the company in ascending  order(hourly rate)");
        System.out.println("  --------------------");
        System.out.println("  12) Search the system for an employee by second name");
        System.out.println("  13) Search the system for an employee within a given managers department");
        System.out.println("  --------------------");
        System.out.println("  14)Save to XML");
        System.out.println("  15)Load from XML");
        System.out.println("  --------------------");
        System.out.println("  0)exit");
        return ScannerInput.readNextInt("==>>");
    }


    /**
     * runMenu() = This method has switch statement and processes the user choice
     * taken in from mainMenu() method
     */
    private void run()  {
        int option = mainMenu();
        while (option != 0) {

            switch (option) {
                case 1:
                    addManager();
                    break;
                case 2:
                    addSalesWorker();
                    break;
                case 3:
                    addAdminWorker();
                    break;
                case 4:
                    addEmpToManager();
                    break;
                case 5:
                    deleteEmployeeByName();
                    break;
                case 6:
                    totalSalariesOwed();
                    break;
                case 7:
                    averageSalariesOwed();
                    break;
                case 8:
                    employeeHighestSalary();
                    break;
                case 9:
                    sortEmployeesByFirstName();
                    break;
                case 10:
                    sortEmployeesByLastName();
                    break;
                case 11:
                    sortEmployeesByHourlyRate();
                    break;
                case 12:
                    searchBySecondName();
                    break;
                case 13:
                    searchByDept();
                    break;
                case 14:
                    try {
                        empAPI.save();
                    }
                    catch (Exception e){
                        System.err.println("Error writing to file: " + e);
                    }
                    break;
                case 15:
                    try {
                        empAPI.load();
                    } catch (Exception e) {
                        System.err.println("Error reading from file: " + e);
                    }
                    break;
                default:
                    System.out.println("Invalid option entered: " + option);
                    break;
            }

            //pause the program so that the user can read what we just printed to the terminal window
            System.out.println("\nPress any key to continue...");
            input.nextLine();

            //display the main menu again
            option = mainMenu();
        }

        //the user chose option 0, so exit the program
        System.out.println("Exiting... bye");
        System.exit(0);
    }

    /**
     * getter for employees ArrayList
     * @return employees
     */
    public ArrayList<Employee> getEmployees() {
        return employees;
    }


    /**
     * addManager()- This method adds a new employee of type manager to the employees arraylist.
     */
    public void addManager(){
        String EmployeeFirstName = ScannerInput.validNextLine("Enter the Managers  First Name:  ").toUpperCase();
        String EmployeeLastName = ScannerInput.validNextLine("Enter the Managers Last Name:  ").toUpperCase();
        String EmployeeEmail=ScannerInput.validNextLine("Enter Managers Email:");
        String EmployeePhone=ScannerInput.validNextLine("Enter Managers Phone Number");
        String EmployeePPS=ScannerInput.validNextLine("Enter the Managers PPS Number:");
        double hourlyRate=ScannerInput.readNextDouble("Enter the Managers Hourly Rate");
        double hoursWorked=ScannerInput.readNextDouble("Enter the Managers Hours Worked");


        empAPI.addEmployee(new Manager(EmployeeFirstName,EmployeeLastName,EmployeeEmail,EmployeePhone,EmployeePPS,hourlyRate,hoursWorked) {
        });
    }

    /**
     * addSalesWorker()- This method adds a new employee of type sales worker to the employees arraylist.
     */
    public void addSalesWorker(){
        String EmployeeFirstName = ScannerInput.validNextLine("Enter the Sales Workers  First Name:  ").toUpperCase();
        String EmployeeLastName = ScannerInput.validNextLine("Enter the Sales Workers Last Name:  ").toUpperCase();
        String EmployeeEmail=ScannerInput.validNextLine("Enter Sales Workers Email:");
        String EmployeePhone=ScannerInput.validNextLine("Enter Sales Workers Phone Number");
        String EmployeePPS=ScannerInput.validNextLine("Enter the Sales Workers PPS Number:");
        double hourlyRate=ScannerInput.readNextDouble("Enter the Sales Workers Hourly Rate");
        double hoursWorked=ScannerInput.readNextDouble("Enter the Sales Workers Hours Worked");
        double salesWorkerBonusPercentage= ScannerInput.readNextDouble("Enter the Sales Worker Bonus Percentage:");

        empAPI.addEmployee(new SalesWorker(EmployeeFirstName,EmployeeLastName,EmployeeEmail,EmployeePhone,EmployeePPS,hourlyRate,hoursWorked,salesWorkerBonusPercentage) {
        });
    }

    /**
     * addAdminWorker()- This method adds a new employee of type admin worker to the employees arraylist.
     */
    public void addAdminWorker(){
        String EmployeeFirstName = ScannerInput.validNextLine("Enter the Admin Workers  First Name:  ").toUpperCase();
        String EmployeeLastName = ScannerInput.validNextLine("Enter the Admin Workers Last Name:  ").toUpperCase();
        String EmployeeEmail=ScannerInput.validNextLine("Enter Admin Workers Email:");
        String EmployeePhone=ScannerInput.validNextLine("Enter Admin Workers Phone Number");
        String EmployeePPS=ScannerInput.validNextLine("Enter the Admin Workers PPS Number:");
        double hourlyRate=ScannerInput.readNextDouble("Enter the Admin Workers Hourly Rate");
        double hoursWorked=ScannerInput.readNextDouble("Enter the Admin Workers Hours Worked");
        double adminWorkerBonusPercentage= ScannerInput.readNextDouble("Enter the Admin Workers Bonus Percentage:");

        empAPI.addEmployee(new AdminWorker(EmployeeFirstName,EmployeeLastName,EmployeeEmail,EmployeePhone,EmployeePPS,hourlyRate,hoursWorked,adminWorkerBonusPercentage) {
        });
    }

    /**
     * addEmpToManger()- This method adds an employee of any type to a employee of type manager,
     * it is added to a new arraylist of Employyes called managerEmployees
     * that is created when a manger employee is created
     */
    public void  addEmpToManager(){
        if(empAPI.getEmployees().size()==0){
            System.out.println("There are no employees");
            return;
        }

         System.out.println(empAPI.listOfEmployees());
         int employee=ScannerInput.readNextInt("Please Enter the Index of the Employee to be Added to the Manager:");
         int manager=ScannerInput.readNextInt("Please Enter the Index of the Manager to Which the Employee Should be Added:");
         empAPI.addEmployeeToDepartment(manager,employee);

    }

    /**
     * deleteEmployeeByName()- This method removes an employee chosen by  his last name from the employees arraylist;
     * and prints out his details after removing
     */
    public void deleteEmployeeByName(){
         String employeeLastName=ScannerInput.validNextLine("Please Enter The Employees Last Name:").toUpperCase();
        System.out.println(empAPI.removeEmployee(empAPI.searchEmployees(employeeLastName)));
    }

    /**
     * totalSalariesOwed() - This method  prints out the total salaries owed
     */
    public void totalSalariesOwed(){
        System.out.println(empAPI.totalSalariesOwed());
    }

    /**
     * averageSalariesOwed() - This method  prints out the average salaries owed
     */
    public void  averageSalariesOwed(){
        System.out.println(empAPI.averageSalaryOwed());
    }

    /**
     *employeeHighestSalary() - This method  prints out the total employee with the highest salary
     */
    public void employeeHighestSalary(){
        System.out.println(empAPI.employeeWithHighestSalary());
    }

    /**
     * sortEmployeesByFirstName() - This method  prints out the employees list in alphabetical order by first name
     */
    public void sortEmployeesByFirstName(){
        empAPI.sortEmployeesByFirstName();
        System.out.println(empAPI.listOfEmployees());
    }

    /**
     * sortEmployeesByLastName() - This method  prints out the employees list in alphabetical order by last name
     */
    public void sortEmployeesByLastName(){
        empAPI.sortEmployeesByLastName();
        System.out.println(empAPI.listOfEmployees());
    }

    /**
     * sortEmployeesByHourlyRate() - This method  prints out the employees list in alphabetical order by ascending hourly rate
     */
    public void sortEmployeesByHourlyRate(){
        empAPI.sortEmployeesByHourlyRate();
        System.out.println(empAPI.listOfEmployees());
    }

    /**
     * searchBySecondName()- This mehod searches the employee arraylist for an employee chosen by his last name
     * and prints out his details
     */
    public void searchBySecondName(){
        String employeeLastName=ScannerInput.validNextLine("Please Enter The Employees Second Name:").toUpperCase();
       System.out.println(empAPI.getEmployee( empAPI.searchEmployees(employeeLastName)));
    }


    /**
     * searchByDept()- This method searches  for an employee chosen by his last name  in the arraylist of managerEmployees
     * in manager which is also chosen by his last name
     */
    public void searchByDept(){
        String employeeLastName=ScannerInput.validNextLine("Please Enter The Employees Last Name:").toUpperCase();
        String managerLastName=ScannerInput.validNextLine("Please Enter The Managers Second Name:").toUpperCase();

        if(empAPI.getEmployee(empAPI.searchEmployees(managerLastName) )instanceof Manager){
            if(empAPI.listManagerEmployees(managerLastName).contains(employeeLastName)){
                System.out.println(empAPI.getEmployee(empAPI.searchEmployees(employeeLastName)));
            }
        }
    }


}
