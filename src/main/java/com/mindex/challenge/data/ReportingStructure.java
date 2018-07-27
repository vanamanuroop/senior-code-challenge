package com.mindex.challenge.data;

public class ReportingStructure {
    /**
     * Ths employee for this record.
     */
    Employee employee;
    /**
     * The number of people who report to this employee.
     */
    int numberOfReports;

    public ReportingStructure() {
        numberOfReports = 0;
    }

    /**
     * Set the employee.
     * @param employee
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * Get the employee instance for this ReportingStructure
     * @return an employee instance.
     */
    public Employee getEmployee() {
        return employee;
    }

    public int getNumberOfReports() {

        return numberOfReports;
    }

    public void setNumberOfReports(int n) {
        numberOfReports = n;
    }

}
