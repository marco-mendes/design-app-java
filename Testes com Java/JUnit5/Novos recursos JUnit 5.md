## Novos recursos JUnit 5



### Introdução

O JUnit 5 trouxe consigo uma série de novos recursos, dentre eles temos:

 - Testes dinâmicos com a anotação @TestFactory
 - Testes de Exceptions 
 - Anotação @DisplayName 
 - Anotação @Disabled 
 - Anotação @Nested 
 - Anotação @ExtendWith 



### Criando testes dinâmicos com a anotação @TestFactory

Os testes dinâmicos do JUnit 5 permitem declarar e executar casos de teste gerados em tempo de execução. Ao contrário dos testes estáticos, que definem um número fixo de casos de teste no tempo de compilação, os testes dinâmicos permitem definir dinamicamente os casos de teste no tempo de execução.

Testes dinâmicos podem ser gerados por um método Factory anotado com **@TestFactory**.

Exemplo de uso:

```java
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
```

O resultado da execução deste teste será semelhante a isso:

<img src="./imagens/resultado-execucao-junit5-p1.PNG" style="float: left"/>

Outros exemplos de uso podem ser encontrados [neste]( https://github.com/junit-team/junit5/blob/master/documentation/src/test/java/example/DynamicTestsDemo.java ) e [neste link]( https://www.programcreek.com/java-api-examples/index.php?api=org.junit.jupiter.api.TestFactory).



### Testando exceptions

Se necessário podemos realizar uma asserção que espere uma exception, este é o caso do método **assertThrows** da classe **Assertions**.

Abaixo um simples exemplo de uso:

```java
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
```





### Anotações @DisplayName e @Disabled

A anotação **@DisplayName** altera o nome de exibição de algum método ou classe de teste, já a anotação **@Disabled** faz com que um método ou classe de teste seja desativado.

Observe o seguinte trecho de código:

```java
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
```

Neste trecho de código estamos alterando o nome de exibição do método **testShowSomething** para "Teste ainda não implementado" utilizando a anotação **@DisplayName**, além disso estamos desativando a execução deste teste com o anotação **@Disabled**.

Podemos verificar o resultado da execução deste teste logo abaixo:

<img src="./imagens/resultado-execucao-junit5-p2.PNG" style="float: left"/>



