## Funções Puras e Funções de Ordem Superior em Java

### Material de Referência
[Funções Puras e Impuras](https://tableless.com.br/o-que-sao-funcoes-puras/)<br/>
[Funções de ordem superior](http://tutorials.jenkov.com/java-functional-programming/higher-order-functions.html)

### Introdução
Neste laboratório abordaremos o uso de **Funções Puras** e **Funções de Ordem Superior** em Java com alguns exemplos.

### Funções Puras
Funções puras são funções que dado um determinado parâmetro sempre vão retornar o mesmo valor sem causar efeitos fora do escopo da função.<br/>
Abordamos no Laboratório 1 algumas características básicas de funções puras como:<br/>
 * Retorna sempre o mesmo resultado quando passados os mesmos parâmetros
 * Depende unicamente dos argumentos passados
 * Não produz efeitos colaterais (side effects)

Exemplo de funções puras utilizando a interface Function:
```java
Function<Double, Double> calculaAreaCirculo = (raio) -> Math.PI * (Math.pow(raio, 2));
System.out.println(calculaAreaCirculo.apply(5.0));
```
Neste exemplo estamos dependendo únicamente dos valores internos de nossa expressão Lambda, com isso podemos considerar essa funções como uma função pura.



### Funções de Ordem Superior
Uma função de ordem superior pode ser considerado como uma função ou método que usa uma função como parâmetro ou retorna uma função após sua execução.<br/>
Exemplo:
```java
import java.util.function.Function;

public class ExemploFuncoesOrdemSuperior {

    public static void main(String[] args) {

        Function<Integer, Double> obtemValorAoQuadrado = (value) -> Math.pow(value, 2);
        System.out.println("Valor ao quadrado: " + calcular(5, obtemValorAoQuadrado));

        System.out.println("Valor ao cubo: " + calcular(5, (value) -> Math.pow(value, 3)));

    }

    public static Double calcular(Integer valor, Function<Integer, Double> operacao){

        return operacao.apply(valor);

    }
    
}
```
Acima vimos um exemplo de função de ordem superior no método **calcular**, onde o mesmo recebe uma função como parâmetro para realizar algum calculo em um número.


### Exercício Função Pura
Com base no código abaixo faça com que a função **multiplicaNumeroPor2** se torne uma função pura novamente
```java
import java.util.function.Function;

public class ExercicioFuncoesPuras {

    public static void main(String[] args) {

        Integer multiplicador = 2;
        Function<Integer, Integer> multiplicaNumeroPor2 = (numero) -> numero * multiplicador;
        System.out.println(multiplicaNumeroPor2.apply(5));

    }

}
```

### Exercício Funções de Ordem Superior
Crie um método chamado **calcular** que receba 3 parâmetros.<br/>
Os dois primeiros parâmetros devem ser números inteiros e o terceiro parâmetro deve receber uma BiFunction.

Ao invocar este método passe como parâmetro uma BiFunction que irá multiplicar os 2 numeros recebidos no método.<br/>
Após executar o método **calcular** imprima no console o valor retornado.<br/>
Código base:
```java
public class ExercicioFuncoesOrdemSuperior {

    public static void main(String[] args) {

    }

}

```