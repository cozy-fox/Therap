package net.therap.service.impl;

import net.therap.dao.CustomerCityDao;
import net.therap.model.Customer;
import net.therap.service.CustomerCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sanjoy.saha
 * @date 6/18/14
 * @time 11:59 AM
 */
@Service
@Transactional(value = "jpaTransactionManager")
public class CustomerCityServiceImpl implements CustomerCityService {

    @Autowired
    private CustomerCityDao customerCityDao;

    @Override
    public List<Customer> getAllCustomerCityList() {
        return customerCityDao.getAllCustomerCityList();
    }
}
