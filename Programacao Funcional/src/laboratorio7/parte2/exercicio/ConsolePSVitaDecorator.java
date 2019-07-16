package laboratorio7.parte2.exercicio;

public class ConsolePSVitaDecorator extends ConsoleDeJogosDecorator {

    ConsolePSVitaDecorator(ConsoleDeJogos consoleDeJogos){
        super(consoleDeJogos);
    }

    @Override
    public String describe() {
        return (super.describe() + " PS Vita");
    }
}
