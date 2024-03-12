package com.example.productservices.controllers;

import com.example.productservices.Services.ProductService;
import com.example.productservices.models.Product;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@RestController
public class productController {
    private ProductService productService;

    public productController(ProductService productService) {
        this.productService = productService;
    }



    // To Get All Product's
    @GetMapping("/products")
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    // Get Single Product
    @GetMapping("/products/{id}"  )
    public Product getSingleProduct(@PathVariable("id") Long id) {
        return productService.getSingleProduct(id);
    }

    // Add a new Product
    @PostMapping("/products")
    public Product createProduct(@RequestBody Product  product ){
        return null;
    }


    //Update a existing product
    @PutMapping("/products/{id}")
    public void update(@RequestBody Product product){
        return;
    }

    //Delete a Product
    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable("id") Long id){
        return;
    }

    @GetMapping("/products/categories")
    public JSONObject getAllCategory(){
        return productService.getAllCategory();
    }
}
