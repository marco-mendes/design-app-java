package gabarito.laboratorio4.exercicio2;

public class Exercicio2 {

    public static void main(String[] args) {
        try(RecursoExercicio2 recursoExercicio2 = new RecursoExercicio2()) {
            recursoExercicio2.executaAlgo();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
