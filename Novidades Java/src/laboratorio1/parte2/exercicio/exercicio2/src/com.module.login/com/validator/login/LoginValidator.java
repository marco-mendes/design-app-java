package com.validator.login;

public class LoginValidator {

    public Boolean login(String usuario, String senha){
        if(usuario == "adm" && senha == "123"){
            return true;
        }
        return false;
    }

}
