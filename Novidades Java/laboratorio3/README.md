## Introdução aos principais recursos do Java 11

### Material de preparação
[Novos métodos String API](https://www.baeldung.com/java-11-string-api)<br/>
[Classe Optional novo método isEmpty](https://dzone.com/articles/optionalisempty-available-in-jdk-11-ea-builds)<br/>
[Interface Collections método toArray](https://dzone.com/articles/jdk-11-new-default-collection-method-toarrayintfun)

### Introdução
Abordaremos neste laboratório os principais recursos introduzidos no Java 11.<br/>
Os recursos mais relevantes inseridos foram:
 * Novos métodos String API
 * Classe Optional novo método isEmpty()
 * Interface Collections adição método toArray
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
System.out.println(testeStrip.strip() + " World!");
System.out.println(testeStrip.stripLeading() + " World!");
System.out.println(testeStrip.stripTrailing() + " World!");
```

O método **isBlank()** retorna true se a string estiver vazia ou se a mesma contiver apenas espaço em branco, caso contrário retorna false.<br/>
Exemplo de uso:<br/>
```java
String valorVazio = "";
String valorEmBranco = "          ";
String valorPreenchido = "Algum valor";

System.out.println(valorVazio.isBlank());
System.out.println(valorEmBranco.isBlank());
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
