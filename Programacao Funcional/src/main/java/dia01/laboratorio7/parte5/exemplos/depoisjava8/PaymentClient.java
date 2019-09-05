package dia01.laboratorio7.parte5.exemplos.depoisjava8;

public class PaymentClient {

    public static void main(String[] args) {
        PaymentValidator validatorCredit = new PaymentValidator((double value) -> {
            System.out.println(String.format("Compra do valor de %s realizada via Crédito!", value));
        });
        validatorCredit.validate(200);

        PaymentValidator validatorDebit = new PaymentValidator((double value) -> {
            System.out.println(String.format("Compra do valor de %s realizada via Débito!", value));
        });
        validatorDebit.validate(250);

        PaymentValidator validatorMoney = new PaymentValidator((double value) -> {
            System.out.println(String.format("Compra do valor de %s realizada à vista!", value));
        });
        validatorMoney.validate(500);

    }

}
