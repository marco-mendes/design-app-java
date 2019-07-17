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

Além dos 3 componentes acima podemos ter também uma classe responsável por executar a validação de um Strategy.

Vamos ver um exemplo concreto do padrão de Strategy e após isso ver como ele é melhorado com os recursos da programação funcional.

### Implementação orientadas a objetos
Suponhamos que estamos implementando uma lógica para validar um pagamento e gostaríamos que a lógica aplicada para validar este pagamento fosse decidida em tempo de execução.<br/>
Podemos fazer isso dessa forma:

#### Interface Strategy
Podemos implementar nossa interface Strategy da seguinte forma:
```java
public interface PaymentStrategy {

    boolean validate(double purchaseValue);

}
```

#### Implementação concreta Interface Strategy
Abaixo alguns exemplos de implementação concreta da Interface Strategy:
```java
public class PaymentInCredit implements PaymentStrategy {
    @Override
    public boolean validate(double purchaseValue) {
        if(purchaseValue > 0) {
            System.out.println(String.format("Compra do valor de %s aprovada via Crédito!", purchaseValue));
            return true;
        } else {
            System.out.println("Transação via crédito negada!");
            return false;
        }
    }
}
```

```java
public class PaymentInDebit implements PaymentStrategy {
    @Override
    public boolean validate(double purchaseValue) {
        if(purchaseValue > 0) {
            System.out.println(String.format("Compra do valor de %s aprovada via Débito!", purchaseValue));
            return true;
        } else {
            System.out.println("Transação via débito negada!");
            return false;
        }
    }
}
```

```java
public class PaymentInMoney implements PaymentStrategy {
    @Override
    public boolean validate(double purchaseValue) {
        if(purchaseValue > 0) {
            System.out.println(String.format("Compra do valor de %s aprovada via pagamento à vista!", purchaseValue));
            return true;
        } else {
            System.out.println("Transação via pagamento à vista negada!");
            return false;
        }
    }
}
```

#### Implementação de uma classe para validar um Strategy
