package com.house58.terra.patient.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity(name = "checking")
public class Checking {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Date date;
    @OneToOne
    private Patient patient;
    @OneToOne
    private Responsible responsible;
}
