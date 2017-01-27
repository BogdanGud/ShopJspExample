package com.andersen.shop.dao.impl;


import com.andersen.shop.dao.ProductDao;
import com.andersen.shop.model.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void add(Product newProduct) {
        sessionFactory.getCurrentSession().saveOrUpdate(newProduct);
    }

    public Product get(int id) {
        return (Product) sessionFactory.getCurrentSession().get(
                Product.class, id);
    }

    public void delete(int id) {
        Product product = (Product) sessionFactory.getCurrentSession().load(
                Product.class, id);
        if (null != product) {
            this.sessionFactory.getCurrentSession().delete(product);
        }
    }

    public void update(Product product) {
        sessionFactory.getCurrentSession().update(product);
    }

    public List<Product> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Product")
                .list();
    }

}
