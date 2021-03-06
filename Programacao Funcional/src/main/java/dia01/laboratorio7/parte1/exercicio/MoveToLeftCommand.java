package dia01.laboratorio7.parte1.exercicio;

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
