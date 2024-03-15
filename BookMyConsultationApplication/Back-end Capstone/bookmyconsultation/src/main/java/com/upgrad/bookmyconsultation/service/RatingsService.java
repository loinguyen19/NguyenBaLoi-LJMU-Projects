package com.upgrad.bookmyconsultation.service;

import com.upgrad.bookmyconsultation.entity.Doctor;
import com.upgrad.bookmyconsultation.entity.Rating;
import com.upgrad.bookmyconsultation.repository.DoctorRepository;
import com.upgrad.bookmyconsultation.repository.RatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class RatingsService {

	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private RatingsRepository ratingsRepository;

	@Autowired
	private DoctorRepository doctorRepository;

	
	//create a method name submitRatings with void return type and parameter of type Rating
		//set a UUID for the rating
		//save the rating to the database
		//get the doctor id from the rating object
		//find that specific doctor with the using doctor id
		//modify the average rating for that specific doctor by including the new rating
		//save the doctor object to the database
	public void submitRatings(Rating rating) {
		rating.setRating(Integer
				.valueOf(UUID.randomUUID().version()));
		int savedRating = rating.getRating();
		ratingsRepository.save(rating);
		List<Rating> findRatings = ratingsRepository.findByDoctorId(rating.getDoctorId());
		int sumRating=0;
		int length=0;
		for(Rating eachRating : findRatings){
			sumRating = sumRating + eachRating.getRating();
			length= length + 1;
		}
		int modifiedRating = sumRating/length;
		rating.setRating(modifiedRating);
		ratingsRepository.save(rating);

		Doctor doctor = new Doctor();
		doctor.setRating((double) modifiedRating);
		doctorRepository.save(doctor);
	}

	public Rating getRating(String id){
		return ratingsRepository.findById(id).get();
	}
}
