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
O primeiro princípio do SOLID é conhecido como Single Responsability, o objetivo do mesmo é fazer com que cada classe tenha apenas uma responsabilidade. Observe que uma responsabilidade não significa que uma classe tenha um método, mas uma responsabilidade. Por exemplo, uma classe conta corrente deveria ter a responsabilidade de gerir o saldo de uma conta.<br/>

Vamos examinar um exemplo de classe que possui mais de uma responsabilidade:
```java
import java.util.List;

public class ContaCorrente {
    private String nomeCorrentista;
    private Integer numeroConta;
    private double saldoConta = 0;

    public ContaCorrente(String nomeCorrentista, Integer numeroConta) {
        this.nomeCorrentista = nomeCorrentista;
        this.numeroConta = numeroConta;
    }

    public ContaCorrente(String titular, Integer nconta, double saldo){
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

    public double getSaldoConta() {
        return saldoConta;
    }

    public void depositar(double valorDeposito){
        saldoConta = saldoConta + valorDeposito;
    }

    public void sacar(double valorSaque){
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

    public void realizarEmprestimo(double valor) {
        if(temCreditoAprovado(this)) {
            System.out.println("Emprestimo negado!");
        } else {
            System.out.println("Emprestimo aprovado!");
        }
    }

    private boolean temCreditoAprovado(ContaCorrente conta) {
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

```java
import java.util.Arrays;
import java.util.List;

