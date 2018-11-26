package com.kiva.codingExercise.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kiva.codingExercise.dao.RepaymentScheduleRepository;
import com.kiva.codingExercise.errorHandler.RestTemplateResponseErrorHandler;
import com.kiva.codingExercise.model.Lender;
import com.kiva.codingExercise.model.LenderList;
import com.kiva.codingExercise.model.Loan;
import com.kiva.codingExercise.model.LoanList;
import com.kiva.codingExercise.model.Repayment;
import com.kiva.codingExercise.model.Terms;
import com.kiva.codingExercise.model.Utils;
import com.kiva.codingExercise.service.LoanService;

/**
 * loan service
 * @author ningm
 *
 */
@Service
public class LoanServiceImpl implements LoanService {

	private static final Logger log = 
			LoggerFactory.getLogger(RestTemplateResponseErrorHandler.class);
	
	private final RestTemplate restTemplate;
	
	private final RepaymentScheduleRepository repaymentScheduleRepository;
	
	public LoanServiceImpl(RestTemplate restTemplate, 
			RepaymentScheduleRepository repaymentScheduleRepository) {
		this.restTemplate = restTemplate;
		this.repaymentScheduleRepository = repaymentScheduleRepository;
	}
	
	/**
	 * get all the loans
	 * @return loan list
	 */
	@Override
	public List<Loan> getAllLoans() {
		LoanList response = restTemplate.getForObject(Utils.GET_ALL_LOANS_API, 
				LoanList.class);
		return response != null ? response.getLoans() : null;
	}
	
	/**
	 * get a particular loan
	 * @param id loan id
	 * @return loan
	 */
	@Override
	public Loan getLoanById(long id) {
		LoanList response = restTemplate.getForObject(Utils.GET_LOAN_API, 
				LoanList.class, id);
		return response != null ? response.getLoans().get(0) : null;
	}

	/**
	 * get all the lenders of a particular loan
	 * @param id loan id
	 * @return lender list
	 */
	@Override
	public List<Lender> getAllLendersById(long id) {
		LenderList response = restTemplate.getForObject(Utils.GET_LENDERS_API, 
				LenderList.class, id);
		return response != null ? response.getLenders() : null;
	}

	/**
	 * generate a repayment schedule
	 * @param id loan id
	 */
	@Override
	public void generateRepaymentSchedule(long id) {
		Loan loan = getLoanById(id);
		List<Lender> lenders = getAllLendersById(id);

		if (loan != null && lenders != null && lenders.size() > 0) {
			Terms terms = loan.getTerms();
			
			try {
				long amount = terms.getLoanAmount() / lenders.size() / terms.getRepaymentTerm();

				lenders.forEach(lender -> repaymentScheduleRepository
						.save(new Repayment(lender.getId(), lender.getName(), amount)));
			} catch (ArithmeticException e) {
				log.error("repayment term is 0, {}", e);
			}
		}
	}

}