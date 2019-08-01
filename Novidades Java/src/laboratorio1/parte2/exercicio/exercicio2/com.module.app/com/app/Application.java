package com.app;

import com.validator.login.LoginValidator;

public class Application {

    public static void main(String[] args){
        LoginValidor validator = new LoginValidator();
        String usuario = "adm";
        String senha = "123";
        Boolean usuarioValidado = validator.login(usuario, senha);
        if(usuarioValidado) {
            System.out.println("Login realizado com sucesso!");
        } else {
            System.out.println("Usuário ou senha inválidos!");
        }
    }

}