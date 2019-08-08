## Introdução aos principais recursos do Java 11

### Material de preparação
[Novos métodos String API](https://www.baeldung.com/java-11-string-api)<br/>
[Classe Optional novo método isEmpty](https://dzone.com/articles/optionalisempty-available-in-jdk-11-ea-builds)<br/>
[Interface Collection método toArray](https://dzone.com/articles/jdk-11-new-default-collection-method-toarrayintfun)

### Introdução
Abordaremos neste laboratório os principais recursos introduzidos no Java 11.<br/>
Os recursos mais relevantes inseridos foram:
 * Novos métodos String API
 * Classe Optional novo método isEmpty()
 * Interface Collection adição método toArray
 * Uso tipo VAR em Lambdas
 

### Novos métodos String API
No Java 11 foram adicionados diversos métodos úteis para a API String, são eles:
 * repeat()
 * strip()
 * isBlank()
 * lines()
 
O método **repeat()** repete o conteúdo de uma String, seu retorno é a concatenação da string repetida n vezes, 
onde n é passado como um parâmetro.<br/>
Exemplo:
```java
String exemplo_1 = "La ".repeat(2) + "Land";
//Imprime: La La Land
System.out.println(exemplo_1);

String exemplo_2 = "Hello ".repeat(2) + "World!";
// Imprime: Hello Hello World!
System.out.println(exemplo_2);
```

O método **strip()** retorna uma string com todos os espaços em branco à esquerda e à direita removidos.<br/>
O Java 11 também incluiu os métodos stripLeading(), que remove os espaços em branco iniciais da String, e o método stripTrailing(), 
que remove os espaço em branco finais da String.<br/>
As diferenças entre os métodos **strip()** e **trim()** foram abordadas no material de preparação!<br/>
Exemplo de uso:<br/>
```java
String testeStrip = "    Hello    ";
// Imprime: Hello World!
System.out.println(testeStrip.strip() + " World!");

// Imprime: Hello     World!
System.out.println(testeStrip.stripLeading() + " World!");

// Imprime:     Hello World!
System.out.println(testeStrip.stripTrailing() + " World!");
```

O método **isBlank()** retorna true se a string estiver vazia ou se a mesma contiver apenas espaço em branco, caso contrário retorna false.<br/>
Exemplo de uso:<br/>
```java
String valorVazio = "";
String valorEmBranco = "          ";
String valorPreenchido = "Algum valor";

// Imprime: true
System.out.println(valorVazio.isBlank());

// Imprime: true
System.out.println(valorEmBranco.isBlank());

// Imprime: false
System.out.println(valorPreenchido.isBlank());
```

O método **lines()** retorna uma Stream com as linhas estraídas da String, usando como separador um terminador de linha, como por exemplo: “**\n**”, “**\r**”, ou “**\r\n**”.<br/>
Exemplo de uso:<br/>
```java
String stringMultilinha = "Linha 1 \nLinha 2 \nLinha 3 \nLinha 4";
Stream<String> streamStringMultilinha = stringMultilinha.lines();

streamStringMultilinha.forEach(l -> System.out.println(l));
```



### Classe Optional novo método isEmpty()
A classe Optional recebeu o método isEmpty() no Java 11, esse método basicamente verifica se o Optional está vazio, se não ouver valor presente 
no Optional ele retorna true, caso exista algum valor no Optional ele retorna false.<br/>
Exemplo de uso:<br/>
```java
import java.util.Optional;

public class Exemplo_2 {

    public static void main(String[] args) {
        Optional<String> optionalNulo = Optional.ofNullable(null);
        Optional<String> optionalPreenchido = Optional.ofNullable("Algum valor");

        // Retorna true
        System.out.println(String.format("Optional está vazio?: %s", optionalNulo.isEmpty()));
        
        // Retorna false
        System.out.println(String.format("Optional está vazio?: %s", optionalPreenchido.isEmpty()));
    }

}
```

### Interface Collection adição do método toArray
No Java 11 a interface Collection foi incrementada com o método default **toArray()**, o mesmo transforma uma coleção em um array do tipo 
especificado como parâmetro para este método.<br/>
Exemplo de uso:
```java
import java.util.Arrays;
import java.util.List;

public class Exemplo_3 {

    public static void main(String[] args) {
        List<String> listaNomes = List.of("Silvana", "Helena", "Mike", "John");
        String[] arrayNomes = listaNomes.toArray(String[]::new);
        System.out.println(Arrays.toString(arrayNomes));

        List<Integer> listaInteiros = List.of(1,2,3,4,5);
        Integer[] arrayInteiros = listaInteiros.toArray(Integer[]::new);
        System.out.println(Arrays.toString(arrayInteiros));
    }

}
``` 
