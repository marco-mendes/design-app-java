## Design Pattern Factory utilizando programação funcional

### Material de preparação
[Pattern Factory com e sem programação funcional](https://www.sourcecodeexamples.net/2018/05/refactoring-factory-design-pattern-with.html)

### Visão geral do Pattern Factory
Esse Pattern nos permite criar objetos sem expor a lógica de instanciação dos mesmos ao cliente.<br/>
Os principais componentes desse Pattern são:
 * **Product**: Define a interface dos objetos que o objeto Factory irá criar.
 * **ConcreteProduct**: Uma ou mais classes concretas que implementam a interface Product.
 * **Factory**: Implementa um método para criar objetos ConcreteProduct.
 * **Client**: Usa o Factory para instanciar um ConcreteProduct.
 
Vamos ver um exemplo concreto do padrão de Factory e após isso ver como ele é melhorado com os recursos da programação funcional.

### Implementação orientadas a objetos
Suponhamos que queremos criar uma fábrica de carros utilizando o Pattern Factory, podemos fazer da seguinte forma:

#### Implementação Componente Product
Nosso componente Product poderia ser implementado da seguinte forma:
```java
public interface Car {

    void start();

}
```

#### Implementação Componente ConcreteProduct
Abaixo alguns exemplos de implementação do componente ConcreteProduct
```java
public class Ferrari implements Car {
    @Override
    public void start() {
        System.out.println("Inside Ferrari::start method");
    }
}
```

```java
public class Mercedes implements Car {
    @Override
    public void start() {
        System.out.println("Inside Mercedes::start method");
    }
}
```

#### Implementação Componente Factory
Nossa componente Factory poderia ser implementado dividido em duas partes, a primeira seria um Enum para o tipo de carro e a segunda seria nossa classe Factory.<br/>
Código da implementação:
```java
enum CarType {
    MERCEDES, FERRARI
}
```

```java
public class CarFactory {

    public Car getCar(CarType carType){
        switch (carType) {
            case MERCEDES: return new Mercedes();
            case FERRARI: return new Ferrari();
            default: return null;
        }
    }

}
```

#### Utilizando nosso Factory no componente Client
Abaixo um exemplo de utilização do mesmo:
```java
public class CarFactoryMain {

    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();

        Car c1 = carFactory.getCar(CarType.MERCEDES);
        c1.start();

        Car c2 = carFactory.getCar(CarType.FERRARI);
        c2.start();
    }

}
```

### Implementação Funcional
Vimos acima como era feita a implementanção do Pattern Factory antes da programação funcional do Java 8, 
veremos aqui como melhorar essa implementação com o uso dos recursos da programação funcional.<br/>

Utilizando a programação funcional seria necessário alterar apenas nossos componentes **Factory** e **Client**, os demais componetes não sofreriam modificações. 

#### Implementação do componente Factory
Podemos reescrever o código de nosso CarFactory da seguinte forma:
```java
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CarFactory {

    private static final Map<CarType, Supplier<Car>> map = new HashMap<>();
    static {
        map.put(CarType.FERRARI, Ferrari::new);
        map.put(CarType.MERCEDES, Mercedes::new);
    }

    public static Car getCar(CarType carType){
        Supplier<Car> car = map.get(carType);
        if(car != null){
            return car.get();
        } else {
            throw new IllegalArgumentException(String.format("Tipo %s não cadastrado!", carType));
        }
    }

}
```
Neste exemplo utilizamos um Map recebendo o tipo do carro e um Supplier para retornar um construtor conforme o tipo informado.

#### Utilizando nosso Factory no componente Client
Abaixo um exemplo de utilização do mesmo:
```java
public class CarFactoryMain {

    public static void main(String[] args) {

        Car c1 = CarFactory.getCar(CarType.MERCEDES);
        c1.start();

        Car c2 = CarFactory.getCar(CarType.FERRARI);
        c2.start();
    }

}
```

### Exercício
Seu objetivo nesse exercício é a melhoria de um código existente que aplica o Pattern Factory, você deverá aplicar os recursos da programação funcional abordados nesse laboratório para melhoria do código existente.<br/>
Você encontrará o código deste exercício neste [link](./exercicio)
