package com.example.productservices.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class fakeStoreProductDto {
    private long id;
    private String title;
    private String description;
    private String category;
    private String image;
    private double price;
}
