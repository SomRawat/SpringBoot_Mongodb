package com.SpringBootMongodb.Springboot_Mongodb.controller;

import com.SpringBootMongodb.Springboot_Mongodb.model.GoogleTranslate;
import com.SpringBootMongodb.Springboot_Mongodb.model.Product;
import com.SpringBootMongodb.Springboot_Mongodb.model.Response;
import com.SpringBootMongodb.Springboot_Mongodb.rep.ProductRepository;
import com.SpringBootMongodb.Springboot_Mongodb.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static com.SpringBootMongodb.Springboot_Mongodb.model.Product.SEQUENCE_NAME;


@RestController
public class ProductController {
    @Autowired
    private SequenceGeneratorService service;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private GoogleTranslate googleTranslate;

    @PostMapping (value = "/")
    public Response saveEmployee(@RequestBody @Valid Product product){
        try {
            product.setId(service.getSequenceNumber(SEQUENCE_NAME));
            productRepository.save(product);
            Response responseEntity = new Response();
            responseEntity.setCode("OkKK");
            responseEntity.setData(product);
            responseEntity.setMessage("Sucess");

            return  responseEntity;


        }
        catch ( Exception e ){
            System.out.println(e.getMessage());

            Response responseEntity = new Response();
            responseEntity.setCode("OkKK");
            responseEntity.setData(null);
            responseEntity.setMessage("fail");
            return responseEntity;
        }
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





@GetMapping(value="/tra/{id}/{exum}")

    Product transltae(@PathVariable int id, @PathVariable String exum){
    Product c=new Product();
    try {

      Product a=productRepository.findById(id).orElse(null);
        String b=a.getName();
       b=GoogleTranslate.translate(exum, b);

      c.setName(b);
      c.setId(a.getId());
      c.setSize(a.getSize());
      c.setUrl(a.getUrl());
      c.setPrice(a.getPrice());
      c.setColour(a.getColour());


    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }


return c;

}







}
