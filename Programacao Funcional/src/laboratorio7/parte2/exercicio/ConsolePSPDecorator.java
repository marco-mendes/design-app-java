package laboratorio7.parte2.exercicio;

public class ConsolePSPDecorator extends ConsoleDeJogosDecorator {

    ConsolePSPDecorator(ConsoleDeJogos consoleDeJogos){
        super(consoleDeJogos);
    }

    @Override
    public String describe() {
        return (super.describe() + " PSP");
    }
}
