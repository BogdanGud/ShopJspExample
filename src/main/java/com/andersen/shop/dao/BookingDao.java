package com.andersen.shop.dao;

import com.andersen.shop.model.Booking;

import java.util.List;

public interface BookingDao {
    List<Booking> getAll();

    void add(Booking newBooking);

    Booking get(int id);

    void delete(int id);

    void update(Booking booking);
}
