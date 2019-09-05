package dia01.laboratorio7.parte1.exemplos.depoisjava8;

public class Client {

    public static void usoComLambdas(){
        Invoker invoker = new Invoker();
        ReceiverImplementation receiverImplementation = new ReceiverImplementation();
        invoker.record(() -> receiverImplementation.open());
        invoker.record(() -> receiverImplementation.close());
        invoker.record(() -> receiverImplementation.save());
        invoker.run();
    }

    public static void usoComMethodReference(){
        Invoker invoker = new Invoker();
        ReceiverImplementation receiverImplementation = new ReceiverImplementation();
        invoker.record(receiverImplementation::open);
        invoker.record(receiverImplementation::close);
        invoker.record(receiverImplementation::save);
        invoker.run();
    }

    public static void main(String[] args) {
        usoComLambdas();
        System.out.println("------------------------------------");
        usoComMethodReference();
    }

}
