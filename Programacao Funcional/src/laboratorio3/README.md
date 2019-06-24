# Laboratório Interface Funcional BiFunction - Protótipo

### Material de Preparação
[Interface Funcional BiFunction](https://www.geeksforgeeks.org/java-bifunction-interface-methods-apply-and-addthen/)<br/>
[Vários exemplos de uso da Interface Funcional BiFunction](https://www.programcreek.com/java-api-examples/?api=java.util.function.Bifunction)

### Introdução
A Interface BiFunction representa uma função que aceita dois argumentos e produz um resultado.
Para criar uma BiFunction precisamos de 3 parâmetros em seu Diamond Operator(<>), são eles:
 * T : denota o tipo do primeiro argumento para a função
 * U : denota o tipo do segundo argumento para a função
 * R : indica o tipo de retorno da função
 
Sendo assim, essa é a estrutura de uma BiFunction:
<br/>BiFunction<T,U,R>

A interface BiFunction recebe dois argumento, realiza uma operação no mesmo e retorna o tipo especificado de dado após a execução da expressão lambda passada a ele.
<br/>As interfaces Function e BiFunction são bem semelhantes em seu método **apply()**, a única diferença entre eles é que o método **apply()** da BiFunction recebe dois parâmetros. 

Um exemplo básico do uso da interface BiFunction seria para realizar o calculo entre 2 números e especificando a operação que seria realizada entre eles através da expressão Lambda.
<br/>No exemplo abaixo iremos realizar a seguinte operação:
 * Somar os dois números recebido e retornar essa soma.
<br/>Podemos fazer isso desta forma:
```java
import java.util.function.BiFunction;

public class ExemploIFBiFunction {
    
    public static void main(String[] args) {
    
        BiFunction<Integer, Integer, Integer> calculaSoma = (valor1, valor2) -> valor1 + valor2;

        System.out.println(calculaSoma.apply(20, 30));
    
    }
    
}
```

### Método andThen()
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

### Exercício
Através do seguinte código realize as seguintes operações:
 * No primeiro BiFunction realize o cálculo da área de um retângulo.
 * No segundo BiFunction verifique se a área do retângulo é maior do que 100, você deve usar o primeiro BiFunction para criar o segundo.
 * Retorne true caso seja verdadeiro e false caso não seja.
```java
import java.util.function.BiFunction;

public class IFBiFunctionExercicio {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> areaRetangulo = ?????;
        BiFunction<Integer, Integer, Boolean> areaRetanguloMaiorQue100 = ?????;
        System.out.println("Área do retângulo maior que 100? " + areaRetanguloMaiorQue100.apply(21, 5));

    }

}
``` 
