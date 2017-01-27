package com.andersen.shop.service;


import com.andersen.shop.dao.ProductDao;
import com.andersen.shop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    @Transactional
    public void create(Product newProduct) {
        productDao.add(newProduct);
    }

    @Transactional
    public Product get(int id) {
        return productDao.get(id);
    }

    @Transactional
    public void delete(int id) {
        productDao.delete(id);
    }

    @Transactional
    public void update(Product newProduct) {
        productDao.update(newProduct);
    }

    @Transactional
    public List<Product> getAll() {
        return productDao.getAll();
    }

}
