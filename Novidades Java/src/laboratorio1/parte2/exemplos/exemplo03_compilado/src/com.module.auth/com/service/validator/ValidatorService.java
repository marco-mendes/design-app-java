package com.service.validator;


public class ValidatorService {

    String tokenValido = "ABC123!@#";

    public boolean validateToken(String token){
        if(token == tokenValido){
            return true;
        }
        return false;
    }

}
