package ru.netology.productmanager;

import java.util.Objects;

public class Smartphone extends Product {
    private String manufacturer;

    public String getManufacturer() {

        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {

        this.manufacturer = manufacturer;
    }

    public Smartphone(int id, String name, int price, String manufacturer) {
        super(id, name, price);

        this.manufacturer = manufacturer;
    }
}