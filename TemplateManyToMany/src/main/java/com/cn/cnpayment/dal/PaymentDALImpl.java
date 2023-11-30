package com.cn.cnpayment.dal;


import com.cn.cnpayment.entity.PaymentReview;
import com.cn.cnpayment.service.PaymentService;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cn.cnpayment.entity.Payment;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentDALImpl implements PaymentDAL{

	@Autowired
	EntityManager entityManager;



	@Override
	public Payment getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Payment payment = session.get(Payment.class, id);
		return payment;
	}

	@Override
	public List<Payment> getAllPayments() {
		Session session = entityManager.unwrap(Session.class);
		List<Payment> allPayments= session.createQuery(
				"SELECT p FROM Payment p", Payment.class).getResultList();
		return allPayments;
	}

	@Override
	public List<Payment> getByPaymentType(String paymentType){
		List<Payment> allPayments=getAllPayments();
		List<Payment> paymentsByPaymentType = new ArrayList<>();
		for(Payment payment : allPayments)
		{
			if(payment.getPaymentType().equalsIgnoreCase(paymentType))
			{
				paymentsByPaymentType.add(payment);
			}
		}
		return paymentsByPaymentType;
	}

	@Override
	public List<Payment> getByPaymentDescription(String keyword){
		List<Payment> allPayments=getAllPayments();
		List<Payment> paymentsByDescription = new ArrayList<>();
		for(Payment payment : allPayments)
		{
			if(payment.getDescription().contains(keyword))
			{
				paymentsByDescription.add(payment);
			}
		}
		return paymentsByDescription;
	}

	public List<Payment> getAllPaymentsByCurrency(String currency){
		List<Payment> allPayments=getAllPayments();
		List<Payment> paymentsByCurrency = new ArrayList<>();
		for(Payment payment : allPayments)
		{
			if(payment.getPaymentDetails().getCurrency().equalsIgnoreCase(currency))
			{
				paymentsByCurrency.add(payment);
			}
		}
		return paymentsByCurrency;
	}
	public List<Payment> getAllPaymentsByQueryType(String queryType) {
		List<Payment> allPayments=getAllPayments();
		List<Payment> paymentsByReviews = new ArrayList<>();
		for(Payment payment : allPayments)
		{
			for(PaymentReview paymentReview : payment.getPaymentReviews())
			{
				if(paymentReview.getQueryType().equalsIgnoreCase(queryType))
				{
					paymentsByReviews.add(payment);
					break;
				}
			}
		}
		return paymentsByReviews;
	}

	public List<PaymentReview> getPaymentReviews(Integer paymentId){
		Payment payment = getById(paymentId);
		List<PaymentReview> paymentReviews=payment.getPaymentReviews();
		return paymentReviews;
	}

	@Override
	public Payment save(Payment payment) {
		Session session = entityManager.unwrap(Session.class);
		session.save(payment);
		return payment;
	}

	@Override
	public void delete(int paymentId) {
		Session session = entityManager.unwrap(Session.class);
		Payment payment = getById(paymentId);
		session.delete(payment);

	}

	@Override
	public void update(Payment updatePayment) {
		Session session = entityManager.unwrap(Session.class);
		Payment currentPayment = getById(updatePayment.getId());
		currentPayment.setDescription(updatePayment.getDescription());
		currentPayment.setPaymentType(updatePayment.getPaymentType());
		session.update(currentPayment);

	}

	@Override
	public void updateDescription(int paymentId,String description) {
		Session session = entityManager.unwrap(Session.class);
		Payment currentPayment = getById(paymentId);
		currentPayment.setDescription(description);
		session.update(currentPayment);
	}

}
