package dia01.gabarito.laboratorio7.parte2.classesdesnecessarias;

import dia01.gabarito.laboratorio7.parte2.ConsoleDeJogos;

public class ConsolePSPDecorator extends ConsoleDeJogosDecorator {

    public ConsolePSPDecorator(ConsoleDeJogos consoleDeJogos){
        super(consoleDeJogos);
    }

    @Override
    public String describe() {
        return (super.describe() + " PSP");
    }
}
