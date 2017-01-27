package com.andersen.shop.dao;

import com.andersen.shop.model.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> getAll();

    void add(Customer newCustomer);

    Customer get(int id);

    void delete(int id);

    void update(Customer customer);
}
