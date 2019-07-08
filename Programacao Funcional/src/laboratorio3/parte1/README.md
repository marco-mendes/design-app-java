## Interfaces Funcionais Function e BiFunction

### Introdução Geral
Abordaremos aqui as duas principais Interfaces Funcionais do tipo **Function**, são elas:
 * Function
 * BiFunction


### Material de Preparação
[Interface Funcional Function](https://www.geeksforgeeks.org/function-interface-in-java-with-examples/)<br/>
[Vários exemplos de uso da Interface Funcional Function](https://www.programcreek.com/java-api-examples/?api=java.util.function.Function)<br/>
[Interface Funcional BiFunction](https://www.geeksforgeeks.org/java-bifunction-interface-methods-apply-and-addthen/)<br/>
[Vários exemplos de uso da Interface Funcional BiFunction](https://www.programcreek.com/java-api-examples/?api=java.util.function.Bifunction)


### Function Composition


### Introdução Interface Funcional Function
A interface Function recebe um argumento, realiza uma operação no mesmo e retorna o tipo especificado de dado após a execução da expressão lambda passada a ele.<br/>
A interface Function é estruturada da seguinte forma:<br/>
Function<T,R><br/>
Onde T é o tipo de parâmetro recebido pelo método **apply** e R é o tipo de retorno da Function.<br/>
Para executar um Function usamos o método **apply()** informando o valor que será usado na função.<br/>
Além do método apply a interface funcional Function possui outros métodos úteis como **andThen()** e **compose()**.

Exemplo de uso básico:
```java
import java.util.function.Function;

public class Exemplo_1 {
    
  public static void main(String[] args) {
    Function<Integer, Integer> funcaoDobro = n -> n * 2;
    // Imprime no console o valor 20
    System.out.println(funcaoDobro.apply(10));
  }
    
}
```
Neste exemplo recebemos um número e retornamos o dobro deste número.<br/>

#### Exercicio 1
Com base no exemplo acima utilize a interface funcional Function para receber um valor do tipo String e retornar uma String no seguinte formato: "Hello parametro".<br/>
Após criar a Function realize um teste e imprima no console o valor retornado por ela.<br/>
Exemplo de retorno utilizando o parâmetro "Jhon": "Hello Jhon".

#### Function Composition
A Function Composition é uma técnica para combinar múltiplas funções em uma única função que utiliza as funções combinadas internamente.<br/>
Veremos alguns exemplos de uso a seguir nesta e nas outras partes do laboratório 3.

#### Método **andThen()**
O método **andThen()** retorna uma função composta que será executada após a execução do método **apply**.

Exemplo:
```java
Function<Integer, Integer> funcaoDobro = n -> n * 2;
Function<Integer, Integer> funcaoDobroMaisCinco = funcaoDobro.andThen(n -> n + 5);
// Imprime no console o valor 25
System.out.println(funcaoDobroMaisCinco.apply(10));
```
Neste exemplo o valor 10 é multiplicado por 2 durante a execução do método **apply** e após isso o valor retornado é somado com 5 no método **andThen** retornando o valor 25.

#### Método **compose()**
O método **compose()** retorna uma função composta que será executada antes da execução do método **apply**.

Exemplo:
```java
Function<Integer, Integer> funcaoDobro = n -> n * 2;
Function<Integer, Integer> funcaoNumeroMaisCincoVezesDois = funcaoDobro.compose(n -> n + 5);
// Imprime no console o valor 30
System.out.println(funcaoNumeroMaisCincoVezesDois.apply(10));
```
Neste exemplo o valor 10 é somado com 5 durante a execução do método **compose**, após isso o valor retornado pelo método compose é multiplicado por 2 durante a execução do método **apply** retornando o valor 30.


