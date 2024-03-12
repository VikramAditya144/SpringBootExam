package com.example.productservices.Services;

import com.example.productservices.dtos.fakeStoreProductDto;
import com.example.productservices.models.Category;
import com.example.productservices.models.Product;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class fakeStoreProductServices implements ProductService {
    RestTemplate restTemplate = new RestTemplate();


    // To get all the products what i am doing that i saw that their are only 20 product in fake store so i am iterating till each product number and adding the product in the array list and return the arraylist
    @Override
    public List<Product> getAllProduct() {
        ArrayList<Product> arr = new ArrayList<>();

        for(long i = 1; i <= 20; i++){
            arr.add(getSingleProduct(i));
        }
        return arr;
    }

    //WE have created an interface in product service because later if we have to fetch information from our database then we dont need to write the incential function again


    //Here we fetched the data from the url and converted that data into dto type then we are making a new product and then copying the attributed from dto
    @Override
    public Product getSingleProduct(Long id) {
         fakeStoreProductDto pd = restTemplate.getForObject(
                "https://fakestoreapi.com/products/"+ id,
                fakeStoreProductDto.class
        );
         Product product = new Product();
        assert pd != null;
        product.setId(pd.getId());
         product.setTitle(pd.getTitle());
         product.setDescription(pd.getDescription());
         product.setCategory(new Category(pd.getCategory()));
         product.setImageURL(pd.getImage());
         product.setPrice(pd.getPrice());

         return product;

    }

    //To Create a Product what we are doing we are taking input of a product from user then we are converting that into json and then sending that json object to fake store . but it will not store in their database so nothing will happen
    @Override
    public Product createProduct(Product product) throws JSONException {
        JSONObject prod = new JSONObject();
        prod.put("title", product.getTitle());
        prod.put("price", product.getPrice());
        prod.put("description", product.getDescription());
        prod.put("image", product.getImageURL());
        prod.put("category", product.getCategory());

        restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                prod ,
                String.class);
        return null;
    }

    @Override
    public JSONObject getAllCategory() {

        return restTemplate.getForObject(
                "https://fakestoreapi.com/products/categories",
                JSONObject.class
        );
    }

    @Override
    public  Category getCategory() {
        return null;
    }

    @Override
    public Product updateProduct() {
        return null;
    }

    @Override
    public Product deleteProduct() {
        return null;
    }

}
