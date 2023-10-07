package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import com.example.demo.model.Produit;
import com.example.demo.repository.ProduitRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProduitServlet extends HttpServlet {

    private ProduitRepository produitRepository;

    public void init() {
        this.produitRepository = new ProduitRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        List<Produit> produits = this.produitRepository.findAll();
        request.setAttribute("products", produits);
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if ("create".equals(action)) {
            this.create(request);
        } else if ("remove".equals(action)) {
            this.remove(request);
        } else if ("edit".equals(action)) {
            this.edit(request);
        }
        response.sendRedirect(request.getContextPath() + "/produit");
    }


    private void create(HttpServletRequest request) {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        Produit produit = new Produit();
        produit.setName(name);
        produit.setPrice(price);
        this.produitRepository.create(produit);
    }

    private void edit(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        Produit produit = new Produit();
        produit.setId(id);
        produit.setName(name);
        produit.setPrice(price);
        this.produitRepository.update(produit);
    }

    private void remove(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean result = this.produitRepository.delete(id);
        System.out.println(result);
    }
}
