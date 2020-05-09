package com.example.springBoot.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.springBoot.model.Question;
import com.example.springBoot.model.Survey;
import com.example.springBoot.service.SurveyService;

@RestController
public class SurveyController {
	
	@Autowired
 private SurveyService surveyService;
	

	@RequestMapping(value="/surveys/{surveyId}/questions", method=RequestMethod.GET)
	public List<Question> retrieveQuestionForSurvey(@PathVariable String surveyId){
		
		return surveyService.retrieveQuestions(surveyId);
	}
	
	@RequestMapping(value="/surveys", method=RequestMethod.GET)
	public List<Survey> retrieveAllSurvey(){
		
		return surveyService.retrieveAllSurveys();	
	}
	
	
	@RequestMapping(value="/survey/{surveyId}/question/{questionId}", method=RequestMethod.GET)
	public Question getQuestionByid(@PathVariable String surveyId, @PathVariable String questionId){
		return surveyService.retrieveQuestion(surveyId, questionId);
					
	}
	
	@RequestMapping(value="/survey/{surveyId}/questions", method=RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Void> addQuestion(@PathVariable String surveyId, @RequestBody Question newquestion  ){
		Question question= surveyService.addQuestion(surveyId, newquestion);
		
		if(question==null) {
			return ResponseEntity.noContent().build();
		}
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(question.getId()).toUri();
		
		 
		
		return ResponseEntity.created(location).build();
					
	}
	
}
