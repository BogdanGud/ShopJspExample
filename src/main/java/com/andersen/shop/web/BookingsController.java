package com.andersen.shop.web;


import com.andersen.shop.model.*;
import com.andersen.shop.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class BookingsController {

    @Autowired
    private BookingService bookingService;
    private int editBookingId;

    @RequestMapping(value = "/shop/orders", method = RequestMethod.GET)
    public String getOrders(Map<String, Object> model) {
        List<Booking> bookings = bookingService.getAll();
        List<BookingViewModel> bookingViewModels = new ArrayList<>();
        for (Booking booking : bookings) {
            BookingViewModel bookingViewModel = new BookingViewModel();
            Customer customer = booking.getCustomer();
            Set<Product> products = booking.getProducts();
            List<String> productsNames = new ArrayList<>();
            List<String> productsPrices = new ArrayList<>();

            bookingViewModel.setId(booking.getId().toString());
            bookingViewModel.setCustomerName(customer.getName());
            bookingViewModel.setCustomerPhone(customer.getPhone());
            bookingViewModel.setCustomerAddress(customer.getAddress());
            bookingViewModel.setDate(booking.getDate());

            for (Product product : products) {
                String tempName = product.getName().toString().replaceAll("[,]", "");
                System.out.println(" tempName" + tempName);
                productsNames.add(tempName);
                productsPrices.add(product.getPrice().toString());
            }
            bookingViewModel.setProductsNames(productsNames);
            bookingViewModel.setProductsPrices(productsPrices);

            bookingViewModels.add(bookingViewModel);
        }

        model.put("bookings", bookingViewModels);
        return "orders";
    }

    @RequestMapping(value = "/shop/newBooking", method = RequestMethod.GET)
    public ModelAndView newBooking(ModelAndView model) {
        BookingServiceObject bookingServiceObject = new BookingServiceObject();
        model.addObject("param", bookingServiceObject);
        model.setViewName("orderSaveForm");
        return model;
    }

    @RequestMapping(value = "/shop/saveBooking", method = RequestMethod.POST)
    public ModelAndView saveBooking(@ModelAttribute BookingServiceObject bookingServiceObject) {
        int customerId = bookingServiceObject.getCustomerId();
        int productId = bookingServiceObject.getProductId();
        Date date = bookingServiceObject.getDate();
        bookingService.createNewOrder(customerId, date, productId);
        return new ModelAndView("redirect:/shop/orders");
    }

    @RequestMapping(value = "/shop/deleteBooking", method = RequestMethod.GET)
    public ModelAndView deleteBooking(HttpServletRequest request) {
        int bookingId = Integer.parseInt(request.getParameter("id"));
        bookingService.delete(bookingId);
        return new ModelAndView("redirect:/shop/orders");
    }

    @RequestMapping(value = "/shop/editBooking", method = RequestMethod.GET)
    public ModelAndView editBooking(HttpServletRequest request) {
        editBookingId = Integer.parseInt(request.getParameter("id"));
        BookingServiceObject bookingServiceObject = new BookingServiceObject();
        ModelAndView model = new ModelAndView("orderEditForm");
        model.addObject("param", bookingServiceObject);
        return model;
    }

    @RequestMapping(value = "/shop/saveEditProduct", method = RequestMethod.POST)
    public ModelAndView saveEditProduct(BookingServiceObject bookingServiceObject) {
        int productId = bookingServiceObject.getProductId();
        int customerId = bookingServiceObject.getCustomerId();
        Date date = bookingServiceObject.getDate();
        bookingService.update(editBookingId, customerId, productId, date);
        return new ModelAndView("redirect:/shop/orders");
    }
}
