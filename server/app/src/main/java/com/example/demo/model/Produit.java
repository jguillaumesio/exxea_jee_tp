package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "produit")
public class Produit implements Model{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private double price;

    public Produit(String name, double price){
        this.name = name;
        this.price = price;
    }

    public Produit() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
