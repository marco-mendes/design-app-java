package dia01.gabarito.laboratorio7.parte1.classesdesnecessarias;

import dia01.gabarito.laboratorio7.parte1.Command;
import dia01.gabarito.laboratorio7.parte1.ReceiverInterface;

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