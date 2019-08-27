package gabarito.laboratorio3.parte1.classesdesnecessarias;

import gabarito.laboratorio3.parte1.ConsoleDeJogos;

public class ConsolePSPDecorator extends ConsoleDeJogosDecorator {

    public ConsolePSPDecorator(ConsoleDeJogos consoleDeJogos){
        super(consoleDeJogos);
    }

    @Override
    public String describe() {
        return (super.describe() + " PSP");
    }
}
