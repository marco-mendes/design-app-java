## Novos métodos classe Optional

### Material de preparação
[Melhorias classe Optional](https://www.baeldung.com/java-9-optional)

### Introdução
No Java 9 a classe **Optional** recebeu novos métodos, são eles: **or()**, **ifPresentOrElse()** e **stream()**.<br/>
Abordaremos brevemente o uso deles

### Método or()
Basicamente este método irá retornar outro Optional caso nosso Optional esteja vazio.<br/>
Exemplo de uso:
```java
import java.util.Optional;

public class Exemplo_1 {

    public static void main(String[] args) {
        Optional<String> optionalVazio = Optional.empty();
        Optional<String> optionalDefault = Optional.of("Valor default");

        Optional<String> resultado = optionalVazio.or(() -> optionalDefault);
        System.out.println(resultado.get());
    }

}
```


### Método ifPresentOrElse()
Basicamente esté método irá verificar se existe um valor presente no Optional, caso exista podemos especificar uma ação a ser realizada com o valor do Optional, 
caso contrário podemos passar uma expressão Lambda sem parâmetros para executar alguma ação. 
Exemplo de uso:
```java
import java.util.Optional;

public class Exemplo_2 {

    public static void main(String[] args) {
        Optional<Pessoa> optionalComValor = Optional.ofNullable(new Pessoa("João", 30));
        Optional<Pessoa> optionalSemValor = Optional.ofNullable(null);

        optionalComValor.ifPresentOrElse(p -> p.imprimePessoa(), () -> System.out.println("Este Optional de Pessoa está vazio"));
        optionalSemValor.ifPresentOrElse(p -> p.imprimePessoa(), () -> System.out.println("Este Optional de Pessoa está vazio"));

    }

}

class Pessoa {

    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void imprimePessoa() {
        System.out.println(String.format("Nome: %s, Idade: %s", this.nome, this.idade));
    }

}
```

#### Exercício 1
Com base no código abaixo realize a seguinte operação com o método ifPresentOrElse nas duas instâncias Optional de carro presentes no exercício:
 * Caso exista algo no Optional invoque o método imprimeCarro
 * Caso não exista algo no Optional imprima a seguinte mensagem: "Modelo não cadastrado!"
```java
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Exercicio_1 {

    public static void main(String[] args) {
        Optional<Carro> carro1 = Carro.buscarCarroPorModelo("Palio");
        Optional<Carro> carro2 = Carro.buscarCarroPorModelo("Siena");

    }

}

class Carro {
    private String modelo;
    private String marca;

    public Carro(String modelo, String marca) {
        this.modelo = modelo;
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public static Optional<Carro> buscarCarroPorModelo(String modelo) {
        List<Carro> listaCarros = Arrays.asList(
                new Carro("Palio", "Fiat"),
                new Carro("Gol", "Volkswagen"),
                new Carro("Versa", "Nissan")
        );

        Optional<Carro> resultado = listaCarros.stream().filter(carro -> carro.getModelo().equals(modelo)).findFirst();
        return resultado;
    }

    public void imprimeCarro() {
        System.out.println(String.format("Carro modelo: %s, Marca: %s", this.modelo, this.marca));
    }

}
```

### Método stream()
Este método nos permite transformar um Optional em um Stream, dessa forma nos permitindo realizar o processamento do mesmo como sendo um Stream.<br/>
Exemplo de uso:
```java
import java.util.Optional;
import java.util.stream.Stream;

public class Exemplo_3 {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("Algum valor");
        Stream<String> optionalConvertidoEmStream = optional.stream();
        optionalConvertidoEmStream.forEach(v -> System.out.println(v));
    }

}
```
