## Design Pattern Builder

### Material de preparação
[Pattern Bulder](https://dzone.com/articles/design-patterns-the-builder-pattern)<br/>
[Pattern Builder com Java 8](https://medium.com/beingprofessional/think-functional-advanced-builder-pattern-using-lambda-284714b85ed5)


### Visão geral do Pattern Builder
O Pattern Builder é usado para facilitar a criação um objeto muito complexo onde seus construtores exigem muitos parâmetros.<br/>
Suponhamos que precisamos criar uma classe Pessoa com diversas informações de uma pessoa, provavelmente faríamos algo semelhante a isso: 
```java
public class Pessoa {

    private String primeiroNome;
    private String ultimoNome;
    private int idade;
    private String nomeDaMae;
    private String nomeDoPai;
    private double altura;
    private double peso;

    public Person(String primeiroNome, String ultimoNome, int idade, String nomeDaMae, String nomeDoPai, double altura, double peso) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.idade = idade;
        this.nomeDaMae = nomeDaMae;
        this.nomeDoPai = nomeDoPai;
        this.altura = altura;
        this.peso = peso;
    }
    
    // Getters e Setters
    
}
```
Bom, parece bem simples certo? Porém instânciar esse objeto não é tão simples quanto parece conforme podemos ver no exemplo abaixo:
```java
Pessoa pessoa = new Pessoa("Carol", "Silva", 32, "Raquel Silva", "Rogerio Silva", 1.65, 68);
```
Nosso contrutor não é nada descritivo, com isso estaríamos abertos a erros durante a criação do objeto Pessoa.<br/>
Inicialmente nosso construtor pode até ser considerado simples porém suponhamos que a classe deve atender ao seguinte requisito:
 * Ouve a necessidade de incluir mais 10 parâmetros nessa classe, todos opcionais.
 
Ao implementar o requisito fictício apresentado acima a estrutura da Classe Pessoa não ficaria tão simples, teríamos que criar vários construtores para essa classe para 
atender ao requisito de parâmetros opcionais e com isso teríamos que criar construtores cada vez mais complexos além de serem de difícil manutenção e compreensão.<br/>
Isso se parece um problema agora certo? Podemos resolver isso utilizando o Pattern Builder.

Normalmente o padrão Builder é estruturado em duas classes: a classe base e a classe Builder, que é uma classe interna responsável pela criação da classe base.<br/>
Abordaremos neste laboratório um exemplo de implementação deste padrão com e sem a programação funcional com os pós e contras de cada implementação.


### Implementação não funcional 
Como foi abordado na introdução a este padrão possuímos duas classes que devem ser implementadas para utilizar este padrão, são elas a classe base e a classe interna Builder.<br/>
Podemos implementá-los da seguinte forma:
```java
public class Pessoa {

    private String primeiroNome;
    private String ultimoNome;
    private int idade;
    private String nomeDaMae;
    private String nomeDoPai;
    private double altura;
    private double peso;

    private Pessoa(){

    }

    public static class Builder {

        private String primeiroNome;
        private String ultimoNome;
        private int idade;
        private String nomeDaMae;
        private String nomeDoPai;
        private double altura;
        private double peso;

        public Builder() {

        }

        public Builder primeiroNome(String primeiroNome) {
            this.primeiroNome = primeiroNome;
            return this;
        }

        public Builder ultimoNome(String ultimoNome) {
            this.ultimoNome = ultimoNome;
            return this;
        }

        public Builder idade(int idade) {
            this.idade = idade;
            return this;
        }

        public Builder nomeDaMae(String nomeDaMae) {
            this.nomeDaMae = nomeDaMae;
            return this;
        }

        public Builder nomeDoPai(String nomeDoPai) {
            this.nomeDoPai = nomeDoPai;
            return this;
        }

        public Builder altura(double altura) {
            this.altura = altura;
            return this;
        }

        public Builder peso(double peso) {
            this.peso = peso;
            return this;
        }

        public Pessoa build() {
            Pessoa pessoa = new Pessoa();
            pessoa.primeiroNome = this.primeiroNome;
            pessoa.ultimoNome = this.ultimoNome;
            pessoa.idade = this.idade;
            pessoa.nomeDaMae = this.nomeDaMae;
            pessoa.nomeDoPai = this.nomeDoPai;
            pessoa.altura = this.altura;
            pessoa.peso = this.peso;
            return pessoa;
        }

    }

    // Getters e Setters

}
```

Podemos instâncias o objeto Pessoa da seguinte forma utilizando o Pattern Builder:
```java
Pessoa pessoa = new Pessoa.Builder()
        .primeiroNome("Márcia")
        .ultimoNome("Ribeiro")
        .idade(32)
        .nomeDaMae("Elisa Ribeiro")
        .nomeDoPai("Caio Ribeiro")
        .altura(1.65)
        .peso(72)
        .build();
```

Conforme vimos no exemplo acima criamos a classe pessoa com todos os seus atributos, alteramos o modificador de acesso ao construtor da classe Pessoa para privado, dessa forma 
só é possível instâncias a classe Pessoa através de nosso Buider.<br/>
Substituímos nosso construtor complexo por um construtor vazio pois não iremos utilizar aquele construtor complexo neste exemplo.

Possuímos também a classe estática interna Builder, esta classe possui todos os atributos da classe Pessoa, a classe Builder também possui alguns métodos para setar cada uma 
das propriedades presentes na classe Pessoa.<br/>
Um ponto curioso que podemos notar é que sempre que setamos um valor para o Builder o mesmo retorna a si mesmo, o motivo disso é para que possamos utilizar o encadeamento 
de métodos durante a criação do objeto Pessoa utilizando o Builder, dessa forma podemos setar apenas os parâmetros que realmente forem necessários.<br/>
Para finalizar a criação do objeto Pessoa possuímos o método **build()** em nossa classe Builder que retorna uma nova instância com todos os atributos da classe Pessoa.
 
Conforme observamos o Pattern Builder é bem simples de ser implementado, caso seja necessário adicionar novas propriedades a classe Pessoa bastaria apenas adicionar essas 
propriedades em nosso Buider, em seguida criar um método para setar o valor da nova propriedade no Builder e setar o valor do mesmo na instância criada do objeto Pessoa 
dentro do método **build()**.

#### Pós e contras desta forma de implementação
Pós: 
 * O código é mais sustentável se o número de campos necessários para criar o objeto for maior que 4 ou 5.
 * A criação do objeto é menos sujeito a erros, pois o usuário saberá exatamente quais parâmetros ele está setando durante a criação do objeto.
Contras:
 * O Pattern Builder é detalhado e requer duplicação de código, pois precisamos copiar todos os campos da classe Original para instânciar o objeto base da mesma.
 * Caso sejam adicionadas N novas propriedades devemos criar N novos métodos para setar essas novas propriedades. 

### Implementação funcional
Utilizando a programação funcional podemos melhorar esse padrão da seguinte forma:
```java
import java.util.function.Consumer;

public class Pessoa {

    private String primeiroNome;
    private String ultimoNome;
    private int idade;
    private String nomeDaMae;
    private String nomeDoPai;
    private double altura;
    private double peso;

    private Pessoa(){

    }

    public static class Builder {

        public String primeiroNome;
        public String ultimoNome;
        public int idade;
        public String nomeDaMae;
        public String nomeDoPai;
        public double altura;
        public double peso;

        public Builder() {

        }

        public Builder set(Consumer<Builder> builderConsumer) {
            builderConsumer.accept(this);
            return this;
        }

        public Pessoa build() {
            Pessoa pessoa = new Pessoa();
            pessoa.primeiroNome = this.primeiroNome;
            pessoa.ultimoNome = this.ultimoNome;
            pessoa.idade = this.idade;
            pessoa.nomeDaMae = this.nomeDaMae;
            pessoa.nomeDoPai = this.nomeDoPai;
            pessoa.altura = this.altura;
            pessoa.peso = this.peso;
            return pessoa;
        }

    }

    // Getters e Setters
    
}
```

Podemos instâncias o objeto Pessoa da seguinte forma utilizando o Pattern Builder:
```java
Pessoa pessoa = new Pessoa.Builder()
        .set(p -> {
            p.primeiroNome = "Márcia";
            p.ultimoNome = "Ribeiro";
            p.idade = 32;
            p.nomeDaMae = "Elisa Ribeiro";
            p.nomeDoPai = "Caio Ribeiro";
            p.altura = 1.65;
            p.peso = 72;
        }).build();
```

No exemplo acima substituímos todos os métodos responsáveis por setar o valor do objeto por um método que demos o nome de **set()**, 
este método recebe um Consumer no qual podemos utilizar uma expressão Labmda para setar todos os valores do novo objeto.<br/>
Isso é possível pois todas as propriedades de nossa classe Builder estão com o modificador de acesso **public**.

#### Pós e contras desta forma de implementação
Pós:
 * Não precisamos criar N métodos para setar as propriedadades da classe base pois com um único método somos capazes de encapsular 
as instruções de atribuição em uma cadeia de expressões lambda.
Contras:
 * Como a set dos valores é feito na expressão lambda, as propriedades da classe Builder devem ser públicas para podermos acessá-las.
 
### Exercício
Seu objetivo nesse exercício é a melhoria de um código existente que aplica o Pattern Builder, você deverá aplicar os recursos da programação funcional abordados nesse 
laboratório para melhoria do código existente.<br/>
Você encontrará o código deste exercício neste [link](./exercicio/)