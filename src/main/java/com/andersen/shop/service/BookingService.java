package com.andersen.shop.service;

import com.andersen.shop.dao.BookingDao;
import com.andersen.shop.dao.CustomerDao;
import com.andersen.shop.dao.ProductDao;
import com.andersen.shop.model.Booking;
import com.andersen.shop.model.Customer;
import com.andersen.shop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingDao bookingDao;
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private ProductDao productDao;

    @Transactional
    public void createNewOrder(int customerId, Date date, int productId) {
        Customer tempCustomer = customerDao.get(customerId);
        Product tempProduct = productDao.get(productId);
        Booking tempBooking = new Booking(tempCustomer, date);
        tempBooking.addProduct(tempProduct);
        bookingDao.add(tempBooking);
    }

    @Transactional
    public Booking get(int id) {
        return bookingDao.get(id);
    }

    @Transactional
    public void delete(int id) {
        bookingDao.delete(id);
    }

    @Transactional
    public void update(int bookingId, int customerId, int productId, Date date) {
        Customer tempCustomer = customerDao.get(customerId);
        Booking newBooking = new Booking(tempCustomer, date);
        Product tempProduct = productDao.get(productId);
        newBooking.addProduct(tempProduct);
        newBooking.setId(bookingId);
        bookingDao.update(newBooking);
    }

    @Transactional
    public List<Booking> getAll() {
        return bookingDao.getAll();
    }


}
