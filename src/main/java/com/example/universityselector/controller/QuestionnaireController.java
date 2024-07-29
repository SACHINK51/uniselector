package com.example.universityselector.controller;

import com.example.universityselector.University;
import com.example.universityselector.entity.Answer;
import com.example.universityselector.entity.User;
import com.example.universityselector.repository.AnswerRepository;
import com.example.universityselector.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
//@RequestMapping("/submitQuestionnaire")
public class QuestionnaireController {

    private static final Logger logger = LoggerFactory.getLogger(QuestionnaireController.class);

    @Autowired
    private AnswerRepository answerRepository;
    
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/submitQuestionnaire")
    //@PostMapping
    public ModelAndView submitForm(
    		//System.out.println("Sachin is submitting the form");
            @RequestParam("highestEducationLevel") String highestEducationLevel,
            @RequestParam("intendedFieldOfStudy") String intendedFieldOfStudy,
            @RequestParam("gpa") float gpa,
            @RequestParam("testTaken") String testTaken,
            @RequestParam("testScore") float testScore,
            @RequestParam("yearsOfExperience") float yearsOfExperience,
            @RequestParam("campusEnvironmentType") String campusEnvironmentType,
            @RequestParam("classSize") int classSize,
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
            @RequestParam("factorsOfSelection") String factorsOfSelection) {

        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            User user = userRepository.findByUsername(username);
            
            if (user == null) {
                logger.error("User not found: " + username);
                return new ModelAndView("error").addObject("message", "User not found.");
            }

            Answer answer = new Answer();
            answer.setUserID(user.getUserId());
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
            
            //System.out.println(answer.getResponseID());
            //System.out.println(answer.getUserID());
            String highestEduLevel = answer.getHighestEducationLevel();
            String intendedFOS = answer.getIntendedFieldOfStudy();
            float gpaScore = answer.getGpa();
            String testTkn = answer.getTestTaken();
            float testScores = answer.getTestScore();
            float exp = answer.getYearsOfExperience();
            String campEnvType = answer.getCampusEnvironmentType();
            int clsSize = answer.getClassSize();
            String onCampHousing = answer.getOnCampusHousing();
            String clubsAndSoc = answer.getClubsAndSocieties();
            String mOS = answer.getModeOfStudy();
            String tuiFees = answer.getTuitionFeesInEuro();
            String finAid = answer.getFinancialAid();
            String livExpenses = answer.getLivingExpenseBudgetPerYearInEuro();
            String prtTime = answer.getPartTime();
            String carGoals = answer.getCareerGoals();
            String empRate = answer.getEmploymentRate();
            String carServices = answer.getCareerServices();
            String aluNw = answer.getAlumniNetwork();
            String factOfSelect = answer.getFactorsOfSelection();
            
            float academicProfileScore = calculateAcademicProfileScore(
                    highestEducationLevel, intendedFieldOfStudy, gpa, testScore, yearsOfExperience);
                float personalPreferencesScore = calculatePersonalPreferencesScore(
                    campusEnvironmentType, classSize, onCampusHousing, clubsAndSocieties, modeOfStudy);
                float financialConstraintsScore = calculateFinancialConstraintsScore(
                    tuitionFeesInEuro, financialAid, livingExpenseBudgetPerYearInEuro, partTime);
                float careerProspectsScore = calculateCareerProspectsScore(
                    careerGoals, employmentRate, careerServices, alumniNetwork, factorsOfSelection);

             // Calculate total percentage
                float totalScore = academicProfileScore + personalPreferencesScore + financialConstraintsScore + careerProspectsScore;
                
                // Determine university list based on total score
                List<University> universityList = getUniversityList(totalScore);
                //Map<String, String> universityMap = getUniversityMap(totalScore);

                logger.info("Total score: " + totalScore + " University list: " + universityList);

                return new ModelAndView("universityList").addObject("universities", universityList);


           // return new ModelAndView("redirect:/universityList");

        } catch (Exception e) {
            logger.error("Error saving answer: ", e);
            return new ModelAndView("error").addObject("message", "An error occurred while processing the form.");
        }
    }
    
    public float calculateAcademicProfileScore(String highestEducationLevel, 
                                                   String intendedFieldOfStudy, 
                                                   float gpa, 
                                                   Float testScore, // Use Float to handle potential null values
                                                   float yearsOfExperience) {
            // Define weightages
            final float weightageEducationLevel = 4.0f;
            final float weightageFieldOfStudy = 5.0f;
            final float weightageGPA = 5.0f;
            final float weightageTestScore = 5.0f;
            final float weightageWorkExperience = 6.0f;

            // Calculate score for Highest Education Level
            float educationScore = 0.0f;
            switch (highestEducationLevel) {
                case "High School Diploma":
                    educationScore = 0.5f;
                    break;
                case "Associate Degree":
                    educationScore = 0.75f;
                    break;
                case "Bachelor's Degree":
                    educationScore = 1.25f;
                    break;
                case "Master's Degree":
                    educationScore = 1.5f;
                    break;
            }
            educationScore *= weightageEducationLevel / 4.0f;

            // Calculate score for Intended Field of Study
            float fieldOfStudyScore = 0.0f;
            switch (intendedFieldOfStudy) {
                case "Engineering":
                    fieldOfStudyScore = 1.0f;
                    break;
                case "Business":
                    fieldOfStudyScore = 0.8f;
                    break;
                case "Arts and Humanities":
                    fieldOfStudyScore = 0.4f;
                    break;
                case "Science and Technology":
                    fieldOfStudyScore = 0.9f;
                    break;
                case "Health Sciences":
                    fieldOfStudyScore = 1.0f;
                    break;
                case "Social Sciences":
                    fieldOfStudyScore = 0.2f;
                    break;
                case "Law":
                    fieldOfStudyScore = 0.7f;
                    break;
            }
            fieldOfStudyScore *= weightageFieldOfStudy / 5.0f;

            // Calculate score for GPA
            float gpaScore = 0.0f;
            if (gpa >= 9.0) {
                gpaScore = 2.0f;
            } else if (gpa >= 8.0) {
                gpaScore = 1.5f;
            } else if (gpa >= 7.0) {
                gpaScore = 0.75f;
            } else if (gpa >= 6.0) {
                gpaScore = 0.5f;
            } else {
                gpaScore = 0.25f;
            }
            gpaScore *= weightageGPA / 5.0f;

            // Calculate score for Test Score
            float testScoreScore = 0.0f;
            if (testScore != null) {
                if (testScore >= 9.0) {
                    testScoreScore = 2.0f;
                } else if (testScore >= 8.0) {
                    testScoreScore = 1.5f;
                } else if (testScore >= 7.0) {
                    testScoreScore = 0.75f;
                } else if (testScore >= 6.0) {
                    testScoreScore = 0.5f;
                } else {
                    testScoreScore = 0.25f;
                }
            }
            testScoreScore *= weightageTestScore / 5.0f;

            // Calculate score for Work Experience
            float workExperienceScore = 0.0f;
            if (yearsOfExperience >= 5) {
                workExperienceScore = 2.5f;
            } else if (yearsOfExperience >= 4) {
                workExperienceScore = 1.75f;
            } else if (yearsOfExperience >= 3) {
                workExperienceScore = 1.0f;
            } else if (yearsOfExperience >= 2) {
                workExperienceScore = 0.5f;
            } else if (yearsOfExperience >= 1) {
                workExperienceScore = 0.25f;
            } else {
                workExperienceScore = 0.0f;
            }
            workExperienceScore *= weightageWorkExperience / 6.0f;

            // Calculate total score for Academic Profile
            float totalAcademicProfileScore = educationScore + fieldOfStudyScore + gpaScore + testScoreScore + workExperienceScore;
            return totalAcademicProfileScore;
        }
    

    public float calculatePersonalPreferencesScore(String campusEnvironmentType, 
                                                       int classSize, 
                                                       String onCampusHousing, 
                                                       String clubsAndSocieties, 
                                                       String modeOfStudy) {
            // Define weightages
            final float weightageCampusEnvironment = 5.0f;
            final float weightageClassSize = 5.0f;
            final float weightageHousing = 5.0f;
            final float weightageClubsAndSocieties = 5.0f;
            final float weightageModeOfStudy = 5.0f;

            // Calculate score for Campus Environment Type
            float campusEnvironmentScore = 0.0f;
            switch (campusEnvironmentType) {
                case "Urban":
                    campusEnvironmentScore = 3.0f;
                    break;
                case "Suburban":
                    campusEnvironmentScore = 2.0f;
                    break;
                case "Rural":
                    campusEnvironmentScore = 1.0f;
                    break;
            }
            campusEnvironmentScore *= weightageCampusEnvironment / 5.0f;

            // Calculate score for Preferred Class Size
            float classSizeScore = 0.0f;
            if (classSize > 50) {
                classSizeScore = 2.5f;
            } else if (classSize >= 40) {
                classSizeScore = 1.0f;
            } else if (classSize >= 30) {
                classSizeScore = 0.75f;
            } else if (classSize >= 20) {
                classSizeScore = 0.5f;
            } else {
                classSizeScore = 0.25f;
            }
            classSizeScore *= weightageClassSize / 5.0f;

            // Calculate score for Type of Housing
            float housingScore = 0.0f;
            switch (onCampusHousing) {
                case "On-campus housing":
                    housingScore = 3.0f;
                    break;
                case "Off-campus housing":
                    housingScore = 2.0f;
                    break;
                case "Commuting from home":
                    housingScore = 1.0f;
                    break;
            }
            housingScore *= weightageHousing / 5.0f;

            // Calculate score for Importance of Extracurricular Activities
            float clubsAndSocietiesScore = 0.0f;
            switch (clubsAndSocieties) {
                case "Very important":
                    clubsAndSocietiesScore = 3.0f;
                    break;
                case "Somewhat important":
                    clubsAndSocietiesScore = 2.0f;
                    break;
                case "Not important":
                    clubsAndSocietiesScore = 1.0f;
                    break;
            }
            clubsAndSocietiesScore *= weightageClubsAndSocieties / 5.0f;

            // Calculate score for Preferred Mode of Study
            float modeOfStudyScore = 0.0f;
            switch (modeOfStudy) {
                case "Full-time":
                    modeOfStudyScore = 2.0f;
                    break;
                case "Part-time":
                    modeOfStudyScore = 1.5f;
                    break;
                case "Online":
                    modeOfStudyScore = 1.0f;
                    break;
                case "Hybrid":
                    modeOfStudyScore = 0.5f;
                    break;
            }
            modeOfStudyScore *= weightageModeOfStudy / 5.0f;

            // Calculate total score for Personal Preferences
            float totalPersonalPreferencesScore = campusEnvironmentScore + classSizeScore + housingScore + clubsAndSocietiesScore + modeOfStudyScore;
            return totalPersonalPreferencesScore;
        }
    

    public float calculateFinancialConstraintsScore(String tuitionFeesInEuro, 
                                                         String financialAid, 
                                                         String livingExpenseBudgetPerYearInEuro, 
                                                         String partTime) {
            // Define weightages
            final float weightageTuitionFees = 8.0f;
            final float weightageFinancialAid = 3.0f;
            final float weightageLivingExpenses = 8.0f;
            final float weightagePartTime = 6.0f;

            // Calculate score for Tuition Fees
            float tuitionFeesScore = 0.0f;
            switch (tuitionFeesInEuro) {
                case "Less than €5,000":
                    tuitionFeesScore = 1.0f;
                    break;
                case "€5,000 - €10,000":
                    tuitionFeesScore = 1.5f;
                    break;
                case "€10,000 - €20,000":
                    tuitionFeesScore = 3.0f;
                    break;
                case "More than €20,000":
                    tuitionFeesScore = 2.5f;
                    break;
            }
            tuitionFeesScore *= weightageTuitionFees / 8.0f;

            // Calculate score for Financial Aid
            float financialAidScore = 0.0f;
            switch (financialAid) {
                case "Yes, fully dependent":
                    financialAidScore = 1.0f;
                    break;
                case "Yes, partially dependent":
                    financialAidScore = 1.5f;
                    break;
                case "No":
                    financialAidScore = 0.5f;
                    break;
            }
            financialAidScore *= weightageFinancialAid / 3.0f;

            // Calculate score for Living Expenses
            float livingExpensesScore = 0.0f;
            switch (livingExpenseBudgetPerYearInEuro) {
                case "Less than €5,000":
                    livingExpensesScore = 1.0f;
                    break;
                case "€5,000 - €10,000":
                    livingExpensesScore = 2.5f;
                    break;
                case "€10,000 - €15,000":
                    livingExpensesScore = 3.0f;
                    break;
                case "More than €15,000":
                    livingExpensesScore = 1.5f;
                    break;
            }
            livingExpensesScore *= weightageLivingExpenses / 8.0f;

            // Calculate score for Part-Time Work
            float partTimeScore = 0.0f;
            switch (partTime) {
                case "Yes":
                    partTimeScore = 5.0f;
                    break;
                case "No":
                    partTimeScore = 1.0f;
                    break;
            }
            partTimeScore *= weightagePartTime / 6.0f;

            // Calculate total score for Financial Constraints
            float totalFinancialConstraintsScore = tuitionFeesScore + financialAidScore + livingExpensesScore + partTimeScore;
            return totalFinancialConstraintsScore;
        }
    

    public float calculateCareerProspectsScore(String careerGoals, 
                                                   String employmentRate, 
                                                   String careerServices, 
                                                   String alumniNetwork, 
                                                   String factorsOfSelection) {
            // Define weightages
            final float weightageCareerGoals = 5.0f;
            final float weightageEmploymentRate = 5.0f;
            final float weightageCareerServices = 5.0f;
            final float weightageAlumniNetwork = 5.0f;
            final float weightageFactorsOfSelection = 5.0f;

            // Calculate score for Career Goals
            float careerGoalsScore = 0.0f;
            switch (careerGoals) {
                case "Employment in Ireland":
                    careerGoalsScore = 2.5f;
                    break;
                case "Further studies":
                    careerGoalsScore = 1.25f;
                    break;
                case "Employment abroad":
                    careerGoalsScore = 0.75f;
                    break;
                case "Starting a business":
                    careerGoalsScore = 0.5f;
                    break;
                case "Other":
                    careerGoalsScore = 0.0f;
                    break;
            }
            careerGoalsScore *= weightageCareerGoals / 5.0f;  // Normalize to the weightage

            // Calculate score for Employment Rate
            float employmentRateScore = 0.0f;
            switch (employmentRate) {
                case "Very important":
                    employmentRateScore = 3.0f;
                    break;
                case "Somewhat important":
                    employmentRateScore = 2.0f;
                    break;
                case "Not important":
                    employmentRateScore = 1.0f;
                    break;
            }
            employmentRateScore *= weightageEmploymentRate / 5.0f;  // Normalize to the weightage

            // Calculate score for Career Services
            float careerServicesScore = 0.0f;
            switch (careerServices) {
                case "Very important":
                    careerServicesScore = 3.0f;
                    break;
                case "Somewhat important":
                    careerServicesScore = 2.0f;
                    break;
                case "Not important":
                    careerServicesScore = 1.0f;
                    break;
            }
            careerServicesScore *= weightageCareerServices / 5.0f;  // Normalize to the weightage

            // Calculate score for Alumni Network
            float alumniNetworkScore = 0.0f;
            switch (alumniNetwork) {
                case "Very important":
                    alumniNetworkScore = 3.0f;
                    break;
                case "Somewhat important":
                    alumniNetworkScore = 2.0f;
                    break;
                case "Not important":
                    alumniNetworkScore = 1.0f;
                    break;
            }
            alumniNetworkScore *= weightageAlumniNetwork / 5.0f;  // Normalize to the weightage

            // Calculate score for Factors of Selection
            float factorsOfSelectionScore = 0.0f;
            switch (factorsOfSelection) {
                case "Academic reputation":
                case "Program availability":
                case "Campus facilities":
                case "Location":
                    factorsOfSelectionScore = 1.0f;
                    break;
                case "Cost":
                case "Student support services":
                    factorsOfSelectionScore = 0.5f;
                    break;
            }
            factorsOfSelectionScore *= weightageFactorsOfSelection / 5.0f;  // Normalize to the weightage

            // Calculate total score for Career Prospects
            float totalCareerProspectsScore = careerGoalsScore + employmentRateScore + careerServicesScore + alumniNetworkScore + factorsOfSelectionScore;
            return totalCareerProspectsScore;
        }

    /*private List<String> getUniversityList(float totalScore) {
        String universityString = "";
        if (totalScore > 42.5) {
            universityString = "Trinity College Dublin, University College Dublin, University of Galway, University College Cork, University of Limerick";
        } else if (totalScore > 35.0  && totalScore <= 42.5) {
            universityString = "Dublin City University, Maynooth University, Technological University of Dublin";
        } else if (totalScore > 25.0 && totalScore <= 35.0) {
            universityString = "Atlantic Technological University (ATU), Munster Technological University, South East Technological University, Royal College of Surgeons in Ireland, National College of Ireland, Dublin Business School, Griffith College";
        } else {
            universityString = "Dundalk Institute of Technology (DKIT), Institute of Art Design and Technology (IADT), ICD Business School, Independent College, American College Dublin, CCT College Dublin, Dorset College, Mary Immaculate College, National College of Art & Design (NCAD), Shannon College of Hotel Management";
        }
        return Arrays.asList(universityString.split(",\\s*"));
    }*/
    
    private List<University> getUniversityList(float totalScore) {
        List<University> universities = new ArrayList<>();
        
        if (totalScore > 42.5) {
            universities.add(new University("Trinity College Dublin", "http://www.tcd.ie"));
            universities.add(new University("University College Dublin", "http://www.ucd.ie"));
            universities.add(new University("University of Galway", "http://www.universityofgalway.ie"));
            universities.add(new University("University College Cork", "http://www.ucc.ie"));
            universities.add(new University("University of Limerick", "http://www.ul.ie"));
        } else if (totalScore > 35.0 && totalScore <= 42.5) {
            universities.add(new University("Dublin City University", "http://www.dcu.ie"));
            universities.add(new University("Maynooth University", "http://www.maynoothuniversity.ie"));
            universities.add(new University("Technological University of Dublin", "http://www.tudublin.ie"));
        } else if (totalScore > 25.0 && totalScore <= 35.0) {
            universities.add(new University("Atlantic Technological University", "http://www.atu.ie"));
            universities.add(new University("Munster Technological University", "http://www.mtu.ie"));
            universities.add(new University("South East Technological University", "http://www.setu.ie"));
            universities.add(new University("Royal College of Surgeons in Ireland", "http://www.rcsi.com"));
            universities.add(new University("National College of Ireland", "http://www.ncirl.ie"));
            universities.add(new University("Dublin Business School", "http://www.dbs.ie"));
            universities.add(new University("Griffith College", "http://www.griffith.ie"));
        } else {
            universities.add(new University("Dundalk Institute of Technology", "http://www.dkit.ie"));
            universities.add(new University("Institute of Art Design and Technology", "http://www.iadt.ie"));
            universities.add(new University("ICD Business School", "http://www.icd.ie"));
            universities.add(new University("Independent College", "http://www.independentcolleges.ie"));
            universities.add(new University("American College Dublin", "http://www.acd.ie"));
            universities.add(new University("CCT College Dublin", "http://www.cct.ie"));
            universities.add(new University("Dorset College", "http://www.dorset-college.ie"));
            universities.add(new University("Mary Immaculate College", "http://www.mic.ie"));
            universities.add(new University("National College of Art & Design", "http://www.ncad.ie"));
            universities.add(new University("Shannon College of Hotel Management", "http://www.shannoncollege.com"));
        }
        
        return universities;
    }

    
    /*private Map<String, String> getUniversityMap(float totalScore) {
        Map<String, String> universityMap = new LinkedHashMap<>();
        if (totalScore > 42.5) {
            universityMap.put("Trinity College Dublin", "https://www.tcd.ie/");
            universityMap.put("University College Dublin", "https://www.ucd.ie/");
            universityMap.put("University of Galway", "https://www.universityofgalway.ie/");
            universityMap.put("University College Cork", "https://www.ucc.ie/en/");
            universityMap.put("University of Limerick", "https://www.ul.ie/");
        } else if (totalScore > 35.0 && totalScore <= 42.5) {
            universityMap.put("Dublin City University", "https://www.dcu.ie/");
            universityMap.put("Maynooth University", "https://www.maynoothuniversity.ie/");
            universityMap.put("Technological University of Dublin", "https://www.tudublin.ie/");
        } else if (totalScore > 25.0 && totalScore <= 35.0) {
            universityMap.put("Atlantic Technological University (ATU)", "https://www.atu.ie/");
            universityMap.put("Munster Technological University", "https://www.mtu.ie/");
            universityMap.put("South East Technological University", "https://www.setu.ie/");
            universityMap.put("Royal College of Surgeons in Ireland", "https://www.rcsi.com/dublin/");
            universityMap.put("National College of Ireland", "https://www.ncirl.ie/");
            universityMap.put("Dublin Business School", "https://www.dbs.ie/");
            universityMap.put("Griffith College", "https://www.griffith.ie/");
        } else {
            universityMap.put("Dundalk Institute of Technology (DKIT)", "https://www.dkit.ie/");
            universityMap.put("Institute of Art Design and Technology (IADT)", "https://iadt.ie/");
            universityMap.put("ICD Business School", "https://icd.ie/");
            universityMap.put("Independent College", "https://independentcollege.ie/");
            universityMap.put("American College Dublin", "https://iamu.edu/");
            universityMap.put("CCT College Dublin", "https://www.cct.ie/");
            universityMap.put("Dorset College", "https://dorset.ie/");
            universityMap.put("Mary Immaculate College", "https://www.mic.ul.ie/");
            universityMap.put("National College of Art & Design (NCAD)", "https://www.ncad.ie/");
            universityMap.put("Shannon College of Hotel Management", "https://www.universityofgalway.ie/shannoncollege/");
        }
        return universityMap;
    }*/

    @RequestMapping("/universityList")
    public String showUniversityList() {
        return "universityList";
    }
}

