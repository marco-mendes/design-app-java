package laboratorio7.parte1.exercicio;

public class Client {

    public static void main(String[] args) {
        ReceiverImplementation receiverImplementation = new ReceiverImplementation();
        Invoker invoker = new Invoker();
        invoker.record(new MoveToLeftCommand(receiverImplementation));
        invoker.record(new MoveToRightCommand(receiverImplementation));
        invoker.record(new MoveToForwardCommand(receiverImplementation));
        invoker.record(new MoveToBackwardCommand(receiverImplementation));
        invoker.run();
    }

}
