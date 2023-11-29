package com.cn.cnpayment.dal;

import com.cn.cnpayment.entity.Payment;

import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class PaymentDALImpl implements PaymentDAL {


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
        List<Payment>result = session.createQuery("select p from Payment p",Payment.class).getResultList();
        return result;
    }

    @Override
    public List<Payment> getByPaymentType(String paymentType) {
        List<Payment> allPayments = getAllPayments();
        List<Payment> paymentsWithType = new ArrayList<>();
        for(Payment p : allPayments){
            if(p.getPaymentType().equalsIgnoreCase(paymentType)){
                paymentsWithType.add(p);
            }
        }
        return paymentsWithType;
    }

    @Override
    public List<Payment> getByPaymentDescription(String keyword) {
        List<Payment> allPayments = getAllPayments();
        List<Payment> paymentsWithDesc = new ArrayList<>();
        for(Payment p : allPayments){
            if(p.getDescription().equalsIgnoreCase(keyword)){
                paymentsWithDesc.add(p);
            }
        }
        return paymentsWithDesc;
    }

    @Override
    public void addPayment(Payment payment) {
        Session session = entityManager.unwrap(Session.class);
        session.save(payment);
    }
}
