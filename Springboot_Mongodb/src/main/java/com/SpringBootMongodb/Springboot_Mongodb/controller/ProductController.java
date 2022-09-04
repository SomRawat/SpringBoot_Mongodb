package com.SpringBootMongodb.Springboot_Mongodb.controller;

import com.SpringBootMongodb.Springboot_Mongodb.model.Product;
import com.SpringBootMongodb.Springboot_Mongodb.rep.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @PostMapping (value = "/")
    void saveEmployee(@RequestBody  Product product){
        productRepository.save(product);
    }




    @GetMapping("/")
    public List<Product> getProduct() {
        return productRepository.findAll();
    }


    @GetMapping(value = "/{id}")
    public Optional<Product> getProductbyId(@PathVariable String id) {
        return productRepository.findById(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    void deleteEmployeeById(@PathVariable String id){
        productRepository.deleteById(id);

    }




}
