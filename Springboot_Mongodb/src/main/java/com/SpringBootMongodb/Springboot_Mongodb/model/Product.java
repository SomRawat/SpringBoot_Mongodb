package com.SpringBootMongodb.Springboot_Mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Document(collection="product1")
public class Product {

    @Transient
    public static final  String SEQUENCE_NAME = "user_sequence";
    @Id
    private int id;
    @NotNull
    private  String name;
    @NotNull
    @Pattern(regexp = "[S|M|L|s|m|l]")
    private  String size;  //  small medium large
    @NotNull
    @Min(value=1, message="must be equal or greater than 1")
    private  double price ;
    @NotNull
    private String  colour;
    @NotNull
    private String url;


}
