package com.hw.hw_13;

import java.util.List;

public class User {
    private long id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
    private Address address;
    private Company company;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public User(String name, String username, String email, Address address,String phone, String website,  Company company) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.address = address;
        this.company = company;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id: " + id + "\n");
        stringBuilder.append("name: " + name + "\n");
        stringBuilder.append("username: " + username + "\n");
        stringBuilder.append("email: " + email + "\n");
        stringBuilder.append("street: " + address.getStreet() + "\n");
        stringBuilder.append("suite: " + address.getSuite() + "\n");
        stringBuilder.append("city: " + address.getCity() + "\n");
        stringBuilder.append("zipcode: " + address.getZipcode() + "\n");
        stringBuilder.append("geo lat: " + address.getGeo().getLat() + "\n");
        stringBuilder.append("geo lng: " + address.getGeo().getLng() + "\n");
        stringBuilder.append("phone: " + phone + "\n");
        stringBuilder.append("website: " + website + "\n");
        stringBuilder.append("company name: " + company.getName() + "\n");
        stringBuilder.append("company catchPhrase: " + company.getCatchPhrase() + "\n");
        stringBuilder.append("company bs: " + company.getBs() + "\n");
        return stringBuilder.toString();
    }
}
