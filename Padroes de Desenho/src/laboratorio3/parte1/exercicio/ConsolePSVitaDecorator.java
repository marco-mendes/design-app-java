package laboratorio3.parte1.exercicio;

public class ConsolePSVitaDecorator extends ConsoleDeJogosDecorator {

    public ConsolePSVitaDecorator(ConsoleDeJogos consoleDeJogos){
        super(consoleDeJogos);
    }

    @Override
    public String describe() {
        return (super.describe() + " PS Vita");
    }
}
