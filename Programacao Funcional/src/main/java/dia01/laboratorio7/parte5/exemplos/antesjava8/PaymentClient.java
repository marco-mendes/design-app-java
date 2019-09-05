package dia01.laboratorio7.parte5.exemplos.antesjava8;

public class PaymentClient {

    public static void main(String[] args) {
        PaymentValidator validatorCredit = new PaymentValidator(new PaymentInCredit());
        validatorCredit.validate(200);

        PaymentValidator validatorDebit = new PaymentValidator(new PaymentInDebit());
        validatorDebit.validate(250);

        PaymentValidator validatorMoney = new PaymentValidator(new PaymentInMoney());
        validatorMoney.validate(500);

    }

}
