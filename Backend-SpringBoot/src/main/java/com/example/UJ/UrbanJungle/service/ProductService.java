package com.example.UJ.UrbanJungle.service;

import com.example.UJ.UrbanJungle.model.ProductStatus;
import com.example.UJ.UrbanJungle.model.Products;
import com.example.UJ.UrbanJungle.model.User;
import com.example.UJ.UrbanJungle.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductsRepository productsRepository;

    public ProductStatus create(Products product){

        Products pro = productsRepository.save(product);

        ProductStatus proStatus = new ProductStatus();
        if(pro.getId() != null){
            proStatus.setStatus("Product added succesfully!!!");
        }
        else {
            proStatus.setStatus("Not able to add product!!!");
        }
        return proStatus;
    }
}
