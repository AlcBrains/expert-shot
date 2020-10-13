package com.christo.directory.service.impl;


import com.christo.directory.domain.entity.Ammo;
import com.christo.directory.domain.entity.ShootingRecord;
import com.christo.directory.domain.repository.AmmoRepository;
import com.christo.directory.domain.repository.ShootingRecordRepository;
import com.christo.directory.service.ShooterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ShooterServiceRepoImpl implements ShooterService {

    private final AmmoRepository ammoRepository;
    private final ShootingRecordRepository shootingRecordRepository;

    public ShooterServiceRepoImpl(@Autowired AmmoRepository ammoRepository,
                                  ShootingRecordRepository shootingRecordRepository) {
        this.ammoRepository = ammoRepository;
        this.shootingRecordRepository = shootingRecordRepository;
    }

    @Override
    public void RegisterShootingRecord(ShootingRecord record) {
        shootingRecordRepository.saveAndFlush(record);
    }

    @Override
    public Map<String, Long> calculateTotals() {
        return ammoRepository.findAll().stream()
                .collect(Collectors.groupingBy(Ammo::getType, Collectors.summingLong(Ammo::getAmount)));
    }

    @Override
    public List<ShootingRecord> getAllShootingRecords() {
        return shootingRecordRepository.findAll();
    }
}
