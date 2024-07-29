package com.example.universityselector.entity;

import javax.persistence.*;

@Entity
public class Housing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int housingID;

    @ManyToOne
    @JoinColumn(name = "collegeID", nullable = false)
    private College college;

    private String environmentType;
    private String onCampusHousingAvailability;
    private String diversity;

    // Getters and Setters

    public int getHousingID() {
        return housingID;
    }

    public void setHousingID(int housingID) {
        this.housingID = housingID;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public String getEnvironmentType() {
        return environmentType;
    }

    public void setEnvironmentType(String environmentType) {
        this.environmentType = environmentType;
    }

    public String getOnCampusHousingAvailability() {
        return onCampusHousingAvailability;
    }

    public void setOnCampusHousingAvailability(String onCampusHousingAvailability) {
        this.onCampusHousingAvailability = onCampusHousingAvailability;
    }

    public String getDiversity() {
        return diversity;
    }

    public void setDiversity(String diversity) {
        this.diversity = diversity;
    }
}
