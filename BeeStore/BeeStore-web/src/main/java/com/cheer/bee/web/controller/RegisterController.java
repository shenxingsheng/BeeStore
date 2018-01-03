package com.cheer.bee.web.controller;

import javax.validation.Valid;

import org.aspectj.apache.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cheer.bee.domain.Customer;
import com.cheer.bee.service.CustomerService;

@Controller
public class RegisterController
{
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerCustomer(Model model)
    {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "registerCustomer";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, Model model)
    {
        if (result.hasErrors())
        {
            return "registerCustomer";
        }

        if (this.customerService.checkEmailIsExists(customer.getEmail()))
        {
            model.addAttribute("emailMsg", "Email already exists");

            return "registerCustomer";
        }

        if (this.customerService.checkUsernameIsExists(customer.getAccount().getUsername()))
        {
            model.addAttribute("usernameMsg", "Username already exists");

            return "registerCustomer";
        }

        customer.getAccount().setEnabled(true);

        this.customerService.save(customer);

        return "registerCustomerSuccess";

    }
}
