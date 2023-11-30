package com.cn.cnpayment.service;

import com.cn.cnpayment.dal.OrderDal;
import com.cn.cnpayment.entity.Orders;
import com.cn.cnpayment.exception.NotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
    Complete the OrderService class as mentioned below:

    a. Autowire OrderDal

    b. Complete the following methods:

      1. getOrderById(int id): This method fetches an Order for a specific Id.

      2. getAllOrders(): This method fetches the list of Orders.

      3. saveOrder(Orders newOrder): This method saves an Order.

      4. delete(int id): This method deletes an Order for a specific Id.
**/

@Service
public class OrderService {

    // Autowire the OrderDal object.
    @Autowired
    OrderDal orderDal;
    /**
     1. Complete the method body for getOrderById() by adding proper arguments.
     2. add proper annotation for registering this method as a Transaction
     **/
   @Transactional
    public Orders getOrderById(int id) {
        Orders order = orderDal.getById(id);
        if(order == null){
            throw new NotFoundException("Not found");
        }
    return order;
    }


    /**
     1. Complete the method body for getAllOrders().
     2. add proper annotation for registering this method as a Transaction
     **/
    @Transactional
    public List<Orders> getAllOrders() {
        return orderDal.getAllOrders();
    }


    /**
     1. Complete the method body for saveOrder() method by adding proper arguments.
     2. add proper annotation for registering this method as a Transaction
     **/
    @Transactional
    public void saveOrder(Orders orders) {
        orderDal.save(orders);
    }


    /**
     1. Complete the method body for delete() method by adding proper arguments.
     2. add proper annotation for registering this method as a Transaction
     **/
    @Transactional
    public void delete(int id) {
//        if(getOrderById(id) ==  null) {
//            throw new NotFoundException("Not fnd");
//        }
        orderDal.delete(id);
    }


}
