package dia01.laboratorio7.parte5.exemplos.antesjava8;

public class PaymentInMoney implements PaymentStrategy {
    @Override
    public void validate(double purchaseValue) {
        System.out.println(String.format("Compra do valor de %s realizada à vista!", purchaseValue));
    }
}
