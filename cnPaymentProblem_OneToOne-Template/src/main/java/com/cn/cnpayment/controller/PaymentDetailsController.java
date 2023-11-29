package com.cn.cnpayment.controller;

import com.cn.cnpayment.service.PaymentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cn.cnpayment.entity.PaymentDetails;

import java.util.List;

/**
  # In the PaymentDetailsController class complete the methods to handle HTTP requests with the required
     annotation for the following APIs:

		a. GET "/details/id/{id}": It fetches a payment detail object by id.

		b. POST "/details/save" (Body - PaymentDetails object): It saves a PaymentDetails object.

		c. DELETE "/details/id/{id}": It deletes a PaymentDetails object by id.

		d. PUT "/details/update" (Body - PaymentDetails object): It updates a PaymentDetails object.

		e. GET "/details/allPaymentDetails": It fetches a list of all PaymentDetails objects.

		f. GET "/details/currency/{currency}": It fetches a list of all PaymentDetails objects with the given
		   currency.

 **/

@RestController
@RequestMapping("/details")
public class PaymentDetailsController {

	// Autowire the PaymentDetailsService object

	@Autowired
	PaymentDetailsService paymentDetailsService;

	/**
	 * 1. Call the required service method
	 * 2. Add proper annotation for GET Mapping and attach the pathvariable to the
	 * method parameter.
	 **/
	@GetMapping("/id/{id}")
	public PaymentDetails getPaymentDetailsById(@PathVariable int id) {
		return paymentDetailsService.getPaymentDetailsById(id);
	}


	/**
	 * 1. Call the required service method
	 * 2. Add proper annotation for GET Mapping and attach the pathvariable to the
	 * method parameter.
	 **/

	@GetMapping("/currency/{currency}")
	public List<PaymentDetails> getByCurrency(@PathVariable String currency) {
		return paymentDetailsService.getByCurrency(currency);
	}

	/**
	 * 1. Call the required service method
	 * 2. Add proper annotation for GET Mapping .
	 **/

	@GetMapping("/allPaymentDetails")
	public List<PaymentDetails> getAllPayments() {
		return paymentDetailsService.getAllPaymentDetails();
	}

	/**
	 * 1. Call the required service method
	 * 2. Add proper annotation for POST Mapping and attach the request body to the
	 * method parameter.
	 **/


	@PostMapping("/save")
	public void savePaymentDetails(@RequestBody PaymentDetails paymentDetails) {
		paymentDetailsService.savePaymentDetails(paymentDetails);
	}

	/**
	 * 1. Call the required service method
	 * 2. Add proper annotation for DELETE Mapping and attach the pathvariable to
	 * the method parameter.
	 **/

	@DeleteMapping("/id/{id}")
	public void delete(@PathVariable int id) {
		paymentDetailsService.delete(id);
	}

	/**
	 * 1. Call the required service method
	 * 2. Add proper annotation for PUT Mapping and attach the request body to the
	 * method parameter.
	 **/

	@PutMapping("/update")
	public void update(@RequestBody PaymentDetails paymentDetails) {
		paymentDetailsService.update(paymentDetails);
	}
}