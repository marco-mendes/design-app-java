## Design Pattern Strategy utilizando programação funcional

### Material de preparação
[Pattern Strategy com e sem programação funcional](https://www.sourcecodeexamples.net/2018/05/refactoring-strategy-design-pattern.html)

### Visão geral do Pattern Strategy
O Pattern de Strategy é uma solução comum para representar uma família de algoritmos e permitir que você escolha entre eles em tempo de execução.<br/>
Você pode aplicar esse padrão a vários cenários, como validar uma entrada com  critérios diferentes, usando diferentes formas de analisar ou formatar uma entrada.

Os principais componentes desse Pattern são:
 * **Strategy**: Uma interface para representar algum algoritmo.
 * **ConcreteStrategy**: Uma ou mais classes com implementações concretas da interface Strategy.
 * **Context**: Um ou mais clients que utilizam os objetos Strategy
 
A relação entre eles é mostrada abaixo:<br/>
<img src="https://3.bp.blogspot.com/-nZ3sD4Fw6MI/WwmEPvUJtDI/AAAAAAAACUA/9JWdM6bDFKsxz_-Slez90FLCctbjtwO1gCLcBGAs/s1600/stratergy_design_pattern.png"/>

Além dos 3 componentes acima podemos ter também um **StrategyValidator**, que é uma classe responsável por executar a validação de um Strategy.

Vamos ver um exemplo concreto do padrão de Strategy e após isso ver como ele é melhorado com os recursos da programação funcional.

### Implementação orientadas a objetos
Suponhamos que estamos implementando uma lógica para realizar um pagamento de diversas formas diferentes e gostaríamos que a lógica aplicada para realizar este pagamento fosse decidida em tempo de execução.<br/>
Podemos fazer isso dessa forma:

#### Implementação Strategy
Podemos implementar nosso componente Strategy da seguinte forma:
```java
public interface PaymentStrategy {

    void validate(double purchaseValue);

}
```

#### Implementação ConcreteStrategy
Abaixo alguns exemplos de implementação do ConcreteStrategy:
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

#### Implementação Context
Podemos implementar nosso componente Context da seguinte forma:
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
Vimos acima como era feita a implementanção do Pattern Strategy antes da programação funcional do Java 8.<br/>
Utilizando a programação funcional nosso componente **Strategy** e nossa classe **StrategyValidator** não sofrem modificações, já nosso componente **ConcreteStrategy** não tem mais utilizade e pode ser substituído facilmente por expressões Lambda.<br/>

#### Invocação do validator em um Context utilizando expressões lambda
No exemplo abaixo vemos como substituir o uso do componente **ConcreteStrategy** por expressões Lambda no componente **Context**:
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