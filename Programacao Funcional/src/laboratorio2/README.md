## Suporte Funcional do JDK8


### Materiais de preparação

[Métodos Default](https://dzone.com/articles/interface-default-methods-java)<br/>
[Method Reference](https://www.baeldung.com/java-method-references)<br/>
[Classe Optional](https://medium.com/@racc.costa/optional-no-java-8-e-no-java-9-7c52c4b797f1)<br/>
[Mais exemplos Method Reference](https://www.javatpoint.com/java-8-method-reference)



### Introdução

Neste laboratório apresentaremos um visão geral sobre o que o JDK8 trouxe como suporte a programação funcional para o Java 8.

Dentre eles possuímos:

* Expressões Lambda
* Interfaces Funcionais
* Métodos Default
* Method Reference
* Optional
* Melhorias na interface Collection

O uso básico das expressões Lambda e Interfaces Funcionais foi abordado no laboratório 1.<br/>
Neste laboratório abordaremos o uso básico de Métodos Default, Method Reference e o uso da classe Optional para evitar o clássico erro NullPointerException.<br/>
Outros assuntos como as melhorias na interface Collection serão abordados nos próximos laboratórios.<br/>


### Métodos Default

Uma das novidades do Java 8 foram os métodos Default.

O modificador **default** permite realizar uma implementação concreta dentro de uma interface de forma a não causar incompatibilidade com o código legado.

Um exemplo de uso seria esse:

```java
import java.util.Arrays;
import java.util.List;

public class Exemplo_1 {

    public static void main(String[] args) {
        List<Integer> listaNotas = Arrays.asList(10, 8 ,6, 9, 7);

        Calculadora calculadora = new Calculadora();
        String resultado = String.format("Média das notas: %d", calculadora.calculaMedia(listaNotas));
        System.out.println(resultado);

    }

}

class Calculadora implements Calculator {
    @Override
    public int calculoSimples(int a, int b){
        return a + b;
    }
    
}

interface Calculator {

    int calculoSimples(int a, int b);

    default int calculaMedia(List<Integer> valores){
        int totalElementos = valores.size();
        int soma = 0;
        for(int valor : valores){
            soma += valor;
        }
        return soma / totalElementos;
    }

}
```

Como vimos não foi necessário sobrescrever o método **calculaMedia** da interface **Calculator** na classe **Calculadora**.

Isso ocorre pois o modificador default nos permite criar uma implementação concreta de método dentro de uma interface, e não nos obriga a implementar os métodos com esse modificador ao usarmos essa interface.

#### Exercício 1

Com base no código acima implemente os seguintes métodos na interface **Calculator** de forma a não quebrar o código já existente:

* calculaRaizQuadrada: Este método deve receber um valor do tipo inteiro e retornar a raiz quadrada do mesmo.
* elevarAoCubo: Este método deve receber um valor do tipo inteiro e retornar esse valor elevado ao cubo.

Após a criação desses métodos invoque cada um deles na classe Exercicio_1 para validar o funcionamento.

### Method Reference

**Method References** são um tipo especial de expressões lambda.

Eles são frequentemente usados para criar expressões lambda simples referenciando métodos existentes.

Existem quatro tipos de Method Reference:

- Métodos estáticos
- Métodos de instância de objetos específicos
- Métodos de instância de um objeto arbitrário de um tipo específico
- Construtor


Cada um deles exemplificado no material de preparação.

Abordaremos nesse laboratório apenas um exemplo de uso básico de **Method References**.

Exemplo de uso básico: 

```java

public class Exemplo_2 {

    public static void imprimeValorMaiusculo(String value){
        System.out.println(value.toUpperCase());
    }

    public static void main(String[] args) {
        List<String> nomes = Arrays.asList("Marry", "Jhon", "Natasha");
        nomes.forEach(Exemplo_2::imprimeValorMaiusculo);
    }
    
}
```


#### Exercício 2

Com base no código abaixo utilize o método **forEach** da lista de Pessoas para acessar o método **imprimePessoa** através de **Method Reference**.

```java

public class Exercicio_2 {

    public static void main(String[] args) {

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Marcio", 30));
        pessoas.add(new Pessoa("Marcela", 26));
        pessoas.add(new Pessoa("João", 29));
        pessoas.add(new Pessoa("Josefina", 21));

    }

}

class Pessoa {

    String nome;
    int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void imprimePessoa(){
        String textoAImprimir = String.format("Nome: %s | Idade: %d", this.nome, this.idade);
        System.out.println(textoAImprimir);
    }

}
```

### Introdução à Classe Optional
A principal proposta deste recurso é encapsular o retorno de métodos e informar se um valor do tipo <T> está presente ou ausente.<br/>
Com ele podemos:
 * Evitar erros NullPointerException
 * Escrever código mais limpo e elegante.

Os principais métodos da classe Optional são:
 * Optional.empty()
 * Optional.of()
 * Optional.ofNullable()
 * isPresent()
 * get()
 * filter()
 * map()
 * flatMap()
 * orElse()
 * orElseThrow()
 
Utilizaremos a seguinte classe para alguns exercícios da classe Optional:
```java
package laboratorio2.exercicio;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

enum TipoProduto {
    Congelados, Bebidas, Eletrodomesticos, Eletronicos
}

public class Produto {

    String id;
    String nome;
    TipoProduto tipo;
    String descricao;


    public Produto(String id, String nome, TipoProduto tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
    }

    public Produto(String id, String nome, TipoProduto tipo, String descricao) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public TipoProduto getTipo() {
        return tipo;
    }

    public Optional<String> getDescricao() {
        return Optional.ofNullable(descricao);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", tipo=" + tipo +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    public static List<Produto> obtemProdutos(){
        List<Produto> produtos = Arrays.asList(
                new Produto("1", "Sorvete", TipoProduto.Congelados),
                new Produto("2", "Cerveja", TipoProduto.Bebidas),
                new Produto("3", "Refrigerante", TipoProduto.Bebidas),
                new Produto("4", "Geladeira", TipoProduto.Eletrodomesticos),
                new Produto("5", "Chromecast", TipoProduto.Eletronicos, "Com ele você pode assistir seus filmes e séries em uma TV que não tenha a função Smart")
        );
        return produtos;
    }


}
```

  
 
### Criando Optionals:
Os métodos utilizados para criar um Optional são:
 * Optional.empty(): Retorna uma instância de Optional vazia.
 * Optional.of(): Retorna um Optional com o valor fornecido, deve ser usado apenas quando se tem certeza que o valor recebido não é nulo.
 * Optional.ofNullable(): Caso o valor recebido não seja nulo retorna um Optional com o valor, caso contrário retorna um Optional vazio.
 
Exemplos de criação de um Optional:
```java
import java.util.Optional;

public class Exemplo_3 {

    public static void main(String[] args) {

        Optional<String> optionalVazio = Optional.empty();
        Optional<String> optionalNaoNulo = Optional.of("Valor recebido não é nulo!");
        Optional<String> optionalPodeOuNaoSerNulo = Optional.ofNullable(null);
        Optional<String> optionalPodeOuNaoSerNulo1 = Optional.ofNullable("Optional não nulo");

    }

}
```


#### Exercicio_3
Com base no código abaixo altere a variável **produto** do método **main()** para ser do tipo Optional e receber o Optional que melhor se encaixe no cenário, lembrando que atualmente o valor recebido por essa variável pode ou não ser nulo.
```java
package laboratorio2.exercicio;

import java.util.List;

public class Exercicio_3 {

    public static Produto buscarProdutoPorId(String id){
        List<Produto> produtos = Produto.obtemProdutos();
        for(Produto produto : produtos){
            if(produto.id.equals(id)){
                return produto;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Produto produto = buscarProdutoPorId("5");
    }

}
```

### Método isPresent()
Este método é responsável por verificar se um valor está presente no Optional, se o valor existir retorna true, se não retorna false.<br/>
Exemplo de uso:
```java
import java.util.Optional;

public class Exemplo_4 {

    public static void main(String[] args) {

        Optional<String> optionalNulo = Optional.ofNullable(null);
        Optional<String> optionalNaoNulo = Optional.ofNullable("Optional não nulo");

        System.out.println(
                String.format("O Optional contém algum valor? %b", optionalNulo.isPresent())
        );
        System.out.println(
                String.format("O Optional contém algum valor? %b", optionalNaoNulo.isPresent())
        );
        
    }

}
```

### Método get()
Retorna o valor encapsulado no Optional, deve ser usado apenas com a certeza que o Optional não está vazio, caso contrário sua invocação irá retornar um NoSuchElementException.<br/>
Exemplo de uso:
```java
import java.util.Optional;

public class Exemplo_5 {

    public static void main(String[] args) {
        Optional<String> optionalNaoNulo = Optional.of("Não nulo!");
        System.out.println(optionalNaoNulo.get());
    }

}
```

#### Exercicio 4
Com base no código abaixo implemente o seguinte comportamento no método **imprimeSeEstiverPresente**:<br/>
Verifique se o valor do Optional está presente, se estiver imprima o valor do mesmo no console, caso contrário imprima a seguinte mensagem: "Produto não encontrado!"
```java
package laboratorio2.exercicio;

import java.util.List;
import java.util.Optional;

public class Exercicio_4 {

    public static Produto buscarProdutoPorId(String id){
        List<Produto> produtos = Produto.obtemProdutos();
        for(Produto produto : produtos){
            if(produto.id.equals(id)){
                return produto;
            }
        }
        return null;
    }

    public static void imprimeSeEstiverPresente(Optional<Produto> produto){

    }

    public static void main(String[] args) {
        List<Produto> produtos = Produto.obtemProdutos();
        Optional<Produto> produtoId1 = Optional.ofNullable(buscarProdutoPorId("1"));
        Optional<Produto> produtoId50 = Optional.ofNullable(buscarProdutoPorId("50"));

        imprimeSeEstiverPresente(produtoId1);
        imprimeSeEstiverPresente(produtoId50);

    }

}

```

### Método filter()
Este método é responsável por realizar uma filtragem no Optional, caso o Optional esteja de acordo com o filtro será retornado um Optional com o valor filtrado, caso contrário será retornado um Optional vazio.<br/>
Exemplo de uso:
```java
import java.util.Optional;

public class Exemplo_6 {

    public static void main(String[] args) {

        Optional<Integer> avaliacao = Optional.of(10);
        Optional<Integer> avaliacaoFiltrada = avaliacao.filter(v -> v > 0);
        if ((avaliacaoFiltrada.isPresent())) {
            System.out.println(avaliacaoFiltrada.get());
        } else {
            System.out.println("Valor não está de acordo com o filtro");
        }

    }

}
```

#### Exercicio 5
Com base no código abaixo altere o método **filtraEImprimeSeHouverDescricao** para filtrar se a propriedade **descricao** está presente no Optional.<br/>
Utilizando o Optional filtrado verifique se o Optional possui valor, se sim imprima a descrição do produto, se não imprima: "Descrição está vazia!"
```java
import java.util.Optional;

public class Exercicio_5 {

    public static void filtraEImprimeSeHouverDescricao(Optional<Produto> produto){
        
    }

    public static void main(String[] args) {

        Produto p1 = new Produto("1", "Geladeira", TipoProduto.Eletrodomesticos);
        Produto p2 = new Produto("2", "Galaxy J5 Prime", TipoProduto.Eletronicos, "Celular Samgung Galaxy J5 Prime");

        Optional<Produto> p1Optional = Optional.of(p1);
        Optional<Produto> p2Optional = Optional.of(p2);

        filtraEImprimeSeHouverDescricao(p1Optional);
        filtraEImprimeSeHouverDescricao(p2Optional);

    }

}
```

### Métodos map() e flatMap()
Os métodos map() e flatMap() são usados para transformar um objeto em outro.<br/>
A diferença entre eles é que o método map() mapeia o objeto que será retornado com o mesmo não sendo um Optional, já o flatMap() mapeia o Objeto que será retornado com o mesmo sendo um Optional.<br/>
No exemplo abaixo estamos transformando algumas propriedades de um objeto do tipo Celular em Strings.
```java
import java.util.Optional;

public class Exemplo_7 {

    public static void main(String[] args) {
        Celular c1 = new Celular("Apple", "Iphone XR", "Novo Iphone XR");

        Optional<Celular> optionalCelular1 = Optional.of(c1);
        
        String nomeCelular = optionalCelular1.map(Celular::getMarca).get();
        String descricaoCelular = optionalCelular1.flatMap(Celular::getDescricao).get();

    }

}

class Celular {

    String marca;
    String modelo;
    String descricao;

    public Celular(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Celular(String marca, String modelo, String descricao) {
        this.marca = marca;
        this.modelo = modelo;
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Optional<String> getDescricao() {
        return Optional.ofNullable(descricao);
    }
}
```

#### Exercício 6
Com base no código abaixo utilize map() e flatMap() para transformar e atribuir os valores das propriedades nome, tipo e descricao do objeto Produto para suas respectivas variáveis.
```java
import java.util.Optional;

public class Exercicio_6 {

    public static void main(String[] args) {

        Produto produto = new Produto("1", "Sorvete", TipoProduto.Congelados, "Sorvete de Morango");

        Optional<Produto> optionalProduto = Optional.of(produto);

        String nomeProduto = ?????;
        TipoProduto tipoProduto = ?????;
        String descricaoProduto = ?????;

        System.out.println(
                String.format("Nome Produto: %s | Tipo Produto: %s | Descrição produto: %s", nomeProduto, tipoProduto, descricaoProduto)
        );

    }

}
```

