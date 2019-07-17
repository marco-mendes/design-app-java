package laboratorio7.parte5.exemplos.antesjava8;

public class PaymentInCredit implements PaymentStrategy {
    @Override
    public boolean validate(double purchaseValue) {
        if(purchaseValue > 0) {
            System.out.println(String.format("Compra do valor de %s aprovada via Crédito!", purchaseValue));
            return true;
        } else {
            System.out.println("Transação via crédito negada!");
            return false;
        }
    }
}
