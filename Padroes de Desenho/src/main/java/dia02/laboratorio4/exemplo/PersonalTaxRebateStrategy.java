package dia02.laboratorio4.exemplo;

public class PersonalTaxRebateStrategy implements TaxStrategy {

    public PersonalTaxRebateStrategy() { }

    @Override
    public double calculateTax(double income) {

        System.out.println("PersonalTaxWithRebate");

        double tax = income * 0.2;
        return tax;
    }
}