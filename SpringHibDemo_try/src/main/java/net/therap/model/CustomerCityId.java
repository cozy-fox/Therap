package net.therap.model;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * @author sanjoy.saha
 * @date 6/17/14
 * @time 3:40 PM
 */
@Embeddable
public class CustomerCityId implements Serializable{
    private Customer customer;
    private City city;

    @ManyToOne
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
