package com.SpringBootMongodb.Springboot_Mongodb.model;

import lombok.Data;



@Data
public class Response {
    private Object data;
    private String message;
    private String code;


}
