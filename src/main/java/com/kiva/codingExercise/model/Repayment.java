package com.kiva.codingExercise.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * repayment information
 * @author ningm
 *
 */
@Entity
@Table(name="REPAYMENT")
public class Repayment {

	public Repayment(String lenderId, String lenderName, long amount) {
		super();
		this.lenderId = lenderId;
		this.lenderName = lenderName;
		this.amount = amount;
	}

	@Id
    @Column(name="ID")
    @GeneratedValue
    private long id;
	
	@Column(name="LENDER_ID")
	private String lenderId;
	
	@Column(name="LENDER_NAME")
	private String lenderName;
	
	@Column(name="AMOUNT")
	private long amount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLenderId() {
		return lenderId;
	}

	public void setLenderId(String lenderId) {
		this.lenderId = lenderId;
	}

	public String getLenderName() {
		return lenderName;
	}

	public void setLenderName(String lenderName) {
		this.lenderName = lenderName;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Repayment [id=" + id + ", lenderId=" + lenderId + ", lenderName=" + lenderName + ", amount=" + amount
				+ "]";
	}
}