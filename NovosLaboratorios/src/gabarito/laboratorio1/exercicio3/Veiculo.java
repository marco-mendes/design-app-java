package gabarito.laboratorio1.exercicio3;

public interface Veiculo {

    void ligarVeiculo();

    default void acelerar() {
        System.out.println("Acelerando!");
    }

}
