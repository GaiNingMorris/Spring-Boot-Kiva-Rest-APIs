package com.kiva.codingExercise.errorHandler;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus.Series;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

/**
 * error handler
 * @author ningm
 *
 */
@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

	private static final Logger log =
			LoggerFactory.getLogger(RestTemplateResponseErrorHandler.class);
	
	@Override
	public boolean hasError(ClientHttpResponse httpResponse) throws IOException {
		Series series = httpResponse.getStatusCode().series();
		
		return (series == HttpStatus.Series.CLIENT_ERROR
				|| series == HttpStatus.Series.SERVER_ERROR
				|| httpResponse.getStatusCode() == HttpStatus.NOT_FOUND);
	}

	@Override
	public void handleError(ClientHttpResponse httpResponse) throws IOException {
		Series series = httpResponse.getStatusCode().series();
		String ErrorReason = httpResponse.getStatusCode().getReasonPhrase();
		
		if (series == HttpStatus.Series.SERVER_ERROR) {
			// handle SERVER_ERROR
			log.error("server error: {}", ErrorReason);
		} else if (series == HttpStatus.Series.CLIENT_ERROR) {
			// handle CLIENT_ERROR
			log.info("Client Error : {}", ErrorReason);
		} else if (httpResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
			// handle NotFoundException
			log.error("This Exception Is Not Found!");
		}
	}

}
