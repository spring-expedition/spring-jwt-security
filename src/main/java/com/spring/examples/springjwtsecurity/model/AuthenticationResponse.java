package com.spring.examples.springjwtsecurity.model;

public class AuthenticationResponse {
    public String jwt;
    public AuthenticationResponse(String jwt){
        this.jwt=jwt;
    }
}
