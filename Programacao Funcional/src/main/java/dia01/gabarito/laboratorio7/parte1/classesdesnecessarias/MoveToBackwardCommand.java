package dia01.gabarito.laboratorio7.parte1.classesdesnecessarias;

import dia01.gabarito.laboratorio7.parte1.Command;
import dia01.gabarito.laboratorio7.parte1.ReceiverInterface;

public class MoveToBackwardCommand implements Command {

    ReceiverInterface receiver;

    public MoveToBackwardCommand(ReceiverInterface receiver){
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.moveToBackward();
    }
}