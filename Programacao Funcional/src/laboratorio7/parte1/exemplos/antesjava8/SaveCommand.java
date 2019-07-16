package laboratorio7.parte1.exemplos.antesjava8;

public class SaveCommand implements Command {

    ReceiverImplementation receiverImplementation;

    public SaveCommand(ReceiverImplementation receiverImplementation){
        this.receiverImplementation = receiverImplementation;
    }

    @Override
    public void execute() {
        receiverImplementation.save();
    }
}
