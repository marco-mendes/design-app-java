package com.exemplo.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AssertionsTest {

	@Test
	public void validarNumeroTelefone() {
		String regex = "(\\(?\\d{2}\\)?\\s)?(\\d{4,5}\\-\\d{4})";
		String telefoneFixo = "(31) 3030-4040";
		String telefoneCelular = "(31) 99558-2040";
		Assertions.assertTrue(telefoneFixo.matches(regex));
		Assertions.assertTrue(telefoneCelular.matches(regex));
	}
	
}
