package com.cn.cnpayment.entity;

import jakarta.persistence.*;

import java.util.List;

/**
 * Modify the code to add one-to-one mapping between Payment and Payment Details.
 * Use Proper Annotations.
 * Add required getters and setters.
 */

@Entity
@Table(name = "Orders")
public class Orders {

    //add proper annotations for mapping a property as id, column etc.

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;
    @Column
    private String category;

    @Column
    private Integer quantity;

    @Column
    private Integer amount;



    //add proper annotation for establishing many-to-many relationship with Payment.
    //add required getter and setter for Payment.

    @ManyToMany(mappedBy = "orders", fetch = FetchType.EAGER)
    List<Payment> payments;


    public Orders() {
    }

    public Orders(int id, String name, String category, Integer quantity, Integer amount) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.amount = amount;
    }

    public Orders(String name, String category, Integer quantity, Integer amount) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.amount = amount;
    }

    public Orders(int id, String name, String category, Integer quantity, Integer amount, List<Payment> payments) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.amount = amount;
        this.payments = payments;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }


}

