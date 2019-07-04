## Introdução aos conceitos básicos da Programação Funcional

### Materiais de preparação
[Introdução da Programaçao Funcional](https://medium.com/labs-olx-brasil/programa%C3%A7%C3%A3o-funcional-vis%C3%A3o-geral-59ebdb4be244)<br/>
[Introdução à Lambdas](https://medium.com/@kasunpdh/java-lambda-expressions-3195f677ed38)<br/>
[Algumas dicas e melhores práticas sobre Lambdas](https://www.baeldung.com/java-8-lambda-expressions-tips)<br/>
[Manipulação de Exceção com Expressões Lambda](https://www.oodlestechnologies.com/blogs/Exception-Handling-with-Lambda-Expressions/)<br/>
[Caso queira se aprofundar mais em Lambdas](https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/Lambda-QuickStart/index.html)<br/>
[Inferência de Tipos](https://www.oodlestechnologies.com/blogs/Type-Inference-Of-Lambda-Expressions-In-Java-8/)

No material de preparação foi apresentada uma visão geral sobre a Programação Funcional e alguns de seus conceitos básicos como:

- Lambda 
- Function Composition
- Funções de ordem superior
- Funções puras e Impuras
- Interfaces Funcionais
- Inferência de tipos


Além disso foi abordado também as diferenças entre Programação Funcional e Programação Orientada a Objetos(POO)


Neste laboratório abordaremos uma visão prática sobre o uso básico de Lambdas, veremos como a Inferência de tipos é aplicada na prática além de exemplos de funções puras e impuras com lambdas.

### Introdução Expressões Lambda

Como vimos nos artigos de preparação, Lambda é uma forma clara e objetiva de representar um método usando apenas uma expressão.

Abaixo temos a estrutura de um lambda:

```java
(parametro) -> corpo da função
```



Existe também uma forma de usar Lambdas no caso da expressão necessitar de mais de uma linha para ser definida, neste caso definimos o corpo da função entre chaves.

```java
(parametro) -> {
    
    corpo da função
    
}
```

Neste caso se a expressão Lambda precisar retornar algo recomendamos usar o palavra chave **return** do Java para isso. 

Além disso vimos também que para realizar o uso de Lambdas precisamos de uma interface funcional.

Um exemplo do uso de Lambdas é para realizar a ordenação de uma lista.
```java
public class ExemplosLambda {

    public static void main(String[] args) {
        System.out.println(ordenaListaProdutosSemLambdas());
        System.out.println(ordenaListaProdutosComLambdas());
    }


    public static List<Produto> ordenaListaProdutosSemLambdas(){
        List<Produto> produtos = obtemListaProdutos();
        produtos.sort(new Comparator<Produto>() {
            @Override
            public int compare(Produto o1, Produto o2) {
                return o1.getPreco().compareTo(o2.getPreco());
            }
        });
        return produtos;
    }
    
    public static List<Produto> ordenaListaProdutosComLambdas(){
        List<Produto> produtos = obtemListaProdutos();
        produtos.sort((c1, c2) -> c1.getPreco().compareTo(c2.getPreco()));
        return produtos;
    }

    public static List<Produto> obtemListaProdutos(){
        List<Produto> listaProdutos = Arrays.asList(
                new Produto("Samsung J5 Prime", 899.00),
                new Produto("Xiaomi Mi 9", 2299.00),
                new Produto("Notebook Dell Inspiron 5566 A50P", 2999.00),
                new Produto("Impressora LexMark XXJ25", 799.00),
                new Produto("TV LG 42 Polegadas" , 1899.00),
                new Produto("Kindle 10A", 349.00)
        );
        return listaProdutos;
    }

}

class Produto {

    String nome;
    Double preco;

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
Neste exemplo possuímos 2 métodos de ordenação da lista de produtos.<br/>
O método **ordenaListaProdutosSemLambdas** exemplifica como era feita a ordenação de uma lista sem o uso de Lambdas, já o método **ordenaListaProdutosComLambdas** exemplifica como é simples e muito mais fácil realizar a mesma operação utilizando expressões Lambdas.

#### Exercício.
Para aquecer o conhecimento recém obtido e com base no código de exemplo crie um método chamado **ordenaListaProdutosPorNome** para ordenar os produtos por nome e retornar a lista de produtos ordenada.<br/>
Após isso invoque este método e imprima a lista retornada no console.


### Uso de Lambdas com Interfaces Funcionais

Uma interface funcional é uma interface com apenas um método abstrato.

Expressões lambda são convertidas em interfaces funcionais durante o tempo de execução.

A expressão lambda deve respeitar o contrato da interface ao qual ela será convertida, deve declarar os mesmos parâmetros e o tipo de retorno deve ser o mesmo.

Podemos exemplificar o uso de Interfaces Funcionais com lambda da seguinte forma:

Possuímos a interface funcional chamada **TestaAlgo**, essa interface recebe um parâmetro genérico e tem como objetivo executar um teste lambda e retornar o resultado do mesmo.

O método **test()** irá executar a expressão lambda recebida pela interface **TestaAlgo**.

```java
interface TestaAlgo<T> {
    boolean test(T t);
}
```



Podemos usar essa interface da seguinte forma:

```java
TestaAlgo<List<Integer>> testador = (lista) -> lista.size() > 5;
List<Integer> listaNumeros = Arrays.asList(1,2,3,4,5,6);

System.out.println("Resultado do teste: ");
System.out.println("A Lista possui mais de 5 elementos? " + testador.test(listaNumeros));
```

#### Exercício
Com base no exemplo acima crie uma interface funcional chamada Calcular, e dentro dessa interface crie um método chamado apply que receba dois números inteiros e retorne um número inteiro.<br/>
Utilize a interface Calcular para realizar a soma de 2 números e retornar o resultado da mesma.
Utilize os números 50 e 75 como parâmetro e imprima o resultado da utilização da interface funcional Calcular.