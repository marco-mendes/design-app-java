package dia02.gabarito.laboratorio4.classesdesnecessarias;

import dia02.gabarito.laboratorio4.TaxStrategy;

public class PersonalTaxRebateStrategy implements TaxStrategy {

    public PersonalTaxRebateStrategy() { }

    @Override
    public double calculateTax(double income) {

        System.out.println("PersonalTaxWithRebate");

        double tax = income * 0.2;
        return tax;
    }
}