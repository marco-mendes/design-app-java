## Introdução aos principais recursos do Java 10

### Material de preparação
[Visão geral Java 10](https://www.baeldung.com/java-10-overview)<br/>
[Inferência de tipos com o tipo var](https://www.baeldung.com/java-10-local-variable-type-inference)<br/>

### Introdução
Abordaremos neste laboratório os principais recursos introduzidos no Java 10.<br/>
Os recursos mais relevantes inseridos foram:
 * Inferencia de tipos em variáveis com o novo tipo **var**
 * Melhorias Coleções imutáveis
 * Optionals novo método orElseThrow()
 
### Introdução ao tipo var
No Java 10 foi inserido um novo tipo, o tipo **var**.
Com ele podemos declarar uma variável local sem especificar o seu tipo, dessa forma o compilador fica responsável por inferir o tipo correto a variável 
com base no valor atribuído a ela.<br/>
Observações: 
 * É obrigatório inicializar uma variável do tipo **var** assim que ela for declarada.
 * Variáveis desse tipo não podem ser usadas como parâmetro de método.

Exemplo de uso:
```java
public class Exemplo_1 {

    public static void main(String[] args) {
        var valorInteiro = 10;
        System.out.println(valorInteiro);
        

        var valorString = "Valor em String";
        System.out.println(valorString.toUpperCase());
    }

}
```

#### Exercício 1
Com base no código acima crie duas variáveis do tipo var, na primeria atribua um valor do tipo Double, na segunda atribua um valor do tipo 
Boolean.

### Melhorias coleções imutáveis método copyOf()
No Java 10 foi introduzido o método copyOf() nas interfaces List, Map e Set.<br/>
Este método básicamente serve para criar uma nova coleção imutável com base nos valores de uma coleção imutável já existente.<br/>
Exemplo de uso:
```java
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Exemplo_2 {

    public static void main(String[] args) {
        List<String> listaImutavel = List.of("Valor 1", "Valor 2");
        List<String> copiaListaImutavel = List.copyOf(listaImutavel);
        System.out.println(copiaListaImutavel);

        Set<String> setImutavel = Set.of("Valor 1", "Valor 2");
        Set<String> copiaSetImutavel = Set.copyOf(setImutavel);
        System.out.println(copiaSetImutavel);

        Map<String, String> mapImutavel = Map.of("Chave 1", "Valor 1", "Chave 2", "Valor 2");
        Map<String, String> copiaMapImutavel = Map.copyOf(mapImutavel);
        System.out.println(copiaMapImutavel);
    }

}
```

### Melhorias coleções imutáveis método Collectors.toUnmodifiable*()
No Java 10 foi adicionada a possibilidade de transformar uma Stream em uma coleção imutável, isso pode ser feito para os tipos **List**, **Set** e **Map** 
através dos métodos **toUnmodifiableList()**, **toUnmodifiableSet()** e **toUnmodifiableMap()** da classe **Collectors**.<br/>
Exemplo:
```java
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exemplo_3 {

    public static void main(String[] args) {
        Stream<String> valores = Stream.of("Valor 1", "Valor 2", "Valor 3");

        List<String> listaImutavel = valores.collect(Collectors.toUnmodifiableList());
        System.out.println(listaImutavel);
    }

}
```
No exemplo acima transfomamos uma Stream em uma lista Imutável.<br/>
Para executar a mesma operação para as coleções Set e Map basta alterar o tipo de variável e alterar o método toUnmodifiableList() para o método 
adequado a qual tipo de coleção imutável o Stream será transformado.

#### Exercício 2
Com base no código abaixo Transforme o Stream de Inteiros em um Set imutável de Inteiros.
```java
import java.util.Set;
import java.util.stream.Stream;

public class Exercicio_2 {

    public static void main(String[] args) {
        Stream<Integer> streamDeInteiros = Stream.of(1, 2, 3, 4, 5);
    }

}
```

### Optionals método orElseThrow()
As classes Optional , OptionalDouble , OptionalInt e OptionalLong receberam um novo método chamado orElseThrow(), o mesmo não aceita nenhum argumento.<br/>
Caso o Optional possua algum valor este método irá retornar o valor presente no Optional, caso contrário lança uma exception do tipo NoSuchElementException<br/>
Exemplo de uso:
```java
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Exemplo_4 {

    public static void exemploValorPresente() {
        List<String> listaNomes = Arrays.asList("João", "Maria", "Carlos", "Elsa", "Roberto");

        Optional<String> resultadoOptional = listaNomes.stream().filter(n -> n.equals("Elsa")).findFirst();
        String resultado = resultadoOptional.orElseThrow();

        System.out.println(resultado);
    }

    public static void exemploValorNaoPresente() {
        List<String> listaNomes = Arrays.asList("João", "Maria", "Carlos", "Elsa", "Roberto");

        Optional<String> resultadoOptional = listaNomes.stream().filter(n -> n.equals("Jurema")).findFirst();
        String resultado = resultadoOptional.orElseThrow();

        System.out.println(resultado);
    }

    public static void main(String[] args) {
        exemploValorPresente();
        exemploValorNaoPresente();
    }

}
```

