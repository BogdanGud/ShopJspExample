package com.andersen.shop.dao;

import com.andersen.shop.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getAll();

    void add(Product newProduct);

    Product get(int id);

    void delete(int id);

    void update(Product product);
}
