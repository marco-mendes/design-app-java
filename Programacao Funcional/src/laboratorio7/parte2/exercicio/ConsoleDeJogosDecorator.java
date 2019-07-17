package laboratorio7.parte2.exercicio;

public abstract class ConsoleDeJogosDecorator  implements ConsoleDeJogos{

    protected ConsoleDeJogos consoleDeJogos;

    ConsoleDeJogosDecorator(ConsoleDeJogos consoleDeJogos){
        this.consoleDeJogos = consoleDeJogos;
    }

    @Override
    public String describe() {
        return consoleDeJogos.describe();
    }
}
