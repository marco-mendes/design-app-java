package dia02.laboratorio4.exemplo;

public class PersonalTaxPenaltyStrategy implements TaxStrategy {

    public PersonalTaxPenaltyStrategy() { }

    @Override
    public double calculateTax(double income) {

        System.out.println("PersonalTaxWithPenalty");

        double tax = income * 0.4;
        return tax;
    }
}