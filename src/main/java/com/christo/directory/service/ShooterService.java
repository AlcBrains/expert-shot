package com.christo.directory.service;

import com.christo.directory.domain.entity.ShootingRecord;

import java.util.List;
import java.util.Map;

public interface ShooterService {

    /**
     * Register a record to the database.
     * @param record the record we wish to register (duh)
     */
    void RegisterShootingRecord(ShootingRecord record);

    /**
     * Calculates the total ammo per type
     * @return the hashmap containing the type , and the respective amounts
     */
    Map<String, Long> calculateTotals();

    /**
     * @return a list of all the ShootingRecord Entities
     */
    List<ShootingRecord> getAllShootingRecords();

}
