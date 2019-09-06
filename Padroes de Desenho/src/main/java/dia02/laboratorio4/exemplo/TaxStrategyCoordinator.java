package dia02.laboratorio4.exemplo;

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