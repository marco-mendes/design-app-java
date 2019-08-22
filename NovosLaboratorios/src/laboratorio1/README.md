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
Exemplo de classe que possui mais de uma responsabilidade:
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
```

```java
public class PromocoesDeFuncionarios {

    public boolean seraPromovidoEsseAno(Funcionario funcionario) {
        // Alguma lógica de implementação
    }

}
```

#### Exercício 1
Com base no que foi abordado até o momento, refatore a seguinte classe para que a mesma esteja de acordo com o primeiro princípio do SOLID.<br/>
Dica: O método **tosarCachorro()** não deveria ser responsabilidade dessa classe.
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
public class Email {

    String destinatario;
    String remetente;

    public Email(String destinatario, String remetente) {
        this.destinatario = destinatario;
        this.remetente = remetente;
    }
    
    public void enviarEmail(String mensagem) {
        System.out.println(String.format("Enviando email para %s", this.destinatario));
        System.out.println(String.format("Remetente: %s", this.remetente));
        System.out.println(String.format("Mensagem: %s", mensagem));
    }

    // Getters e Setters

}
``` 
 
Em um belo dia surgiu a necessidade de implementar novas funcionalidades a essa classe, porém essa necessidade pode resultar em bugs em nossa classe Email.<br/>
Para evitar isso podemos usar o princípio Open/Closed no qual a classe Email será extendida e as novas funcionalidades serão implementadas na nova classe criada 
como no exemplo abaixo:
```java
public class EmailEmpresarial extends Email {

    String assinatura;

    public EmailEmpresarial(String destinatario, String remetente, String assinatura) {
        super(destinatario, remetente);
        this.assinatura = assinatura;
    }

    public void enviarEmailEmpresarial(String mensagem) {
        System.out.println(String.format("Enviando E-mail empresarial para %s", this.destinatario));
        System.out.println(String.format("Remetente: %s", this.remetente));
        System.out.println(String.format("Mensagem: %s", mensagem));
        System.out.println(String.format("Assinatura: %s", this.assinatura));
    }
    
}
```

#### Exercício 2
Com base no código abaixo implemente uma nova funcionalidade chamada raizQuadrada, a mesma deverá calcular a raiz quadrada do número informado e retornar seu resultado.<br/>
Utilize o princípio Open/Close para isso.
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

### (L) - Liskov Substitution (Princípio da substituição de Liskov)
O terceiro princípio do SOLID é conhecido como Liskov Substitution, para melhor compreensão do mesmo considere a seguinte situação:<br/>
Possuímos a classe A, que é um subtipo de B, segundo o princípio da Liskov Substitution, devemos ser capazes de substituir B por A sem ocorrer problemas no 
funcionamento de nosso programa.<br/>
Exemplo: 
```java
public interface Animal {

    public void facaBarulho();

}
```

```java
public class Cachorro implements Animal {

    @Override
    public void facaBarulho() {
        System.out.println("AU AU");
    }
}
```

```java
public class Main {

    public static void fazerBarunho(Animal animal) {
        animal.facaBarulho();
    }

    public static void main(String[] args) {
        Cachorro cachorro = new Cachorro();
        fazerBarunho(cachorro);
    }

}
```

No exemplo acima possuímos a classe Cachorro que é um subtipo da classe Animal, conforme vimos no exemplo conseguimos substituir um objeto do tipo Animal 
por um objeto do tipo Cachorro no método fazerBarulho().<br/>
Este seria um exemplo bem simples desse princípio.

#### Exercício 3
Utilizando o princípio Liskov Substitution, crie um subtipo de Veiculo chamado Carro, no método ligarVeiculo da classe Carro imprima 
"Ligando Carro", apos isso invoque o método dirigir da classe Motorista utilizando uma instÂncia do tipo Carro.<br/>
Código base para esse exercício:
```java
public interface Veiculo {

    void ligarVeiculo();

    default void acelerar() {
        System.out.println("Acelerando!");
    }

}
```

```java
public class Motorista {

    public static void dirigir(Veiculo veiculo) {
        veiculo.ligarVeiculo();
        veiculo.acelerar();
    }

    public static void main(String[] args) {
        // Invocar método dirigir com uma instância do tipo Carro

    }

}
```

#### (I) - Interface Segregation (Princípio da Segregação de Interfaces)
O quarto princípio do SOLID é conhecido como Interface Segregation, o objetivo do mesmo é basicamente dividir interfaces maiores em interfaces menores, fazendo isso 
podemos garantir que as classes de implementação só precisem implementar os métodos que realmente irão precisar.<br/>
Considere a seguinte interface:
```java
public interface GerarRelatorio {

    public void relatorioWord();
    public void relatorioExcel();
    public void relatorioPDF();

}
```

Caso fossemos implementar a mesma seríamos obrigado a implementar todos os seus 3 métodos, utilizando o princípio Interface Segregation podemos refatorar essa interface 
em interfaces menores, e dessa forma implementar apenas os métodos que realmente iremos precisar.<br/>
Um exemplo desse princípio aplicado a essa interface seria:
```java
public interface RelatorioWord {

    public void gerarRelatorio();

}
```

```java
public interface RelatorioExcel {

    public void gerarRelatorio();

}
```

```java
public interface RelatorioPDF {

    public void gerarRelatorio();

}
```

Exemplo de implementação apenas da interface RelatorioPDF:
```java
public class ImplementacaoRelatorioPDF implements RelatorioPDF {

    @Override
    public void gerarRelatorio() {
        System.out.println("Gerando relatório em PDF!");
    }

}
```

#### Exercício 4
Com base no que foi mostrado até agora aplique o princípio Interface Segretation no código abaixo:
```java
public interface Impressora {

    public void imprimir();
    public void escanear();
    public void imprimirViaBluetooth();

}
```

#### (D) - Dependency Inversion (Princípio da Inversão de Dependências)