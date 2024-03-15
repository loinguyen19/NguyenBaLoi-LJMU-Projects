package com.upgrad.bookmyconsultation.controller;

import com.upgrad.bookmyconsultation.dto.RatingDTO;
import com.upgrad.bookmyconsultation.entity.Rating;
import com.upgrad.bookmyconsultation.service.RatingsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ratings")
public class RatingsController {

	@Autowired
	private RatingsService ratingsService;

	@Autowired
	ModelMapper modelMapper;

	//create a post method named submitRatings with return type as ResponseEntity
		//define the method parameter rating of type Rating, use @RequestBody for mapping
		//submit the ratings
		//return http response with status set to OK

	@PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity submitRatings(@RequestBody RatingDTO ratingDTO){
		Rating newRating = modelMapper.map(ratingDTO, Rating.class);
		ratingsService.submitRatings(newRating);
		Rating savedRating = ratingsService.getRating(ratingDTO.getId());
		RatingDTO savedRatingDTO = modelMapper.map(savedRating, RatingDTO.class);

		return new ResponseEntity(savedRatingDTO, HttpStatus.OK);
	}

}
