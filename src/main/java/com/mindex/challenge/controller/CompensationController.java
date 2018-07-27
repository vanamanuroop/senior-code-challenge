package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * REST end points for compensation.
 *
 * Here is a sample HTTP post that should be sent to localhost:8080/compensation
 {
 "employee": {"employeeId" : "62c1084e-6e34-4630-93fd-9153afb65309"},
 "salary": 10000,
 "effectiveDate": "2018-10-10"
 }
 */
@RestController
public class CompensationController {
    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureController.class);

    @Autowired
    private CompensationService compensationService;

    @Autowired
    private EmployeeService employeeService;


    /**
     * Creates a new compensation object. And persist to storage
     * @param compensation the object to be created.
     * @return the newly created object.
     */
    @PostMapping("/compensation")
    public Compensation create(@RequestBody Compensation compensation) {
        LOG.debug("Received compensation create request for [{}]", compensation);

        return compensationService.create(compensation);
    }

    /**
     * Retrieve a new compensation object.
     * @param id
     * @return
     */
    @GetMapping("/compensation/{id}")
    public Compensation read(@PathVariable String id) {
        LOG.debug("Received compensation read request for id [{}]", id);
        Compensation compensation = compensationService.read(id);
        compensation.setEmployee(employeeService.read(compensation.getEmployee().getEmployeeId()));

        return compensation;
    }
}
