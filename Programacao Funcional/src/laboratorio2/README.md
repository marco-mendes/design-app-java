## Suporte Funcional do JDK8


### Materiais de preparação

[Métodos Default](https://dzone.com/articles/interface-default-methods-java)<br/>
[Method Reference](https://www.baeldung.com/java-method-references)<br/>
[Mais exemplos Method Reference](https://www.javatpoint.com/java-8-method-reference)



### Introdução

Neste laboratório apresentaremos um visão geral sobre o que o JDK8 trouxe como suporte a programação funcional para o Java 8.

Dentre eles possuímos:

* Expressões Lambda
* Interfaces Funcionais
* Métodos Default
* Method Reference
* Melhorias na interface Collection

O uso básico das expressões Lambda e Interfaces Funcionais foi abordado no laboratório 1.<br/>
Neste laboratório abordaremos o uso básico de Métodos Default e Method Reference.<br/>
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

### Exercício 1

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


### Exercício 2

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

