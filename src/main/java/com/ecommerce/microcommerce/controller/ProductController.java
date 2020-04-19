package com.ecommerce.microcommerce.controller;

import com.ecommerce.microcommerce.dao.Productdao;
import com.ecommerce.microcommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

        return productdao.findById(id);
    }

    @PostMapping(value="/Produits")
    public void ajouterProduit(@RequestBody Product product) {
        Product product1 = productdao.save(product);
    }

    @GetMapping(value = "test/Produits/{prixLimit}")
    public List<Product> testDeRequetes(@PathVariable int prixLimit) {
        return productdao.findByPrixGreaterThan(prixLimit);
    }


    /*Produits
    @PostMapping(value="/Produits")
    public ResponseEntity<Void> ajouterProduit(@RequestBody Product product){
        Product product1 = productdao.save(product);

        //si le produit n'a pas été ajouté, builder et envoie la réponse noContent
        if(product == null) {
            return ResponseEntity.noContent().build();
        }

        //par contre si le produit a été ajouté, il faut récuperer l'URI
        //et donc construire son uri pour cela :
        //ServletUriComponentsBuilder permet de creer une lien (create a links based on) une requette
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath() //from current requette
                .path("/{id}") //a cet uri ajoute un id, id de produit qu'on aajouté
                .buildAndExpand(product1.getId()) //remplacer cet id par son contenu par la method buildAndExpand
                .toUri(); //Tr en uri

        //Maintenant qu'on a le uri on va le retourner
        return ResponseEntity.created(location).build(); //build pour construire cette reponse

    }*/
}
