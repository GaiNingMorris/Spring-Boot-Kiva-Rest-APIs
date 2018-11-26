package com.kiva.codingExercise.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * terms information
 * @author ningm
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Terms {

	@JsonProperty("repayment_term")
	private int repaymentTerm;
	
	@JsonProperty("loan_amount")
	private long loanAmount;

	public int getRepaymentTerm() {
		return repaymentTerm;
	}

	public void setRepaymentTerm(int repaymentTerm) {
		this.repaymentTerm = repaymentTerm;
	}

	public long getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(long loanAmount) {
		this.loanAmount = loanAmount;
	}

	@Override
	public String toString() {
		return "Terms [repaymentTerm=" + repaymentTerm + ", loanAmount=" + loanAmount + "]";
	}
}
