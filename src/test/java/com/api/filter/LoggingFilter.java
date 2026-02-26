package com.api.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter {

	private final static Logger logger = LogManager.getLogger(LoggingFilter.class);

	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		logRequest(requestSpec);
		Response response = ctx.next(requestSpec, responseSpec); // Request is going to be executed
		logResponse(response); // test for assertion

		return response;
	}

	public void logRequest(FilterableRequestSpecification requestSpec) {
		logger.info("BASEURL:" + requestSpec.getBaseUri());
		logger.info("Request Payload:" + requestSpec.getBody());
		logger.info("Request Header:" + requestSpec.getHeaders());
	}

	public void logResponse(Response response) {
		logger.info("BASEURL:" + response.getStatusCode());
		logger.info("Request Header:" + response.headers());
		logger.info("Request Payload:" + response.getBody().prettyPrint());
	}

}
