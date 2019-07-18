## Design Pattern Strategy utilizando programação funcional

### Material de preparação
[Pattern Strategy com e sem programação funcional](https://www.sourcecodeexamples.net/2018/05/refactoring-strategy-design-pattern.html)

### Visão geral do Pattern Strategy
O Pattern de Strategy é uma solução comum para representar uma família de algoritmos e permitir que você escolha entre eles em tempo de execução.<br/>
Você pode aplicar esse padrão a vários cenários, como validar uma entrada com  critérios diferentes, usando diferentes formas de analisar ou formatar uma entrada.

Os principais componentes desse Pattern são:
 * Interface Strategy: Uma interface para representar algum algoritmo.
 * Implementação concreta interface Strategy: Uma ou mais classes com implementações concretas da interface Strategy.
 * Client: Um ou mais clients que utilizam os objetos Strategy
 
A relação entre eles é mostrada abaixo:<br/>
<img src="https://3.bp.blogspot.com/-nZ3sD4Fw6MI/WwmEPvUJtDI/AAAAAAAACUA/9JWdM6bDFKsxz_-Slez90FLCctbjtwO1gCLcBGAs/s1600/stratergy_design_pattern.png"/>

Além dos 3 componentes acima podemos ter também um **StrategyValidator**, que é uma classe responsável por executar a validação de um Strategy.

Vamos ver um exemplo concreto do padrão de Strategy e após isso ver como ele é melhorado com os recursos da programação funcional.

### Implementação orientadas a objetos
Suponhamos que estamos implementando uma lógica para validar um pagamento e gostaríamos que a lógica aplicada para validar este pagamento fosse decidida em tempo de execução.<br/>
Podemos fazer isso dessa forma:

#### Interface Strategy
Podemos implementar nossa interface Strategy da seguinte forma:
```java
public interface PaymentStrategy {

    void validate(double purchaseValue);

}
```

#### Implementação concreta Interface Strategy
Abaixo alguns exemplos de implementação concreta da Interface Strategy:
```java
public class PaymentInCredit implements PaymentStrategy {
    @Override
    public void validate(double purchaseValue) {
        System.out.println(String.format("Compra do valor de %s realizada via Crédito!", purchaseValue));
    }
}
```

```java
public class PaymentInDebit implements PaymentStrategy {
    @Override
    public void validate(double purchaseValue) {
        System.out.println(String.format("Compra do valor de %s realizada via Débito!", purchaseValue));
    }
}
```

```java
public class PaymentInMoney implements PaymentStrategy {
    @Override
    public void validate(double purchaseValue) {
        System.out.println(String.format("Compra do valor de %s realizada à vista!", purchaseValue));
    }
}
```

#### Implementação de uma classe StrategyValidator
```java
public class PaymentValidator {

    private final PaymentStrategy strategy;

    public PaymentValidator(PaymentStrategy strategy){
        this.strategy = strategy;
    }

    public void validate(double value){
        strategy.validate(value);
    }

}
```

#### Uso do Validator em um Client
Abaixo um exemplo de uso do validator em um client:
```java
public class PaymentClient {

    public static void main(String[] args) {
        PaymentValidator validatorCredit = new PaymentValidator(new PaymentInCredit());
        validatorCredit.validate(200);

        PaymentValidator validatorDebit = new PaymentValidator(new PaymentInDebit());
        validatorDebit.validate(250);

        PaymentValidator validatorMoney = new PaymentValidator(new PaymentInMoney());
        validatorMoney.validate(500);

    }

}
```


### Implementação Funcional
Vimos acima como era feita a implementanção do Pattern Strategy antes da programação funcional do Java 8, 
veremos aqui como melhorar essa implementação com o uso dos recursos da programação funcional.<br/>

Utilizando a programação funcional nossas implementações concretas da interface Strategy não tem mais utilizade pois podemos substituí-las facilmente por expressões Lambda passadas no construtor de nosso StrategyValidator.<br/>

#### Invocação do validator utilizando expressões lambda
No exemplo abaixo vemos como substituir o uso de classes concretas que implementam o Strategy por expressões Lambda:
```java
public class PaymentClient {

    public static void main(String[] args) {
        PaymentValidator validatorCredit = new PaymentValidator((double value) -> {
            System.out.println(String.format("Compra do valor de %s realizada via Crédito!", value));
        });
        validatorCredit.validate(200);

        PaymentValidator validatorDebit = new PaymentValidator((double value) -> {
            System.out.println(String.format("Compra do valor de %s realizada via Débito!", value));
        });
        validatorDebit.validate(250);

        PaymentValidator validatorMoney = new PaymentValidator((double value) -> {
            System.out.println(String.format("Compra do valor de %s realizada à vista!", value));
        });
        validatorMoney.validate(500);

    }

}
```

### Exercício
Seu objetivo nesse exercício é a melhoria de um código existente que aplica o Pattern Strategy, você deverá aplicar os recursos da programação funcional abordados nesse laboratório para melhoria do código existente.<br/>
Você encontrará o código deste exercício neste [link](https://github.com/corelioBH/design-app-java/tree/master/Programacao%20Funcional/src/laboratorio7/parte5/exercicio)