
Vamos examinar o conceito do padrão Strategy, que é uma forma de introduzir variabilidade no comportamento 
sem criar acoplamento excessivo com a classe cliente que demanda um determinado comportamento.

```java
public interface TaxStrategy {
 
    public double calculateTax(double income);
}

public class PersonalTaxStrategy implements TaxStrategy {
 
    public PersonalTaxStrategy() { }
 
    @Override
    public double calculateTax(double income) {
 
        System.out.println("PersonalTax");
 
        double tax = income * 0.3;
        return tax;
    }
}

public class PersonalTaxPenaltyStrategy implements TaxStrategy {
 
    public PersonalTaxPenaltyStrategy() { }
 
    @Override
    public double calculateTax(double income) {
 
        System.out.println("PersonalTaxWithPenalty");
 
        double tax = income * 0.4;
        return tax;
    }
}

public class PersonalTaxRebateStrategy implements TaxStrategy {
 
    public PersonalTaxRebateStrategy() { }
 
    @Override
    public double calculateTax(double income) {
 
        System.out.println("PersonalTaxWithRebate");
 
        double tax = income * 0.2;
        return tax;
    }
}

import java.util.Arrays;
import java.util.List;
 
public class TaxStrategyCoordinator {
 
    public static void main(String [] args) {
 
        // Lista de estrategias para cenários diferentes
        List<TaxStrategy> taxStrategyList =
                Arrays.asList(
                        new PersonalTaxStrategy(),
                        new PersonalTaxPenaltyStrategy(),
                        new PersonalTaxRebateStrategy());
 
        // Calcula taxas com estrategias diferentes..
        for (TaxStrategy taxStrategy : taxStrategyList) {
            System.out.println(taxStrategy.calculateTax(30000.0));
        }
    }
}

````

Exercício 4 - Refatore esse código para usar programação funcional com o uso de expressões Lambda.

Dica: Veja o seguinte tutorial para ver como isso pode ser realizado - 
https://dzone.com/articles/strategy-pattern-using-lambda
