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

        User user1 = new User("Marcos", writer);
        User user2 = new User("Carlos", reader);
        User user3 = new User("Mateus", reader);
        User user4 = new User("Alan", writer);

        List<User> users = Arrays.asList(
            user1,
            user2,
            user3,
            user4
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
        List<User> usersWithAllPermissions = users.stream().filter(Exemplo1::getUserWithAllPermissions).collect(Collectors.toList());
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
Com base no que foi abordado até o momento refatore o código 