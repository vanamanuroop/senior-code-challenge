package com.mindex.challenge.data;

import java.util.Date;

/**
 * Employee compensation
 */
public class Compensation {
    /**
     * The employee instance
     */
    Employee employee;
    /**
     * The Salary that's being plaid
     */
    float salary;
    /**
     * The date that the salary came into effect
     */
    Date effectiveDate;

    /**
     *
     * @return the employee object
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     *
     * @param employee the employee object
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     *
     * @return current salary
     */
    public float getSalary() {
        return salary;
    }

    /**
     *
     * @param salary the new salary
     */
    public void setSalary(float salary) {
        this.salary = salary;
    }

    /**
     *
     * @return the date the salary came into effect
     */
    public Date getEffectiveDate() {
        return effectiveDate;
    }

    /**
     *
     * @param effectiveDate the date the salary comes into effect.
     */
    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
