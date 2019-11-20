package com.examplo.junit5;

import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestesDinamicos {

	@TestFactory
	public Stream<DynamicTest> validadorNumerosDeTelefoneTestFactory() {
		
		List<String> numeros = Arrays.asList("31 3333-3333", "31 3535-3535", "(31) 98877-2020", "(31) 89977-4565");
		
		return numeros
				.stream()
				.map(numero -> dynamicTest("Teste numero: " + numero, () -> Assertions.assertTrue(validarNumeroDeTelefone(numero))));
		
	}
	
	public boolean validarNumeroDeTelefone(String numero) {
		String regex = "(\\(?\\d{2}\\)?\\s)?(\\d{4,5}\\-\\d{4})";
		return numero.matches(regex);
	}
	
}
