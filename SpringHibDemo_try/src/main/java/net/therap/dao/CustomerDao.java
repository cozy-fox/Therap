package net.therap.dao;

import net.therap.model.Customer;

import java.util.List;

/**
 * @author sanjoy.saha
 * @date 6/9/14
 * @time 11:50 AM
 */
public interface CustomerDao {
    public void insert(Customer customer);
    public Customer findByCustomerId(int customerId);
    public List<Customer> getAllCustomersList();
}
