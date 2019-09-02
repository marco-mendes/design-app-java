package gabarito.laboratorio1.parte3;

public class Exercicio {

    public static void main(String[] args) {
        String texto = "A mulher é muito bonita";
        Expression textInterpreter = new TextInterpreter(texto, TextUtils.obterAdjetivos(), TextUtils.obterArtigos(), TextUtils.obterSubstantivos());
        textInterpreter.interpret();

        String texto1 = "O João é um homem brasileiro";
        Expression textInterpreter1 = new TextInterpreter(texto1, TextUtils.obterAdjetivos(), TextUtils.obterArtigos(), TextUtils.obterSubstantivos());
        textInterpreter1.interpret();

    }

}
