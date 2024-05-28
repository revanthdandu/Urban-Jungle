package com.example.UJ.UrbanJungle.repository;

import com.example.UJ.UrbanJungle.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, String> {
}
