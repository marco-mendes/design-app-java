package gabarito.laboratorio7.parte1.classesdesnecessarias;

import gabarito.laboratorio7.parte1.Command;
import gabarito.laboratorio7.parte1.ReceiverInterface;

public class MoveToForwardCommand implements Command {

    ReceiverInterface receiver;

    public MoveToForwardCommand(ReceiverInterface receiver){
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.moveToForward();
    }
}