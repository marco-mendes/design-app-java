## Interface Funcional Supplier

### Material de Preparação
[Uso Interface Funcional Supplier com Exemplos](https://www.geeksforgeeks.org/supplier-interface-in-java-with-examples/)<br/>
[Vários exemplos de uso da Interface Funcional Supplier](https://www.programcreek.com/java-api-examples/?api=java.util.function.Supplier)

### Introdução
A Interface Funcional Supplier representa uma função que não aceita argumentos.
<br/>No entanto, esse tipo de função retorna um valor do tipo T(Valor generico baseado no que o Supplier recebeu em sua expressão Lambda).
<br/>A expressão lambda atribuída a um objeto do tipo Supplier é usada para definir o comportamento de seu método **get()**, que eventualmente realiza alguma operação e retorna um valor.

Exemplo de uso básico:
<br/>Aqui temos um Supplier que recebe em sua expressão lambda para retornar a data atual.
```java
import java.util.Date;
import java.util.function.Supplier;

public class ExemploIFSupplier {

    public static void main(String[] args) {
        Supplier<Date> s = ()->new Date();
        Date today = s.get();

        System.out.println("Today : "+today);       
    }
}
```

### Exercício
Com base no código abaixo crie um Supplier que retorne um valor aleatório do tipo Double.

```java
import java.util.function.Supplier;

public class IFSupplierExercicio {
    public static void main(String[] args) {
        Supplier<Double> valorAleatorio = ????;
        System.out.println(valorAleatorio.get());
    }
}
```