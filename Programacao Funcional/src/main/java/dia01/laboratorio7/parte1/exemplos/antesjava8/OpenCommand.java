package dia01.laboratorio7.parte1.exemplos.antesjava8;

public class OpenCommand implements Command {

    ReceiverInterface receiver;

    public OpenCommand(ReceiverInterface receiver){
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.open();
    }
}