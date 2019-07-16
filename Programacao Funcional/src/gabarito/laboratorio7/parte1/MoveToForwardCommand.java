package gabarito.laboratorio7.parte1;

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