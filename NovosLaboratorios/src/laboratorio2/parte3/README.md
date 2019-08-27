## Design Pattern Prototype

### Material de preparação
[Pattern Prototype](https://howtodoinjava.com/design-patterns/creational/prototype-design-pattern-in-java/)<br/>


### Visão geral do Pattern Prototype
O Pattern Prototype é usado em cenários em que a aplicação precisa criar várias instâncias de uma classe(chamada de Protótipo ou Prototype), que tem quase o mesmo estado ou 
difere muito pouco.<br/>
A idéia principal desse é padrão é ser usada quando a criação de uma instância é muito custosa para a aplicação, quando isso ocorre podemos utilizar este padrão para 
clonar uma instância existente da classe e assim criar um novo objeto da mesma várias vezes de forma não tão custosa para a aplicação.<br/>
Os participantes desse Pattern são:
 * PrototypeCapable: Este é um participante opcional que pode ser uma Interface ou classe abstrata, ele será usado como base para criação dos prototypes, com ele teremos 
 * Protótipo : Este é o protótipo do objeto real.
 * Registro de protótipo : é usado como serviço de registro para ter todos os protótipos acessíveis usando parâmetros de string simples.
 * Cliente : O cliente será responsável pelo uso do serviço de registro para acessar as instâncias do protótipo. 
 a capacidade de clonar protótipos sem conhecer seus tipos reais.
 
### Implementando o Pattern Prototype
Suponhamos que iremos aplicar o Pattern Prototype para a criação de itens de um carrinho de compras, podemos realizar a implementação da seguinte forma:

#### Criando o PrototypeCapable
Criaremos aqui a interface que servirá de base para a criação dos Protótipos
```java
public interface PrototypeCapable extends Cloneable {
    public PrototypeCapable clone() throws CloneNotSupportedException;
}
``` 

#### Criando os Protótipos
Os protótipos serão criados com base em nossa interface **PrototypeCapable**, alguns exemplos de implementaçao destes objetos seria:
```java
public class Livro implements PrototypeCapable {

    public Livro() {}

    @Override
    public Livro clone() throws CloneNotSupportedException {
        System.out.println("Clonando Objeto Livro");
        return (Livro) super.clone();
    }

    @Override
    public String toString() {
        return "Livro";
    }

}
```

```java
public class Revista implements PrototypeCapable {

    public Revista() {}

    @Override
    public Revista clone() throws CloneNotSupportedException {
        System.out.println("Clonando Objeto Revista");
        return (Revista) super.clone();
    }

    @Override
    public String toString() {
        return "Revista";
    }

}
```

```java
public class Jornal implements PrototypeCapable {

    public Jornal() {}

    @Override
    public Jornal clone() throws CloneNotSupportedException {
        System.out.println("Clonando Objeto Jornal");
        return (Jornal) super.clone();
    }

    @Override
    public String toString() {
        return "Jornal";
    }

}
```

#### Criando nosso PrototypeRegistry
Nosso PrototypeRegistry pode ser criado da seguinte forma:
```java
import java.util.HashMap;
import java.util.Map;

public class PrototypeFactory {

    public static class ModelType {
        public static final String LIVRO = "livro";
        public static final String REVISTA = "revista";
        public static final String JORNAL = "jornal";
    }

    private static Map<String, PrototypeCapable> prototypes = new HashMap<String, PrototypeCapable>();

    static {
        prototypes.put(ModelType.LIVRO, new Livro());
        prototypes.put(ModelType.REVISTA, new Revista());
        prototypes.put(ModelType.JORNAL, new Jornal());
    }

    public static PrototypeCapable getInstance(final String s) throws CloneNotSupportedException {
        return ((PrototypeCapable) prototypes.get(s).clone());
    }

}
```

Neste exemplo mapeamos todos os tipos de Protótipos utilizando um Map com uma String específica e a instância de cada protótipo, no método **getInstance()** 
realizamos a clonagem do objeto utilizando o método **clone()**.

#### Criando nosso client
Podemos criar o client da seguinte forma para poder acessar as instâncias de nosso protótipos:
```java
public class PrototypePatternMain {

    public static void main(String[] args) {
        try {
            String livro = PrototypeFactory.getInstance(PrototypeFactory.ModelType.LIVRO).toString();
            System.out.println(livro);

            String jornal = PrototypeFactory.getInstance(PrototypeFactory.ModelType.JORNAL).toString();
            System.out.println(jornal);

            String revista = PrototypeFactory.getInstance(PrototypeFactory.ModelType.REVISTA).toString();
            System.out.println(revista);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }

}
```

