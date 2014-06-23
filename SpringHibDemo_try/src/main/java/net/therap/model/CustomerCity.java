package net.therap.model;

import javax.persistence.*;

/**
 * @author sanjoy.saha
 * @date 6/17/14
 * @time 3:59 PM
 */
@Entity
@Table(name = "customer_city")
@AssociationOverrides({
        @AssociationOverride(
            name = "pk.customer",
            joinColumns = @JoinColumn(name = "CUST_ID")
        ),
        @AssociationOverride(
            name = "pk.city",
            joinColumns = @JoinColumn(name = "CITY_ID")
        )
})
public class CustomerCity {

    private CustomerCityId pk = new CustomerCityId();
    private String area;

    @EmbeddedId
    public CustomerCityId getPk() {
        return pk;
    }

    public void setPk(CustomerCityId pk) {
        this.pk = pk;
    }

    @Transient
    public Customer getCustomer() {
        return getPk().getCustomer();
    }

    public void setCustomer(Customer customer) {
        getPk().setCustomer(customer);
    }

    @Transient
    public City getCity() {
        return getPk().getCity();
    }

    public void setCity(City city) {
        getPk().setCity(city);
    }

    @Column(name = "AREA", nullable = false)
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "CustomerCity{" +
                "area='" + area + '\'' +
                '}';
    }
}
