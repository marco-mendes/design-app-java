package com.examplo.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestandoExceptions {

	@Test
	public void shouldThrowException() {
	    Throwable exception = Assertions.assertThrows(UnsupportedOperationException.class, () -> {
	      throw new UnsupportedOperationException("Not supported");
	    });
	    Assertions.assertEquals(exception.getMessage(), "Not supported");
	}
	
	@Test
	public void assertThrowsException() {
	    String str = null;
	    Assertions.assertThrows(IllegalArgumentException.class, () -> {
	      Integer.parseInt(str);
	    });
	}
	
}
