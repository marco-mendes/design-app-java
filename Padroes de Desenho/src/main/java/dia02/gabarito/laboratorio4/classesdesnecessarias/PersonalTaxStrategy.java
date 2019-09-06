package dia02.gabarito.laboratorio4.classesdesnecessarias;

import dia02.gabarito.laboratorio4.TaxStrategy;

public class PersonalTaxStrategy implements TaxStrategy {

    public PersonalTaxStrategy() { }

    @Override
    public double calculateTax(double income) {

        System.out.println("PersonalTax");

        double tax = income * 0.3;
        return tax;
    }
}
