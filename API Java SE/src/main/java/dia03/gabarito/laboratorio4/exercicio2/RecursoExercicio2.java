package dia03.gabarito.laboratorio4.exercicio2;

public class RecursoExercicio2 implements AutoCloseable {

    public void executaAlgo() {
        System.out.println("Executando alguma ação que pode retornar uma exception!");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Meu primeiro recurso personalizado do try-with-resouce");
    }
}
