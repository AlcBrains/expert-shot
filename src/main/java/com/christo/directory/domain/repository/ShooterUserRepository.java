package com.christo.directory.domain.repository;

import com.christo.directory.domain.entity.ShooterUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShooterUserRepository extends JpaRepository<ShooterUser, Long> {
}
