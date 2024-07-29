package com.example.universityselector.entity;

import javax.persistence.*;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseID;

    @ManyToOne
    @JoinColumn(name = "collegeID", nullable = false)
    private College college;

    private String courseName;
    private String courseStudentSize;
    private float courseFee;

    // Getters and Setters

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseStudentSize() {
        return courseStudentSize;
    }

    public void setCourseStudentSize(String courseStudentSize) {
        this.courseStudentSize = courseStudentSize;
    }

    public float getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(float courseFee) {
        this.courseFee = courseFee;
    }
}
