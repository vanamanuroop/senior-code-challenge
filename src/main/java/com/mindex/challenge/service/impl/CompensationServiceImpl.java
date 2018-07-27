package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create and Read operation for Compensation objects
 */
@Service
public class CompensationServiceImpl implements CompensationService{
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private CompensationRepository compensationRepository;

    /**
     * Persist a compensation object.
     * @param compensation the object to be persisted
     * @return the newly saved object
     */
    @Override
    public Compensation create(Compensation compensation) {
        LOG.debug("Create new compensation object");
        compensationRepository.insert(compensation);

        return compensation;
    }

    /**
     * Read a compensaation object.
     * @param id the id of the employee with whom is object is associated.
     * @return
     */
    @Override
    public Compensation read(String id) {
        LOG.debug("Creating employee with id [{}]", id);

        Compensation compensation = compensationRepository.findByEmployeeId(id);

        if (compensation == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        return compensation;
    }
}
