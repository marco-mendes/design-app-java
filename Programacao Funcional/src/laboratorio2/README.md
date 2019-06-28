## Suporte Funcional do JDK8



### Materiais de preparação

[Métodos Default](https://dzone.com/articles/interface-default-methods-java)

[Method Reference](https://www.baeldung.com/java-method-references)

[Mais exemplos Method Reference](https://www.javatpoint.com/java-8-method-reference)





### Introdução

Neste laboratório apresentaremos um visão geral sobre o que o JDK8 trouxe como suporte a programação funcional para o Java 8.

Dentre eles possuímos:

* Expressões Lambda
* Interfaces Funcionais
* Métodos Default
* Method Reference



Além dessas melhorias possuímos também as Streams.

Em resumos as Streams foram introduzidas para facilitar a manipulação e computação de dados dentro de uma coleção.

As Streams são abordadas nos próximos laboratórios com mais detalhes.



### Expressões Lambda

Como vimos no laboratório 1 as expressões Lambda são uma forma clara e objetiva de representar um método usando apenas uma expressão.

Esta foi uma das abordagens do Java 8 para a programação funcional.



### Interfaces Funcionais

No laboratório 1 abordamos também as Interfaces Funcionais que são interfaces com apenas 1 método abstrato.

Expressões lambda são convertidas em interfaces funcionais durante o tempo de execução.

A expressão lambda deve respeitar o contrato da interface ao qual ela será convertida, deve declarar os mesmos parâmetros e o tipo de retorno deve ser o mesmo.

O Java 8 possui algumas interfaces funcionais prontas que podemos utilizar, elas são divididas em 5 categorias, são elas:

* **Function**: Transforma seus argumentos e retorna um valor.
* **Predicate**: São utilizados para executar um teste e retornar um valor booleano.
* **Consumer**: Recebe argumentos porém não retorna um valor.
* **Supplier**: Não recebe argumentos porém retorna um valor.
* **Operator**: Recebe argumentos e executa qualquer tipo de operação.

Cada uma dessas será abordada detalhadamente nos próximos laboratórios.



### Métodos Default

Uma das novidades do Java 8 foram os métodos Default.

O modificador **default** permite que adicionemos novos métodos a interfaces sem o risco de perdemos a compatibilidade com versões anteriores do código.

Este modificador foi introduzido devido seguinte necessidade:

Suponhamos que somos da equipe de desenvolvimento do Java, precisamos de uma forma de atualizar a Inteface **List** sem causar incompatibilidade em todo o código legado do Java.

Antes dos métodos default teríamos que declarar o novo método e ir em todos os trechos de código que usam a interface **List** e implementar esse novo método.

Essa não é uma boa abordagem por que além da equipe de desenvolvimento do Java, todos os desenvolvedores que utilizam essa interface teriam que implementar este novo método em seus sistemas.

Seria uma grande dor de cabeça para ambos os lados.

Visto isso a equipe do Java criou o modificador **default**, este modificador permite realizar uma implementação concreta dentro de uma interface de forma a não causar incompatibilidade com o código legado.

Um exemplo de uso seria esse:

```java
public class ExemplosSuporteFuncionalJDK8 {

    public static void main(String[] args) {
        UsoDefaultExemplo usoDefaultExemplo = new UsoDefaultExemplo();
        usoDefaultExemplo.MeuNovoMetodo();
    }

}

class UsoDefaultExemplo implements IntefaceComDefault {

    public UsoDefaultExemplo() {

    }
}

interface IntefaceComDefault {

    default void MeuNovoMetodo(){
        System.out.println("Novo método");
    }

}
```

Como vimos não foi necessário sobrescrever o método **MeuNovoMetodo** da interface **IntefaceComDefault** para realizar o uso do novo método na classe **UsoDefaultExemplo**.

Isso ocorre pois o modificador default nos permite criar uma implementação concreta de método dentro de uma interface, e não nos obriga a implementar os métodos com esse modificador ao usarmos essa interface.

Para se aprofundar mais em métodos default leia o material de preparação sobre [métodos default]([https://medium.com/@RafaelSermenho/m%C3%A9todos-default-java-8-d0ca312fea47](https://medium.com/@RafaelSermenho/métodos-default-java-8-d0ca312fea47))



### Method Reference

**Method References são um tipo especial de expressões lambda** .

Eles são frequentemente usados para criar expressões lambda simples referenciando métodos existentes.

Existem quatro tipos de referências de métodos:

- Métodos estáticos
- Métodos de instância de objetos específicos
- Métodos de instância de um objeto arbitrário de um tipo específico
- Construtor



O uso de cada um deles foi exemplificado no material de preparação.



### Exercício 1

Com base no código abaixo implemente os seguintes métodos na interface Calculator de forma a não quebrar o código existente:

* calculaRaizQuadrada: Este método deve receber um valor do tipo inteiro e retornar a raiz quadrada do mesmo.
* elevarAoCubo: Este método deve receber um valor do tipo inteiro e retornar esse valor elevado ao cubo.

```java
public class ExercicioSuporteFuncionalJDK8 implements Calculator {

    public static void main(String[] args) {
        
    }

    @Override
    public int calculoSimples(int a, int b){
        return a + b;
    }

}

interface Calculator {

    int calculoSimples(int a, int b);

}
```



### Exercício 2

Com base no código resolvido abaixo utilize o método forEach da lista de Pessoas para acessar o método imprimePessoa através de **Method Reference** para imprimir o nome de cada pessoa na lista.

```java
public class Exercicio_2_SuporteFuncionalJDK8 {

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
        System.out.println("Nome: " + this.nome + " | Idade: " + this.idade);
    }

}
```

