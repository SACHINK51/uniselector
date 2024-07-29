package com.example.universityselector.entity;

import javax.persistence.*;

@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int testID;

    @ManyToOne
    @JoinColumn(name = "collegeID", nullable = false)
    private College college;

    private String testName;
    private float minimumTestScore;

    // Getters and Setters

    public int getTestID() {
        return testID;
    }

    public void setTestID(int testID) {
        this.testID = testID;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public float getMinimumTestScore() {
        return minimumTestScore;
    }

    public void setMinimumTestScore(float minimumTestScore) {
        this.minimumTestScore = minimumTestScore;
    }
}
