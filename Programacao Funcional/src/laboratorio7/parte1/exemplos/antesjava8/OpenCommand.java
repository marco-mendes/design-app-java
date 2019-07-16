package laboratorio7.parte1.exemplos.antesjava8;

public class OpenCommand implements Command {

    ReceiverImplementation receiverImplementation;

    public OpenCommand(ReceiverImplementation receiverImplementation){
        this.receiverImplementation = receiverImplementation;
    }

    @Override
    public void execute() {
        receiverImplementation.open();
    }
}
