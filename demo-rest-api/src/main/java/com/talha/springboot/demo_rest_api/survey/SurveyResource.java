package com.talha.springboot.demo_rest_api.survey;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class SurveyResource {

	private SurveyService surveyService;

	public SurveyResource(SurveyService surveyService) {
		super();
		this.surveyService = surveyService;
	}

	@RequestMapping("/surveys")
	public List<Survey> retrieveAllSurveys() {
		return surveyService.retrieveAllSurveys();
	}

	@RequestMapping("/surveys/{surveyId}")
	public Survey retrieveSurveyById(@PathVariable String surveyId) {

		Survey survey = surveyService.SurveyById(surveyId);

		if (survey == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return survey;
	}

	@RequestMapping("/surveys/{surveyId}/questions")
	public List<Question> retrieveAllSurveyQuestions(@PathVariable String surveyId) {

		List<Question> question = surveyService.retriveAllSurveyQuestions(surveyId);

		if (question == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return question;
	}

	@RequestMapping(value = "/surveys/{surveyId}/questions/{questionId}", method= RequestMethod.GET)
	public Question retrieveSpecificSurveyQuestion(@PathVariable String surveyId, @PathVariable String questionId) {

		Question question = surveyService.retrieveSpecificSurveyQuestion(surveyId, questionId);

		if (question == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return question;
	}

	@RequestMapping(value = "/surveys/{surveyId}/questions", method = RequestMethod.POST)
	public ResponseEntity<Object> AddNewSurveyQuestion(@PathVariable String surveyId, @RequestBody Question question) {

		String questionID = surveyService.AddNewSurveyQuestion(surveyId, question);
		var location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{questionID}").buildAndExpand(questionID).toUri();
		return ResponseEntity.created(null).build();
	}
	
	
	@RequestMapping(value = "/surveys/{surveyId}/questions/{questionId}", method= RequestMethod.DELETE)
	public ResponseEntity<Object> deleteSurveyQuestion(@PathVariable String surveyId, @PathVariable String questionId) {

		surveyService.deleteSurveyQuestion(surveyId, questionId);
		return ResponseEntity.noContent().build();


	}
	
	@RequestMapping(value = "/surveys/{surveyId}/questions/{questionId}", method= RequestMethod.PUT)
	public ResponseEntity<Object> updateSurveyQuestion(@PathVariable String surveyId, @PathVariable String questionId,@RequestBody Question question) {

		surveyService.updateSurveyQuestion(surveyId ,questionId,question);
		return ResponseEntity.noContent().build();  


	}

}
