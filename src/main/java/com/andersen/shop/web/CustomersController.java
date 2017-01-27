package com.andersen.shop.web;

import com.andersen.shop.model.Customer;
import com.andersen.shop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CustomersController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/shop/customers")
    public ModelAndView listEmployee(ModelAndView model) {
        List<Customer> customers = customerService.getAll();
        model.addObject("customers", customers);
        model.setViewName("customers");
        return model;
    }

    @RequestMapping(value = "/shop/newCustomer", method = RequestMethod.GET)
    public ModelAndView newCustomer(ModelAndView model) {
        Customer customer = new Customer();
        model.addObject("customer", customer);
        model.setViewName("customerForm");
        return model;
    }

    @RequestMapping(value = "/shop/saveCustomer", method = RequestMethod.POST)
    public ModelAndView saveCustomer(@ModelAttribute Customer customer) {
        if (customer.getId() == null) {
            customerService.create(customer);
        } else {
            customerService.update(customer);
        }
        return new ModelAndView("redirect:/shop/customers");
    }

    @RequestMapping(value = "/shop/deleteCustomer", method = RequestMethod.GET)
    public ModelAndView deleteCustomer(HttpServletRequest request) {
        int customerId = Integer.parseInt(request.getParameter("id"));
        customerService.delete(customerId);
        return new ModelAndView("redirect:/shop/customers");
    }

    @RequestMapping(value = "/shop/editCustomer", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int customerId = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.get(customerId);
        ModelAndView model = new ModelAndView("customerForm");
        model.addObject("customer", customer);
        return model;
    }
}
