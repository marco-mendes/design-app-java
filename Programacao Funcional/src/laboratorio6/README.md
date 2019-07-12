## Stream API e melhorias na interface Collection

### Material de Referência
[Stream API](https://blog.tecsinapse.com.br/stream-api-e-fun%C3%A7%C3%B5es-lambda-no-java-8-9941e8ae95d8)

### Introdução
Neste laboratório abordaremos as Streams.<br/>
Streams são um recurso introduzido no Java 8 que nos permite realizar o processamento de dados dentro de uma coleção através de expressões Lambda.<br/>
Utilizaremos a classe Pessoa para os próximos exemplos:
```java
package laboratorio6.exemplos;

import java.util.Arrays;
import java.util.List;

enum Sexo {
    MASCULINO, FEMININO
}

public class Pessoa {

    String nome;
    Sexo sexo;
    Integer idade;
    
    public Pessoa(String nome, Sexo sexo, Integer idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public Integer getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", sexo=" + sexo +
                ", idade=" + idade +
                '}';
    }

    public static List<Pessoa> obtemListaPessoas(){
        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Marcos", Sexo.MASCULINO, 32),
                new Pessoa("Robério", Sexo.MASCULINO, 29),
                new Pessoa("Maria", Sexo.FEMININO, 31),
                new Pessoa("Carla", Sexo.FEMININO, 26),
                new Pessoa("Marcos", Sexo.MASCULINO, 35),
                new Pessoa("Silvia", Sexo.FEMININO, 40)
        );
        return pessoas;
    }

}
```


### Criando uma Stream
Uma das formas para criarmos uma Stream é utilizamos o método **stream()** presente em classes e interfaces que implementam a interface Collection.<br/>
Exemplo:
```java
package laboratorio6.exemplos;

import java.util.List;
import java.util.stream.Stream;

public class Exemplo_1 {

    public static void main(String[] args) {

        List<Pessoa> pessoas = Pessoa.obtemListaPessoas();
        Stream<Pessoa> streamPessoas = pessoas.stream();

    }

}

```
Neste exemplo criamos uma Stream a partir da interface List, esta é apenas a forma de se criar uma Stream, porém ainda não iremos conseguir utilizá-la desta forma.<br/>

### Operações Intermediárias e Operações Terminais
Quando trabalhamos com a interface Stream devemos ter em mente que ela nos fornece dois tipos de operações:
 * Operações intermediárias retornam uma Stream, com operações intermediárias podemos realizar chamada de métodos Stream de forma encadeada.
 * Operações terminais retornam um valor ou o objeto esperado, com operações terminais não podemos mais acessar os métodos do Stream, para acessar os métodos Stream novamente deve ser criado outro Stream.

Alguns exemplos de operações intermediárias: filter(), map(), flatMap().<br/>
Alguns exemplos de operações terminais: collect(Collectors.toList()), count(), max(), min(). 

### Operação collect(Collectors.toList())
Esta é uma operação terminal, a mesma transforma uma Stream em uma lista novamente.<br/>
Exemplo de uso:
```java
package laboratorio6.exemplos;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exemplo_2 {

    public static void main(String[] args) {
        List<Pessoa> pessoas = Pessoa.obtemListaPessoas();
        Stream<Pessoa> pessoasStream = pessoas.stream();
 
        List<Pessoa> streamRevertidoParaLista = pessoasStream.collect(Collectors.toList());
        streamRevertidoParaLista.forEach(p -> System.out.println(p));
    }

}
```

#### Exercicio 1
Com base no código abaixo transforme a lista em uma Stream e atribua a mesma para a variável **listaConvertidaEmStream**, e logo em seguida reverta a Stream criada para uma lista novamente atribuindo a mesma para a variável **streamConvertidaEmLista**.
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercicio_1 {

    public static void main(String[] args) {
        List<String> listaNomes = Arrays.asList("João", "Maria", "Carla", "Roberta", "Jhon", "Sabrina");
        Stream<String> listaConvertidaEmStream = ?????;

        List<String> streamConvertidaEmLista = ?????;
        streamConvertidaEmLista.forEach(nome -> System.out.println(nome));
    }

}
```

### Operação count()
A operação **count()** conta quantos elementos a coleção possui e retorna este valor.<br/>
O tipo de retorno desta operação é um valor do tipo Long.<br/>
Exemplo de uso:
```java
package laboratorio6.exemplos;

import java.util.Arrays;
import java.util.List;

public class Exemplo_3 {

    public static void main(String[] args) {
        List<Pessoa> pessoas = Arrays.asList(
            new Pessoa("João", Sexo.MASCULINO, 30),
            new Pessoa("Maria", Sexo.FEMININO, 31)
        );

        Long totalPessoas = pessoas.stream().count();
        System.out.println(
                String.format("A lista possui %s elementos!",totalPessoas)
        );
    }

}
```

#### Exercício 2
Através do código abaixo utilize a operação **count()** para verificar e imprimir no console a quantidade de elementos que a lista possui .
```java
import java.util.Arrays;
import java.util.List;

public class Exercicio_2 {

    public static void main(String[] args) {
        List<String> listaNomes = Arrays.asList("João", "Maria", "Carla", "Roberta", "Jhon", "Sabrina");
    }
    
}
```

### Operações max() e min()
Operação max(): Encontrar um determinado objeto de uma lista que possua o maior valor de algum de seus atributos.<br/>
Operação min(): Encontrar um determinado objeto de uma lista que possua o menor valor de algum de seus atributos.<br/>
Essas duas operações retornam um objeto do tipo **Optional<T>** com base no tipo da lista no qual a operação está sendo executada.

Exemplo de uso:
```java
package laboratorio6.exemplos;

import java.util.List;
import java.util.Optional;

public class Exemplo_4 {

    public static void main(String[] args) {
        List<Pessoa> listaPessoas = Pessoa.obtemListaPessoas();
        Optional<Pessoa> optionalPessoaMaisVelha =  listaPessoas.stream()
                .max((pessoa1, pessoa2) -> pessoa1.getIdade().compareTo(pessoa2.getIdade()));

        Optional<Pessoa> optionalPessoaMaisNova =  listaPessoas.stream()
                .min((pessoa1, pessoa2) -> pessoa1.getIdade().compareTo(pessoa2.getIdade()));

        System.out.println(String.format("Pessoa mais velha: %s", optionalPessoaMaisVelha.get()));
        System.out.println(String.format("Pessoa mais nova: %s", optionalPessoaMaisNova.get()));
        
    }

}
```
No exemplo acima obtivemos a pessoa mais velha e a pessoa mais nova comparando o atributo idade de todos os objetos dentro das operações **max()** e **min()** utilizando expressões Lambda.

#### Exercicio 3
Com base no código abaixo obtenha e imprima o maior e menor valor contido na lista:
```java
import java.util.Arrays;
import java.util.List;

public class Exercicio_3 {

    public static void main(String[] args) {
        List<Integer> listaValores = Arrays.asList(10, 5, 8, 20, 2, 19, 31, 50);        
    }
    
}
```

### Operação filter()
A operação **filter()** é utilizada para realizarmos uma filtragem em um Stream e retornar um novo Stream com apenas os elementos que corresponderam a filtragem, desta forma os elementos que não corresponerem a filtragem não serão incluídos no novo Stream.<br/>
Exemplo de uso:
```java
package laboratorio6.exemplos;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exemplo_5 {

    public static void main(String[] args) {
        List<Pessoa> listaPessoas = Pessoa.obtemListaPessoas();
        Stream<Pessoa> streamPessoasSexoFeminino = listaPessoas.stream().filter(p -> p.getSexo().equals(Sexo.FEMININO));

        List<Pessoa> listaPessoasSexoFeminino = streamPessoasSexoFeminino.collect(Collectors.toList());
        listaPessoasSexoFeminino.forEach(p -> System.out.println(p));

    }

}
```

#### Exercicio 4
Considere a classe abaixo para este e os próximos exercícios:
```java
package laboratorio6.exercicio;

public class Produto {

    private String nome;
    private Double preco;

    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }
}
```

Com base no código abaixo realize uma filtragem na lista de produtos para que a mesma contenha apenas produtos com o preço acima de 1299.99.<br/>
Após ser realizada a filtragem converta o Stream criado para uma nova lista de produtos e imprima no console todos os produtos da lista criada.
```java
package laboratorio6.exercicio;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercicio_4 {

    public static void main(String[] args) {
        List<Produto> listaProdutos = Arrays.asList(
                new Produto("Xiaomi Mi 9", 1799.99),
                new Produto("Microondas", 299.00),
                new Produto("IPhone XS", 5299.99),
                new Produto("Notebook Dell", 2999.00),
                new Produto("Geladeira", 1299.99),
                new Produto("Samsung J5 Prime", 899.99)

        );
    }

}
```

### Operação map()
O **map()** é uma operação intermediária que permite transformar um objeto em algum outro tipo de objeto.<br/>
Exemplo:
```java
package laboratorio6.exemplos;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exemplo_6 {

    public static void main(String[] args) {
        List<Pessoa> pessoas = Pessoa.obtemListaPessoas();
        Stream<Pessoa> streamPessoas = pessoas.stream();
        Stream<String> streamNomesPessoas = streamPessoas.map(p -> p.getNome());
        List<String> listaNomesPessoas = streamNomesPessoas.collect(Collectors.toList());
        listaNomesPessoas.forEach(nome -> System.out.println(nome));

    }

}
```
Neste exemplo transformamos a lista de pessoas em uma Stream de Pessoas, em seguida utilizamos a operação **map()** para transformar o Stream de pessoas em um Stream de String povoando esta Stream com todas as propriedades **nome** da lista de pessoas.<br/>

#### Exercício 5
Com base no código abaixo, utilize a operação map() para montar uma nova lista contendo apenas os nomes de todos os produtos da lista de produtos.
```java
package laboratorio6.exercicio;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercicio_5 {

    public static void main(String[] args) {
        List<Produto> listaProdutos = Arrays.asList(
                new Produto("Xiaomi Mi 9", 1799.99),
                new Produto("Microondas", 299.00),
                new Produto("IPhone XS", 5299.99),
                new Produto("Notebook Dell", 2999.00),
                new Produto("Geladeira", 1299.99),
                new Produto("Samsung J5 Prime", 899.99)

        );

        List<String> listaNomeProdutos = ?????;
        listaNomeProdutos.forEach(p -> System.out.println(p));
    }

}
```

### Operação flatMap()
Em alguns casos desejamos obter uma lista que é o resultado da junção de várias outras listas.<br/>
O flatMap consegue obter este tipo de resultado concatenando várias listas, desde que elas sejam informadas no formato de uma Stream.<br/>
Exemplo:
```java
package laboratorio6.exemplos;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exemplo_7 {

    public static void main(String[] args) {

        List<Pessoa> listaPessoasSexoMasculino = Pessoa.obtemListaPessoas()
                .stream()
                .filter(p -> p.getSexo().equals(Sexo.MASCULINO))
                .collect(Collectors.toList());

        List<Pessoa> listaPessoasSexoFeminino = Pessoa.obtemListaPessoas()
                .stream()
                .filter(p -> p.getSexo().equals(Sexo.FEMININO))
                .collect(Collectors.toList());

        List<List<Pessoa>> listaTiposPessoas = Arrays.asList(listaPessoasSexoMasculino, listaPessoasSexoFeminino);
        List<Pessoa> listaTodasAsPessoas = listaTiposPessoas.stream().flatMap(tipo -> tipo.stream()).collect(Collectors.toList());
        listaTodasAsPessoas.forEach(p -> System.out.println(p));

    }

}
```

No exemplo acima criamos duas listas de pessoas, uma filtrando apenas pessoas do sexo masculino e a outra filtrando apenas pessoas do sexo feminino.<br/>
Em seguida criamos a variável **listaTiposPessoas** que é uma lista que contém uma lista de pessoas e atribuímos a ela a lista de pessoas do sexo masculino e a lista de pessoas do sexo feminino.<br/>
Através da **listaTiposPessoas** utilizamos a operação flatMap() para criar uma nova lista conténdo a junção das duas listas contidas na variável **listaTiposPessoas**.

#### Exercício 6 
