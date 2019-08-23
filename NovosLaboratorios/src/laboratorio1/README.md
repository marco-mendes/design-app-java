## Princípios do SOLID em Java

### Material de preparação
[Princípios do SOLID](https://www.baeldung.com/solid-principles)<br/>
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
import java.util.List;

public class ContaCorrente {
    private String nomeCorrentista;
    private Integer numeroConta;
    private float saldoConta = 0;

    public ContaCorrente(String nomeCorrentista, Integer numeroConta) {
        this.nomeCorrentista = nomeCorrentista;
        this.numeroConta = numeroConta;
    }

    public ContaCorrente(String titular, Integer nconta, float saldo){
        this.nomeCorrentista = titular;
        this.numeroConta = nconta;
        this.saldoConta = saldo;
    }

    public String getNomeCorrentista() {
        return nomeCorrentista;
    }

    public Integer getNumeroConta() {
        return numeroConta;
    }

    public float getSaldoConta() {
        return saldoConta;
    }

    public void depositar(float valorDeposito){
        saldoConta = saldoConta + valorDeposito;
    }

    public void sacar(float valorSaque){
        if (valorSaque <= saldoConta) {
            saldoConta = saldoConta - valorSaque;
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public void mostrarStatus(){
        System.out.println(nomeCorrentista);
        System.out.println(numeroConta);
        System.out.println("R$ " + saldoConta);
    }

    public void realizarEmprestimo(float valor) {
        if(contaJaFoiNegativada(this)) {
            System.out.println("Emprestimo negado!");
        } else {
            System.out.println("Emprestimo aprovado!");
        }
    }

    private boolean contaJaFoiNegativada(ContaCorrente conta) {
        List<ContaCorrente> contasJaNegativadas = ContasJaNegativadas.obtemContasJaNegativadas();
        boolean contaJaFoiNegativada = contasJaNegativadas.stream()
                .filter(c -> c.getNumeroConta()
                        .equals(conta.getNumeroConta()))
                .findFirst()
                .isPresent();
        return contaJaFoiNegativada;
    }

}
```

Classe responsável por retornar a lista de contas que já foram negativadas.
```java
import java.util.Arrays;
import java.util.List;

public class ContasJaNegativadas {

    private static List<ContaCorrente> contasJaNegativadas;

    public static List<ContaCorrente> obtemContasJaNegativadas() {
        contasJaNegativadas = Arrays.asList(
                new ContaCorrente("Marcos", 12345),
                new ContaCorrente("Silvio", 23456),
                new ContaCorrente("Raquel", 75690),
                new ContaCorrente("Joana", 01134),
                new ContaCorrente("Fábio", 57123)
        );
        return contasJaNegativadas;
    }

}
```

No exemplo acima a classe **ContaCorrente** possui responsabilidades que a mesma não deveria possuir, sendo elas: realizar empréstimo e verificar se a conta já foi negativada.<br/>
A forma como essa classe está estruturada viola nosso primeiro princípio do SOLID, no qual cada classe deve possuir apenas uma responsabilidade.<br/>
Para corrigir isso podemos separar as responsabilidades atribuídas a classe **ContaCorrente**, onde será criada uma classe que será responsável por autorizar empréstimos para 
uma Conta Corrente como no exemplo abaixo:
```java
public class ContaCorrente{
    private String nomeCorrentista;
    private Integer numeroConta;
    private float saldoConta = 0;

    public ContaCorrente(String nomeCorrentista, Integer numeroConta) {
        this.nomeCorrentista = nomeCorrentista;
        this.numeroConta = numeroConta;
    }

    public ContaCorrente(String titular, Integer nconta, float saldo){
        this.nomeCorrentista = titular;
        this.numeroConta = nconta;
        this.saldoConta = saldo;
    }

    public String getNomeCorrentista() {
        return nomeCorrentista;
    }

    public Integer getNumeroConta() {
        return numeroConta;
    }

    public float getSaldoConta() {
        return saldoConta;
    }

    public void depositar(float valorDeposito){
        saldoConta = saldoConta + valorDeposito;
    }

    public void sacar(float valorSaque){
        if (valorSaque <= saldoConta) {
            saldoConta = saldoConta - valorSaque;
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public void mostrarStatus(){
        System.out.println(nomeCorrentista);
        System.out.println(numeroConta);
        System.out.println("R$ " + saldoConta);
    }

}
```

```java
import java.util.List;

// Classe separada com a responsabilidade derealizar empréstimos.
public class Emprestimo {

    public void realizarEmprestimo(ContaCorrente conta, float valor) {
        if(contaJaFoiNegativada(conta)) {
            System.out.println("Emprestimo negado!");
        } else {
            System.out.println("Emprestimo aprovado!");
        }
    }

    private boolean contaJaFoiNegativada(ContaCorrente conta) {
        List<ContaCorrente> contasJaNegativadas = ContasJaNegativadas.obtemContasJaNegativadas();
        boolean contaJaFoiNegativada = contasJaNegativadas.stream()
                .filter(c -> c.getNumeroConta()
                        .equals(conta.getNumeroConta()))
                .findFirst()
                .isPresent();
        return contaJaFoiNegativada;
    }

}
```

#### Exercício 1
Com base no que foi abordado até o momento, refatore a classe Usuario para que a mesma esteja de acordo com o primeiro princípio do SOLID.<br/>
```java
import java.util.List;

public class Usuario {

    private String nome;
    private String email;
    private String senha;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public static boolean autenticarUsuario(Usuario usuario) {
        if(usuarioExistente(usuario)) {
            List<Usuario> usuarios = UserDatabase.obterTodosUsuarios();
            boolean usuarioAutenticado =  usuarios.stream()
                    .filter(user -> user.getEmail().equals(usuario.getEmail()) &&
                            user.getSenha().equals(usuario.getSenha()))
                    .findFirst()
                    .isPresent();

            if(usuarioAutenticado) {
                System.out.println("Usuário autenticado com sucesso!");
            } else {
                System.out.println("e-mail ou senha incorretos!");
            }

            return usuarioAutenticado;
        } else {
            System.out.println("Usuário não cadastrado!");
            return false;
        }

    }

    private static boolean usuarioExistente(Usuario usuario) {
        List<Usuario> usuarios = UserDatabase.obterTodosUsuarios();
        boolean usuarioExistente = usuarios.stream()
                .filter(user -> user.getEmail().equals(usuario.getEmail()))
                .findFirst()
                .isPresent();
        return usuarioExistente;
    }

}
```

```java
import java.util.ArrayList;
import java.util.List;

// Classe responsável por retornar a lista de usuários
public class UserDatabase {

    private static List<Usuario> usuarios;

    public UserDatabase() {
        usuarios = new ArrayList<Usuario>();
        usuarios.add(new Usuario("Cleber", "cleber@gmail.com", "12345"));
        usuarios.add(new Usuario("Joana", "joana@yahoo.com", "54325"));
        usuarios.add(new Usuario("Wilson Oliveira", "w.oliveira@gmail.com", "85094"));
        usuarios.add(new Usuario("Tales Franco", "tales.franco@gmail.com", "12847"));
    }

    public static List<Usuario> obterTodosUsuarios() {
        return usuarios;
    }

}
```

### (O) - Open/Closed (Princípio do Aberto/Fechado)
O segundo princípio do SOLID é conhecido como Open/Closed, o objetivo do mesmo é garantir que a classe esteja aberta para ser extendida porém fechada para modificações.<br/>

Exemplo:<br/>
Considere que a classe **EnviarEmail** do código abaixo já foi testada e está funcionando corretamente.
```java
// Classe de modelo para Email
public class Email {

    private String destinatario;
    private String remetente;

    public Email(String destinatario, String remetente) {
        this.destinatario = destinatario;
        this.remetente = remetente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getRemetente() {
        return remetente;
    }
    
}
``` 
 
```java
public class EnviarEmail {

    Email email;

    public EnviarEmail(Email email) {
        this.email = email;
    }

    public void enviarEmail(String mensagem) {
        System.out.println(String.format("Enviando email para %s", this.email.getDestinatario()));
        System.out.println(String.format("Remetente: %s", this.email.getRemetente()));
        System.out.println(String.format("Mensagem: %s", mensagem));
    }
    
}
```
 
Em um belo dia surgiu a necessidade de implementar novas funcionalidades para essa classe, porém essa necessidade pode resultar em bugs em nossa classe **EnviarEmail**.<br/>
Para evitar isso podemos usar o princípio Open/Closed no qual a classe **EnviarEmail** será extendida e as novas funcionalidades serão implementadas na nova classe criada 
como no exemplo abaixo:
```java
public class EnviarEmailEmpresarial extends EnviarEmail {

    String assinatura;

    public EnviarEmailEmpresarial(Email email, String assinatura) {
        super(email);
        this.assinatura = assinatura;
    }

    public void enviarEmailEmpresarial(String mensagem) {
        System.out.println(String.format("Enviando E-mail empresarial para %s", this.email.getDestinatario()));
        System.out.println(String.format("Remetente: %s", this.email.getRemetente()));
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

    public static void fazerBarulho(Animal animal) {
        animal.facaBarulho();
    }

    public static void main(String[] args) {
        Cachorro cachorro = new Cachorro();
        fazerBarulho(cachorro);
    }

}
```

No exemplo acima possuímos a classe **Cachorro** que é um subtipo da classe **Animal**, conforme vimos no exemplo acima conseguimos substituir um objeto do tipo **Animal** 
por um objeto do tipo **Cachorro** no método **fazerBarulho()**.<br/>
Este seria um exemplo bem simples desse princípio.

#### Exercício 3
Utilizando o princípio Liskov Substitution, crie um subtipo de **Veiculo** chamado **Carro**, no método **ligarVeiculo()** da classe **Carro** imprima no console 
"Ligando Carro", apos isso invoque o método **dirigir** da classe **Motorista** utilizando uma instância do tipo **Carro**.<br/>
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

### (I) - Interface Segregation (Princípio da Segregação de Interfaces)
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

    public void gerarRelatorioWord();

}
```

```java
public interface RelatorioExcel {

    public void gerarRelatorioExcel();

}
```

```java
public interface RelatorioPDF {

    public void gerarRelatorioPDF();

}
```

Exemplo de implementação apenas da interface **RelatorioPDF**:
```java
public class ImplementacaoRelatorioPDF implements RelatorioPDF {

    @Override
    public void gerarRelatorioPDF() {
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

### (D) - Dependency Inversion (Princípio da Inversão de Dependências)
O quinto e ultimo princípio do SOLID é conhecido como Dependency Inversion, o objetivo do mesmo é retirar a dependência de objetos concretos de uma classe, 
substituindo eles por abstrações dos mesmos, onde quem for utilizar a classe fica responsável pela injeção de dependências da mesma.<br/>
No exemplo abaixo possuímos a classe **ConsoleXboxOne** que depende de um objeto concreto da classe **ControleXboxOne**, essa dependência é instanciada diretamente na classe 
**ConsoleXboxOne**.
```java
public class ControleXboxOne {

    public void executarAcao() {
        // Alguma implementação
    }

}
```

```java
public class ConsoleXboxOne {

    private final ControleXboxOne controleXboxOne;

    public ConsoleXboxOne() {
        this.controleXboxOne = new ControleXboxOne();
    }
}
```

Aplicando o princípio Dependency Inversion podemos tornar a injeção de dependências da classe **ConsoleXboxOne** uma responsabilidade da classe que for utilizá-la.<br/>
Exemplo do princípio Dependency Inversion aplicado ao código do exemplo acima:
```java
public class ConsoleXboxOne {

    private final ControleXboxOne controleXboxOne;

    public ConsoleXboxOne(ControleXboxOne controleXboxOne) {
        this.controleXboxOne = controleXboxOne;
    }
    
}
```

#### Exercício 5
Com base no código abaixo aplique o princípio Dependency Inversion utilizando o que foi abordado até o momento.
```java
public class BackEndDeveloper {

    public void writeAPI() {
        System.out.println("Desenvolvedor BackEnd desenvolvendo API");
    }

}
```

```java
public class FrontEndDeveloper {

    public void writeClientConsumer() {
        System.out.println("Desenvolvedor FrontEnd implementando Client que irá consumir a API do BackEnd");
    }

}
```

```java
public class ProjetoApiClient {

    private final BackEndDeveloper backEndDeveloper;
    private final FrontEndDeveloper frontEndDeveloper;

    public ProjetoApiClient() {
        this.backEndDeveloper = new BackEndDeveloper();
        this.frontEndDeveloper = new FrontEndDeveloper();
    }

    public void implementar() {
        this.backEndDeveloper.writeAPI();
        this.frontEndDeveloper.writeClientConsumer();
    }

}
```
