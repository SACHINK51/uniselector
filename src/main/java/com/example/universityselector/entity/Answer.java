package com.example.universityselector.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long responseID;
    
    @Column(name = "userID")
    private long userID;
    
    @Column(name = "highestEducationLevel")
    private String highestEducationLevel;
    
    @Column(name = "intendedFieldOfStudy")
    private String intendedFieldOfStudy;
    
    @Column(name = "gpa")
    private float gpa;
    
    @Column(name = "testTaken")
    private String testTaken;
    
    @Column(name = "testScore")
    private float testScore;
    
    @Column(name = "yearsOfExperience")
    private float yearsOfExperience;
    
    @Column(name = "campusEnvironmentType")
    private String campusEnvironmentType;
    
    @Column(name = "classSize")
    private int classSize;
    
    @Column(name = "onCampusHousing")
    private String onCampusHousing;
    
    @Column(name = "clubsAndSocieties")
    private String clubsAndSocieties;
    
    @Column(name = "modeOfStudy")
    private String modeOfStudy;
    
    @Column(name = "tuitionFeesInEuro")
    private String tuitionFeesInEuro;
    
    @Column(name = "financialAid")
    private String financialAid;
    
    @Column(name = "livingExpenseBudgetPerYearInEuro")
    private String livingExpenseBudgetPerYearInEuro;
    
    @Column(name = "partTime")
    private String partTime;
    
    @Column(name = "careerGoals")
    private String careerGoals;
    
    @Column(name = "employmentRate")
    private String employmentRate;
    
    @Column(name = "careerServices")
    private String careerServices;
    
    @Column(name = "alumniNetwork")
    private String alumniNetwork;
    
    @Column(name = "factorsOfSelection")
    private String factorsOfSelection;
	public long getResponseID() {
		return responseID;
	}
	public void setResponseID(long responseID) {
		this.responseID = responseID;
	}
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public String getHighestEducationLevel() {
		return highestEducationLevel;
	}
	public void setHighestEducationLevel(String highestEducationLevel) {
		this.highestEducationLevel = highestEducationLevel;
	}
	public String getIntendedFieldOfStudy() {
		return intendedFieldOfStudy;
	}
	public void setIntendedFieldOfStudy(String intendedFieldOfStudy) {
		this.intendedFieldOfStudy = intendedFieldOfStudy;
	}
	public float getGpa() {
		return gpa;
	}
	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
	public String getTestTaken() {
		return testTaken;
	}
	public void setTestTaken(String testTaken) {
		this.testTaken = testTaken;
	}
	public float getTestScore() {
		return testScore;
	}
	public void setTestScore(float testScore) {
		this.testScore = testScore;
	}
	public float getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(float yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	public String getCampusEnvironmentType() {
		return campusEnvironmentType;
	}
	public void setCampusEnvironmentType(String campusEnvironmentType) {
		this.campusEnvironmentType = campusEnvironmentType;
	}
	public int getClassSize() {
		return classSize;
	}
	public void setClassSize(int classSize) {
		this.classSize = classSize;
	}
	public String getOnCampusHousing() {
		return onCampusHousing;
	}
	public void setOnCampusHousing(String onCampusHousing) {
		this.onCampusHousing = onCampusHousing;
	}
	public String getClubsAndSocieties() {
		return clubsAndSocieties;
	}
	public void setClubsAndSocieties(String clubsAndSocieties) {
		this.clubsAndSocieties = clubsAndSocieties;
	}
	public String getModeOfStudy() {
		return modeOfStudy;
	}
	public void setModeOfStudy(String modeOfStudy) {
		this.modeOfStudy = modeOfStudy;
	}
	public String getTuitionFeesInEuro() {
		return tuitionFeesInEuro;
	}
	public void setTuitionFeesInEuro(String tuitionFeesInEuro) {
		this.tuitionFeesInEuro = tuitionFeesInEuro;
	}
	public String getFinancialAid() {
		return financialAid;
	}
	public void setFinancialAid(String financialAid) {
		this.financialAid = financialAid;
	}
	public String getLivingExpenseBudgetPerYearInEuro() {
		return livingExpenseBudgetPerYearInEuro;
	}
	public void setLivingExpenseBudgetPerYearInEuro(String livingExpenseBudgetPerYearInEuro) {
		this.livingExpenseBudgetPerYearInEuro = livingExpenseBudgetPerYearInEuro;
	}
	public String getPartTime() {
		return partTime;
	}
	public void setPartTime(String partTime) {
		this.partTime = partTime;
	}
	public String getCareerGoals() {
		return careerGoals;
	}
	public void setCareerGoals(String careerGoals) {
		this.careerGoals = careerGoals;
	}
	public String getEmploymentRate() {
		return employmentRate;
	}
	public void setEmploymentRate(String employmentRate) {
		this.employmentRate = employmentRate;
	}
	public String getCareerServices() {
		return careerServices;
	}
	public void setCareerServices(String careerServices) {
		this.careerServices = careerServices;
	}
	public String getAlumniNetwork() {
		return alumniNetwork;
	}
	public void setAlumniNetwork(String alumniNetwork) {
		this.alumniNetwork = alumniNetwork;
	}
	public String getFactorsOfSelection() {
		return factorsOfSelection;
	}
	public void setFactorsOfSelection(String factorsOfSelection) {
		this.factorsOfSelection = factorsOfSelection;
	}
}
