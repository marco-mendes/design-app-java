package laboratorio7.parte1.exemplos.antesjava8;

public class SaveCommand implements Command {

    ReceiverInterface receiver;

    public SaveCommand(ReceiverInterface receiver){
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.save();
    }
}