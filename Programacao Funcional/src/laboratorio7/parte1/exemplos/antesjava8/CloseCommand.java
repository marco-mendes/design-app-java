package laboratorio7.parte1.exemplos.antesjava8;

public class CloseCommand implements Command {

    ReceiverInterface receiver;

    public CloseCommand(ReceiverInterface receiver){
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.close();
    }
}