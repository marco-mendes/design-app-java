package dia01.laboratorio7.parte2.exercicio;

public class ConsolePSVitaDecorator extends ConsoleDeJogosDecorator {

    public ConsolePSVitaDecorator(ConsoleDeJogos consoleDeJogos){
        super(consoleDeJogos);
    }

    @Override
    public String describe() {
        return (super.describe() + " PS Vita");
    }
}
