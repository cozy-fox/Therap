package net.therap.service;

import net.therap.model.Customer;

import java.util.List;

/**
 * @author sanjoy.saha
 * @date 6/12/14
 * @time 2:55 PM
 */
public interface CustomerService {
    public void insert(Customer customer);
    public Customer findByCustomerId(int customerId);
    public List<Customer> getAllCustomersList();
}
