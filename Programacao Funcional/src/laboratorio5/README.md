# Laboratório Interface Funcional Supplier - Protótipo

### Material de Preparação
[Uso Interface Funcional Supplier com Exemplos](https://www.geeksforgeeks.org/supplier-interface-in-java-with-examples/)

### Introdução
A Interface Funcional Supplier representa uma função que não aceita argumentos.
<br/>No entanto, esse tipo de função retorna um valor do tipo T(Valor generico baseado no que o Supplier recebeu em sua expressão Lambda).
<br/>A expressão lambda atribuída a um objeto do tipo Supplier é usada para definir o comportamento de seu método **get()**, que eventualmente realiza alguma operação e retorna um valor.

Exemplo de uso básico:
Aqui temos um Supplier que recebe em sua expressão lambda um número randômico.
```java
import java.util.function.Supplier;

public class ExemploIFSupplier {

    public static void main(String[] args) {
        Supplier<Double> valorAleatorio = () -> Math.random();
        System.out.println(valorAleatorio.get());
    }
}
```

