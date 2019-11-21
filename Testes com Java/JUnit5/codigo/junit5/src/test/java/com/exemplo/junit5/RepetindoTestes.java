package com.exemplo.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

public class RepetindoTestes {
	
	@RepeatedTest(10)
	public void validarNumeroTelefone() {
		// esse teste será executado 10 vezes
		
		String regex = "(\\(?\\d{2}\\)?\\s)?(\\d{4,5}\\-\\d{4})";
		String telefoneFixo = "(31) 3030-4040";
		String telefoneCelular = "(31) 99558-2040";
		Assertions.assertTrue(telefoneFixo.matches(regex));
		Assertions.assertTrue(telefoneCelular.matches(regex));
	}
	
}
