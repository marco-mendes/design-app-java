package dia02.gabarito.laboratorio4.classesdesnecessarias;

import dia02.gabarito.laboratorio4.TaxStrategy;

public class PersonalTaxPenaltyStrategy implements TaxStrategy {

    public PersonalTaxPenaltyStrategy() { }

    @Override
    public double calculateTax(double income) {

        System.out.println("PersonalTaxWithPenalty");

        double tax = income * 0.4;
        return tax;
    }

}