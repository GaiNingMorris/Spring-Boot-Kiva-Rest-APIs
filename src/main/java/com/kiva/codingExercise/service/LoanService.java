package com.kiva.codingExercise.service;

import java.util.List;

import com.kiva.codingExercise.model.Lender;
import com.kiva.codingExercise.model.Loan;

public interface LoanService {
	
	public List<Loan> getAllLoans();
	
	public Loan getLoanById(long id);
	
	public List<Lender> getAllLendersById(long id);
	
	public void generateRepaymentSchedule(long id);
}
