package com.cn.cnpayment.entity;


import jakarta.persistence.*;


import java.util.List;



@Entity
@Table(name="Payment")
public class Payment {

	public Payment(int id, String paymentType, String description) {
		this.id = id;
		this.paymentType = paymentType;
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;

	@Column
	private String paymentType;

	@Column
	private String description;

	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private PaymentDetails paymentDetails;

	//add proper annotation for establishing one-to-many relationship with PaymentReview.
	//add required getter setter for PaymentReview.
	@OneToMany(mappedBy = "payment",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<PaymentReview> paymentReviews;

	public List<PaymentReview> getPaymentReviews() {
		return paymentReviews;
	}

	public void setPaymentReviews(List<PaymentReview> paymentReviews) {
		this.paymentReviews = paymentReviews;
	}

	public int getId() {
		return id;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

	@Override
	public String toString() {
		return "Payment{" +
				"id=" + id +
				", paymentType='" + paymentType + '\'' +
				", description='" + description + '\'' +
				'}';
	}

	public Payment(int id, String paymentType, String description, PaymentDetails paymentDetails, List<PaymentReview> paymentReviews) {
		this.id = id;
		this.paymentType = paymentType;
		this.description = description;
		this.paymentDetails = paymentDetails;
		this.paymentReviews = paymentReviews;
	}



	public Payment() {
	}

}
