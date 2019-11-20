package com.examplo.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AssumptionsTest {

	@BeforeAll
	public static void setaAmbiente() {
		System.setProperty("ENV", "DEV");
	}
	
	@Test
	public void testeEmDev() {
		String ambienteDev = "DEV";
		Assumptions.assumeTrue(ambienteDev.equals(System.getProperty("ENV")));
		Assertions.assertTrue(ambienteDev.equals(System.getProperty("ENV")));
	}
	
	@Test
	public void testeEmProd() {
		String ambientePROD = "PROD";
		Assumptions.assumeTrue(ambientePROD.equals(System.getProperty("ENV")));
		// O teste será cancelado devido ao Assumption acima não ser verdadeiro
		// O assert abaixo resultaria em um erro neste caso e não será executado
		Assertions.assertTrue(ambientePROD.equals(System.getProperty("ENV")));
	}
	
}
