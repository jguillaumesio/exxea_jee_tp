package com.example.demo.repository;

import com.example.demo.model.Produit;

import java.util.List;

public class TestProduitRepository {
    public static void main(String[] args) {
        ProduitRepository repository = new ProduitRepository();

        repository.create(new Produit("REF0", 3));
        repository.create(new Produit("REF1", 3));
        repository.create(new Produit("REF2", 3));

        System.out.println("------------------------------");
        List<Produit> produits = repository.findAll();
        for(Produit p : produits) {
            System.out.println(p.getName());
        }
        try {
            Produit p = repository.findById(1);
            p.setPrice(9000);
            repository.update(p);
            Produit p2 = repository.findById(1);
            System.out.println(p2.getPrice());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        repository.delete(1);

    }
}