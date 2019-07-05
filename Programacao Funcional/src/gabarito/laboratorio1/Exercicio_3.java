package gabarito.laboratorio1;

public class Exercicio_3 {

    public static void main(String[] args) {
        System.out.println(calculoComplexo((a) -> Math.sqrt(a), 25.0));
    }

    public static <T> T calculoComplexo(ComplexOperator<T> complexOperator, T value){
        return complexOperator.apply(value);
    }

}

interface ComplexOperator<T> {
    T apply(T t);
}