package dia01.gabarito.laboratorio7.parte1.classesdesnecessarias;

import dia01.gabarito.laboratorio7.parte1.Command;
import dia01.gabarito.laboratorio7.parte1.ReceiverInterface;

public class MoveToLeftCommand implements Command {

    ReceiverInterface receiver;

    public MoveToLeftCommand(ReceiverInterface receiver){
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.moveToLeft();
    }
}
