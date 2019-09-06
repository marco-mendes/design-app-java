package dia02.laboratorio1.exercicios.exercicio3;

public interface Veiculo {

    void ligarVeiculo();

    default void acelerar() {
        System.out.println("Acelerando!");
    }

}
