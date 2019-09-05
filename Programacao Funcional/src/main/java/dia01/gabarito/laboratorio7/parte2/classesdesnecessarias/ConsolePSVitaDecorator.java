package dia01.gabarito.laboratorio7.parte2.classesdesnecessarias;

import dia01.gabarito.laboratorio7.parte2.ConsoleDeJogos;

public class ConsolePSVitaDecorator extends ConsoleDeJogosDecorator {

    public ConsolePSVitaDecorator(ConsoleDeJogos consoleDeJogos){
        super(consoleDeJogos);
    }

    @Override
    public String describe() {
        return (super.describe() + " PS Vita");
    }
}
