# Laboratório Interface Funcional UnaryOperator - Protótipo

### Material de Preparação
[Uso Interface Funcional UnaryOperator com Exemplos](https://www.geeksforgeeks.org/unaryoperator-interface-in-java/)<br/>
[Vários exemplos de uso da Interface Funcional UnaryOperator](https://www.programcreek.com/java-api-examples/?api=java.util.function.UnaryOperator)

### Introdução
A Interface Funcional UnaryOperator faz parte do grupo de Interfaces Funcionais do tipo Operator.
<br/>As interfaces do tipo **Operator** são casos especiais de uma função, a diferença é que as Interfaces do tipo Operator recebem e retornam o mesmo tipo de valor.

Abordaremos nesse Laboratório e no [Laboratório 8](https://github.com/corelioBH/design-app-java/tree/master/Programacao%20Funcional/src/laboratorio8/) as duas principais Interfaces Funcionais do tipo Operator que são a **UnaryOperator** e **BinaryOperator**.

Também existem especializações de UnaryOperator e BinaryOperator que podem ser usadas com valores primitivos, como [DoubleUnaryOperator](https://www.geeksforgeeks.org/doubleunaryoperator-interface-in-java/) , [IntUnaryOperator](https://www.geeksforgeeks.org/intunaryoperator-interface-in-java/) , [LongUnaryOperator](https://www.geeksforgeeks.org/longunaryoperator-interface-in-java/) , [DoubleBinaryOperator](https://docs.oracle.com/javase/8/docs/api/java/util/function/DoubleBinaryOperator.html) , [IntBinaryOperator](https://docs.oracle.com/javase/8/docs/api/java/util/function/IntBinaryOperator.html) e [LongBinaryOperator](https://docs.oracle.com/javase/8/docs/api/java/util/function/LongBinaryOperator.html) porém não abordaremos o uso de cada uma delas nesses Laboratórios.

<br/>O UnaryOperator<T&gt; sobrecarrega o tipo Function<T, T> e com isso herdando os seguintes métodos da interface funcional Function:
 * apply()
 * andThen()
 * compose()

O uso de cada um desses é abordado no [Laboratório 2](https://github.com/corelioBH/design-app-java/tree/master/Programacao%20Funcional/src/laboratorio2).
<br/>Exemplos de uso dos mesmos com UnaryOperator podem ser observados nos materias de preparação.

Exemplo de uso básico do UnaryOperator:
<br/>Suponhamos que queremos criar um UnaryOperator para extrair a raiz quadrada de um número.
<br/>Podemos fazer isso dessa forma:
```java
import java.util.function.UnaryOperator;

public class ExemploIFUnaryOperator {

    public static void main(String[] args) {

        UnaryOperator<Double> obtemRaizQuadrada = (valor) -> Math.sqrt(valor);
        System.out.println("Raiz Quadrada: " + obtemRaizQuadrada.apply(25.0));

    }

}
```

### Exercício
Com base no código abaixo crie um UnaryOperator que deve receber um valor do tipo Double referente ao valor de uma mercadoria.
<br/>Você deve aplicar sobre este valor um imposto de 10% retornando assim o valor da mercadoria com o valor do imposto já incluído.
```java
import java.util.function.UnaryOperator;

public class ExemploIFUnaryOperator {

    public static void main(String[] args) {

        UnaryOperator<Double> aplicaImposto = ????;
        Double valorMercadoria = 2500.00;
        System.out.println("Valor total mercadoria com imposto: " + aplicaImposto.apply(valorMercadoria));

    }

}
```