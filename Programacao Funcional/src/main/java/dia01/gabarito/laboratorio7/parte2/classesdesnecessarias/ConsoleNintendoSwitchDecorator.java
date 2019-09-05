package dia01.gabarito.laboratorio7.parte2.classesdesnecessarias;

import dia01.gabarito.laboratorio7.parte2.ConsoleDeJogos;

public class ConsoleNintendoSwitchDecorator extends ConsoleDeJogosDecorator {

    public ConsoleNintendoSwitchDecorator(ConsoleDeJogos consoleDeJogos){
        super(consoleDeJogos);
    }

    @Override
    public String describe() {
        return (super.describe() + " Nintendo Switch");
    }
}
