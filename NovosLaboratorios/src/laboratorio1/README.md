## Princípios do SOLID em Java

### Material de preparação
[Princípios do SOLID](https://www.baeldung.com/solid-principles)
[Princípios do SOLID com mais exemplos](https://howtodoinjava.com/best-practices/5-class-design-principles-solid-in-java/)

### Introdução
Como vimos no material de preparação, o SOLID é composto por 5 princípios orientados a objeto que tem por objetivo manter o código organizado e bem estruturado.<br/>
Os princípios do SOLID são:
 * S - Single Responsability (Princípio da responsabilidade única)
 * O - Open/Closed (Princípio do Aberto/Fechado)
 * L - Liskov Substitution (Princípio da substituição de Liskov)
 * I - Interface Segregation (Princípio da Segregação de Interfaces)
 * D - Dependency Inversion (Princípio da Inversão de Dependências)
 
Abordaremos cada um desses princípios neste laboratório.

### (S) - Single Responsability
O primeiro princípio do SOLID é conhecido como Single Responsability, o objetivo do mesmo é fazer com que cada classe tenha apenas uma responsabilidade.<br/>
Neste exemplo de classe que possui mais de uma responsabilidade:
```java
public class Funcionario {

    private String registro;
    private String nome;
    private String endereco;

    public Funcionario(String registro, String nome, String endereco) {
        this.registro = registro;
        this.nome = nome;
        this.endereco = endereco;
    }

    // Getters e Setters

    public boolean seraPromovidoEsseAno() {
        // Alguma lógica de implementação
        return true;
    }

}
```
No exemplo acima a classe Funcionario possui duas responsabilidades, sendo elas: servir de modelo para um Funcionário e verificar se o mesmo será promovido no ano atual.<br/>
A forma como essa classe está estruturada viola nosso primeiro princípio do SOLID, no qual cada classe deve possuir apenas uma responsabilidade.<br/>
Para corrigir isso podemos separar as responsabilidades atribuídas a classe Funcionário, onde será criada uma classe que será responsável por verificar se um funcionário será 
promovido como no exemplo abaixo:
```java
public class Funcionario {

    private String registro;
    private String nome;
    private String endereco;

    public Funcionario(String registro, String nome, String endereco) {
        this.registro = registro;
        this.nome = nome;
        this.endereco = endereco;
    }

    // Getters e Setters

}

public class PromocoesDeFuncionarios {

    public boolean seraPromovidoEsseAno(Funcionario funcionario) {
        // Alguma lógica de implementação
        return true;
    }

}
```

#### Exercício 1
Com base no que foi abordado até o momento, refatore a seguinte classe para que a mesma esteja de acordo com o primeiro princípio do SOLID.
```java

//Código a definir

```