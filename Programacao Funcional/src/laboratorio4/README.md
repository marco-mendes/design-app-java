# Laboratório Interface Funcional Consumer - Protótipo

### Material de Preparação
[Uso Interface Funcional Consumer com Exemplos](https://www.geeksforgeeks.org/java-8-consumer-interface-in-java-with-examples/)

### Introdução
A Interface Funcional Consumer representa uma função que aceita um argumento e produz um resultado.
<br/>No entanto, esse tipo de função não retorna nenhum valor.
<br/>A expressão lambda atribuída a um objeto do tipo Consumer é usada para definir o comportamento de seu método **accept()**, que eventualmente aplica a operação atribuída ao Consumer em seu argumento.
<br/>A interface Consumer é útil quando não precisamos retornar nenhum valor, pois a mesma funciona via efeitos colaterais.

Exemplo de uso básico:
Temos aqui um consumer que recebe um número e imprime uma mensagem com o número recebido.
```java
Consumer<Integer> display = n -> System.out.println("Imprimindo número: " + n);
display.accept(5);
```

Outro exemplo do uso de um Consumer está dentro do método forEach da interface List, podemos passar a ele uma expressão lambda como no exemplo abaixo:
```java
List<Integer> integerList = Arrays.asList(1,2,3,4,5);
integerList.forEach(n -> System.out.println(n));
```

