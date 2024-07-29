package com.example.universityselector.repository;

/*import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.universityselector.entity.Answer;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {

    //@Query("SELECT a.optionText FROM Answer a WHERE a.question = :question")
    //List<String> findOptionsByQuestion(String question);
	
	}
*/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.universityselector.entity.Answer;
import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    //List<Answer> findByQuestion(String question);  // Assuming you have a way to link questions to their options
}
