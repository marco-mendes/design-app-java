package dia01.laboratorio7.parte1.exercicio;

import java.util.ArrayList;
import java.util.List;

public class Invoker {

    List<Command> commands;

    public Invoker(){
        commands = new ArrayList<>();
    }

    public void record(Command command){
        commands.add(command);
    }

    public void run(){
        for(Command command : commands){
            command.execute();
        }
    }

}