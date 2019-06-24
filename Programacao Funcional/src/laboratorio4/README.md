# Laboratório Interface Funcional Consumer - Protótipo

### Material de Preparação
[Uso Interface Funcional Consumer com Exemplos](https://www.geeksforgeeks.org/java-8-consumer-interface-in-java-with-examples/)<br/>
[Vários exemplos de uso da Interface Funcional Consumer](https://www.programcreek.com/java-api-examples/?api=java.util.function.Consumer)

### Introdução
A Interface Funcional Consumer representa uma função que aceita um argumento e produz um resultado.
<br/>No entanto, esse tipo de função não retorna nenhum valor.
<br/>A expressão lambda atribuída a um objeto do tipo Consumer é usada para definir o comportamento de seu método **accept()**, que eventualmente aplica a operação atribuída ao Consumer em seu argumento.
<br/>A interface Consumer é útil quando não precisamos retornar nenhum valor, pois a mesma funciona via efeitos colaterais.

Exemplo de uso básico:
Temos aqui um consumer que recebe um número e imprime uma mensagem com o número recebido.
```java
import java.util.function.Consumer;

public class ExemploIFConsumer {

    public static void main(String[] args) {
        Consumer<Integer> display = n -> System.out.println("Imprimindo número: " + n);
        display.accept(5);
    }
}
```

Outro exemplo do uso de um Consumer está dentro do método forEach da interface List, podemos passar a ele uma expressão lambda referente a um Consumer como no exemplo abaixo:
```java
import java.util.function.Consumer;

public class ExemploIFConsumer {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,3,4,5);
        integerList.forEach(n -> System.out.println(n));
    }
}
```

### Método andThen()
Outro método da Interface Funcional Consumer é o método **andThen()**, ele recebe uma expressão lambda ou um Consumer como parâmetro.
<br/>Seu funcionamento ocorre da seguinte forma:
 * Primeiro executa o método **accept()** com o comportamento definido para o Consumer.
 * Em seguida executa o comportamento inserido no método **andThen()**.

Exemplo de uso:
<br/>Suponhamos que queremos receber um número, imprimir esse número e em seguida verificar se o mesmo é um número par. 
<br/>Podemos fazer isso desta forma:
```java
Consumer<Integer> imprime = n -> System.out.println("Imprimindo número: " + n);
Consumer<Integer> verificaNumeroPar = imprime.andThen(i -> {
    if(i % 2 == 0){
        System.out.println("O número " + i + " é um número par");
    } else {
        System.out.println("O número " + i + " não é um número par");
    }
});
verificaNumeroPar.accept(4);
verificaNumeroPar.accept(7);
```

### Exercício
Como base no código abaixo altere os Consumers presentes no exercício para atenderem as seguintes condições:
 * O consumerImprimeNome deve imprimir o atributo nome da instância do objeto pessoa.
 * O consumerImprimeNomeEIdade deve imprimir os atributos nome e idade da instância do objeto pessoa.
 * O consumerImprimeNomeEIdade deve ser criado usando como base o consumerImprimeNome. 
```java
import java.util.function.Consumer;

public class IFConsumerExercicio {

    public static void main(String[] args) {

        // A resolver
        Consumer<Pessoa> consumerImprimeNome = ??? -> ???;
        Consumer<Pessoa> consumerImprimeNomeEIdade = ??? -> ???;

        Pessoa p = new Pessoa("João", 32);

        consumerImprimeNomeEIdade.accept(p);
    }

}

class Pessoa {

    String nome;
    int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

}
```