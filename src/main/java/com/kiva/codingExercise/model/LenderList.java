package com.kiva.codingExercise.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * lender list
 * @author ningm
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LenderList {

	private List<Lender> lenders;

	public List<Lender> getLenders() {
		return lenders;
	}

	public void setLenders(List<Lender> lenders) {
		this.lenders = lenders;
	}

	@Override
	public String toString() {
		return "LenderList [lenders=" + lenders + "]";
	}
	
}
