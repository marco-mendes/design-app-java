package laboratorio7.parte1.exercicio;

public class MoveToBackwardCommand implements Command {

    ReceiverInterface receiver;

    public MoveToBackwardCommand(ReceiverInterface receiver){
        this.receiver = receiver;
    }

    @Override
    public void move() {
        receiver.moveToBackward();
    }
}