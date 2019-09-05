## Funções Puras e Funções de Ordem Superior em Java

### Material de Referência
[Funções Puras e Impuras](https://tableless.com.br/o-que-sao-funcoes-puras/)<br/>
[Funções de ordem superior](http://tutorials.jenkov.com/java-functional-programming/higher-order-functions.html)

### Introdução
Neste laboratório abordaremos o uso de **Funções Puras** e **Funções de Ordem Superior** em Java com alguns exemplos.

### Funções Puras
Funções puras são funções que dado um determinado parâmetro sempre vão retornar o mesmo valor sem causar efeitos fora do escopo da função.<br/>
Algumas características básicas de funções puras são:<br/>
 * Retorna sempre o mesmo resultado quando passados os mesmos parâmetros
 * Depende unicamente dos argumentos passados
 * Não produz efeitos colaterais (side effects)

Exemplo de funções puras utilizando a interface Function:
```java
import java.util.function.Function;

public class Exemplo_1 {

    public static void main(String[] args) {
        Function<Double, Double> calculaAreaCirculo = (raio) -> Math.PI * (Math.pow(raio, 2));
        System.out.println(calculaAreaCirculo.apply(5.0));
    }

}
```
Neste exemplo estamos dependendo únicamente dos valores internos de nossa expressão Lambda, com isso podemos considerar essa função como uma função pura.


#### Exercício 1
Com base no código abaixo faça com que a função **multiplicaNumeroPor2** se torne uma função pura novamente
```java
import java.util.function.Function;

public class Exercicio_1 {

    public static void main(String[] args) {

        Integer multiplicador = 2;
        Function<Integer, Integer> multiplicaNumeroPor2 = (numero) -> numero * multiplicador;
        System.out.println(multiplicaNumeroPor2.apply(5));

    }

}
```


### Funções de Ordem Superior
Uma função de ordem superior pode ser considerada como uma função ou método que utiliza uma função como parâmetro ou retorna uma função após sua execução.<br/>
Exemplo:
```java
import java.util.function.Function;

public class Exemplo_2 {

    public static Double calcular(Integer valor, Function<Integer, Double> operacao){

        return operacao.apply(valor);

    }

    public static void main(String[] args) {

        Function<Integer, Double> obtemValorAoQuadrado = (value) -> Math.pow(value, 2);
        Function<Integer, Double> obtemValorAoCubo = (value) -> Math.pow(value, 3);

        System.out.println(
                String.format("Valor ao quadrado: %s", calcular(5, obtemValorAoQuadrado))
        );

        System.out.println(
                String.format("Valor ao cubo: %s", calcular(5, obtemValorAoCubo))
        );

    }

}
```
Neste exemplo possuímos uma função de ordem superior no método **calcular**, onde o mesmo recebe uma função como parâmetro para realizar algum cálculo em um número.




#### Exercício 2
Crie um método chamado **calcular** que receba 3 parâmetros.<br/>
Os dois primeiros parâmetros devem ser números inteiros e o terceiro parâmetro deve receber uma BiFunction.

Ao invocar este método passe como parâmetro uma BiFunction que irá multiplicar os 2 numeros recebidos no método **calcular**.<br/>
Após executar o método criado imprima no console o valor retornado.<br/>
Código base:
```java
public class Exercicio_2 {

    public static void main(String[] args) {

    }

}
```