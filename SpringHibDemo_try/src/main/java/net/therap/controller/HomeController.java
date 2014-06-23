package net.therap.controller;

import net.therap.model.Customer;
import net.therap.model.CustomerCity;
import net.therap.service.CustomerCityService;
import net.therap.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author sanjoy.saha
 * @date 6/12/14
 * @time 4:17 PM
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerCityService customerCityService;

    @RequestMapping(method = RequestMethod.GET)
    public String showAllCustomerCityList(ModelMap model) {
        List<Customer> customerCities = customerCityService.getAllCustomerCityList();
        Iterator<Customer> customerIterator = customerCities.iterator();

        while(customerIterator.hasNext()) {
            Customer tmpCustomer = customerIterator.next();
            System.out.println("customerIterator.next() = " + tmpCustomer);

            Set<CustomerCity> tmpCustomerCitySet = tmpCustomer.getCustomerCities();
            Iterator<CustomerCity> tmpCustomerCityIterator = tmpCustomerCitySet.iterator();
            while (tmpCustomerCityIterator.hasNext()) {
                System.out.println(tmpCustomerCityIterator.next());
            }
        }

        model.addAttribute("customerCities", customerCities);
        return "customers";
    }
    /*public String showOneCustomers(ModelMap model) {

        Customer customer = customerService.findByCustomerId(5);
        System.out.println("DEBUG from MAIN: "+ customer.getName());
        model.addAttribute("customer", customerService.findByCustomerId(5));
        return "customers";
    }*/
    /*public String showAllCustomers(ModelMap model) {

        model.addAttribute("message", "Hello world!");
        return "hello";
    }*/
}
