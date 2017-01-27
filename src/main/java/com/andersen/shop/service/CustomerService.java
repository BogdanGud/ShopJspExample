package com.andersen.shop.service;


import com.andersen.shop.dao.CustomerDao;
import com.andersen.shop.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Transactional
    public void create(Customer newCustomer) {
        customerDao.add(newCustomer);
    }

    @Transactional
    public Customer get(int id) {
        return customerDao.get(id);
    }

    @Transactional
    public void delete(int id) {
        customerDao.delete(id);
    }

    @Transactional
    public void update(Customer newCustomer) {
        customerDao.update(newCustomer);
    }

    @Transactional
    public List<Customer> getAll() {
        return customerDao.getAll();
    }
}
