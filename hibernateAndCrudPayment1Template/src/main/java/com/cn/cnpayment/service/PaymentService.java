package com.cn.cnpayment.service;


import com.cn.cnpayment.dal.PaymentDAL;
import com.cn.cnpayment.exception.ElementAlreadyExistException;
import com.cn.cnpayment.exception.InvalidInputException;
import com.cn.cnpayment.exception.NotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.cnpayment.entity.Payment;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    PaymentDAL paymentDAL;

    @Transactional
    public Payment getPaymentById(int id) {

        Payment payment=paymentDAL.getById(id);

        if(payment==null)
        {
            try {
                throw new NotFoundException("No payment found with id:  "+id);
            } catch (NotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return payment;
    }

    @Transactional
    public List<Payment> getPaymentByPaymentType(String paymentType) {

        ArrayList<String> validPayments = new ArrayList<String>() {{
            add("Cash");
            add("Cheques");
            add("DebitCard");
            add("CreditCard");
        }};
        Boolean isValidPayment=false;
        for(String validPayment : validPayments)
        {
            if(validPayment.equalsIgnoreCase(paymentType))
            {
                isValidPayment=true;
                break;
            }
        }
        if(isValidPayment==false)
        {
            try {
                throw new InvalidInputException("Payment type "+ paymentType + "is incorrect");
            } catch (InvalidInputException e) {
                throw new RuntimeException(e);
            }
        }
        List<Payment> payment = paymentDAL.getByPaymentType(paymentType);

        if(payment==null)
        {
            try {
                throw new NotFoundException("No payments found having paymentType: "+paymentType);
            } catch (NotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return payment;
    }

    @Transactional
    public List<Payment> getPaymentByDescriptionKeyword(String keyword) {

        List<Payment> payments = paymentDAL.getByPaymentDescription(keyword);
        if(payments==null)
        {
            try {
                throw new NotFoundException("No payments found, with description having keyword: "+keyword);
            } catch (NotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return payments;
    }

    @Transactional
    public List<Payment> getAllPayments() {

        List<Payment> payment = paymentDAL.getAllPayments();
        if(payment==null)
        {
            try {
                throw new NotFoundException("No payments found.");
            } catch (NotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return payment;
    }

    public void addPayment(Payment payment)  {
        if (paymentDAL.getById(payment.getId())!=null){
            try {
                throw new ElementAlreadyExistException("Payment already exists");
            } catch (ElementAlreadyExistException e) {
                throw new RuntimeException(e);
            }
        }
        paymentDAL.addPayment(payment);
    }
}

