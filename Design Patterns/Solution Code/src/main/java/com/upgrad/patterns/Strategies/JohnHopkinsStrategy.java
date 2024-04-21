package com.upgrad.patterns.Strategies;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upgrad.patterns.Config.RestServiceGenerator;
import com.upgrad.patterns.Entity.JohnHopkinResponse;
import com.upgrad.patterns.Interfaces.IndianDiseaseStat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JohnHopkinsStrategy implements IndianDiseaseStat {

	private Logger logger = LoggerFactory.getLogger(JohnHopkinsStrategy.class);

	private RestTemplate restTemplate;

	@Value("${config.john-hopkins-url}")
	private String baseUrl;

	public JohnHopkinsStrategy() {
		restTemplate = RestServiceGenerator.GetInstance();
	}

	@Override
	public String GetActiveCount() {


		try{

			JohnHopkinResponse[] response = getJohnHopkinResponses();

			List<JohnHopkinResponse> indiaJohnHopkinResponse = Arrays.stream(response).filter(jhresponse -> jhresponse.getCountry().equalsIgnoreCase("India")).collect(Collectors.toList());

			List<Float> confirmedIndiaJohnHopkinValue = indiaJohnHopkinResponse.stream().map(ijhresponse -> ijhresponse.getStats().getConfirmed()).collect(Collectors.toList());

			Float sumValue = confirmedIndiaJohnHopkinValue.stream().reduce(Float::sum).get();

			return String.format("%.0f",sumValue);
		}catch(Exception e){

			logger.error(e.toString());
		}


		return null;
	}

	private JohnHopkinResponse[] getJohnHopkinResponses() throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		ClassPathResource resource = new ClassPathResource("JohnHopkins.json");
		return new JohnHopkinResponse[]{objectMapper.readValue(resource.getFile(), JohnHopkinResponse.class)};
	}
}
