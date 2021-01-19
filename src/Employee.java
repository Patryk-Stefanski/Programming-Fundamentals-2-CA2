/**
 * @author Patryk Stefanski
 * @version 1.0 employeeAPP  10/04
 *
 * This employee class is responsible fro managing object types of employee.
 */
public abstract class Employee {

    private double hoursWorked;
    private double hourlyRate;
    private static double NORMAL_WORKWEEK = 39.5;
    private static double MIN_WAGE = 9.80;
    private String EmployeeFirstName;
    private String EmployeeLastName;
    private String EmployeeEmail;
    private String EmployeePhone;
    private String EmployeePPS;

    /**
     *Constructor for an employee object
     */
    public Employee(String EmployeeFirstName, String EmployeeLastName, String EmployeeEmail, String EmployeePhone, String EmployeePPS, double hourlyRate, double hoursWorked) {
        this.EmployeeFirstName = Utilities.max20Chars(EmployeeFirstName).toUpperCase();
        this.EmployeeLastName = Utilities.max20Chars(EmployeeLastName).toUpperCase();
        if (Utilities.validEmail(EmployeeEmail) == true) {
            this.EmployeeEmail = EmployeeEmail;
        } else this.EmployeeEmail = ("invalid format email. Needs to contain . and @");

        if (Utilities.onlyContainsNumbers(EmployeePhone) == true) {
            this.EmployeePhone = EmployeePhone;
        } else this.EmployeePhone = ("unknown");
        this.EmployeePPS = Utilities.validPPS(EmployeePPS);
        if (Utilities.validHourlyRate(hourlyRate) == true) {
            this.hourlyRate = hourlyRate;
        } else this.hourlyRate = 9.80;
        if (Utilities.validDoubleNonNegative(hoursWorked) == true) {
            this.hoursWorked = hoursWorked;
        } else this.hoursWorked = 40;


    }


    //getters


    public double getHourlyRate() {
        return hourlyRate;
    }

    public static double getMinWage() {
        return MIN_WAGE;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public static double getNormalWorkweek() {
        return NORMAL_WORKWEEK;
    }

    public String getEmployeeEmail() {
        return EmployeeEmail;
    }

    public String getEmployeeFirstName() {
        return EmployeeFirstName;
    }

    public String getEmployeeLastName() {
        return EmployeeLastName;
    }

    public String getEmployeePhone() {
        return EmployeePhone;
    }

    public String getEmployeePPS() {
        return EmployeePPS;
    }


    //Setters


    public void setEmployeeFirstName(String employeeFirstName) {
        EmployeeFirstName = Utilities.max20Chars(employeeFirstName).toUpperCase();
    }

    public void setEmployeeLastName(String employeeLastName) {
        EmployeeLastName = Utilities.max20Chars(employeeLastName).toUpperCase();
    }

    public void setEmployeeEmail(String employeeEmail) {
        if (Utilities.validEmail(employeeEmail) == true) {
            this.EmployeeEmail = employeeEmail;
        }
    }

    public void setEmployeePhone(String employeePhone) {
        if (Utilities.onlyContainsNumbers(employeePhone) == true) {
            this.EmployeePhone = employeePhone;
        }
    }

    public void setEmployeePPS(String employeePPS) {
        if (employeePPS.equals(Utilities.validPPS(employeePPS))) {
            this.EmployeePPS = employeePPS;
        }
    }

    public void setHourlyRate(double hourlyRate) {
        if (Utilities.validHourlyRate(hourlyRate) == true) {
            this.hourlyRate = hourlyRate;
        }
    }

    public void setHoursWorked(double hoursWorked) {
        if (Utilities.validDoubleNonNegative(hoursWorked) == true) {
            this.hoursWorked = hoursWorked;
        }
    }


    public String toString() {
        return "Employee{" +
                "Hours Worked=" + hoursWorked +
                ", hourlyRate=" + hourlyRate + "per hour" +
                ", EmployeeFirstName='" + EmployeeFirstName + '\'' +
                ", EmployeeLastName='" + EmployeeLastName + '\'' +
                ", EmployeeEmail='" + EmployeeEmail + '\'' +
                ", EmployeePhone='" + EmployeePhone + '\'' +
                ", EmployeePPS='" + EmployeePPS + '\'' +
                '}';
    }

    //methods

    /**
     * getOverTime() - this method returns the amount of hours  a workerhas worked over his  normal work weeek
     */

    public double getOverTime() {
        double overtimeMoney = 0;
        if (getHoursWorked() > getNormalWorkweek()) {

            overtimeMoney = ((getHoursWorked() - getNormalWorkweek()) * (getHourlyRate() * 2));
        }
        return overtimeMoney;
    }


    /**
     *getSalary()- this returns the salary without the workers bonus
     */
    public double getSalary() {
        double workHours = 0;
        if (getHoursWorked() <= getNormalWorkweek()) {
            workHours = getHoursWorked();
        } else {
            workHours = getNormalWorkweek();
        }

        return ((getHourlyRate() * workHours) + getOverTime());
    }

    /**
     *This method has to be included in all other classes that extend this class
     */
    public abstract double calculateSalary();
}
