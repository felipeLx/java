package com.partyFind.app.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import java.util.Objects;

public class Customer {

    @Id
    public String id;

    public String businessName;
    public String neighborhood;
    public String city;
    public String state;
    public String businessType;
    public String email;

    public Customer() {
    }

    public Customer(String businessName, String neighborhood, String city, String state, String businessType, String email) {
        this.businessName = businessName;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.businessType = businessType;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
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

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", businessName='" + businessName + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", businessType='" + businessType + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
