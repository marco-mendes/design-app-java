package laboratorio7.parte1.exemplos.antesjava8;

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
