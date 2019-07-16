package gabarito.laboratorio7.parte1;

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
