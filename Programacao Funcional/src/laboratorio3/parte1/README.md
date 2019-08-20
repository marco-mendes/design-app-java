## Interfaces Funcionais Function e BiFunction

### Introdução Geral
Abordaremos aqui as duas principais Interfaces Funcionais do tipo **Function**, são elas:
 * Function
 * BiFunction


### Material de Preparação
[Interface Funcional Function](https://www.geeksforgeeks.org/function-interface-in-java-with-examples/)<br/>
[Vários exemplos de uso da Interface Funcional Function](https://www.programcreek.com/java-api-examples/?api=java.util.function.Function)<br/>
[Interface Funcional BiFunction](https://www.geeksforgeeks.org/java-bifunction-interface-methods-apply-and-addthen/)<br/>
[Vários exemplos de uso da Interface Funcional BiFunction](https://www.programcreek.com/java-api-examples/?api=java.util.function.Bifunction)<br/>
[Functional Composition](http://tutorials.jenkov.com/java-functional-programming/functional-composition.html)

### Introdução Interface Funcional Function
A interface Function recebe um argumento, realiza uma operação no mesmo e retorna o tipo especificado de dado após a execução da expressão lambda passada a ele.<br/>
A interface Function é estruturada da seguinte forma: **Function<T,R>**<br/>
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

#### Functional Composition
A Functional Composition é uma técnica para criar funções compostas dentro de uma única função que utiliza as funções combinadas internamente.<br/>
Veremos alguns exemplos de uso a seguir nesta e nas outras partes do laboratório 3.

#### Método **andThen()**
O método **andThen()** retorna uma função composta que será executada após a execução do método **apply**.

Exemplo:
```java
import java.util.function.Function;

public class Exemplo_2 {

    public static void main(String[] args) {
        Function<Integer, Integer> funcaoDobro = n -> n * 2;
        Function<Integer, Integer> funcaoDobroMaisCinco = funcaoDobro.andThen(n -> n + 5);
        // Imprime no console o valor 25
        System.out.println(funcaoDobroMaisCinco.apply(10));
    }

}
```
Neste exemplo o valor 10 é multiplicado por 2 durante a execução do método **apply** e após isso o valor retornado é somado com 5 no método **andThen** retornando o valor 25.

#### Método **compose()**
O método **compose()** retorna uma função composta que será executada antes da execução do método **apply**.

Exemplo:
```java
import java.util.function.Function;

public class Exemplo_3 {

    public static void main(String[] args) {

        Function<Integer, Integer> funcaoDobro = n -> n * 2;
        Function<Integer, Integer> funcaoNumeroMaisCincoVezesDois = funcaoDobro.compose(n -> n + 5);
        // Imprime no console o valor 30
        System.out.println(funcaoNumeroMaisCincoVezesDois.apply(10));

    }

}
```
Neste exemplo o valor 10 é somado com 5 durante a execução do método **compose**, após isso o valor retornado pelo método compose é multiplicado por 2 durante a execução do método **apply** retornando o valor 30.

#### Exercicio 2
Com base no código abaixo altere a função **verificarAlunoAprovado** para que a mesma receba uma função composta baseada na função **calcularMedia** e retorne true caso a média seja maior que 6, caso contrário retorne false.
```java
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Exercicio_2 {

    public static void main(String[] args) {

        Function<List<Integer>, Float> calcularMedia = (lista) -> {
            int soma = 0;
            for(int valor : lista){
                soma += valor;
            }
            float media = soma / lista.size();
            System.out.println(String.format("Media: %d", media));
            return media;
        };
        Function<List<Integer>, Boolean> verificarAlunoAprovado = ??????;

        List<Integer> notas = Arrays.asList(10, 5, 8, 1, 9);
        System.out.println(String.format("Aluno aprovado? %b", verificarAlunoAprovado.apply(notas)));

    }

}
```

### Introdução Interface Funcional BiFunction
A Interface funcional BiFunction representa uma função que aceita dois argumentos e produz um resultado.<br/>
A Interface BiFunction é estruturada da seguinte forma: **BiFunction<T,U,R>**<br/>
Onde:
 * T : É o tipo do primeiro argumento do método **apply**
 * U : É o tipo do segundo argumento do método **apply**
 * R : Indica o tipo de retorno da função


As interfaces Function e BiFunction são bem semelhantes em seu método **apply()**, a única diferença entre eles é que o método **apply()** da BiFunction recebe dois parâmetros. 

Exemplo de uso básico:
```java
import java.util.function.BiFunction;

public class Exemplo_4 {
    
    public static void main(String[] args) {
    
        BiFunction<Integer, Integer, Integer> calculaSoma = (valor1, valor2) -> valor1 + valor2;

        System.out.println(calculaSoma.apply(20, 30));
    
    }
    
}
```
Neste exemplo recebemos 2 números e retornamos o valor da soma de ambos.

#### Exercicio 3
Com base no código acima utilize a interface BiFunction para multiplicar os dois valores recebidos e retornar seu resultado.

#### Método andThen()
O uso do método **andThen()** é bem semelhante ao seu uso na interface funcional Function.<br/> 
Exemplo de uso:
```java
import java.util.function.BiFunction;

public class Exemplo_5 {
    
    public static void main(String[] args) {
    
        BiFunction<Integer, Integer, Integer> calculaSoma = (valor1, valor2) -> valor1 + valor2;
        BiFunction<Integer, Integer, Double> calculaRaizQuadradaDaSoma = calculaSoma.andThen(v -> Math.sqrt(v));

        System.out.println(calculaRaizQuadradaDaSoma.apply(40, 24));
    
    }
    
}
```
O resultado do exemplo acima irá imprimir o valor 8.0 referente a soma dos dois parâmetros recebidos e retornando a raiz quadrada dessa soma.


#### Exercício 4
Através do seguinte código realize as seguintes operações:
 * No primeiro BiFunction realize o cálculo da área de um retângulo.
 * No segundo BiFunction verifique se a área do retângulo é maior do que 100, você deve usar o primeiro BiFunction para criar o segundo.
 * Retorne true caso seja verdadeiro e false caso não seja.
```java
import java.util.function.BiFunction;

public class Exercicio_4 {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> areaRetangulo = ?????;
        BiFunction<Integer, Integer, Boolean> areaRetanguloMaiorQue100 = ?????;
        System.out.println("Área do retângulo maior que 100? " + areaRetanguloMaiorQue100.apply(21, 5));

    }

}
``` 

### Uso da Interfaces Funcionais como parâmetro de método
O Java também aceita qualquer tipo de Interface Funcional como parâmetros de métodos.<br/>
Iremos exemplificar seu uso com a interface Funcional Funcion, lembrando que seu uso não está limitado apenas a ela.<br/>
Exemplo de uso:
```java
import java.util.function.Function;

public class Exemplo_6 {

    public static int calcular (int valor, Function<Integer, Integer> operation){
        return operation.apply(valor);
    }

    public static void main(String[] args) {
        // Exemplo passando uma expressão lambda na chamada do método
        System.out.println(calcular(20, (x) -> x * 5));
        //Exemplo passando uma função na chamada do método
        Function<Integer, Integer> funcaoDivisao = (value) -> value / 3;
        System.out.println(calcular(60,  funcaoDivisao));
    }
}
```

#### Exercicio 5
Com base no código abaixo invoque o método **calcular** passando como parâmetro para ele uma função que calcule a raiz quadrada do número informado como parâmetro.<br/>
Após a invocação do método imprima o valor retornado no console.

```java
import java.util.function.Function;

public class Exercicio_5 {
    
    public static Double calcular (Double valor, Function<Double, Double> operation){
        return operation.apply(valor);
    }

    public static void main(String[] args) {

    }

}
```
