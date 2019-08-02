package com.app;

import com.service.validator.ValidatorService;

public class Application {

    public static void main(String[] args){
        String tokenAcesso = "ABC123!@#";
        ValidatorService validatorService = new ValidatorService();
        boolean tokenValido = validatorService.validateToken(tokenAcesso);
        if(tokenValido) {
            System.out.println("Token validado com sucesso");
        } else {
            System.out.println("Token inválido!");
        }
    }
}
