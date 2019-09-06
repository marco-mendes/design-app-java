package dia02.gabarito.laboratorio3.parte1.classesdesnecessarias;

import dia02.gabarito.laboratorio3.parte1.ConsoleDeJogos;

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
