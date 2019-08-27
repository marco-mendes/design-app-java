package gabarito.laboratorio3.parte1.classesdesnecessarias;

import gabarito.laboratorio3.parte1.ConsoleDeJogos;

public class ConsoleNintendoSwitchDecorator extends ConsoleDeJogosDecorator {

    public ConsoleNintendoSwitchDecorator(ConsoleDeJogos consoleDeJogos){
        super(consoleDeJogos);
    }

    @Override
    public String describe() {
        return (super.describe() + " Nintendo Switch");
    }
}
