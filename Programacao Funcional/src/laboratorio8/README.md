# Laboratório Interface Funcional BinaryOperator - Protótipo

### Material de Preparação
[Uso Interface Funcional BinaryOperator com Exemplos](https://www.geeksforgeeks.org/binaryoperator-interface-in-java/)<br/>
[Vários exemplos de uso da Interface Funcional BinaryOperator](https://www.programcreek.com/java-api-examples/?api=java.util.function.BinaryOperator)

### Introdução
A Interface Funcional **BinaryOperator** faz parte do grupo de Interfaces Funcionais do tipo **Operator**.
<br/>As interfaces do tipo **Operator** são casos especiais de uma função, a diferença é que as Interfaces do tipo Operator recebem e retornam o mesmo tipo de valor.

<br/>O **BinaryOperator <T&gt;** estende o tipo **BiFunction <T, T, T>** e com isso herda os seguintes métodos da interface funcional de **BiFunction**:
 * apply()
 * andThen()
 
O uso de cada um desses é abordado no [Laboratório 3](https://github.com/corelioBH/design-app-java/tree/master/Programacao%20Funcional/src/laboratorio3).
<br/>Exemplos de uso dos mesmos com BinaryOperator podem ser observados nos materias de preparação.

O que distingue um **BinaryOperator** de um **BiFunction** normal é que ambos os seus argumentos e seu tipo de retorno são os mesmos.

Exemplo de uso básico do **BinaryOperator**:
<br/>Suponhamos que queremos criar um BinaryOperator para somar 2 números e retornar o valor dessa soma.
<br/>Podemos fazer isso dessa forma:
```java
import java.util.function.BinaryOperator;

public class ExemploIFBinaryOperator {

    public static void main(String[] args) {
        BinaryOperator<Integer> somaNumeros = (a, b) -> a + b;
        System.out.println(somaNumeros.apply(5,5));
    }
    
}
```

### Outros métodos do BinaryOperator
Além dos métodos herdados da interface **BiFunction**, a interface **BinaryOperator** possui dois métodos estáticos que podemos usar, são eles:
 * maxBy()
 * minBy()
 
### Método estático maxBy()
Esse metodo retorna um **BinaryOperator** que retorna o maior dos dois elementos com base em um **Comparator**.
<br/>Exemplo de uso:
```java
import java.util.function.BinaryOperator;

public class ExemploIFBinaryOperator {

    public static void main(String[] args) {

        BinaryOperator<Integer> maiorNumero = BinaryOperator.maxBy((a, b) -> a.compareTo(b));
        System.out.println(maiorNumero.apply(48, 6));

    }
    
}
```

### Método estático minBy()
Esse metodo retorna um BinaryOperator que retorna o menor dos dois elementos com base em um **Comparator**.
<br/>Exemplo de uso:
```java
import java.util.function.BinaryOperator;

public class ExemploIFBinaryOperator {

    public static void main(String[] args) {

        BinaryOperator<Integer> menorNumero = BinaryOperator.minBy((a, b) -> a.compareTo(b));
        System.out.println(menorNumero.apply(18, 60));

    }
    
}
```

### Exercício
Com base no código abaixo altere o BinaryOperator para retornar a raiz quadrada da subtração dos números informados no método **apply()**.
```java
import java.util.function.BinaryOperator;

public class IFBinaryOperatorExercicio {

    public static void main(String[] args) {

        BinaryOperator<Double> obtemRaizQuadradaDaSubtracao = ?????;
        System.out.println(obtemRaizQuadradaDaSubtracao.apply(70.0, 6.0));
        
    }

}
```