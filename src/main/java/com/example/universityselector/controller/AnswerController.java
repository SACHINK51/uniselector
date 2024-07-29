/*package com.example.universityselector.controller;

import com.example.universityselector.entity.Answer;
import com.example.universityselector.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping("/submitQuestionnaire")
    public String submitQuestionnaire(
    	//@RequestParam("responseId") int responseId,
    	//@RequestParam("user_id") int user_id,
        @RequestParam("highestEducationLevel") String highestEducationLevel,
        @RequestParam("intendedFieldOfStudy") String intendedFieldOfStudy,
        @RequestParam("gpa") String gpa,
        @RequestParam("testTaken") String testTaken,
        @RequestParam("testScore") float testScore,
        @RequestParam("workExperience") String workExperience,
        @RequestParam("yearsOfExperience") String yearsOfExperience,
        // Add other parameters as needed
        @RequestParam("campusEnvironmentType") String campusEnvironmentType,
        @RequestParam("classSize") String classSize,
        @RequestParam("onCampusHousing") String onCampusHousing,
        @RequestParam("clubsAndSocieties") String clubsAndSocieties,
        @RequestParam("modeOfStudy") String modeOfStudy,
        @RequestParam("tuitionFeesInEuro") String tuitionFeesInEuro,
        
        @RequestParam("financialAid") String financialAid,
        @RequestParam("livingExpenseBudgetPerYearInEuro") String livingExpenseBudgetPerYearInEuro,
        @RequestParam("partTime") String partTime,
        @RequestParam("careerGoals") String careerGoals,
        @RequestParam("employmentRate") String employmentRate,
        @RequestParam("careerServices") String careerServices,
        
        @RequestParam("alumniNetwork") String alumniNetwork,
        @RequestParam("universityCollegeConsideration") String universityCollegeConsideration,
        @RequestParam("factorsOfSelection") String factorsOfSelection,
        @RequestParam("otherRequirements") String otherRequirements
    ) {
        Answer answer = new Answer();
        
        
        //answer.setResponseID(responseId);
        answer.setUserID(user_id);
        answer.setHighestEducationLevel(highestEducationLevel);
        answer.setIntendedFieldOfStudy(intendedFieldOfStudy);
        answer.setGpa(gpa);
        answer.setTestTaken(testTaken);
        answer.setTestScore(testScore);
        answer.setWorkExperience(workExperience);
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
        answer.setUniversityCollegeConsideration(universityCollegeConsideration);
        answer.setFactorsOfSelection(factorsOfSelection);
        answer.setOtherRequirements(otherRequirements);
        answerService.saveAnswer(answer);

        return "redirect:/universityList";  // Redirect to a success page
    }
}
*/