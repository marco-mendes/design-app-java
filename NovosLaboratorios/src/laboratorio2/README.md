## Padrões de programação funcional com Java 8

### Material de preparação
[Padrões de programação funcional com Java 8](https://dzone.com/articles/functional-programming-patterns-with-java-8)

### Introdução
Nesse laboratório abordaremos alguns padrões e boas práticas de desenvolvimento com Java 8 que podem nos ajudar a manter o código simples e limpo.

Os padrões e boas práticas abordados serão:
 * Utilizar funções nomeadas em vez de funções lambda anônimas
 * Evitar o excesso de encadeamento de métodos em Streams
 * Utilizar funções que retornem Optionals caso o resultado possa ser nulo
 * Padrão de Empréstimo de código(Passing-a-Block)
 * Forma de implementar lógica  específica por tipo em Java 8.
 
 
###  Prefira utilizar funções nomeadas em vez de lambdas anônimas
Essa boa prática sugere sempre extrair lambdas complexos em métodos com um nome expressivo, com o objetivo de tornar o código mais organizado e de fácil compreensão.<br/>
Observe o seguinte exemplo:
```java
public enum PermissionType {

    READ, WRITE, REMOVE

}
```

```java
import java.util.Arrays;
import java.util.List;

public class User {

    private String nome;
    private List<PermissionType> permissions;

    public User(String nome, List<PermissionType> permissions) {
        this.nome = nome;
        this.permissions = permissions;
    }

    public String getNome() {
        return nome;
    }

    public List<PermissionType> getPermissions() {
        return permissions;
    }

    public void addPermission(PermissionType permissionType) {
        this.permissions.add(permissionType);
    }

    public void removePermission(PermissionType permissionType) {
        this.permissions.remove(permissionType);
    }

    public static List<User> getUsers() {
        List<PermissionType> writer = Arrays.asList(
                PermissionType.READ, PermissionType.WRITE, PermissionType.REMOVE
        );
        List<PermissionType> reader = Arrays.asList(
                PermissionType.READ
        );
        
        List<User> users = Arrays.asList(
                new User("Marcos", writer), 
                new User("Carlos", reader),
                new User("Mateus", reader),
                new User("Alan", writer)
        );

        return users;
    }

    @Override
    public String toString() {
        return "User{" +
                "nome='" + nome + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}
```

```java
import java.util.List;
import java.util.stream.Collectors;

public class Exemplo1 {


    public static void exemploComLambdaAnonimo() {
        List<User> users = User.getUsers();
        List<User> usersWithAllPermissions = users.stream().filter(u -> {
            return u.getPermissions().contains(PermissionType.READ) &&
                    u.getPermissions().contains(PermissionType.WRITE) &&
                    u.getPermissions().contains(PermissionType.REMOVE);

        }).collect(Collectors.toList());
        usersWithAllPermissions.forEach(u -> System.out.println(u));
    }

    public static void exemploComMetodoNomeado() {
        List<User> users = User.getUsers();
        List<User> usersWithAllPermissions = users.stream()
                .filter(Exemplo1::getUserWithAllPermissions)
                .collect(Collectors.toList());
        usersWithAllPermissions.forEach(u -> System.out.println(u));
    }

    public static boolean getUserWithAllPermissions(User user) {
        return user.getPermissions().contains(PermissionType.READ) &&
                user.getPermissions().contains(PermissionType.WRITE) &&
                user.getPermissions().contains(PermissionType.REMOVE);
    }
    
    public static void main(String[] args) {
        exemploComLambdaAnonimo();
        exemploComMetodoNomeado();
    }

}
```

O objetivo do exemplo acima é filtrar os usuários de uma lista que possuem todas as permissões de acesso disponíveis.<br/>
No método **exemploComLambdaAnonimo()** podemos ver uma situação bem comum no uso de Lambdas, inicialmente teríamos que analisar a expressão Lambda anônima para buscar 
compreender qual era o objetivo da mesma, dependendo do nível de complexidade dessa expressão isso pode ser tornar um pouco complicado de compreender além de dificultar 
a manutenção da mesma.<br/>
Já no método **exemploComMetodoNomeado()** podemos observar que nossa expressão Lambda anônima foi transferida para o método **getUserWithAllPermissions()**, em 
comparação com a primeira abordagem bastaria ler o nome do método invocado durante a filtragem para compreender o que está sendo feito, isso facilita muito a leitura,
compreensão e manutenção do código.


#### Exercício 1
Refatore o código abaixo aplicando a boa prática abordada neste tópico.<br/>
O código completo desse exercício pode ser encontrado neste [link](./exercicios/exercicio1/).

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercicio1 {

    public static List<ContaCorrente> obterContasCorrente() {
        List<ContaCorrente> contasCorrente = Arrays.asList(
                new ContaCorrente("Silvio", 23456, 250.00),
                new ContaCorrente("Carlos", 55990, 750.00),
                new ContaCorrente("Raquel", 75690, 300.00),
                new ContaCorrente("Marcia", 11790, 800.00),
                new ContaCorrente("Joana", 01134, 100.00),
                new ContaCorrente("Michelle", 80902, 1000.00)
        );
        return contasCorrente;
    }


    public static void main(String[] args) {
        List<ContaCorrente> contasAptasParaEmprestimo = obterContasCorrente().stream().filter(conta -> {

            List<ContaCorrente> contasJaNegativadas = ContasJaNegativadas.obtemContasJaNegativadas();
            boolean contaJaFoiNegativada = contasJaNegativadas.stream()
                    .filter(c -> c.getNumeroConta()
                            .equals(conta.getNumeroConta()))
                    .findFirst()
                    .isPresent();

            if(contaJaFoiNegativada) {
                return false;
            } else {
                return true;
            }

        }).collect(Collectors.toList());

        contasAptasParaEmprestimo.forEach(conta -> System.out.println(conta));

    }

}
```


### Evitar o uso excessivo de encadeamento de métodos em Streams
A idéia principal dessa boa prática é evitar o uso excessivo de encadeamento de métodos em streams, dividindo a lógica em partes e introduzindo variáveis explicativas 
para elas com o objetivo de tornar o código mais claro o possível para leitura e futuras manutenções.<br/>
Observe o exemplo abaixo, possuímos o método **encadeamentoExcessivoDeMetodosStream()** demonstrando um exemplo de encadeamento excessivo de métodos em um stream, para 
melhorar esse cenário criamos o método **encadeamentoExcessivoRefatoradoEmVariaveisExplicativas()** que divide a lógica em partes introduzindo variáveis auto explicativas.
```java
enum TipoProduto {
    ELETRONICO, ELETRODOMESTICO
}
```

```java
import java.util.Arrays;
import java.util.List;

class Produto {

    private int id;
    private String nome;
    private Double preco;
    private TipoProduto tipoProduto;

    public Produto(int id, String nome, Double preco, TipoProduto tipoProduto) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.tipoProduto = tipoProduto;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public static List<Produto> obterProdutos() {
        List<Produto> produtos = Arrays.asList(
                new Produto(1, "IPhone X", 3999.00, TipoProduto.ELETRONICO),
                new Produto(2, "Geladeira", 899.00, TipoProduto.ELETRODOMESTICO),
                new Produto(3, "MacBook Pro", 3899.00, TipoProduto.ELETRONICO),
                new Produto(4, "Xiaomi Mi 8", 999.00, TipoProduto.ELETRONICO)
        );
        return produtos;
    }

}
```

```java
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exemplo2 {

    public static void encadeamentoExcessivoDeMetodosStream() {
        List<String> eletronicosComPrecoAcimaDe899 = Produto.obterProdutos()
                .stream()
                .filter(p -> p.getTipoProduto().equals(TipoProduto.ELETRONICO))
                .filter(p -> p.getPreco() > 899.00)
                .map(p -> String.format("ID: %s - Nome: %s", p.getId(), p.getNome()))
                .collect(Collectors.toList());

        eletronicosComPrecoAcimaDe899.forEach(p -> System.out.println(p));

    }

    public static void encadeamentoExcessivoRefatoradoEmVariaveisExplicativas() {
        Stream<Produto> streamEletronicosAcima899 = Produto.obterProdutos()
                .stream()
                .filter(p -> p.getTipoProduto().equals(TipoProduto.ELETRONICO))
                .filter(p -> p.getPreco() > 899.00);

        Stream<String> streamResultadoFormatado = streamEletronicosAcima899.map(p -> String.format("ID: %s - Nome: %s", p.getId(), p.getNome()));
        List<String> listaResultadoFormatado = streamResultadoFormatado.collect(Collectors.toList());
    }


    public static void main(String[] args) {
        encadeamentoExcessivoDeMetodosStream();
        encadeamentoExcessivoRefatoradoEmVariaveisExplicativas();
    }


}
```
