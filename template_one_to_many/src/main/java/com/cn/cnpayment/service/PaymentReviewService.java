package com.cn.cnpayment.service;

import com.cn.cnpayment.dal.PaymentReviewDAL;
import com.cn.cnpayment.exception.InvalidInputException;
import com.cn.cnpayment.exception.NotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.cnpayment.entity.PaymentReview;
import java.util.List;


/**
		Complete the PaymentReviewService class as mentioned below:
				
				a. Autowire PaymentReviewDAL

				b. Complete the following methods:

				1. getPaymentReviewById(int id): This method fetches PaymentReview for a specific id.

				2. getAllPaymentReviews(): This method fetches the list of all PaymentReviews.

				3. savePaymentReview(PaymentReview newPaymentReview): This method saves the PaymentReview entity.

				4. delete(int id): This method deletes PaymentReview for a specific id.

				5. getPaymentReviewByQueryType(String queryType): This method fetches the list of PaymentReview 
				   based on the queryType received.

**/

@Service
public class PaymentReviewService {

	// Autowire the PaymentReviewDAL object.
	@Autowired
	PaymentReviewDAL paymentReviewDAL;

	/**
	 * 1. Complete the method body for getPaymentReviewById() method by adding
	 * proper arguments.
	 * 2. add proper annotation for registering this method as a Transaction
	 **/

	@Transactional
	public PaymentReview getPaymentReviewById(int id) {
		PaymentReview paymentReview = paymentReviewDAL.getById(id);
		if(paymentReview == null){
			throw new NotFoundException("Not found");
		}
		return  paymentReview	;
	}

	/**
	 * 1. Complete the method body for getAllPaymentReviews() method.
	 * 2. add proper annotation for registering this method as a Transaction.
	 **/
	@Transactional
	public List<PaymentReview> getAllPaymentReviews() {
		return paymentReviewDAL.getAllPaymentReview();
	}

	/**
	 * 1. Complete the method body for savePaymentReview() method by adding proper
	 * arguments.
	 * 2. add proper annotation for registering this method as a Transaction
	 **/
	@Transactional
	public void savePaymentReview(PaymentReview paymentReview) {
		paymentReviewDAL.save(paymentReview);
	}

	/**
	 * 1. Complete the method body for delete() method by adding proper arguments.
	 * 2. add proper annotation for registering this method as a Transaction
	 **/
	@Transactional
	public void delete(int id) {
		paymentReviewDAL.delete(id);
	}

	/**
	 * 1. Complete the method body for getPaymentReviewByQueryType() method by
	 * adding proper arguments.
	 * 2. add proper annotation for registering this method as a Transaction.
	 **/

	@Transactional
	public List<PaymentReview> getPaymentReviewByQueryType(String queryType) {
//		if(!queryType.equals("Bank Issue")){
//			throw new InvalidInputException("invalid input");
//		}
		List<PaymentReview> paymentReviews = paymentReviewDAL.getByQueryType(queryType);
		if(paymentReviews.isEmpty()){
			throw new InvalidInputException("invalid input");
		}
		return paymentReviews;
	}

}
