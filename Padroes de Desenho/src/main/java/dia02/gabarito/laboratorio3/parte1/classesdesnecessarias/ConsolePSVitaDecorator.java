package dia02.gabarito.laboratorio3.parte1.classesdesnecessarias;

import dia02.gabarito.laboratorio3.parte1.ConsoleDeJogos;

public class ConsolePSVitaDecorator extends ConsoleDeJogosDecorator {

    public ConsolePSVitaDecorator(ConsoleDeJogos consoleDeJogos){
        super(consoleDeJogos);
    }

    @Override
    public String describe() {
        return (super.describe() + " PS Vita");
    }
}
