package com.example.universityselector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.universityselector.entity.Answer;

import com.example.universityselector.repository.AnswerRepository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/*@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Transactional
    public void saveAnswer(QuestionnaireDTO questionnaire) {
        saveAnswer("education", questionnaire.getEducation());
        saveAnswer("fieldOfStudy", questionnaire.getFieldOfStudy());
        saveAnswer("gpa", questionnaire.getGpa());
        saveAnswer("testTaken", questionnaire.getTestTaken());
        saveAnswer("testScore", questionnaire.getTestScore());
        saveAnswer("workExperience", questionnaire.getWorkExperience());
        saveAnswer("campusEnvironment", questionnaire.getCampusEnvironment());
        saveAnswer("classSize", questionnaire.getClassSize());
        saveAnswer("housing", questionnaire.getHousing());
        saveAnswer("extracurricularActivities", questionnaire.getExtracurricularActivities());
        saveAnswer("culturalDiversity", questionnaire.getCulturalDiversity());
        saveAnswer("modeOfStudy", questionnaire.getModeOfStudy());
        saveAnswer("tuitionBudget", questionnaire.getTuitionBudget());
        saveAnswer("financialAid", questionnaire.getFinancialAid());
        saveAnswer("livingBudget", questionnaire.getLivingBudget());
        saveAnswer("partTimeWork", questionnaire.getPartTimeWork());
        saveAnswer("careerGoals", questionnaire.getCareerGoals());
        saveAnswer("employmentRates", questionnaire.getEmploymentRates());
        saveAnswer("coopInternship", questionnaire.getCoopInternship());
        
        // Example method to save an answer
    }

	//private void saveAnswers(int userID, HighestEducationLevel highestEducationLevel, IntendedFieldOfStudy intendedFieldOfStudy, float gpa, TestTaken testTaken, float testScore, float yearsOfExperience, CampusEnvironmentType campusEnvironmentType, int classSize, OnCampusHousing onCampusHousing, ClubsAndSocieties clubsAndSocieties, ModeOfStudy modeOfStudy, TuitionFeesInEuro tuitionFeesInEuro, FinancialAid financialAid, LivingExpenseBudgetPerYearInEuro livingExpenseBudgetPerYearInEuro, PartTime partTime, CareerGoals careerGoals, EmploymentRate employmentRate, CareerServices careerServices, AlumniNetwork alumniNetwork, FactorsOfSelection factorsOfSelection) {
    public void saveAnswer(QuestionnaireDTO questionnaire)  {  
    Answer answer = new Answer();
        //answer.setQuestion(question);
        answer.setUserID(userID);
        answer.setHighestEducationLevel(highestEducationLevel);
        answer.setIntendedFieldOfStudy(intendedFieldOfStudy);
        answer.setGpa(gpa);
        answer.setTestTaken(testTaken);
        
        answer.setTestScore(testScore);
        answer.setYearsOfExperience(yearsOfExperience);
        answer.setCampusEnvironmentType(campusEnvironmentType);
        answer.setClassSize(classSize);
        answer.setOnCampusHousing(onCampusHousing);
        answer.setClubsAndSocieties(clubsAndSocieties);
        answer.setModeOfStudy(modeOfStudy);
        answer.setTuitionFeesInEuro(tuitionFeesInEuro);
        answer.setFinancialAid(financialAid);
        answer.setLivingExpenseBudgetPerYearInEuro(livingExpenseBudgetPerYearInEuro);
        answer.setPartTime(partTime);
        answer.setCareerGoals(careerGoals);
        answer.setEmploymentRate(employmentRate);
        answer.setCareerServices(careerServices);
        answer.setAlumniNetwork(alumniNetwork);
        answer.setFactorsOfSelection(factorsOfSelection);
        answerRepository.save(answer);
    }
	
    public List<String> getOptions(String question) {
        return answerRepository.findOptionsByQuestion(question);
    }
}*/


/*@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Transactional
    public void saveAnswer(Answer answer) {
        answerRepository.save(answer);
    }
}
*/

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    // Fetch options for a specific question
    //public List<String> findOptionsByQuestion(String question) {
    //    return answerRepository.findOptionsByQuestion(question);
    //}

    // Save response from the questionnaire
    /*public void saveResponse(Map<String, String> responses) {
        Answer answer = new Answer();
        // Assume setters for all fields based on your entity
        // For example:
        answer.setEducation(responses.get("education"));
        answer.setFieldOfStudy(responses.get("fieldOfStudy"));
        // Continue for other fields
        answerRepository.save(answer);
    }*/
    
    //@Transactional
    public void saveAnswer(Answer answer) {
    	System.out.println("Sachin is saving the answers from AnswerRepo");
        answerRepository.save(answer);
    }
    
 // Assuming method to fetch options if necessary
    // This would typically involve fetching distinct values from stored answers or another configuration table
    public List<String> fetchOptionsForQuestion(String question) {
        // Placeholder logic
        return new ArrayList<>();
    }
}
