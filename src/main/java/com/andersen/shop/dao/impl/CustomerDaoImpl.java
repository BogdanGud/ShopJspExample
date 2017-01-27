package com.andersen.shop.dao.impl;


import com.andersen.shop.dao.CustomerDao;
import com.andersen.shop.model.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void add(Customer newCustomer) {
        sessionFactory.getCurrentSession().saveOrUpdate(newCustomer);
    }

    public Customer get(int id) {
        return (Customer) sessionFactory.getCurrentSession().get(
                Customer.class, id);
    }

    public void delete(int id) {
        Customer customer = (Customer) sessionFactory.getCurrentSession().load(
                Customer.class, id);
        if (null != customer) {
            this.sessionFactory.getCurrentSession().delete(customer);
        }
    }

    public void update(Customer customer) {
        sessionFactory.getCurrentSession().update(customer);
    }

    public List<Customer> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Customer")
                .list();
    }

}
