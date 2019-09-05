package dia01.laboratorio7.parte1.exemplos.antesjava8;

public class Client {

    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        ReceiverImplementation receiverImplementation = new ReceiverImplementation();
        invoker.record(new OpenCommand(receiverImplementation));
        invoker.record(new CloseCommand(receiverImplementation));
        invoker.record(new SaveCommand(receiverImplementation));
        invoker.run();
    }

}