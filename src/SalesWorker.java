/**
 * @author Patryk Stefanski
 * @version 1.0 employeeAPP  10/04
 *
 * This salesWorker class is responsible for managing the employees of type salesWorker
 */

public class SalesWorker extends Employee {
    private double salesWorkerBonusPercentage;

    public SalesWorker(String EmployeeFirstName, String EmployeeLastName, String EmployeeEmail, String EmployeePhone, String EmployeePPS, double hourlyRate, double hoursWorked, double salesWorkerBonusPercentage) {
        super(EmployeeFirstName, EmployeeLastName, EmployeeEmail, EmployeePhone, EmployeePPS, hourlyRate, hoursWorked);
        this.salesWorkerBonusPercentage = Utilities.validSalesWorkerBonus(salesWorkerBonusPercentage);
    }

    public double getSalesWorkerBonusPercentage() {
        return salesWorkerBonusPercentage;
    }

    public void setSalesWorkerBonusPercentage(double salesWorkerBonusPercentage) {
        this.salesWorkerBonusPercentage = Utilities.validSalesWorkerBonus(salesWorkerBonusPercentage);
    }

    /**
     * calculates a sales worker salary with binuses
     */
    public double calculateSalary() {
        return (getSalary() + (getSalary() * getSalesWorkerBonusPercentage()));
    }
}
