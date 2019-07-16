package laboratorio7.parte2.exercicio;

public class ConsoleNintendoSwitchDecorator extends ConsoleDeJogosDecorator {

    ConsoleNintendoSwitchDecorator(ConsoleDeJogos consoleDeJogos){
        super(consoleDeJogos);
    }

    @Override
    public String describe() {
        return (super.describe() + " Nintendo Switch");
    }
}
