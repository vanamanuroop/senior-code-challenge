package com.mindex.challenge.controller;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest end point for reporting structure
 */
@RestController
public class ReportingStructureController {
    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureController.class);

    @Autowired
    private EmployeeService employeeService;

    /**
     * GET reporting structure information for an employee
     * @param id the employee id.
     * @return
     */
    @GetMapping("/reporting/{id}")
    public ReportingStructure read(@PathVariable String id) {
        LOG.debug("Received reporting structure request request for id [{}]", id);

        ReportingStructure struct = new ReportingStructure();
        Employee emp = employeeService.read(id);

        struct.setEmployee(emp);
        countDirectReports(struct);

        return struct;
    }

    /**
     * Recursively calculate the number of reporting employees.
     * <p>
     * The employee of interest.
     *
     * @param struct - the ReportingStructure object to do the calculation for.
     */
    public void countDirectReports(ReportingStructure struct) {

        List<Employee> reporting = struct.getEmployee().getDirectReports();
        if (reporting != null) {
            struct.setNumberOfReports(struct.getNumberOfReports() + reporting.size());

            for(int i = 0 ; i < reporting.size() ; i++) {
                Employee employee = employeeService.read(reporting.get(i).getEmployeeId());
                reporting.set(i, employee);
                ReportingStructure sub = new ReportingStructure();
                sub.setEmployee(employee);
                countDirectReports(sub);
                struct.setNumberOfReports(struct.getNumberOfReports() + sub.getNumberOfReports());
            }
        }
    }
}
