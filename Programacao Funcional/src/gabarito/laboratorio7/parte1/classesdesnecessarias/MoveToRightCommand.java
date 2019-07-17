package gabarito.laboratorio7.parte1.classesdesnecessarias;

import gabarito.laboratorio7.parte1.Command;
import gabarito.laboratorio7.parte1.ReceiverInterface;

public class MoveToRightCommand implements Command {

    ReceiverInterface receiver;

    public MoveToRightCommand(ReceiverInterface receiver){
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.moveToRight();
    }
}