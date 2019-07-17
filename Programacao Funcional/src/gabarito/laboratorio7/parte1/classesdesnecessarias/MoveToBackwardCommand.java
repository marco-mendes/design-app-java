package gabarito.laboratorio7.parte1.classesdesnecessarias;

import gabarito.laboratorio7.parte1.Command;
import gabarito.laboratorio7.parte1.ReceiverInterface;

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