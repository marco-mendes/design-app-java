# Laboratório Lambdas - Protótipo

### Material de Preparação

[Introdução](http://blog.gabrielamorim.com/java-8-expressoes-lambda-closures-interfaces-funcionais-e-um-pouco-mais/)<br/>
[Algumas dicas e melhores práticas](https://www.baeldung.com/java-8-lambda-expressions-tips)<br/>
[Uso de lambdas com Functions, Streams e Collections](https://rodrigouchoa.wordpress.com/2014/05/20/novidades-do-java-8-lambda-expressions/)<br/>
[Caso queira se aprofundar mais](https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/Lambda-QuickStart/index.html)

### Introdução Expressões Lambda
Como vimos nos artigos de preparação, Lambda é uma forma clara e objetiva de representar um método usando apenas uma expressão.

Abaixo temos a estrutura de um lambda:
```java
(parametro) -> corpo da função 
```

Além disso vimos também que para realizar o uso de Lambdas precisamos de uma interface funcional.

Um exemplo do uso e Lambdas é para realizar a ordenação de uma lista.Um exemplo do uso e Lambdas é para realizar a ordenação de uma lista.

Neste exemplo vemos como era realizada a ordenação de listas através do método **sort()** antes do uso das Lambdas onde era necessário criarmos uma classe anônima dentro da invocação do método  **sort()**:

```java
public static void ordenacaoAntesLambdas(){
  List<String> listaNomes = Arrays.asList("Joao", "Maria", "Dalva", "Vilma", "Carlos", "Roberto");
  listaNomes.sort(new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
                  return o1.compareTo(o2);
    }
  });
  System.out.println(listaNomes);
}
```

Com o Java 8 já podemos substituir este trecho de código por esse através do uso de lambdas da seguinte forma:
```java
public static void ordenacaoComLambdas(){
  List<String> listaNomes = Arrays.asList("Joao", "Maria", "Dalva", "Vilma", "Carlos", "Roberto");
  listaNomes.sort((c1, c2) -> c1.compareTo(c2));
  System.out.println(listaNomes);
}
```
Este é apenas um dos exemplo de uso dentro da interface List.

### Exercício
Neste exercício escreva uma expressão Lambda que imprima todos os valores de um array.

```java
import java.util.Arrays;
import java.util.List;


public class LambdasExercicio {
      public static void main(String[] args) {
    List<String> listaNomes = Arrays.asList("Joao", "Maria", "Dalva", "Vilma", "Carlos", "Roberto");
    listaNomes.forEach(parametro -> operacao);
  }
}
```