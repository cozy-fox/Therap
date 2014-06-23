package net.therap.dao.impl;

import net.therap.dao.CustomerDao;
import net.therap.model.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author sanjoy.saha
 * @date 6/12/14
 * @time 3:33 PM
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {

//    @Autowired
//    @Qualifier("sessionFactory")
//    private SessionFactory sessionFactory;
    @PersistenceContext
    private EntityManager entityManager;

    /*private Session getSession() {
        return sessionFactory.getCurrentSession();
    }*/
    @Override
    public void insert(Customer customer) {
    }

    @Override
    public Customer findByCustomerId(int customerId) {
        System.out.println("DEBUG: " + customerId);
        return entityManager.find(Customer.class, customerId);
    }

    @Override
    public List<Customer> getAllCustomersList() {
        return null;
    }
}
