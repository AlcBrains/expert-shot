package com.christo.directory.domain.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ShootingRecord {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private ShooterUser shooterUser;

    @ManyToOne
    private Ammo ammo;

    public ShootingRecord() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShooterUser getShooterUser() {
        return shooterUser;
    }

    public void setShooterUser(ShooterUser shooterUser) {
        this.shooterUser = shooterUser;
    }

    public Ammo getAmmo() {
        return ammo;
    }

    public void setAmmo(Ammo ammo) {
        this.ammo = ammo;
    }
}
