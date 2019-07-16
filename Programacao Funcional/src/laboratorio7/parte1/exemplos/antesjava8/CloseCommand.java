package laboratorio7.parte1.exemplos.antesjava8;

public class CloseCommand implements Command {

    ReceiverImplementation receiverImplementation;

    public CloseCommand(ReceiverImplementation receiverImplementation){
        this.receiverImplementation = receiverImplementation;
    }

    @Override
    public void execute() {
        receiverImplementation.close();
    }
}
