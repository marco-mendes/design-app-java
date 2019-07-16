package laboratorio7.parte1.exercicio;

public class ReceiverImplementation implements ReceiverInterface {

    @Override
    public void moveToLeft() {
        System.out.println("Movendo para a esquerda!");
    }

    @Override
    public void moveToRight() {
        System.out.println("Movendo para a direita!");
    }

    @Override
    public void moveToForward() {
        System.out.println("Movendo para frente!");
    }

    @Override
    public void moveToBackward() {
        System.out.println("Movendo para a trás!");
    }
}
