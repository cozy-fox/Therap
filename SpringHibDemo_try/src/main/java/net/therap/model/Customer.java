package net.therap.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sanjoy.saha
 * @date 6/9/14
 * @time 11:48 AM
 */

@Entity
@Table(name = "customer", uniqueConstraints = {
        @UniqueConstraint(columnNames = "CUST_ID")
})
public class Customer {

    private int id;
    private int age;
    private String name;
    private Set<CustomerCity> customerCities = new HashSet<CustomerCity>(0);


    @Id
    @GeneratedValue
    @Column(name = "CUST_ID", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "AGE")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.customer", cascade = CascadeType.ALL)
    public Set<CustomerCity> getCustomerCities() {
        return customerCities;
    }

    public void setCustomerCities(Set<CustomerCity> customerCities) {
        this.customerCities = customerCities;
    }

    @Override
    public String toString(){
        return "Customer [ id: "+this.id+" name: "+this.name+" age: "+this.age+" ]";
    }
}
