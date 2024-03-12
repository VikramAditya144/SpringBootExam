package com.example.productservices.Services;

import com.example.productservices.dtos.fakeStoreProductDto;
import com.example.productservices.models.Category;
import com.example.productservices.models.Product;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();
    Product getSingleProduct(Long id);

    Product createProduct(Product product) throws JSONException;

    JSONObject getAllCategory();
    Category getCategory();

    Product updateProduct();
    Product deleteProduct();

}
