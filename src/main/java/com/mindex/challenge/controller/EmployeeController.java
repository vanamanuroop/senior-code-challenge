package com.mindex.challenge.controller;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
 * Apparently this controller does really save updates.
 * It seems capable of saving new records - the results of POST requests but it does not
 * save them for PUT requests.
 *
 * This is referring to the data persistance between two serial requests to the same run on the
 * server. I am aware that data will be lost when the server shuts down.
 * To overcome this problem. Create a new reocrd and mark one of the existing records as the
 * child node.
 *
 * Also node that this Employee service does not validate the data in anyway, it's quite possible to
 * create a cyclic relationship.
 *
 * {
    "employeeId": "37aac196-a9ad-45ef-913a-48f6c47adf41",
    "firstName": "Elvis",
    "lastName": "Presley",
    "position": "Boss",
    "department": "Management",
    "directReports": [
        {
            "employeeId": "16a596ae-edd3-4847-99fe-c4518e82c86f",
            "firstName": null,
            "lastName": null,
            "position": null,
            "department": null,
            "directReports": null
        }
    ]
}

 */
@RestController
public class EmployeeController {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public Employee create(@RequestBody Employee employee) {
        LOG.debug("Received employee create request for [{}]", employee);

        return employeeService.create(employee);
    }

    @GetMapping("/employee/{id}")
    public Employee read(@PathVariable String id) {
        LOG.debug("Received employee create request for id [{}]", id);

        return employeeService.read(id);
    }

    @PutMapping("/employee/{id}")
    public Employee update(@PathVariable String id, @RequestBody Employee employee) {
        LOG.debug("Received employee create request for id [{}] and employee [{}]", id, employee);

        employee.setEmployeeId(id);
        return employeeService.update(employee);
    }
}
