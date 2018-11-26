package com.kiva.codingExercise.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.kiva.codingExercise.model.Lender;
import com.kiva.codingExercise.model.Loan;
import com.kiva.codingExercise.service.LoanService;

/**
 * unit test for LoanController
 * 
 * @author ningm
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(LoanController.class)
public class LoanControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private LoanService loanServiceMock;

	// loan id
	private final long id = 300000;

	// a mock loan
	private final Loan loan = new Loan("John", "funded");

	// get all the loans
	@Test
	public void getAllLoans() throws Exception {
		List<Loan> loans = new ArrayList<Loan>();
		loans.add(loan);
		String expected = "[{\"id\":0,\"name\":\"John\",\"status\":\"funded\",\"activity\":null,\"sector\":null,"
				+ "\"use\":null,\"terms\":null,\"funded_amount\":null,\"posted_date\":null,\"planned_expiration_date"
				+ "\":null,\"loan_amount\":0,\"borrower_count\":0,\"lender_count\":0,\"bonus_credit_eligibility\":false}]";

		when(loanServiceMock.getAllLoans()).thenReturn(loans);
		MvcResult result = this.mockMvc.perform(get("/getAllLoans")).andDo(print()).andExpect(status().isOk())
				.andReturn();
		assertEquals(expected, result.getResponse().getContentAsString());
	}

	// get a particular loan
	@Test
	public void getLoan() throws Exception {
		String expected = "{\"id\":0,\"name\":\"John\",\"status\":\"funded\",\"activity\":null,\"sector\":null,"
				+ "\"use\":null,\"terms\":null,\"funded_amount\":null,\"posted_date\":null,\"planned_expiration_date"
				+ "\":null,\"loan_amount\":0,\"borrower_count\":0,\"lender_count\":0,\"bonus_credit_eligibility\":false}";

		when(loanServiceMock.getLoanById(Mockito.anyLong())).thenReturn(loan);
		MvcResult result = this.mockMvc.perform(get("/getLoan/" + id)).andDo(print()).andExpect(status().isOk())
				.andReturn();
		assertEquals(expected, result.getResponse().getContentAsString());
	}

	// get all the lenders of a particular loan
	@Test
	public void getAllLenders() throws Exception {
		List<Lender> lenders = new ArrayList<Lender>();
		lenders.add(new Lender("Jack", "us"));
		String expected = "[{\"name\":\"Jack\",\"uid\":null,\"image\":null,\"lender_id\":null,"
				+ "\"whereabouts\":0,\"country_code\":\"us\"}]";

		when(loanServiceMock.getAllLendersById(Mockito.anyLong())).thenReturn(lenders);
		MvcResult result = this.mockMvc.perform(get("/getAllLenders/" + id)).andDo(print()).andExpect(status().isOk())
				.andReturn();
		assertEquals(expected, result.getResponse().getContentAsString());
	}

}