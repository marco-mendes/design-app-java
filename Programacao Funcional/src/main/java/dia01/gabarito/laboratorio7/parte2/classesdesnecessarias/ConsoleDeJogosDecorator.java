package dia01.gabarito.laboratorio7.parte2.classesdesnecessarias;

import dia01.gabarito.laboratorio7.parte2.ConsoleDeJogos;

public abstract class ConsoleDeJogosDecorator  implements ConsoleDeJogos {

    protected ConsoleDeJogos consoleDeJogos;

    public ConsoleDeJogosDecorator(ConsoleDeJogos consoleDeJogos){
        this.consoleDeJogos = consoleDeJogos;
    }

    @Override
    public String describe() {
        return consoleDeJogos.describe();
    }
}
