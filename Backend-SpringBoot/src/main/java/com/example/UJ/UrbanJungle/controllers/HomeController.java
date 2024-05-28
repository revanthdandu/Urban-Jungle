package com.example.UJ.UrbanJungle.controllers;

import com.example.UJ.UrbanJungle.model.ProductStatus;
import com.example.UJ.UrbanJungle.model.Products;
import com.example.UJ.UrbanJungle.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public ProductStatus getProducts(@RequestBody Products product){
        return productService.create(product);
    }

}
