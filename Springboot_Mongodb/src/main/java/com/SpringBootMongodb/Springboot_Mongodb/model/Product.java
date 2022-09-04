package com.SpringBootMongodb.Springboot_Mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Document(collection="product")
public class Product {
    @Id
    private String  id;
    private  String name;
    private  String size;
    private  double price ;
    private double colour;
    private String url;


}
