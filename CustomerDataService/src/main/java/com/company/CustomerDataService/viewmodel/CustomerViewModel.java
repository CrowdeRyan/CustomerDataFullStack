package com.company.CustomerDataService.viewmodel;

import com.company.CustomerDataService.model.Customer;

import java.util.Objects;

public class CustomerViewModel {
    private int id;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String level;

//    public CustomerViewModel(int id, String firstName, String lastName, String street, String city, String state, String zip, String level) {
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
        return id == customer.getId() && Objects.equals(firstName, customer.getFirstName()) && Objects.equals(lastName, customer.getLastName()) && Objects.equals(street, customer.getStreet()) && Objects.equals(city, customer.getCity()) && Objects.equals(state, customer.getState()) && Objects.equals(zip, customer.getZip()) && Objects.equals(level, customer.getLevel());
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
