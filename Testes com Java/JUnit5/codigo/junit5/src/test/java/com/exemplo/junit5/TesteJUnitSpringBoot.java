package com.exemplo.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TesteJUnitSpringBoot {
	
	@Test
	public void validarEmail() {
		String regex = 
		        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
		String email = "teste123@teste.com.br";
		Assertions.assertTrue(email.matches(regex));
		
	}
	
}