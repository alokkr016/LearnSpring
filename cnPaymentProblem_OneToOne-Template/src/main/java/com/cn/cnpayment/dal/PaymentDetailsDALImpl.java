package com.cn.cnpayment.dal;

import com.cn.cnpayment.entity.PaymentDetails;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/** 
    # Complete the PaymentDetailsDALImpl class as mentioned below:

		a. Autowire EntityManager.

		b. Override the following methods:
		
  		  1. getById(int id): This method fetches PaymentDetails for a specific id from the database.

  	 	  2. getAllPaymentDetails(): This method fetches the list of PaymentDetails from the database.

  		  3. save(PaymentDetails paymentDetails): This method saves the PaymentDetails entity into the database.

  		  4. delete(int id): This method deletes the PaymentDetails entity for a specific id.

		  5. update(PaymentDetails paymentDetails): This method updates paymentDetails.

		  6. getByCurrency(String currency): This method fetches the list of PaymentDetails from the database for
		     a specific currency.
**/

@Repository
public class PaymentDetailsDALImpl implements PaymentDetailsDAL {


	@Autowired
	EntityManager entityManager;


	@Override
	public PaymentDetails getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		PaymentDetails paymentDetails = session.get(PaymentDetails.class,id);
		return paymentDetails;
	}

	@Override
	public void save(PaymentDetails paymentDetails) {
		Session session = entityManager.unwrap(Session.class);
		session.save(paymentDetails);
	}

	@Override
	public void delete(int id) {
		Session session = entityManager.unwrap(Session.class);
		PaymentDetails paymentDetails = getById(id);
		session.delete(paymentDetails);
	}

	@Override
	public List<PaymentDetails> getAllPaymentDetails() {
		Session session = entityManager.unwrap(Session.class);
		List<PaymentDetails> paymentDetailsList = session.createQuery("select p from PaymentDetails p",PaymentDetails.class).getResultList();
		return paymentDetailsList;
	}

	@Override
	public void update(PaymentDetails paymentDetails) {
		Session session = entityManager.unwrap(Session.class);

		PaymentDetails oldPaymentDetails = getById(paymentDetails.getId());
		oldPaymentDetails.setPayment(paymentDetails.getPayment());
		oldPaymentDetails.setAmount(paymentDetails.getAmount());
		oldPaymentDetails.setCurrency(paymentDetails.getCurrency());
		oldPaymentDetails.setDebitAccount(paymentDetails.getDebitAccount());
		oldPaymentDetails.setCreditAccount(paymentDetails.getCreditAccount());
		session.update(oldPaymentDetails);

	}

	@Override
	public List<PaymentDetails> getByCurrency(String currency) {
		List<PaymentDetails> allPaymentDetails = getAllPaymentDetails();
		List<PaymentDetails> currencyPaymentDetails = new ArrayList<>();

		for (PaymentDetails details : allPaymentDetails){
			if (details.getCurrency().equalsIgnoreCase(currency)){
				currencyPaymentDetails.add(details);
			}
		}
		return currencyPaymentDetails;
	}

	//Autowire the EntityManager object


}
