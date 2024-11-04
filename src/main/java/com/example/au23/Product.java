package com.example.au23;

import java.time.LocalDate;

public class Product {
    private String name;
    private String id;
    private String material;
    private int quantity;
    private LocalDate deliveryDate;

    public Product(String id, String name, String material, int quantity, LocalDate deliveryDate) {
        this.id = id;
        this.name = name;
        this.material = material;
        this.quantity = quantity;
        this.deliveryDate = deliveryDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", material='" + material + '\'' +
                ", quantity=" + quantity +
                ", deliveryDate=" + deliveryDate +
                '}';
    }



}
