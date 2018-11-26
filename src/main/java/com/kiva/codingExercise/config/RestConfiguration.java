package com.kiva.codingExercise.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.kiva.codingExercise.errorHandler.RestTemplateResponseErrorHandler;

/**
 * RestTemplate Configuration
 * 
 * @author ningm
 *
 */
@Configuration
public class RestConfiguration {

	/**
	 * instantiate RestTemplate object using RestTemplateBuilder
	 * 
	 * @return RestTemplate
	 */
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.errorHandler(new RestTemplateResponseErrorHandler()).build();
	}

}
