package com.javastudy.deliveryservice.mvc.model;

/**
 * Created by Maxim Sambulat
 */
public class ProfileInfo {
    String login;
    String address;
    String email;
    String phone;

    public ProfileInfo() {
    }

    public ProfileInfo(String login, String address, String email, String phone) {
        this.login = login;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}
