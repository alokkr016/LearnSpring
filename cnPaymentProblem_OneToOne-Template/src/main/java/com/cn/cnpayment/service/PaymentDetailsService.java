package com.cn.cnpayment.service;


import com.cn.cnpayment.exception.NotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.cnpayment.dal.PaymentDetailsDAL;
import com.cn.cnpayment.entity.PaymentDetails;
import java.util.List;

/**

 # Complete the PaymentDetailsService class as mentioned below:

   a. Autowire PaymentDetailsDAL

   b. Complete the following methods:
   
	 1. getPaymentDetailsById(): This method fetches PaymentDetails for a specific id.

	 2. getAllPaymentDetails(): This method fetches a list of PaymentDetails from the database.

	 3. savePaymentDetails(): This method saves the PaymentDetails entity into the database.

	 4. delete(int id): This method deletes a paymentDetails object from the id.

	 5. update(PaymentDetails paymentDetails): This method updates paymentDetails object in the database.

	 6. getByCurrency(): This method fetches the list of paymentDetails for a specific currency.
 
 **/

@Service
public class PaymentDetailsService {

	// autowire the PaymentDetailsDAL object
	@Autowired
	PaymentDetailsDAL paymentDetailsDAL;

	/**
	 * 1. Complete the method body for get paymentDetails by id.
	 * 2. add proper annotation for registering this method as a Transaction
	 **/
	@Transactional
	public PaymentDetails getPaymentDetailsById(int id) {
		return paymentDetailsDAL.getById(id);
	}

	/**
	 * 1. Complete the method body for get all paymentDetails.
	 * 2. add proper annotation for registering this method as a Transaction
	 **/
	@Transactional
	public List<PaymentDetails> getAllPaymentDetails() {
		return paymentDetailsDAL.getAllPaymentDetails();
	}

	/**
	 * 1. Complete the method body for saving paymentDetail into the database.
	 * 2. Also add PaymentDetails as a argument for accepting data. 
	 * 3. add proper annotation for registering this method as a Transaction
	 **/
	@Transactional
	public void savePaymentDetails(PaymentDetails details) {
		paymentDetailsDAL.save(details);
	}

	/**
	 * 1. Complete the method body for deleting paymentDetails from the database for a specific id.
	 * 2. add proper annotation for registering this method as a Transaction
	 **/
	@Transactional
	public void delete(int id) {
		paymentDetailsDAL.delete(id);
	}

	/**
	 * 1. Complete the method body for updating paymentDetails entity in the database.
	 * 2. Also add PaymentDetails as a argument for accepting updated data. 
	 * 3. add proper annotation for registering this method as a Transaction.
	 **/
	@Transactional
	public void update(PaymentDetails details) {
		if(paymentDetailsDAL.getById(details.getId()) == null){
			throw new NotFoundException("No payments found.");
		}
		paymentDetailsDAL.update(details);
	}

	/**
	 * 1. Complete the method body for getting all paymentDetails by currency name.
	 * 2. add proper annotation for registering this method as a Transaction
	 **/
	@Transactional
	public List<PaymentDetails> getByCurrency(String currency) {
		return paymentDetailsDAL.getByCurrency(currency);
	}
}