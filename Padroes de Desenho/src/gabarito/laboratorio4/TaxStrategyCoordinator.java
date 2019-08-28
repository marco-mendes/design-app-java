package gabarito.laboratorio4;

import gabarito.laboratorio4.classesdesnecessarias.PersonalTaxPenaltyStrategy;
import gabarito.laboratorio4.classesdesnecessarias.PersonalTaxRebateStrategy;
import gabarito.laboratorio4.classesdesnecessarias.PersonalTaxStrategy;

import java.util.Arrays;
import java.util.List;

public class TaxStrategyCoordinator {

    public static void formaNaoFuncional() {
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

    public static void formaFuncional() {
        // Lista de estrategias para cenários diferentes
        List<TaxStrategy> taxStrategyList =
                Arrays.asList(
                        (income) -> {
                            System.out.println("PersonalTax");

                            double tax = income * 0.3;
                            return tax;
                        },
                        (income) -> {

                            System.out.println("PersonalTaxWithPenalty");

                            double tax = income * 0.4;
                            return tax;
                        },
                        (income) -> {

                            System.out.println("PersonalTaxWithRebate");

                            double tax = income * 0.2;
                            return tax;
                        });

        // Calcula taxas com estrategias diferentes..
        for (TaxStrategy taxStrategy : taxStrategyList) {
            System.out.println(taxStrategy.calculateTax(30000.0));
        }
    }

    public static void main(String [] args) {
        formaNaoFuncional();
        formaFuncional();
    }
}