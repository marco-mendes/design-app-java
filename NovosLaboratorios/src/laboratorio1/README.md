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

### (S) - Single Responsability (Princípio da responsabilidade única)
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
Com base no que foi abordado até o momento, refatore a seguinte classe para que a mesma esteja de acordo com o primeiro princípio do SOLID.<br/>
Dica: O método tosarCachorro() não deveria ser responsabilidade dessa classe.
```java
public class Cachorro {

    private String nome;
    private String raca;

    public Cachorro(String nome, String raca) {
        this.nome = nome;
        this.raca = raca;
    }

    // Getters e Setters

    public void comer() {
        System.out.println(String.format("%s está comendo!", this.nome));
    }

    public void latir() {
        System.out.println(String.format("%s está latindo!", this.nome));
    }

    public void brincar() {
        System.out.println(String.format("%s está brincando!", this.nome));
    }

    public void tosarCachorro() {
        System.out.println(String.format("Tosando: %s | Raça: %s", this.nome, this.raca));
    }

}
```


### (O) - Open/Closed (Princípio do Aberto/Fechado)
O segundo princípio do SOLID é conhecido como Open/Closed, o objetivo do mesmo é garantir que a classe esteja aberta para ser extendida porém fechada para modificações.<br/>

Exemplo:<br/>
Considere que a classe abaixo já foi testada e está funcionando corretamente.
```java
public class CalculadoraSimples {

    public CalculadoraSimples() {

    }

    public int soma(int valor1, int valor2) {
        return valor1 + valor2;
    }

    public int subtracao(int valor1, int valor2) {
        return valor1 - valor2;
    }

    public int multiplicacao(int valor1, int valor2) {
        return valor1 * valor2;
    }

    public double divisao(int valor1, int valor2) {
        return valor1 / valor2;
    }

}
``` 
 
Em um belo dia surgiu a necessidade de implementar novas funcionalidades a essa classe, porém essa necessidade pode resultar em bugs em nossa classe CalculadoraSimples.<br/>
Para evitar isso podemos usar o princípio Open/Closed no qual a classe CalculadoraSimples será extendida e as novas funcionalidades serão implementadas na nova classe criada 
como no exemplo abaixo:
```java
public class CalculadoraCientifica extends CalculadoraSimples {

    public CalculadoraCientifica() {

    }

    public double raizQuadrada(double valor) {
        return Math.sqrt(valor);
    }

    public double potencia(double valor, double potencia) {
        return Math.pow(valor, potencia);
    }

}
```

### (L) - Liskov Substitution (Princípio da substituição de Liskov)
O terceiro princípio do SOLID é conhecido como Liskov Substitution, para melhor compreensão do mesmo considere a seguinte situação:<br/>
Possuímos a classe A, que é um subtipo da classe B, segundo o princípio da Liskov Substitution, devemos ser capazes de substituir B por A sem ocorrer problemas no 
funcionamento de nosso programa.<br/>
Exemplo: 
