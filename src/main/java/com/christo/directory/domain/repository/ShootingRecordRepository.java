package com.christo.directory.domain.repository;

import com.christo.directory.domain.entity.ShootingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShootingRecordRepository extends JpaRepository<ShootingRecord, Long> {
}
