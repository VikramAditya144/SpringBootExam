package com.example.productservices.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category  {
private long id;
private String name;
public Category(String name){
    this.name = name;
    id = 0;
}
}
