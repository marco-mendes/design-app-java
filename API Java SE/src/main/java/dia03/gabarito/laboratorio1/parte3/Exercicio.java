package dia03.gabarito.laboratorio1.parte3;

public class Exercicio {

    public static void main(String[] args) {
        String texto = "A mulher é muito bonita";
        Expression localizarArtigoInterpreter = new LocalizarArtigoInterpreter(texto, TextUtils.obterArtigos());
        localizarArtigoInterpreter.interpret();

        Expression localizarAdjetivoInterpreter = new LocalizarAdjetivoInterpreter(texto, TextUtils.obterAdjetivos());
        localizarAdjetivoInterpreter.interpret();

        Expression localizarSubstantivoInterpreter = new LocalizarSubstantivoInterpreter(texto, TextUtils.obterSubstantivos());
        localizarSubstantivoInterpreter.interpret();


        String texto1 = "O João é um homem brasileiro";
        Expression localizarArtigoInterpreter1 = new LocalizarArtigoInterpreter(texto1, TextUtils.obterArtigos());
        localizarArtigoInterpreter1.interpret();

        Expression localizarAdjetivoInterpreter1 = new LocalizarAdjetivoInterpreter(texto1, TextUtils.obterAdjetivos());
        localizarAdjetivoInterpreter1.interpret();

        Expression localizarSubstantivoInterpreter1 = new LocalizarSubstantivoInterpreter(texto1, TextUtils.obterSubstantivos());
        localizarSubstantivoInterpreter1.interpret();


    }

}
