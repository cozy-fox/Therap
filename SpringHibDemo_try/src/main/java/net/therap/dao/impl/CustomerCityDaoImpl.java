package net.therap.dao.impl;

import net.therap.dao.CustomerCityDao;
import net.therap.model.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author sanjoy.saha
 * @date 6/18/14
 * @time 12:00 PM
 */
@Repository
public class CustomerCityDaoImpl implements CustomerCityDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> getAllCustomerCityList() {
        Query query = entityManager.createQuery("FROM Customer");
        return query.getResultList();
    }
}
