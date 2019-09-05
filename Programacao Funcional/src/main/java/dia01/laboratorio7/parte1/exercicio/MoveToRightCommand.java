package dia01.laboratorio7.parte1.exercicio;

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