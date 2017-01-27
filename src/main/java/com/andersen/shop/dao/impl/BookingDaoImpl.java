package com.andersen.shop.dao.impl;

import com.andersen.shop.dao.BookingDao;
import com.andersen.shop.model.Booking;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BookingDaoImpl implements BookingDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void add(Booking newBooking) {
        sessionFactory.getCurrentSession().saveOrUpdate(newBooking);
    }

    public Booking get(int id) {
        return (Booking) sessionFactory.getCurrentSession().get(
                Booking.class, id);
    }

    public void delete(int id) {
        Booking booking = (Booking) sessionFactory.getCurrentSession().load(
                Booking.class, id);
        if (null != booking) {
            this.sessionFactory.getCurrentSession().delete(booking);
        }
    }

    public void update(Booking booking) {
        sessionFactory.getCurrentSession().update(booking);
    }

    public List<Booking> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Booking")
                .list();
    }

}
