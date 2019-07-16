package laboratorio7.parte1.exercicio;

public class MoveToForwardCommand implements Command {

    ReceiverInterface receiver;

    public MoveToForwardCommand(ReceiverInterface receiver){
        this.receiver = receiver;
    }

    @Override
    public void move() {
        receiver.moveToForward();
    }
}