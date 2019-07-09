## Interface Funcional Consumer

### Material de Preparação
[Uso Interface Funcional Consumer com Exemplos](https://www.geeksforgeeks.org/java-8-consumer-interface-in-java-with-examples/)<br/>
[Vários exemplos de uso da Interface Funcional Consumer](https://www.programcreek.com/java-api-examples/?api=java.util.function.Consumer)

### Introdução
A Interface Funcional Consumer representa uma função que aceita um argumento e produz um resultado.
<br/>No entanto, esse tipo de função não retorna nenhum valor.
<br/>A expressão lambda atribuída a um objeto do tipo Consumer é usada para definir o comportamento de seu método **accept()**, que eventualmente aplica a operação atribuída ao Consumer em seu argumento.
<br/>A interface Consumer é útil quando não precisamos retornar nenhum valor, pois a mesma funciona via efeitos colaterais.

Exemplo de uso básico:<br/>
```java
import java.util.function.Consumer;

public class Exemplo_1 {

    public static void main(String[] args) {
        Consumer<Integer> display = n -> System.out.println(String.format("Imprimindo número: %s", n));
        display.accept(5);
    }
}
```
Temos aqui um consumer que recebe um número e imprime uma mensagem com o número recebido.<br/>

Outro exemplo do uso de um Consumer está dentro do método forEach da interface List, podemos passar a ele uma expressão lambda ou um Consumer como no exemplo abaixo:
```java
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Exemplo_2 {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,3,4,5);
        Consumer<Integer> display = n -> System.out.println(String.format("Imprimindo número: %s", n));
        integerList.forEach(display);
    }
}
```

#### Exercicio 1
Com base no código abaixo crie um Consumer chamado **imprimeCelularConsumer** que recebe um objeto do tipo **Celular** e executa o método **imprimeCelular()** do objeto recebido.<br/>
Após isso execute o consumer criado utilizando cada um dos objetos Celular criados no código base.
```java
import java.util.function.Consumer;

public class Exercicio_1 {

    public static void main(String[] args) {

        Celular c1 = new Celular("J5 Prime", "Samsung", "Preto");
        Celular c2 = new Celular("Mi 9", "Xiaomi", "Azul");
        Celular c3 = new Celular("G7", "LG", "Cinza");

    }

}

class Celular {

    String modelo;
    String marca;
    String cor;

    public Celular(String modelo, String marca, String cor) {
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getCor() {
        return cor;
    }

    public void imprimeCelular(){
        System.out.println(String.format("Modelo: %s | Marca: %s | Cor: %s", this.modelo, this.marca, this.cor));
    }

}
```

### Método andThen()
Outro método da Interface Funcional Consumer é o método **andThen()**, ele recebe uma expressão lambda ou um Consumer como parâmetro.<br/>
Seu comportamento é bem semelhante ao método **andThen** da **Interface Funcional Function**, a diferença é que este método não retorna nenhum valor.

Exemplo de uso:
```java
import java.util.function.Consumer;

public class Exemplo_3 {

    public static void main(String[] args) {
        Consumer<Integer> imprime = n -> System.out.println("Imprimindo número: " + n);
        Consumer<Integer> verificaNumeroPar = imprime.andThen(i -> {
            if(i % 2 == 0){
                System.out.println(String.format("O número %d é um número par", i));
            } else {
                System.out.println(String.format("O número %d não é um número par", i));
            }
        });
        verificaNumeroPar.accept(4);
        verificaNumeroPar.accept(7);
    }

}
```

### Exercício 2
Como base no código abaixo altere os Consumers presentes no exercício para atenderem as seguintes condições:
 * O **consumerImprimeNome** deve imprimir o atributo nome da instância do objeto pessoa.
 * O **consumerImprimeNomeEIdade** deve imprimir os atributos nome e idade da instância do objeto pessoa.
 * O **consumerImprimeNomeEIdade** deve ser criado usando como base o consumerImprimeNome. 
```java
import java.util.function.Consumer;

public class Exercicio_2 {

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