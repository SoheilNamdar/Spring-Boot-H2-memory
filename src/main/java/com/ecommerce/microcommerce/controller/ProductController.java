package com.ecommerce.microcommerce.controller;

import com.ecommerce.microcommerce.dao.Productdao;
import com.ecommerce.microcommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private Productdao productdao;

    //Produits
    @GetMapping(value = "Produits")
    public List<Product> listProduits() {
        return productdao.findAll();
    }

    //Produits/{id}
    @GetMapping(value = "Produits/{id}")
    public Product afficherUnProduit(@PathVariable int id){
       return new Product(id, new String("aaspirateur"), 100);

    }
}
