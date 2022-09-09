package com.SpringBootMongodb.Springboot_Mongodb.controller;

import com.SpringBootMongodb.Springboot_Mongodb.model.Product;
import com.SpringBootMongodb.Springboot_Mongodb.model.Response;
import com.SpringBootMongodb.Springboot_Mongodb.rep.ProductRepository;
import com.SpringBootMongodb.Springboot_Mongodb.service.SequenceGeneratorService;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static com.SpringBootMongodb.Springboot_Mongodb.model.Product.SEQUENCE_NAME;


@RestController
public class ProductController {
    @Autowired
    private SequenceGeneratorService service;

    @Autowired
    private ProductRepository productRepository;


    @PostMapping (value = "/")
    ResponseEntity<Response> saveEmployee(@RequestBody @Valid Product product){
try {
    product.setId(service.getSequenceNumber(SEQUENCE_NAME));
    productRepository.save(product);
    return new ResponseEntity<>(HttpStatus.OK);

}
catch ( Exception e ){
    System.out.println(e.getMessage());
}
        return new ResponseEntity<Response>(HttpStatus.INTERNAL_SERVER_ERROR);
    }




    @GetMapping("/")
    public List<Product> getProduct() {
        return productRepository.findAll();
    }


    @GetMapping(value = "/{id}")
    public Optional<Product> getProductbyId(@PathVariable int id)
    {
        return productRepository.findById(id);


    }


    @DeleteMapping(value = "/delete/{id}")
    void deleteEmployeeById(@PathVariable int id){
        productRepository.deleteById(id);

    }






}
