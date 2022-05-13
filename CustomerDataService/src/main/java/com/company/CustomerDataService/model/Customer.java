package com.company.CustomerDataService.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "customer")
public class Customer implements Serializable {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @NotEmpty(message= "You must use a real First Name... dan!")
    private String firstName;
//    @NotEmpty(message= "You must use a real Last Name... dan!")
    private String lastName;
    private String street;
    private String city;
    private String state;
//    @NotEmpty(message= "You must use a real Zip Code... dan!")
//    @Size(min=5,max=5, message= "Use a real Zip Code.")
    private String zip;
    private String level;

//    public Customer() {
//    }
//
//    public Customer(int id, String firstName, String lastName, String street, String city, String state, String zip, String level) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.street = street;
//        this.city = city;
//        this.state = state;
//        this.zip = zip;
//        this.level = level;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(street, customer.street) && Objects.equals(city, customer.city) && Objects.equals(state, customer.state) && Objects.equals(zip, customer.zip) && Objects.equals(level, customer.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, street, city, state, zip, level);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
