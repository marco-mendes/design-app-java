## Interfaces Funcionais Function e BiFunction

### Introdução Geral
Neste laboratório abordaremos as duas principais Interfaces Funcionais do tipo **Function**, são elas:
 * Function
 * BiFunction


### Material de Preparação
[Interface Funcional Function](https://www.geeksforgeeks.org/function-interface-in-java-with-examples/)<br/>
[Vários exemplos de uso da Interface Funcional Function](https://www.programcreek.com/java-api-examples/?api=java.util.function.Function)<br/>
[Interface Funcional BiFunction](https://www.geeksforgeeks.org/java-bifunction-interface-methods-apply-and-addthen/)<br/>
[Vários exemplos de uso da Interface Funcional BiFunction](https://www.programcreek.com/java-api-examples/?api=java.util.function.Bifunction)


### Introdução Interface Funcional Function

Nos laboratórios anteriores falamos sobre Lambdas que são uma forma clara e objetiva de representar um método usando apenas uma expressão.

Agora iremos falar sobre a interface funcional Function, que nos permite passar uma expressão Lambda para podermos realizar alguma operação.

A interface Function recebe um argumento, realiza uma operação no mesmo e retorna o tipo especificado de dado após a execução da expressão lambda passada a ele.

Um exemplo de uso da interface Function poderia ser de receber um valor e realizar uma operação em cima deste valor.<br/>Para executar a função usamos o método **apply()** informando o valor que será usado na função.
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

A Interface Function possui outros métodos que podem nos ser úteis, são eles: **andThen()** e **compose()**.<br/>
Ambos os métodos podem ser usados para Composição de Funções(Function Composition).

#### Método andThen()
O método **andThen()** executa uma operação após o termino da execução do método **apply()**.
<br/>O valor que a função retorna é o valor processado no método **andThen()**<br/>
Exemplo:
Imagine a seguinte situação, você precisa receber um número, multiplicá-lo por dois e após isso somar o resultado com 5 e retornar o valor após essa operação.
Podemos fazer isso da seguinte forma:

```java
Function<Integer, Integer> funcaoDobro = n -> n * 2;
Function<Integer, Integer> funcaoDobroMaisCinco = funcaoDobro.andThen(n -> n + 5);
// Imprime no console o valor 25
System.out.println(funcaoDobroMaisCinco.apply(10));
```
Conforme mostrado no exemplo acima utilizamos o método **andThen** para criar uma função composta e atribuimos o resultado a outra função.
Este é um exemplo de function composition.

Abaixo outra forma de executar esta mesma operação

```java
Function<Integer, Integer> funcao = n -> n * 2;
// Imprime no console o valor 25
System.out.println(funcao.andThen(n -> n + 5).apply(10));
```

Neste exemplo primeiro o valor recebido será multiplicado por 2, e após isso o resultado será somado com 5.


#### Método compose()

O método **compose()** executa uma operação antes da execução do método **apply()**, o valor retornado por este método é usado para a operação do método **apply()**.<br/>
Exemplo:<br/>
Imagine a seguinte situação, você precisa receber um número, somá-lo com 5, e somente após isso multiplicá-lo por 2.<br/>
Podemos fazer isso da seguinte forma:

```java
Function<Integer, Integer> funcaoDobro = n -> n * 2;
Function<Integer, Integer> funcaoNumeroMaisCincoVezesDois = funcaoDobro.compose(n -> n + 5);
// Imprime no console o valor 30
System.out.println(funcaoNumeroMaisCincoVezesDois.apply(10));
```

Neste exemplo primeiro é executada a expressão presente dentro do método **compose()** e após isso é executada a função do método **apply()**.<br/>
O exemplo acima também pode ser considerado uma Function Composition.


#### Uso da interface funcional Function como parâmetro de método

O Java também aceita funções como parâmetros em métodos.<br/>
Imagine a seguinte situação:<br/>
Sempre que você chamar um método X você gostaria que este método realizasse determinada operação matemática porém você não sabe ao certo qual operação vai ser executada.<br/>
Para resolver isso você pode passar como parâmetro uma função ou uma expressão Lambda com o que deve ser executado.<br/>
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

### Introdução Interface Funcional BiFunction
A Interface funcional BiFunction representa uma função que aceita dois argumentos e produz um resultado.<br/>
Para criar uma BiFunction precisamos de 3 parâmetros em seu Diamond Operator(<>), são eles:

 * T : denota o tipo do primeiro argumento para a função
 * U : denota o tipo do segundo argumento para a função
 * R : indica o tipo de retorno da função

Sendo assim, essa é a estrutura de uma BiFunction:
<br/>BiFunction<T,U,R>

A interface BiFunction recebe dois argumento, realiza uma operação no mesmo e retorna o tipo especificado de dado após a execução da expressão lambda passada a ele.
<br/>As interfaces Function e BiFunction são bem semelhantes em seu método **apply()**, a única diferença entre eles é que o método **apply()** da BiFunction recebe dois parâmetros. 

Um exemplo básico do uso da interface BiFunction seria para realizar o calculo entre 2 números  especificando a operação que seria realizada entre eles através da expressão Lambda.
<br/>No exemplo abaixo iremos realizar a seguinte operação:

 * Somar os dois números recebido e retornar essa soma.

Podemos fazer isso desta forma:
```java
import java.util.function.BiFunction;

public class ExemploIFBiFunction {
    
    public static void main(String[] args) {
    
        BiFunction<Integer, Integer, Integer> calculaSoma = (valor1, valor2) -> valor1 + valor2;

        System.out.println(calculaSoma.apply(20, 30));
    
    }
    
}
```

#### Método andThen()
O método **andThen()** executa uma operação após o termino da execução do método **apply()**.
<br/>O valor que a função retorna é o valor processado no método **andThen()**<br/>

Seu funcionamento é semelhante ao do método **andThen()** da interface **Function**.

<br/>No exemplo abaixo iremos realizar a seguinte operação: 
 * Somar os 2 números inteiros recebidos como parâmetro.
 * Calcular e retornar a raiz quadrada dessa soma.
```java
import java.util.function.BiFunction;

public class ExemploIFBiFunction {
    
    public static void main(String[] args) {
    
        BiFunction<Integer, Integer, Integer> calculaSoma = (valor1, valor2) -> valor1 + valor2;
        BiFunction<Integer, Integer, Double> calculaRaizQuadradaDaSoma = calculaSoma.andThen(v -> Math.sqrt(v));

        System.out.println(calculaRaizQuadradaDaSoma.apply(40, 24));
    
    }
    
}
```
O resultado do exemplo acima irá imprimir o valor 8.0 referente a soma dos dois parâmetros recebidos e retornando a raiz quadrada dessa soma.


### Exercicio Interface Funcional Function
Através do seguinte código calcule a raiz quadrada do número informado e imprima o resultado no console:

```java
import java.util.function.Function;

public class ExercicioIFFunction {

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

### Exercício Interface Funcional BiFunction
Através do seguinte código realize as seguintes operações:
 * No primeiro BiFunction realize o cálculo da área de um retângulo.
 * No segundo BiFunction verifique se a área do retângulo é maior do que 100, você deve usar o primeiro BiFunction para criar o segundo.
 * Retorne true caso seja verdadeiro e false caso não seja.
```java
import java.util.function.BiFunction;

public class ExercicioIFBiFunction {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> areaRetangulo = ?????;
        BiFunction<Integer, Integer, Boolean> areaRetanguloMaiorQue100 = ?????;
        System.out.println("Área do retângulo maior que 100? " + areaRetanguloMaiorQue100.apply(21, 5));

    }

}
``` 

