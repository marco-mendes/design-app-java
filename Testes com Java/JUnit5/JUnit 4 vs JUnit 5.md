## JUnit 4 vs JUnit 5



### Anotações

A maioria das anotações nas duas versões é a mesma, mas poucas diferem. Aqui está uma comparação rápida. 



<img src="C:/Users/Lenovo/Documents/Laboratorios TRT/Testes com Java/JUnit5/imagens/features.png"/>

Uma observação importante é que todas as anotações do JUnit 4 foram migradas do pacote **org.junit** para o pacote **org.junit.jupiter.api** no JUnit 5.



### Assertions

Assertions é uma coleção de métodos utilitários utilizados para realizar asserções durante os testes de unidade, caso uma asserção falhe o teste do método em execução também irá falhar.

No JUnit 4 essa classe era conhecida como a classe **Assert** presente no pacote [**org.junit.Assert**](http://junit.org/junit4/javadoc/4.12/org/junit/Assert.html), já no JUnit 5 a mesma foi renomeada para **Assertions** e foi movida para o pacote  [**org.junit.jupiter.Assertions**](http://junit.org/junit5/docs/current/api/org/junit/jupiter/api/Assertions.html).

Com isso no lugar de utilizarmos **Assert.assertEquals** utilizaremos **Assertions.assertEquals** como no exemplo de código abaixo:

```java
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TesteJUnitSpringBoot {
	
	@Test
	public void validarNumeroTelefone() {
		String regex = "(\\(?\\d{2}\\)?\\s)?(\\d{4,5}\\-\\d{4})";
		String telefoneFixo = "(31) 3030-4040";
		String telefoneCelular = "(31) 99558-2040";
		Assertions.assertTrue(telefoneFixo.matches(regex));
		Assertions.assertTrue(telefoneCelular.matches(regex));
	}
	
}
```



### Assumptions(Premissas)

Assumptions é uma classe com uma coleção de métodos utilitários que suportam a execução condicional de testes, ou seja, se um Assumption for verdadeiro o método de teste será executado, caso contrário a execução do método de teste será cancelada, uma curiosidade sobre isso é que o teste do método não será considerado como um teste com falha dessa forma não interferindo no resultado final dos testes de unidade de uma classe.

Normalmente, as premissas são usadas sempre que não faz sentido continuar a execução de um determinado método de teste, por exemplo, se o teste depende de algo que não existe no ambiente de tempo de execução atual.

No JUnit 4 essa classe era conhecida como **Assume** presente no pacote  [org.junit.Assume](http://junit.org/junit4/javadoc/4.12/org/junit/Assume.html), já no JUnit 5 esta classe foi renomeada para **Assumptions** e foi movida para o pacote  [org.junit.jupiter.api.Assumptions](http://junit.org/junit5/docs/current/api/org/junit/jupiter/api/Assumptions.html).

Exemplo de uso:

```java
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TesteJUnitSpringBoot {
	
	@BeforeAll
	public static void setaAmbiente() {
		System.setProperty("ENV", "DEV");
	}

	@Test
	public void testeEmDev() {
		String ambienteDev = "DEV";
		Assumptions.assumeTrue(ambienteDev.equals(System.getProperty("ENV")));
		// Algum código para teste
	}
	
	@Test
	public void testeEmProd() {
		String ambientePROD = "PROD";
		Assumptions.assumeTrue(ambientePROD.equals(System.getProperty("ENV")));
		// Algum código para teste
	}
	
}
```



