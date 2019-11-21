package com.exemplo.junit5.extensions;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
 
@ExtendWith(TestLifeCycleExtensions.class)
public class TestLifeCycleExtensionTest {
	
    @BeforeAll
    public static void beforeAll() {
        System.out.println("Dentro de @BeforeAll");
    }
 
    @BeforeEach
    public void beforeEach() {
        System.out.println("Dentro de @BeforeEach");
    }
 
    @Test
    public void primeiroTeste() {
        System.out.println("Dentro do primeiro teste");
    }
 
    @Test
    public void segundoTeste() {
        System.out.println("Dentro do segundo teste");
    }
 
    @AfterEach
    public void afterEach() {
        System.out.println("Dentro de @AfterEach");
    }
 
    @AfterAll
    public static void afterAll() {
        System.out.println("Dentro de @AfterAll");
    }
    
}