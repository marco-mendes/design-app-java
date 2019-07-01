## Introdução aos conceitos básicos da Programação Funcional e uso básico de Lambdas

### Materiais de preparação
[Introdução da Programaçao Funcional](https://medium.com/labs-olx-brasil/programa%C3%A7%C3%A3o-funcional-vis%C3%A3o-geral-59ebdb4be244)<br/>
[Introdução à Lambdas](http://blog.gabrielamorim.com/java-8-expressoes-lambda-closures-interfaces-funcionais-e-um-pouco-mais/)<br/>
[Como escrever Lambdas multilinha](https://www.gunnargissel.com/how-to-write-a-multiline-lambda-in-java8.html)<br/>
[Algumas dicas e melhores práticas sobre Lambdas](https://www.baeldung.com/java-8-lambda-expressions-tips)<br/>
[Uso de lambdas com Functions, Streams e Collections](https://rodrigouchoa.wordpress.com/2014/05/20/novidades-do-java-8-lambda-expressions/)<br/>
[Manipulação de Exceção com Expressões Lambda](https://www.oodlestechnologies.com/blogs/Exception-Handling-with-Lambda-Expressions/)<br/>
[Caso queira se aprofundar mais em Lambdas](https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/Lambda-QuickStart/index.html)<br/>
[Inferência de Tipos](https://www.oodlestechnologies.com/blogs/Type-Inference-Of-Lambda-Expressions-In-Java-8/)

No material de preparação foi apresentada uma visão geral sobre a Programação Funcional e alguns de seus conceitos básicos como:

- Function Composition
- Lambda 
- Inferência de tipos
- Funções puras e Impuras (Conceito)
- Funções de ordem superior (Conceito)



Além disso foi abordado também as diferenças entre Programação Funcional e Programação Orientada a Objetos(POO)


Neste laboratório abordaremos uma visão prática sobre o uso básico de Lambdas, veremos como a Inferência de tipos é aplicada na prática além de exemplos de funções puras e impuras com lambdas.

Conceitos como **Function Composition** e **Funções de Ordem superior** serão abordados com mais detalhes nos próximos laboratórios em conjunto com as **Streams** e a **Interface Funcional Function**.



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

Neste exemplo vemos como era realizada a ordenação de listas através do método **sort()** antes do uso das Lambdas onde era necessário criarmos uma classe anônima dentro da invocação do método  **sort()**:

```java
public static void ordenacaoAntesLambdas(){
  List<String> listaNomes = Arrays.asList("Joao", "Maria", "Dalva", "Vilma", "Carlos", "Roberto");
  listaNomes.sort(new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
                  return o1.compareTo(o2);
    }
  });
  System.out.println(listaNomes);
}
```

Com o Java 8 já podemos substituir este trecho de código por esse através do uso de lambdas da seguinte forma:
```java
public static void ordenacaoComLambdas(){
  List<String> listaNomes = Arrays.asList("Joao", "Maria", "Dalva", "Vilma", "Carlos", "Roberto");
  listaNomes.sort((c1, c2) -> c1.compareTo(c2));
  System.out.println(listaNomes);
}
```
Este é apenas um dos exemplo de uso dentro da interface List.



### Funções puras e impuras com Lambda

Conforme foi abordado no material de preparação as Funções Puras possuem 3 características básicas que são:

* **Retorna sempre o mesmo resultado quando passados os mesmos parâmetros**

* **Depende unicamente dos argumentos passados**

* **Não produz efeitos colaterais (side effects)**

  

Podemos usar como exemplo de função pura o seguinte exemplo partindo da interface List:

````java
List<Integer> lista = Arrays.asList(1,2,3,4,5);

lista.forEach((v) -> System.out.println(v * 2));
````

Neste exemplo estamos imprimindo o valor de todos os elementos de uma lista multiplicados por 2.



Sobre as funções impuras:

* **Sofrem interferência de fatores externos a expressão lambda.**
* **Podem causar efeitos colaterais na aplicação, seja alterando o valor de alguma variável local da classe ou algo do tipo.**

Podemos considerar o seguinte exemplo como uma função impura:

```java
List<Integer> lista = Arrays.asList(1,2,3,4,5);

int multiplicador = 5;

lista.forEach((v) -> System.out.println(v * multiplicador));
```

Neste exemplo a expressão lambda acessa uma variável externa à declaração de seu escopo, com isso seu retorno pode variar de acordo com o valor da variável **multiplicador**.



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

No exemplo acima estamos testando através de uma expressão lambda se a lista recebida como parâmetro possui mais de 5 elementos.

Ao executar o método **test()** teremos o retorno true indicando que a lista possui mais de 5 elementos.


### Tratamento de Exceptions com Lambda

Uma expressão Lambda pode lança uma exceção, mas essa exceção deve ser compatível com aquelas especificadas na cláusula **throws** do método na interface funcional.

Se um corpo de expressão lambda lançar uma exceção a mesma deve ser igual ou subtipo da exceção declarada na cláusula **throws** da interface funcional.

Se uma interface funcional não especificar nenhuma exceção com uma cláusula **throws**, a expressão Lambda também não poderá gerar nenhuma exceção.


Suponhamos que temos uma interface funcional chamada **CalculoComum**, essa interface realiza uma operação com 2 números inteiros e retorna um resultado com base na operação definida pela expressão lambda.

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
class Calculadora {

    public static void main(String[] args) {
		System.out.println(calcular((a, b) -> a + b, 5, 20));
    }

    public static <T> T calcular(Operator<T> operacao, T value1, T value2){
        return operacao.apply(value1,value2);
    }

}
```

Como podemos ver na classe **Calculadora** nosso método **calcular** recebe como parâmetro um objeto do tipo **Operator <T&gt;** e recebe 2 parâmetros genéricos.

Durante a execução do método **calcular** não definimos explicitamente nenhum tipo de dado e mesmo assim o programa compila e executa normalmente nos retornado a soma dos valores 5 e 20.



Isso ocorre pois o compilador "adivinha" o tipo de dados recebido e realiza a inferência dos mesmos na execução do método.



### Exercício

* Com base no código abaixo crie uma interface funcional chamada **ComplexOperator**, essa interface deve possuir um método que recebe um valor genérico e retorna um valor genérico.
* Na classe **ExercicioLambda** utilize a interface funcional **ComplexOperator** para calcular a raiz quadrada de um número.
* Utilize o número 25 como um exemplo para testar a interface **ComplexOperator** e imprima o resultado do teste.

Código para o exercício:

```java
class ExercicioLambda {

    public static void main(String[] args) {	 
    
    }
}
```

