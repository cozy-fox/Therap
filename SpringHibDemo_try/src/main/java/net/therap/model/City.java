package net.therap.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sanjoy.saha
 * @date 6/17/14
 * @time 3:36 PM
 */
@Entity
@Table(name = "city", uniqueConstraints = {
        @UniqueConstraint(columnNames = "CITY_ID")
})
public class City {

    private int id;
    private String name;
    private Set<CustomerCity> customerCities = new HashSet<CustomerCity>(0);

    @Id
    @GeneratedValue
    @Column(name = "CITY_ID", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "CITY_NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.city")
    public Set<CustomerCity> getCustomerCities() {
        return customerCities;
    }

    public void setCustomerCities(Set<CustomerCity> customerCities) {
        this.customerCities = customerCities;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
