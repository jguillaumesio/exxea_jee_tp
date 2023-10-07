package com.example.demo.repository;

import com.example.demo.model.Produit;

import java.sql.ResultSet;

public class ProduitRepository extends AbstractRepository<Produit>{

    public ProduitRepository(){
        super(Produit.class);
    }

    public Produit mapResultSetToEntity(ResultSet resultSet) {
        Produit entity = null;
        try {
            entity = associatedClass.getDeclaredConstructor().newInstance();
            if (entity instanceof Produit) {
                Produit produit = (Produit) entity;
                produit.setId(resultSet.getInt("id"));
                produit.setName(resultSet.getString("name"));
                produit.setPrice(resultSet.getDouble("price"));
            }
            // Add more if-else blocks for other entity types as needed

        } catch (Exception e) {
            e.printStackTrace();
        }

        return entity;
    }
}
