package com.andersen.shop.model;

import java.util.Date;
import java.util.List;

public class BookingViewModel {
    String id;
    String customerName;
    String customerPhone;
    String customerAddress;
    List<String> productsNames;
    List<String> productsPrices;
    Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public List<String> getProductsNames() {
        return productsNames;
    }

    public void setProductsNames(List<String> productsNames) {
        this.productsNames = productsNames;
    }

    public List<String> getProductsPrices() {
        return productsPrices;
    }

    public void setProductsPrices(List<String> productsPrices) {
        this.productsPrices = productsPrices;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
