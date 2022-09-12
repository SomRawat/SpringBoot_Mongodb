package com.SpringBootMongodb.Springboot_Mongodb.rep;

import com.SpringBootMongodb.Springboot_Mongodb.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,Integer> {
}
