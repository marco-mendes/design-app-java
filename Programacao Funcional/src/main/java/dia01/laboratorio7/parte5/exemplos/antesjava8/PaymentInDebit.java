package dia01.laboratorio7.parte5.exemplos.antesjava8;

public class PaymentInDebit implements PaymentStrategy {
    @Override
    public void validate(double purchaseValue) {
        System.out.println(String.format("Compra do valor de %s realizada via Débito!", purchaseValue));
    }
}
