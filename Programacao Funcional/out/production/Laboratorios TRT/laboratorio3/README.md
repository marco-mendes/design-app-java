# Laboratório Interface Funcional Predicate - Protótipo

### Material de Preparação
[Como usar Predicates](http://www.edneiparmigiani.com.br/java-8-como-usar-o-predicate/)<br/>
[Predicate com Exemplos](https://www.geeksforgeeks.org/java-8-predicate-with-examples/)

### Introdução
A interface funcional **Predicate** foi projetada para ser usada em situações em que um teste precisa ser executado e um valor booleano precisa ser retornado.

O método usado para executarmos as funções do tipo Predicate é o método **test()** que recebe uma expressão Lambda e deve retornar um valor booleano após a execução da mesma.

Assim como a interface funcional **Function** a interface funcional **Predicate** também pode ser usada como parâmetro em métodos.

Exemplo de uso básico desta interface funcional:
```java
import java.util.function.Predicate;

public class ExemploIFPredicate {

    public static void main(String[] args) {

        // Exemplo com Lambda em linha única
        Predicate<Integer> testeMaioridade = n -> (n > 18) ? true : false;

        // Exemplo com Lambda Multilinha
        Predicate<Integer> testeMaioridadeMultilinha = n -> {
            if(n > 18){
                return true;
            } else {
                return false;
            }
        };

        System.out.println("É maior de idade? " + testeMaioridade.test(28));
        System.out.println("É maior de idade? " + testeMaioridade.test(17));
        System.out.println("É maior de idade? " + testeMaioridadeMultilinha.test(14));
        System.out.println("É maior de idade? " + testeMaioridadeMultilinha.test(31));

    }
}
```

Além do método **test()** a interface funcional **Predicate** também possui outros 4 métodos que podemos utilizar.
<br/>Entre eles possuímos 3 métodos que não sao estáticos: **and()**, **or()** e **negate()**.  
<br/>Possuímos também 1 método estático: **Predicate.isEqual()**

### Método and()
Este método é equivalente ao operador lógico **E**, o mesmo é executado após o método **test()** ser executado.
<br/>Exemplo: 
<br/>Suponhamos que queremos verificar a idade de uma pessoa e informar se ela é adulta e não é idosa.

Poderíamos fazer isso da seguinte forma usando o método **and()**:
```java
Predicate<Integer> testeMaioridade = n -> (n > 18) ? true : false;
Predicate<Integer> testeMaioridadeENaoIdoso = testeMaioridade.and(n -> (n < 60) ? true : false);
System.out.println("É maior de idade e não é idoso? " + testeMaioridadeENaoIdoso.test(65));
System.out.println("É maior de idade e não é idoso? " + testeMaioridadeENaoIdoso.test(42));
```

### Método or()
Este método é equivalente ao operador lógico **OU**, o mesmo é executado após o método **test()** ser executado.
<br/>Exemplo:
<br/>Suponhamos que queremos verificar se um nome informado é "Jose" ou "Maria".

Poderíamos fazer isso da seguinte forma usando o método **or()**:
```java
Predicate<String> seChamaJose = nome -> (nome == "Jose") ? true : false;
Predicate<String> seChamaJoseOuMaria = seChamaJose.or(nome -> (nome == "Maria") ? true : false);
System.out.println("Se chama Jose ou Maria? " + seChamaJoseOuMaria.test("Jose"));
System.out.println("Se chama Jose ou Maria? " + seChamaJoseOuMaria.test("Maria"));
System.out.println("Se chama Jose ou Maria? " + seChamaJoseOuMaria.test("Draven"));
```

### Método negate()
Este método é equivalente a um operador de negação, o mesmo nega o resultado de algum Predicate.
<br/>Exemplo:
```java
Predicate<Integer> maiorQueDez = (i) -> i > 10;

Predicate<Integer> menorQueVinte = (i) -> i < 20;
boolean result = maiorQueDez.and(menorQueVinte).test(15);
System.out.println(result);

boolean result2 = maiorQueDez.and(menorQueVinte).negate().test(15);
System.out.println(result2);
```

### Método estático Predicate.isEqual()
Este método verificar se uma entrada é equivalente ao esperado.
Este método é estático e seu uso é diferente dos demais.
<br/>Exemplo:
<br/>Suponhamos que queremos verificar se uma entrada é equivalente à "Brasileiro"
Poderíamos fazer isso da seguinte forma usando o método **Predicate.isEqual()**:
```java
Predicate<String> isBrasileiro = Predicate.isEqual("Brasileiro");
System.out.println("É Brasileiro? " + isBrasileiro.test("Brasileiro"));
System.out.println("É Brasileiro? " + isBrasileiro.test("Argentino"));
```

Este método também pode ser útil para comparar objetos.


### Exercício
