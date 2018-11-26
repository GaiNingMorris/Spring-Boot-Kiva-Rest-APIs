package com.kiva.codingExercise.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * loan information
 * @author ningm
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Loan {
	
	private long id;
	
	private String name;
	
	private String status;
	
	private String activity;
	
	private String sector;
	
	private String use;
	
	@JsonProperty("funded_amount")
	private String fundedAmount;
	
	@JsonProperty("posted_date")
	private Date postedDate;
	
	@JsonProperty("planned_expiration_date")
	private Date plannedExpirationDate;
	
	@JsonProperty("loan_amount")
	private long loanAmount;
	
	@JsonProperty("borrower_count")
	private int borrowerCount;
	
	@JsonProperty("lender_count")
	private int lenderCount;
	
	@JsonProperty("bonus_credit_eligibility")
	private boolean bonusCreditEligibility;
	
	private Terms terms;
	
	public Loan() {
	}
	
	public Loan(String name, String status) {
		this.name = name;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}

	public String getFundedAmount() {
		return fundedAmount;
	}

	public void setFundedAmount(String fundedAmount) {
		this.fundedAmount = fundedAmount;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	public Date getPlannedExpirationDate() {
		return plannedExpirationDate;
	}

	public void setPlannedExpirationDate(Date plannedExpirationDate) {
		this.plannedExpirationDate = plannedExpirationDate;
	}

	public long getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(long loanAmount) {
		this.loanAmount = loanAmount;
	}

	public long getBorrowerCount() {
		return borrowerCount;
	}

	public void setBorrowerCount(int borrowerCount) {
		this.borrowerCount = borrowerCount;
	}

	public long getLenderCount() {
		return lenderCount;
	}

	public void setLenderCount(int lenderCount) {
		this.lenderCount = lenderCount;
	}

	public boolean isBonusCreditEligibility() {
		return bonusCreditEligibility;
	}

	public void setBonusCreditEligibility(boolean bonusCreditEligibility) {
		this.bonusCreditEligibility = bonusCreditEligibility;
	}

	public Terms getTerms() {
		return terms;
	}

	public void setTerms(Terms terms) {
		this.terms = terms;
	}

	@Override
	public String toString() {
		return "Loan [id=" + id + ", name=" + name + ", status=" + status + ", activity=" + activity + ", sector="
				+ sector + ", use=" + use + ", fundedAmount=" + fundedAmount + ", postedDate=" + postedDate
				+ ", plannedExpirationDate=" + plannedExpirationDate + ", loanAmount=" + loanAmount + ", borrowerCount="
				+ borrowerCount + ", lenderCount=" + lenderCount + ", bonusCreditEligibility=" + bonusCreditEligibility
				+ ", terms=" + terms + "]";
	}
	
}