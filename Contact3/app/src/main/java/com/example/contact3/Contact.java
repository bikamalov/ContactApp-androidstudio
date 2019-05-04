package com.example.contact3;

public class Contact {
    private String name;
    private String phone;
    private int Photo;

    public Contact(){

    }

    public Contact(String name, String phone, int photo) {
        this.name = name;
        this.phone = phone;
        Photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPhoto() {
        return Photo;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }
}
