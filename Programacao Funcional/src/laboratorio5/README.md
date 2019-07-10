## Uso de Currying e Closures com Java 8

### Material de Referência
[Closures](https://klauslaube.com.br/2011/05/29/afinal-o-que-sao-closures.html)<br/>
[Currying](https://www.geeksforgeeks.org/currying-functions-in-java-with-examples/)

### Introdução
Neste laboratório abordaremos o uso de **Currying** e **Closures** com alguns exemplos em Java.

### Closures
Como vimos no material de preparação um Closure fornece acesso ao escopo de uma função externa dentro de uma função interna.<br/>
Exemplo: 
```java
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Exemplo_1 {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Double> calculaPotencia = (numero, potencia) -> {

          Consumer<Double> imprimeResultado = (r) -> {
              System.out.println(
                      String.format("O resultado do número %s elevado à %s foi: %s", numero, potencia, r)
              );
          };
          Double resultado = Math.pow(numero, potencia);
          imprimeResultado.accept(resultado);
          return resultado;
        };

        calculaPotencia.apply(5,2);

    }
}
```
Neste exemplo vemos claramente a função interna utilizando parâmetros da função externa, basicamente este é o conceito de closure.

#### Exercício 1
Com base no exemplo acima crie um closure seguindo os seguintes passos:<br/>
Crie uma Function chamada **calculaRaizQuadrada** que irá receber um número inteiro como parâmetro e retornar um valor do tipo Double referente a raiz quadrada do mesmo.<br/>
Dentro dessa Function crie um Consumer chamado **imprimirRaizQuadrada** e o invoque dentro da Function **calculaRaizQuadrada** passando como argumento a raiz quadrada já calculada.<br/>
Este consumer deve imprimir a seguinte mensagem no console: "O resultado da raiz quadrada do número VALOR_RECEBIDO_PELO_FUNCTION é: VALOR_RAIZ_QUADRADA_CALCULADO".<br/>
Por exemplo, a função **calculaRaizQuadrada** foi invocada com o valor 25, o valor impresso pelo consumer **imprimirRaizQuadrada** deve ser semelhante a isso: "O resultado da raiz quadrada do número 25 é: 5".<br/>
  

### Currying
Currying é um conceito de quebrar uma função com muitos argumentos em muitas funções com um único argumento, de tal forma que a saída é a mesma.<br/>
O currying divide funções de ordem superior em uma série de funções em cascata menores que recebem um argumento e retornam uma função, exceto a última função em cascata que retorna o valor desejado.<br/>
Exemplo:
```java
import java.util.function.Function;

public class Exemplo_2 {

    public static void main(String[] args) {

        Function<Integer,
                Function<Integer, Integer>> curryingSomaDoisValores = u -> v -> u + v;
        System.out.println(
                curryingSomaDoisValores
                        .apply(5)
                        .apply(10)
        );

    }

}
```
Neste exemplo divimos a função em duas partes.

Outro exemplo:
```java
public class Exemplo_3 {

    public static void main(String[] args) {

        Function<Integer,
                Function<Integer,
                        Function<Integer, Integer>>> curryingSomaTresValores = u -> v -> w -> u + v + w;
        System.out.println(
                curryingSomaTresValores
                        .apply(5)
                        .apply(10)
                        .apply(15)
        );

    }

}
```
Neste exemplo divimos a função em duas partes.

#### Exercicio 2
Com base nos exemplos acima crie um Currying que divida uma função em duas partes chamado **curryingMultiplicaValores**, o mesmo deve retornar o valor da multiplicação do valores recebidos pelo currying.<br/>
_Dica: É bem semelhante ao Exemplo 2_
