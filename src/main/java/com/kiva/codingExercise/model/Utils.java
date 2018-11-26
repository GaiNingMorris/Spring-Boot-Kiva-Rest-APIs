package com.kiva.codingExercise.model;

/**
 * Common Util
 * 
 * @author ningm
 *
 */
public class Utils {

	// the url to get all loans 
	public static final String GET_ALL_LOANS_API = "http://api.kivaws.org/v1/loans/search.json?status=funded";
	
	// the url to get loan by loan id
	public static final String GET_LOAN_API = "http://api.kivaws.org/v1/loans/{id}.json";

	// the url to get lenders by loan id
	public static final String GET_LENDERS_API ="http://api.kivaws.org/v1/loans/{id}/lenders.json";
}