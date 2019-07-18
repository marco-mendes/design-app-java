package laboratorio7.parte5.exemplos.antesjava8;

public class PaymentValidator {

    private final PaymentStrategy strategy;

    public PaymentValidator(PaymentStrategy strategy){
        this.strategy = strategy;
    }

    public void validate(double value){
        strategy.validate(value);
    }

}
