package dia01.laboratorio7.parte5.exemplos.depoisjava8;

public class PaymentValidator {

    private final PaymentStrategy strategy;

    public PaymentValidator(PaymentStrategy strategy){
        this.strategy = strategy;
    }

    public void validate(double value){
        strategy.validate(value);
    }

}
