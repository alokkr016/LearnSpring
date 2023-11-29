package com.cn.cnpayment.entity;


import jakarta.persistence.*;

/**
 * Modify the code to add one-to-one mapping between Payment and Payment Details.
 * Use Proper Annotations.
 * Add required getters and setters.
 */

@Entity
@Table(name = "PaymentDetails")
public class PaymentDetails {


	//add proper annotations for mapping a property as id, column etc.
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String creditAccount;
	@Column
	private String debitAccount;
	@Column
	private Integer amount;
	@Column
	private String currency;

	public int getId() {
		return id;
	}

	public String getCreditAccount() {
		return creditAccount;
	}

	public void setCreditAccount(String creditAccount) {
		this.creditAccount = creditAccount;
	}

	public String getDebitAccount() {
		return debitAccount;
	}

	public void setDebitAccount(String debitAccount) {
		this.debitAccount = debitAccount;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	//add proper annotation for establishing one-to-one relationship with Payment.
	//add required getter and setter for Payment.
	@OneToOne(mappedBy = "paymentDetails")
	private Payment payment;

	public PaymentDetails(int id, String creditAccount, String debitAccount, Integer amount, String currency) {
		this.id = id;
		this.creditAccount = creditAccount;
		this.debitAccount = debitAccount;
		this.amount = amount;
		this.currency = currency;
	}

	public PaymentDetails() {
	}

}
