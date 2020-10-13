package com.christo.directory.controller;


import com.christo.directory.domain.entity.ShootingRecord;
import com.christo.directory.service.ShooterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class MainController {

    private final ShooterService shooterService;
    private final ObjectMapper objectMapper;

    @Autowired
    public MainController(ShooterService shooterService, ObjectMapper objectMapper) {
        this.shooterService = shooterService;
        this.objectMapper = objectMapper;

    }

    /**
     * @return the total amount of ammo in arrayNode form
     */
    @GetMapping("/totals")
    @ResponseBody
    public Map<String, Long> totals() {
        return shooterService.calculateTotals();
    }

    @GetMapping("/records")
    @ResponseBody
    public ArrayNode getShootingRecords() {
        return objectMapper.valueToTree(shooterService.getAllShootingRecords());
    }

    /**
     * Saves a record to the database
     *
     * @param shootingRecord the record to be saved in json stringified form
     * @return arrayNode of total ammunition and their quantity
     * @throws JsonProcessingException if the parser can't unmarshal the JSON
     */
    @PostMapping("/record")
    @ResponseBody
    public Map<String, Long> postShooting(@RequestBody String shootingRecord) throws JsonProcessingException {
        // create the record first
        ShootingRecord record = objectMapper.readValue(shootingRecord, ShootingRecord.class);
        // Save the record
        shooterService.RegisterShootingRecord(record);

        // Recalculate the total amount of bullet
        // Return the total bullets per type
        return shooterService.calculateTotals();
    }

    @GetMapping("favicon.ico")
    @ResponseBody
    void returnNoFavicon() {
    }
}
