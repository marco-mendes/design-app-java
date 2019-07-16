## Design Pattern Decorator utilizando programação funcional

### Material de preparação
[Pattern Decorator com e sem programação funcional](https://gssachdeva.wordpress.com/2015/12/04/java-8-lambda-expression-for-design-patterns-decorator-design-pattern/)

### Visão geral do Pattern Decorator
Este padrão permite que um comportamento seja adicionado a um objeto individual, seja estaticamente ou dinâmicamente, sem afetar o comportamento de outros objetos da mesma classe.<br/>
Os principais participantes do padrão Decorator estão representados abaixo:
 * **Component**: Especifica a interface base com um único método para todos os objetos que podem ter responsabilidades adicionadas a eles dinamicamente.
 * **ConcreteComponent**: Define um objeto concreto ao qual responsabilidades adicionais podem ser adicionadas.
 * **Decorador**: Define uma classe abstrata que implementa nosso Component, esta classe recebe um objeto do tipo Component e executa seu método único.
 * **ConcreteDecorator**: Define um objeto Decorator concreto com responsabilidades baseado em um ConcreteComponent.

A relação entre eles é mostrada abaixo:<br/>
<img src="https://gssachdeva.files.wordpress.com/2015/12/decorator.png?w=640"/>
 
Vamos ver um exemplo concreto do padrão de Decorator e após isso ver como ele é melhorado com expressões lambda.

### Implementação orientadas a objetos
Suponhamos que possuímos um objeto do tipo Carro e gostariámos de atribuir a ele o Pattern Decorator, podemos fazer da seguinte forma:

#### Implementação do Component:
Nosso component pode ser implementado da seguinte forma:
```java
public interface Carro {

    String describe();

}
```

#### Implementação de um ConcreteComponent
Nosso ConcreteComponent seria algo como a classe abaixo:
```java
public class CarroBasico implements Carro {

    @Override
    public String describe() {
        return "Carro básico";
    }

}
```

#### Implementação do Decorator
Nosso Decorator pode ser implementado da seguinte forma:
```java
public abstract class CarroDecorator implements Carro {

    protected Carro carro;

    CarroDecorator(Carro carro){
        this.carro = carro;
    }

    @Override
    public String describe() {
        return carro.describe();
    }

}
```

#### Implementação do ConcreteDecorator
Abaixo alguns exemplos de implementação de Concrete Decorators
```java
public class CarroCompactoDecorator extends CarroDecorator {

    CarroCompactoDecorator(Carro carro){
        super(carro);
    }

    @Override
    public String describe() {
        return (super.describe() + " Compacto");
    }
}
```

```java
public class CarroEsportivoDecorator extends CarroDecorator {

    CarroEsportivoDecorator(Carro carro){
        super(carro);
    }

    @Override
    public String describe(){
        return (super.describe() + " Esportivo");
    }

}
```

```java
public class CarroSedaDecorator extends CarroDecorator {

    CarroSedaDecorator(Carro carro){
        super(carro);
    }

    @Override
    public String describe(){
        return (super.describe() + " Sedã");
    }

}
```

#### Utilizando nosso Decorator
Abaixo um exemplo de utilização do mesmo:
```java
import java.util.ArrayList;
import java.util.List;

public class CarroDescriptionMain {

    public static void main(String[] args) {
        CarroBasico carroBasico = new CarroBasico();
        CarroCompactoDecorator carroCompacto = new CarroCompactoDecorator(carroBasico);
        CarroEsportivoDecorator carroEsportivo = new CarroEsportivoDecorator(carroBasico);
        CarroSedaDecorator carroSeda = new CarroSedaDecorator(carroBasico);

        List<Carro> carroList = new ArrayList<Carro>();
        carroList.add(carroCompacto);
        carroList.add(carroEsportivo);
        carroList.add(carroSeda);

        for(Carro carro : carroList){
            System.out.println(carro.describe());
        }

    }

}
```


### Implementação Funcional
Vimos acima como era feita a implemetanção do Pattern Decorator antes da programação funcional do Java 8, veremos aqui como melhorar essa implementação de forma a simplificar a mesma com o uso de Lambdas<br/>

Utilizando a programação funcional nosso **Component** e **ConcreteComponent** não sofrem modificações.<br/>
Já nossas classes **Decorator** e **ConcreteDecorator** não tem mais utilizade pois podemos substituí-las facilmente por expressões Lambda.<br/>
Utilizando a programação funcional nossa implementação do Pattern Decorator seria resumida da seguinte forma:

#### Implementação Interface Component:
```java
public interface Carro {

    String describe();

}
```

#### Implementação de um ConcreteComponent
```java
public class CarroBasico implements Carro {

    @Override
    public String describe() {
        return "Carro básico";
    }

}
```

#### Utilizando o Pattern Decorator com a programação funcional
No código abaixo podemos ver claramente que não precisamos mais das classes **Decorator** e **ConcreteDecorator** pois substituímos seu comportamente facilmente por expressões Lambda.<br/>
```java
import java.util.ArrayList;
import java.util.List;

public class CarroDescriptionMain {

    public static void main(String[] args) {
        CarroBasico carroBasico = new CarroBasico();
        Carro carroCompacto = () -> carroBasico.describe() + " Compacto";
        Carro carroEsportivo = () -> carroBasico.describe() + " Esportivo";
        Carro carroSeda = () -> carroBasico.describe() + " Sedã";
        
        List<Carro> carroList = new ArrayList<>();
        carroList.add(carroCompacto);
        carroList.add(carroEsportivo);
        carroList.add(carroSeda);

        carroList.forEach(c -> System.out.println(c.describe()));
    }

}
```

### Exercício
Seu objetivo nesse exercício é a melhoria de um código existente que aplica o Pattern Decorator, você deverá aplicar os recursos da programação funcional abordados nesse laboratório para melhoria do código existente.<br/>
Você encontrará o código deste exercício neste [link]()
