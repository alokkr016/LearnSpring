package com.cn.cnpayment.entity;


import jakarta.persistence.*;

/**
 * Modify the code to add one-to-one mapping between Payment and Payment Details.
 * Use Proper Annotations.
 * Add required getters and setters.
 */

@Entity
@Table(name = "payment_review")
public class PaymentReview {

	//add proper annotations for mapping a property as id, column etc.
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;

	@Column
	private String queryPersonName;

	@Column
	private String queryType;

	@Column
	private String queryDescription;

	//add proper annotation for establishing many-to-one relationship with Payment.
	//add required getter and setter for Payment.
	@ManyToOne
	private Payment payment;
	@JoinColumn(name = "payment_id")
	public int getId() {
		return id;
	}

	public PaymentReview() {
	}

	public PaymentReview(int id, String queryPersonName, String queryType, String queryDescription) {
		this.id = id;
		this.queryPersonName = queryPersonName;
		this.queryType = queryType;
		this.queryDescription = queryDescription;
	}

	public PaymentReview(int id, String queryPersonName, String queryType, String queryDescription, Payment payment) {
		this.id = id;
		this.queryPersonName = queryPersonName;
		this.queryType = queryType;
		this.queryDescription = queryDescription;
		this.payment = payment;
	}

	public String getQueryPersonName() {
		return queryPersonName;
	}

	public void setQueryPersonName(String queryPersonName) {
		this.queryPersonName = queryPersonName;
	}

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	public String getQueryDescription() {
		return queryDescription;
	}

	public void setQueryDescription(String queryDescription) {
		this.queryDescription = queryDescription;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}



}
