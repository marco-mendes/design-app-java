# Laboratório Interface Funcional Function - Protótipo

### Material de Preparação
[Interface Funcional Function](https://www.geeksforgeeks.org/function-interface-in-java-with-examples/)<br/>
[Vários exemplos de uso da Interface Funcional Function](https://www.programcreek.com/java-api-examples/?api=java.util.function.Function)

### Introdução

Nos laboratórios anteriores falamos sobre Lambdas que são uma forma clara e objetiva de representar um método usando apenas uma expressão.

Agora iremos falar sobre a interface funcional Function, que nos permite passar uma expressão Lambda para podermos realizar alguma operação.

A interface Function recebe um argumento, realiza uma operação no mesmo e retorna o tipo especificado de dado após a execução da expressão lambda passada a ele.

Um exemplo de uso da interface Function poderia ser de receber um valor e realizar uma operação em cima deste valor.
Para executar a função usamos o método **apply()** informando o valor que será usado na função.
Vamos imaginar uma situação que seja necessário receber um número e retornar o dobro do número informado usando a interface Function.
Poderíamos realizar isso desta forma:

```java
import java.util.function.Function;

public class ExemploIFFunction {
    
  public static void main(String[] args) {
    Function<Integer, Integer> funcaoDobro = n -> n * 2;
    // Imprime no console o valor 20
    System.out.println(funcaoDobro.apply(10));
  }
    
}
```
A Interface Function possui outros métodos que podem nos ser úteis, são eles: **andThen()** e **compose()**

### Método andThen()
O método **andThen()** executa uma operação após o termino da execução do método **apply()** o valor que a função retorna é o valor processado no método **andThen()**
Exemplo:
Imagine a seguinte situação, você precisa receber um número, multiplicá-lo por dois e após isso somar o resultado com 5 e retornar o valor após essa operação.
Podemos fazer isso da seguinte forma:

```java
Function<Integer, Integer> funcaoDobro = n -> n * 2;
Function<Integer, Integer> funcaoDobroMaisCinco = funcaoDobro.andThen(n -> n + 5);
// Imprime no console o valor 25
System.out.println(funcaoDobroMaisCinco.apply(10));
```

Abaixo outra forma de executar esta mesma operação

```java
Function<Integer, Integer> funcao = n * 2;
// Imprime no console o valor 25
System.out.println(funcao.andThen(n -> n + 5).apply(10));
```

Neste exemplo primeiro o valor recebido será multiplicado por 2, e após isso o resultado será somado com 5.


### Método compose()

O método **compose()** executa uma operação antes da execução do método **apply()**, o valor retornado por este método é usado para a operação do método **apply()**
Exemplo:
Imagine a seguinte situação, você precisa receber um número, somá-lo com 5, e somente após isso multiplicá-lo por 2;
Podemos fazer isso da seguinte forma:

```java
Function<Integer, Integer> funcaoDobro = n -> n * 2;
Function<Integer, Integer> funcaoNumeroMaisCincoVezesDois = funcaoDobro.compose(n -> n + 5);
// Imprime no console o valor 30
System.out.println(funcaoNumeroMaisCincoVezesDois.apply(10));
```

Neste exemplo primeiro é executada a expressão presente dentro do método **compose()** e após isso é executada a função do método **apply()** 


### Uso da interface funcional Function como parâmetro de método

O Java também aceita funções como parâmetros em métodos.
Imagine a seguinte situação:
Sempre que você chamar um método X você gostaria que este método realizasse determinada operação matemática porém você não sabe ao certo qual operação vai ser executada.
Para resolver isso você pode passar como parâmetro uma função ou uma expressão Lambda com o que deve ser executado.
Podemos fazer isso desta forma:



```java
import java.util.function.Function;

public class ExemploIFFunction {

   public static void main(String[] args) {
         // Exemplo passando uma expressão lambda na chamada do método 
        System.out.println(calcular(20, (x) -> x * 5));
        System.out.println(calcular(16, (x) -> x + 4));
        System.out.println(calcular(30, (x) -> x - 2));
        //Exemplo passando uma função na chamada do método
        Function<Integer, Integer> funcaoDivisao = (value) -> value / 3;
        System.out.println(calcular(60,  funcaoDivisao));
   }

   public static int calcular (int valor, Function<Integer, Integer> operation){
        return operation.apply(valor);
   }
}
```

### Exercício
Através do seguinte código calcule a raiz quadrada do número informado e imprima o resultado no console:

```java
import java.util.function.Function;

public class IFFunctionExercicio {

  public static void main(String[] args) {

    Function<Double, Double> funcaoRaizQuadrada = (parametro) -> operacao;
    double valor = 25;
    calcular(valor, funcaoRaizQuadrada);

  }

  public static double calcular(double value, Function<Double, Double> operation){

    double resultado = ?????;

    System.out.println("Resultado da operação: " + resultado);
    return resultado;

  }
  
}
```