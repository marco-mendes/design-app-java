package com.examplo.junit5;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("Teste anotações @DisplayName e @Disabled")
public class TesteDisplayNameEDisabled {

	@Test
	@DisplayName("Teste ainda não implementado")
	@Disabled
	public void testShowSomething() {
		
	}
	
}
