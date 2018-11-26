package com.kiva.codingExercise.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kiva.codingExercise.model.Lender;
import com.kiva.codingExercise.model.Loan;
import com.kiva.codingExercise.service.LoanService;

/**
 * Loan Controller
 * 
 * @author ningm
 *
 */
@RestController
public class LoanController {

	private final LoanService loanService;

	public LoanController(LoanService loanService) {
		this.loanService = loanService;
	}

	/**
	 * get all the loans
	 */
	@GetMapping("getAllLoans")
	public List<Loan> getAllLoans() {
		return loanService.getAllLoans();
	}

	/**
	 * get a particular loan
	 */
	@GetMapping("/getLoan/{id}")
	public Loan getLoan(@PathVariable(value = "id", required = true) long id) {
		return loanService.getLoanById(id);
	}

	/**
	 * get all the lenders of a particular loan
	 */
	@GetMapping("/getAllLenders/{id}")
	public List<Lender> getAllLenders(@PathVariable(value = "id", required = true) long id) {
		return loanService.getAllLendersById(id);
	}

	/**
	 * generate repayment schedule
	 */
	@GetMapping("/generateRepaymentSchedule/{id}")
	public void generateRepaymentSchedule(@PathVariable(value = "id", required = true) long id) {
		loanService.generateRepaymentSchedule(id);
	}
}
