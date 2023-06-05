package com.example.blogsystem.ApiExeption;

public class ApiExeption extends RuntimeException {
    public ApiExeption(String massage){
        super(massage);
    }
}
