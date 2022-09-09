package com.SpringBootMongodb.Springboot_Mongodb.model;

import lombok.Data;


@Data
public class Response {
    private Object data;
    private String message;
    private String code;


//    public Response(Object data, String message, String code) {
//        this.data = data;
//        this.message = message;
//        this.code = code;
//    }
    public Response(String message, String code) {

        this.message = message;
        this.code = code;
    }
}
