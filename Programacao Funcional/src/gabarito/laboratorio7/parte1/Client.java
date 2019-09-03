package gabarito.laboratorio7.parte1;

import gabarito.laboratorio7.parte1.classesdesnecessarias.*;

public class Client {

    public static void implementacaoSemProgramacaoFuncional(){
        ReceiverImplementation receiverImplementation = new ReceiverImplementation();
        Invoker invoker = new Invoker();
        invoker.record(new MoveToLeftCommand(receiverImplementation));
        invoker.record(new MoveToRightCommand(receiverImplementation));
        invoker.record(new MoveToForwardCommand(receiverImplementation));
        invoker.record(new MoveToBackwardCommand(receiverImplementation));
        invoker.run();
    }

    public static void implementacaoComLambdas(){
        ReceiverImplementation receiverImplementation = new ReceiverImplementation();
        Invoker invoker = new Invoker();
        invoker.record(() -> receiverImplementation.moveToLeft());
        invoker.record(() -> receiverImplementation.moveToRight());
        invoker.record(() -> receiverImplementation.moveToForward());
        invoker.record(() -> receiverImplementation.moveToBackward());
        invoker.run();
    }

    public static void implementacaoComMethodReference(){
        ReceiverImplementation receiverImplementation = new ReceiverImplementation();
        Invoker invoker = new Invoker();
        invoker.record(receiverImplementation::moveToLeft);
        invoker.record(receiverImplementation::moveToRight);
        invoker.record(receiverImplementation::moveToForward);
        invoker.record(receiverImplementation::moveToBackward);
        invoker.run();
    }

    public static void main(String[] args) {
        implementacaoSemProgramacaoFuncional();
        implementacaoComLambdas();
        implementacaoComMethodReference();
    }

}