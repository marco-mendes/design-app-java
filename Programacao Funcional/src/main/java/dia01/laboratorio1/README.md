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
- Funções puras
- Interfaces Funcionais
- Inferência de tipos


Além disso foi abordado também as diferenças entre Programação Funcional e Programação Orientada a Objetos(POO).


Neste laboratório abordaremos uma visão prática sobre o uso básico de Lambdas, veremos como a Inferência de tipos é aplicada na prática e também veremos um exemplo de uso básico de interfaces funcionais<br/>
Outros assuntos como Function composition, Funções de ordem superior e Funções puras serão abordados com mais detalhes futuramente.


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
public class Exemplo_1 {

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

    public static void main(String[] args) {
        System.out.println(ordenaListaProdutosSemLambdas());
        System.out.println(ordenaListaProdutosComLambdas());
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

#### Exercício 1
Para aquecer o conhecimento recém obtido e com base no código de exemplo crie um método chamado **ordenaListaProdutosPorNome** para ordenar os produtos por nome e retornar a lista de produtos ordenada.<br/>
Após isso invoque este método e imprima a lista retornada no console.


### Uso de Lambdas com Interfaces Funcionais

Uma interface funcional é uma interface com apenas um método abstrato.

Expressões lambda são convertidas em interfaces funcionais durante o tempo de execução.

A expressão lambda deve respeitar o contrato da interface ao qual ela será convertida, deve declarar os mesmos parâmetros e o tipo de retorno deve ser o mesmo.

Podemos exemplificar o uso de Interfaces Funcionais com lambda da seguinte forma:

Possuímos a interface funcional chamada **TestarAlgo**, essa interface recebe uma lista e tem como objetivo executar um teste lambda e retornar o resultado do mesmo.

O método **test()** irá executar a expressão lambda recebida pela interface **TestarAlgo**.

```java
interface TestarAlgo {
    boolean test(List lista);
}
```



Podemos usar essa interface da seguinte forma:

```java
TestarAlgo testador = (lista) -> lista.size() > 5;
List<Integer> listaNumeros = Arrays.asList(1,2,3,4,5,6);

System.out.println("Resultado do teste: ");
System.out.println("A Lista possui mais de 5 elementos? " + testador.test(listaNumeros));
```

#### Exercício 2
Como base no exemplo acima altere a interface TestarAlgo para receber como parâmetro um número inteiro.<br/>
Utilize a interface TestarAlgo para verificar se um número é um número par, caso seja a expressão lambda deve retornar true caso contrário deve retornar false.<br/>
Imprima o resultado do teste no console.<br/>
Código base:
```java
public class Exercicio_2 {

    public static void main(String[] args) {

    }   
    
}

interface TestarAlgo {
    boolean test(Integer numero);
}
```

### Tratamento de Exceptions com Lambda
No material de preparação vimos como é feito o tratamento de exceptions utilizando Lambdas.<br/>
No exemplo abaixo simulamos um caso comum de erro no Java, uma divisão por 0 e exemplificamos o tratamento da mesma.

```java
public class ExemploLambdaComException {

    public static void main(String[] args) {

        CalculoComum calculoComum = (numero1, numero2) -> {

            try {
                int resultado = numero1 / numero2;
                System.out.println(resultado);
            } catch (ArithmeticException e) {
                System.out.println("Operação inválida: " + e.getMessage());
                e.printStackTrace();
            }

        };

        calculoComum.calculaEImprimeResultado(10,2);
        calculoComum.calculaEImprimeResultado(5,0);

    }

}

interface CalculoComum {

    void calculaEImprimeResultado(int numero1, int numero2) throws ArithmeticException;

}
```

### Inferência de Tipos

A inferência de tipos refere-se à detecção automática do tipo de dados de uma expressão em uma linguagem de programação.

Um bom exemplo disso são interfaces funcionais que fazem o uso de Generics, a interface será definida genericamente e o compilador de certa forma irá "adivinhar" o tipo de dados passado ao método e o converter para o tipo correto durante a compilação.

Vamos exemplificar isso da seguinte forma:

Você possui uma interface chamada **Operator** que possui um único método chamado **apply()**, este método recebe dois parâmetros genéricos, executa uma operação e retorna um valor como no exemplo abaixo:

```java
interface Operator<T> {

    T apply(T a, T b);

}
```

Aqui possuímos a classe que irá utilizar essa interface:

```java
class Exemplo_3 {

    public static <T> T calcular(Operator<T> operacao, T value1, T value2){
        return operacao.apply(value1,value2);
    }

    public static void main(String[] args) {
		System.out.println(calcular((a, b) -> a + b, 5, 20));
    }

}
```

Como podemos ver na classe **Exemplo_3** nosso método **calcular** recebe como parâmetro um objeto do tipo **Operator <T&gt;** e recebe 2 parâmetros genéricos.

Durante a execução do método **calcular** não definimos explicitamente nenhum tipo de dado e mesmo assim o programa compila e executa normalmente nos retornado a soma dos valores 5 e 20.



Isso ocorre pois o compilador "adivinha" o tipo de dados recebido e realiza a inferência dos mesmos na execução do método.



#### Exercício 3
Com base no código do exemplo acima crie uma interface funcional chamada **ComplexOperator**, essa interface deve possuir um método chamado **apply** que recebe um valor genérico e retorna um valor genérico.<br/>
Na classe **Exercicio_3** crie um método chamado **calculoComplexo** que receba como parâmetro um **ComplexOperator**, um parâmetro genérico e retorne um valor genérico.<br/>
Invoque este método de forma a conseguir calcular a raiz quadrada do número passado como parâmetro e imprima o valor retornado.<br/>
Utilize o valor 25.0 para fins de teste.

Código para o exercício:

```java
public class Exercicio_3 {

    public static void main(String[] args) {

    }

}

```
