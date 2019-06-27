package gabarito.laboratorio1;

public class ExercicioLambdas {

    public static void main(String[] args) {
        ComplexOperator<Double> calculaRaizQuadrada = (n) -> Math.sqrt(n);
        System.out.println(calculaRaizQuadrada.apply(25.0));
    }

}

interface ComplexOperator<T> {
    T apply(T t);
}