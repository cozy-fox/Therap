package net.therap.service.impl;

import net.therap.dao.CustomerDao;
import net.therap.model.Customer;
import net.therap.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sanjoy.saha
 * @date 6/12/14
 * @time 2:56 PM
 */
@Service
@Transactional(value = "jpaTransactionManager")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public void insert(Customer customer) {
        customerDao.insert(customer);
    }

    @Override
    public Customer findByCustomerId(int customerId) {
        return customerDao.findByCustomerId(customerId);
    }

    @Override
    public List<Customer> getAllCustomersList() {
        return customerDao.getAllCustomersList();
    }
}
