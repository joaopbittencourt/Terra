package com.house58.terra.patient.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "checking")
public class Checking {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private long id;
    private Date date;
    @OneToOne
    private Patient patient;
    @OneToOne
    private Responsible responsible;
}
