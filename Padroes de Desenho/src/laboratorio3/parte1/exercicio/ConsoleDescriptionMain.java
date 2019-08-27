package laboratorio3.parte1.exercicio;

import java.util.ArrayList;
import java.util.List;

public class ConsoleDescriptionMain {

    public static void main(String[] args) {
        ConsolePortatil consolePortatil = new ConsolePortatil();
        ConsolePSPDecorator psp = new ConsolePSPDecorator(consolePortatil);
        ConsolePSVitaDecorator psVita = new ConsolePSVitaDecorator(consolePortatil);
        ConsoleNintendoSwitchDecorator nintendoSwitch = new ConsoleNintendoSwitchDecorator(consolePortatil);

        List<ConsoleDeJogos> consolesList = new ArrayList<>();
        consolesList.add(psp);
        consolesList.add(psVita);
        consolesList.add(nintendoSwitch);

        for(ConsoleDeJogos console : consolesList){
            System.out.println(console.describe());
        }

    }

}