// Classe responsável por retornar a lista de contas que já foram negativadas.
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
    private double saldoConta = 0;

    public ContaCorrente(String nomeCorrentista, Integer numeroConta) {
        this.nomeCorrentista = nomeCorrentista;
        this.numeroConta = numeroConta;
    }

    public ContaCorrente(String titular, Integer nconta, double saldo){
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

    public double getSaldoConta() {
        return saldoConta;
    }

    public void depositar(double valorDeposito){
        saldoConta = saldoConta + valorDeposito;
    }

    public void sacar(double valorSaque){
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

// Classe separada com a responsabilidade de realizar empréstimos.
public class Emprestimo {

    public void realizarEmprestimo(ContaCorrente conta, double valor) {
        if(temCreditoAprovado(conta)) {
            System.out.println("Emprestimo negado!");
        } else {
            System.out.println("Emprestimo aprovado!");
        }
    }

    private boolean temCreditoAprovado(ContaCorrente conta) {
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

Vamos olhar um contra-exemplo e os seus efeitos colaterais.

```java
public class Rectangle {
    public double Width;
    public double Height;

    //Getters and Setters

}

public class AreaCalculator {

    public double area(Rectangle[] shapes) {
        double area = 0;

        for(var shape : shapes) {
            area += shape.Width*shape.Height;
        }

        return area;
    }

}

/// Se quisermos estender o método area para lidar com circulos o codigo poderia ser criado da forma abaixo.

public double area(Object[] shapes) {
    double area = 0;
    for (var shape : shapes) {
        if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shape;
            area += rectangle.Width*rectangle.Height;
        } else {
            Circle circle = (Circle)shape;
            area += circle.radius * circle.radius * Math.PI;
        }
    }
    return area;
}

```

Esse exemplo acima funciona, mas nao segue o princípio Open/Closed. Qualquer modificação na classe requer mudança na implementação do método de cálculo de área.

Vamos fazer algo melhor...

```java
public interface Shape
{
    public double getArea();
}

public class Rectangle implements Shape
{
    public double width;
    public double height;
    public double getArea()
    {
        return width*height;
    }
}

public class Circle implements Shape
{
    public double radius;
    public double getArea()
    {
        return radius*radius*Math.PI;
    }
}
```
 
 Com essa implementação acima podemos ter um método genérico de calculo de area aberto/fechado.

```java
public class AreaCalculator {
    public double getArea(Shape[] shapes) {
        double area = 0;
        for(var shape : shapes) {
            area += shape.getArea();
        }

        return area;
    }
}
```
Esse método é aberto/fechado pois tem uma implementação fechada (não exige modificação) mas consegue calcular a área de qualquer forma geométrica (até as que não foram criadas ainda).


#### Exercício 2
Considere o contexto de cálculo dos descontos a serem aplicados em uma nota fiscal. Vamos assumir que os seguintes impostos são aplicados hoje:
* ISS (2%)
* COFINS (3%)
* ICMS_MinasGerais (18%)

Gostariamos de pode criar um método calculador de impostos mas que não fique preso a apenas esses impostos pois novos impostos podem surgir e as alíquotas podem variar entre estados da federação, tipo de produto ou regimes tributários

A sua missão é implementar um método que calcule os descontos a serem aplicadas em uma nota fiscal que não esteja preso a impostos específicos (Open), mas que consiga ser fechada em sua implementação (Closed).


### (L) - Liskov Substitution (Princípio da substituição de Liskov)
O terceiro princípio do SOLID é conhecido como Liskov Substitution, para melhor compreensão do mesmo considere a seguinte situação:<br/>
Possuímos a classe A, que é um subtipo de B, segundo o princípio da Liskov Substitution, devemos ser capazes de substituir B por A sem ocorrer problemas no funcionamento de nosso programa.<br/>

Vamos examinar um contra exemplo.

```java
public class Retangulo
{
    public double altura;
    public double largura;

    public  void inserirAltura(double altura)
    {
        this.altura = altura;
    }

    public  void inserirLargura(double largura)
    {
        this.largura = largura;
    }
}

public class Quadrado extends Retangulo
{
    public void inserirAltura(double altura)
    {
        this.altura = altura;
        this.largura = altura;
    }

    public void inserirLargura(double largura)
    {
        this.largura = largura;
        this.altura = largura;
    }
}
```

No código acima, estamos dizendo que um quadro (tipo A) é um retangulo (tipo B), mas nao podemos substituir B por A sem ocorrer problemas no funcionamento de nosso programa. 

Vamos trabalhar um exemplo de verificacao de teste.

```java

void verifica(Retangulo r) {
    r.inserirLargura(5);
    r.inserirAltura(4);
    assert(r.altura * r.largura == 20);  // Falha se passamos um objeto quadrado como parametro!!!
}

```

O artigo original com esse princípio e esse contra-exemplo é publicado aqui: https://drive.google.com/file/d/0BwhCYaYDn8EgNzAzZjA5ZmItNjU3NS00MzQ5LTkwYjMtMDJhNDU5ZTM0MTlh/view

#### Exercício 3

Crie uma hierarquia que contenha as abstrações Quadrado e Retangulo, mas que atenda ao principio LSP.
Dica: Use uma interface Shape.

### (I) - Interface Segregation (Princípio da Segregação de Interfaces)
O quarto princípio do SOLID é conhecido como Interface Segregation, o objetivo do mesmo é basicamente dividir interfaces maiores em interfaces menores, fazendo isso  podemos garantir que as classes de implementação só precisem implementar os métodos que realmente irão precisar.<br/>

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
No exemplo abaixo possuímos a classe **AuthenticationService** que depende de um objeto concreto da classe **UserDatabase**, essa dependência é instanciada diretamente na classe 
**AuthenticationService**.
```java
public class User {

    private String nome;
    private String email;
    private String senha;

    public User(String nome, String email, String senha) {
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

}
```

```java
import java.util.ArrayList;
import java.util.List;

public class UserDatabase {

    private List<User> usuarios;

    public UserDatabase() {
        this.usuarios = new ArrayList<User>();
        this.usuarios.add(new User("Leandro Ribeiro", "l_ribeiro@gmail.com.br", "12345"));
        this.usuarios.add(new User("Michelle Bastos", "michelle.bastos@gmail.com.br", "90453"));
        this.usuarios.add(new User("Carlos Alberto", "carlos.a@yahoo.com.br", "89167"));
    }

    public List<User> obterUsuarios() {
        return usuarios;
    }
    
    public void cadastrar(User usuario) {
        this.usuarios.add(usuario);
    }

    public void remover(User usuario) {
        this.usuarios.remove(usuario);
    }

}
```

```java
import java.util.List;

public class AuthenticationService {

    private UserDatabase userDatabase = new UserDatabase();

    public boolean authenticateUser(User usuario) {
        List<User> usuarios = this.userDatabase.obterUsuarios();
        boolean usuarioAutenticado =  usuarios.stream()
                .filter(user -> user.getEmail().equals(usuario.getEmail()) &&
                        user.getSenha().equals(usuario.getSenha()))
                .findFirst()
                .isPresent();

        if(usuarioAutenticado) {
            System.out.println("Usuário autenticado com sucesso!");
        } else {
            System.out.println("Falha ao autenticar usuário!");
        }

        return usuarioAutenticado;
    }

}
```

Aplicando o princípio Dependency Inversion podemos tornar a injeção de dependências da classe **AuthenticationService** uma responsabilidade da classe que for utilizá-la.<br/>
Exemplo do princípio Dependency Inversion aplicado ao código do exemplo acima:
```java
import java.util.List;

public class AuthenticationService {

    private UserDatabase userDatabase;

    public AuthenticationService(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }

    public boolean authenticateUser(User usuario) {
        List<User> usuarios = this.userDatabase.obterUsuarios();
        boolean usuarioAutenticado =  usuarios.stream()
                .filter(user -> user.getEmail().equals(usuario.getEmail()) &&
                        user.getSenha().equals(usuario.getSenha()))
                .findFirst()
                .isPresent();

        if(usuarioAutenticado) {
            System.out.println("Usuário autenticado com sucesso!");
        } else {
            System.out.println("Falha ao autenticar usuário!");
        }

        return usuarioAutenticado;
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

    private final BackEndDeveloper backEndDeveloper = new BackEndDeveloper();
    private final FrontEndDeveloper frontEndDeveloper = new FrontEndDeveloper();
    
    public void implementar() {
        this.backEndDeveloper.writeAPI();
        this.frontEndDeveloper.writeClientConsumer();
    }

}
```
