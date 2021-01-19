/**
 * @author Patryk Stefanski
 * @version 1.0 employeeAPP  10/04
 *
 * This adminWorker class is responsible for managing all employees of type adminWorker
 */
public class AdminWorker extends Employee {

    private double AdminWorkerBonusPercentage;

    public AdminWorker(String EmployeeFirstName, String EmployeeLastName, String EmployeeEmail, String EmployeePhone, String EmployeePPS, double hourlyRate, double hoursWorked,double adminWorkerBonusPercentage ) {
        super(EmployeeFirstName, EmployeeLastName, EmployeeEmail, EmployeePhone, EmployeePPS, hourlyRate, hoursWorked);
      this.AdminWorkerBonusPercentage = Utilities.validAdminWorkerBonus(adminWorkerBonusPercentage);
    }


    public double getAdminWorkerBonusPercentage() {
        return AdminWorkerBonusPercentage;
    }

    public void setAdminWorkerBonusPercentage(double adminWorkerBonusPercentage) {
        AdminWorkerBonusPercentage = Utilities.validAdminWorkerBonus(adminWorkerBonusPercentage);
    }

    /**
     * calculates a admins workers salary with bonuses
     * @return
     */
    public double calculateSalary() {
        return (getSalary()+(getSalary()*getAdminWorkerBonusPercentage()));
    }
}
