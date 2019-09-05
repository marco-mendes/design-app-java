package dia01.laboratorio7.parte1.exemplos.depoisjava8;

public class ReceiverImplementation implements ReceiverInterface {


    @Override
    public void open() {
        System.out.println("Comando open executado com sucesso!");
    }

    @Override
    public void close() {
        System.out.println("Comando close executado com sucesso!");
    }

    @Override
    public void save() {
        System.out.println("Comando save executado com sucesso!");
    }
}