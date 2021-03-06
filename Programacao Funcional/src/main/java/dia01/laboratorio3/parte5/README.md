## Interfaces Funcionais UnaryOperator e BinaryOperator

### Introdução Geral
Abordaremos aqui as duas principais Interfaces Funcionais do tipo **Operator**, são elas:
 * UnaryOperator
 * BinaryOperator

As interfaces do tipo **Operator** são casos especiais de uma função, a diferença é que as Interfaces do tipo Operator recebem e retornam o mesmo tipo de valor.
 
Também existem especializações de UnaryOperator e BinaryOperator que podem ser usadas com valores primitivos, como:
 * [DoubleUnaryOperator](https://www.geeksforgeeks.org/doubleunaryoperator-interface-in-java/)
 * [IntUnaryOperator](https://www.geeksforgeeks.org/intunaryoperator-interface-in-java/)
 * [LongUnaryOperator](https://www.geeksforgeeks.org/longunaryoperator-interface-in-java/)
 * [DoubleBinaryOperator](https://docs.oracle.com/javase/8/docs/api/java/util/function/DoubleBinaryOperator.html)
 * [IntBinaryOperator](https://docs.oracle.com/javase/8/docs/api/java/util/function/IntBinaryOperator.html)
 * [LongBinaryOperator](https://docs.oracle.com/javase/8/docs/api/java/util/function/LongBinaryOperator.html)
  
Não abordaremos o uso de cada uma delas nesse Laboratório, caso queira saber mais basta acessar os links de referência acima.
 
 
### Material de Preparação
[Uso Interface Funcional UnaryOperator com Exemplos](https://www.geeksforgeeks.org/unaryoperator-interface-in-java/)<br/>
[Vários exemplos de uso da Interface Funcional UnaryOperator](https://www.programcreek.com/java-api-examples/?api=java.util.function.UnaryOperator)<br/>
[Uso Interface Funcional BinaryOperator com Exemplos](https://www.geeksforgeeks.org/binaryoperator-interface-in-java/)<br/>
[Vários exemplos de uso da Interface Funcional BinaryOperator](https://www.programcreek.com/java-api-examples/?api=java.util.function.BinaryOperator)

### Introdução Interface Funcional UnaryOperator
A Interface Funcional UnaryOperator faz parte do grupo de Interfaces Funcionais do tipo Operator.<br/>
O UnaryOperator<T&gt; sobrecarrega o tipo Function<T, T> e com isso herdando os seguintes métodos da interface funcional Function:
 * apply()
 * andThen()
 * compose()

O uso de cada um desses métodos é abordado na [parte 1 desse laboratório](../parte1).<br/>
Exemplos de uso dos mesmos com UnaryOperator podem ser observados nos materias de preparação.

Exemplo de uso básico do UnaryOperator:
```java
import java.util.function.UnaryOperator;

public class Exemplo_1 {

    public static void main(String[] args) {

        UnaryOperator<Double> obtemRaizQuadrada = (valor) -> Math.sqrt(valor);
        System.out.println(String.format("Raiz Quadrada: %s", obtemRaizQuadrada.apply(25.0)));

    }

}
```

#### Exercício 1
Com base no código abaixo crie um UnaryOperator que deve receber um valor do tipo Double referente ao valor de uma mercadoria.<br/>
Você deve aplicar sobre este valor um imposto de 10% retornando assim o valor da mercadoria com o valor do imposto já incluído.
```java
import java.util.function.UnaryOperator;

public class Exercicio_1 {

    public static void main(String[] args) {

        UnaryOperator<Double> aplicaImposto = ????;
        Double valorMercadoria = 2500.00;
        System.out.println(String.format("Valor total mercadoria com imposto: %s", aplicaImposto.apply(valorMercadoria)));

    }

}
```

### Introdução Interface Funcional BinaryOperator
A Interface Funcional **BinaryOperator** faz parte do grupo de Interfaces Funcionais do tipo **Operator**.

O **BinaryOperator <T&gt;** estende o tipo **BiFunction <T, T, T>** e com isso herdando os seguintes métodos da interface funcional **BiFunction**:
 * apply()
 * andThen()
 
O uso de cada um desses métodos é abordado na [parte 1 desse laboratório](../parte1).<br/>
Exemplos de uso dos mesmos com BinaryOperator podem ser observados nos materias de preparação.

O que distingue um **BinaryOperator** de um **BiFunction** normal é que ambos os seus argumentos e seu tipo de retorno são os mesmos.

Exemplo de uso básico do **BinaryOperator**:
```java
import java.util.function.BinaryOperator;

public class Exemplo_2 {

    public static void main(String[] args) {
        BinaryOperator<Integer> somaNumeros = (a, b) -> a + b;
        System.out.println(somaNumeros.apply(5,5));
    }
    
}
```

#### Exercício 2
Com base no código abaixo altere o BinaryOperator para retornar a raiz quadrada da subtração dos números informados no método apply().
```java
import java.util.function.BinaryOperator;

public class Exercicio_2 {

    public static void main(String[] args) {

        BinaryOperator<Double> obtemRaizQuadradaDaSubtracao = ?????;
        System.out.println(obtemRaizQuadradaDaSubtracao.apply(70.0, 6.0));
        
    }

}
```

#### Outros métodos do BinaryOperator
Além dos métodos herdados da interface **BiFunction**, a interface **BinaryOperator** possui dois métodos estáticos que podemos usar, são eles:
 * maxBy()
 * minBy()
 
#### Método estático maxBy()
Esse metodo retorna um **BinaryOperator** que retorna o maior dos dois elementos com base em um **Comparator**.
<br/>Exemplo de uso:
```java
import java.util.function.BinaryOperator;

public class Exemplo_3 {

    public static void main(String[] args) {

        BinaryOperator<Integer> maiorNumero = BinaryOperator.maxBy((a, b) -> a.compareTo(b));
        System.out.println(maiorNumero.apply(48, 6));

    }
    
}
```

#### Método estático minBy()
Esse metodo retorna um BinaryOperator que retorna o menor dos dois elementos com base em um **Comparator**.
<br/>Exemplo de uso:
```java
import java.util.function.BinaryOperator;

public class Exemplo_4 {

    public static void main(String[] args) {

        BinaryOperator<Integer> menorNumero = BinaryOperator.minBy((a, b) -> a.compareTo(b));
        System.out.println(menorNumero.apply(18, 60));

    }
    
}
```

#### Exercício 3
Com base no código abaixo siga os seguintes passos:
 * Crie um BinaryOperator chamado **produtoMaisBarato**, o mesmo deve verificar qual dos dois produtos é o mais barato.<br/>
 * Crie um BinaryOperator chamado **produtoMaisCaro**, o mesmo deve verificar qual dos dois produtos é o mais caro.<br/>
 * Utilize os métodos estáticos **maxBy** e **minBy** para criar esses 2 BinaryOperator.
 * Invoque cada um dos BinaryOperator utilizando os 2 objetos do tipo produto já criados e imprima no console o resultado de cada invocação.
 
_Dica: O Diamond Operator do BinaryOperator deve utilizar um objeto do tipo Produto._
 
```java
import java.util.function.BinaryOperator;

public class Exercicio_3 {

    public static void main(String[] args) {

        Produto produto1 = new Produto("Celular Galaxy J5 Prime", 899.00);
        Produto produto2 = new Produto("Xiaomi Mi 8", 1999.00);
        
    }

}

class Produto {

    String nome;
    Double preco;

    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }
}
```
