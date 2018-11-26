package com.kiva.codingExercise.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * loan list
 * @author ningm
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoanList {

	private List<Loan> loans;
	
	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}

	@Override
	public String toString() {
		return "LoanList [loans=" + loans + "]";
	}
}
