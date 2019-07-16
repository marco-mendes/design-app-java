package gabarito.laboratorio7.parte1;

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