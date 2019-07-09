## Interface Funcional Supplier

### Material de Preparação
[Uso Interface Funcional Supplier com Exemplos](https://www.geeksforgeeks.org/supplier-interface-in-java-with-examples/)<br/>
[Vários exemplos de uso da Interface Funcional Supplier](https://www.programcreek.com/java-api-examples/?api=java.util.function.Supplier)

### Introdução
A Interface Funcional Supplier representa uma função que não aceita argumentos.<br/>
No entanto, esse tipo de função retorna um valor do tipo T(Valor generico baseado no que o Supplier recebeu em sua expressão Lambda).<br/>
A expressão lambda atribuída a um objeto do tipo Supplier é usada para definir o comportamento de seu método **get()**, que eventualmente realiza alguma operação e retorna um valor.

Exemplo de uso básico:
```java
import java.util.Date;
import java.util.function.Supplier;

public class Exemplo_1 {

    public static void main(String[] args) {
        Supplier<Date> dateSupplier = () -> new Date();
        Date today = dateSupplier.get();

        System.out.println("Today : "+today);
    }
}
```

#### Exercício
Com base no código abaixo crie um Supplier chamado **valorAleatorioSupplier** que retorne um valor aleatório do tipo Double.<br/>
Invoque esse Supplier e imprima o valor retornado por ele no console.
```java
import java.util.function.Supplier;

public class Exercicio_1 {
    public static void main(String[] args) {

    }
}
```