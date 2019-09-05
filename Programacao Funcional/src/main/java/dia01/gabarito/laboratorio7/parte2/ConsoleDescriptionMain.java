package dia01.gabarito.laboratorio7.parte2;

import dia01.gabarito.laboratorio7.parte2.classesdesnecessarias.ConsoleNintendoSwitchDecorator;
import dia01.gabarito.laboratorio7.parte2.classesdesnecessarias.ConsolePSPDecorator;
import dia01.gabarito.laboratorio7.parte2.classesdesnecessarias.ConsolePSVitaDecorator;


import java.util.ArrayList;
import java.util.List;

public class ConsoleDescriptionMain {

    public static void implementacaoSemProgramacaoFuncional(){
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

    public static void implementacaoComProgramacaoFuncional(){
        ConsolePortatil consolePortatil = new ConsolePortatil();
        ConsoleDeJogos psp = () -> consolePortatil.describe() + " PSP";
        ConsoleDeJogos psVita = () -> consolePortatil.describe() + " PS Vita";
        ConsoleDeJogos nintendoSwitch = () -> consolePortatil.describe() + " Nintendo Switch";

        List<ConsoleDeJogos> consolesList = new ArrayList<>();
        consolesList.add(psp);
        consolesList.add(psVita);
        consolesList.add(nintendoSwitch);

        consolesList.forEach(c -> System.out.println(c.describe()));
    }

    public static void main(String[] args) {
        implementacaoSemProgramacaoFuncional();
        implementacaoComProgramacaoFuncional();
    }

}
