package com.andersen.shop.web;

import com.andersen.shop.model.Product;
import com.andersen.shop.model.ProductViewModel;
import com.andersen.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

@Controller
public class ProductsController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/shop/products")
    public ModelAndView listEmployee(ModelAndView model) {
        List<Product> products = productService.getAll();
        model.addObject("products", products);
        model.setViewName("products");
        return model;
    }

    @RequestMapping(value = "/shop/newProduct", method = RequestMethod.GET)
    public ModelAndView newProduct(ModelAndView model) {
        Product product = new Product();
        model.addObject("product", product);
        model.setViewName("productForm");
        return model;
    }

    @RequestMapping(value = "/shop/saveProduct", method = RequestMethod.POST)
    public ModelAndView saveProduct(@ModelAttribute ProductViewModel product) {
        if (product.getId() == null) {
            Product tempProduct = new Product();
            tempProduct.setName(product.getName());
            BigDecimal price = new BigDecimal(product.getPrice().toString());
            tempProduct.setPrice(price);
            productService.create(tempProduct);
        } else {
            Product tempProduct = new Product();
            tempProduct.setId(product.getId());
            tempProduct.setName(product.getName());
            BigDecimal price = new BigDecimal(product.getPrice().toString());
            tempProduct.setPrice(price);
            productService.update(tempProduct);
        }
        return new ModelAndView("redirect:/shop/products");
    }

    @RequestMapping(value = "/shop/deleteProduct", method = RequestMethod.GET)
    public ModelAndView deleteProduct(HttpServletRequest request) {
        int productId = Integer.parseInt(request.getParameter("id"));
        productService.delete(productId);
        return new ModelAndView("redirect:/shop/products");
    }

    @RequestMapping(value = "/shop/editProduct", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int productId = Integer.parseInt(request.getParameter("id"));
        Product product = productService.get(productId);
        ModelAndView model = new ModelAndView("productForm");
        model.addObject("product", product);
        return model;
    }
}
