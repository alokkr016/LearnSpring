package com.cn.cnpayment.controller;

import com.cn.cnpayment.entity.PaymentReview;

import com.cn.cnpayment.service.PaymentReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
		# In the PaymentReviewController class complete the methods to handle HTTP requests with the required 
		annotation for the following APIs:

				a. GET "/review/id/{id}": It fetches PaymentReview for a specific id.

				b. POST "/review/save" (RequestBody: PaymentReview): It saves PaymentReview in the database.

				c. DELETE "/review/id/{id}": It deletes a PaymentReview for a specific id.

				d. GET "/review/queryType/{queryType}": It fetches the list of all payment reviews containing 
				   the given query type from the database.

				e. GET "/review/allReviews": It fetches the list of all payment reviews from the database.

**/




@RestController
@RequestMapping("/review")
public class PaymentReviewController {

	// Autowire the PaymentReviewService object.
	@Autowired
	PaymentReviewService paymentReviewService;
	/**
	 * 1. Call the required service method
	 * 2. Add proper annotation for GET Mapping and attach the path-variable to the
	 * method parameter.
	 **/

	@GetMapping("/id/{id}")
	public PaymentReview getPaymentReviewById(@PathVariable int id) {
		return paymentReviewService.getPaymentReviewById(id);
	}

	/**
	 * 1. Call the required service method
	 * 2. Add proper annotation for POST Mapping and attach the required RequestBody
	 * to the method parameter.
	 **/

	@PostMapping("/save")
	public void savePaymentReview(@RequestBody PaymentReview paymentReview) {
		paymentReviewService.savePaymentReview(paymentReview);
	}

	/**
	 * 1. Call the required service method
	 * 2. Add proper annotation for DELETE Mapping and attach the path-variable to
	 * the method parameter.
	 **/
	@DeleteMapping("/id/{id}")
	public void delete(@PathVariable int id) {
		paymentReviewService.delete(id);
	}

	/**
	 * 1. Call the required service method
	 * 2. Add proper annotation for GET Mapping.
	 **/
	@GetMapping("/queryType/{queryType}")
	public List<PaymentReview> getReviewsByQueryType(@PathVariable String queryType) {
		return paymentReviewService.getPaymentReviewByQueryType(queryType);
	}

	/**
	 * 1. Call the required service method
	 * 2. Add proper annotation for GET Mapping.
	 **/

	@GetMapping("/allReviews")
	public List<PaymentReview> getAllReviews() {
		return paymentReviewService.getAllPaymentReviews();
	}
}
