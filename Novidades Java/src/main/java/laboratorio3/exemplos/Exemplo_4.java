package laboratorio3.exemplos;

public class Exemplo_4 {

    public static void main(String[] args) {
        Calculate calculoSimples = (var v1, var v2) -> v1 * v2;
        double resultado = calculoSimples.calculate(5, 2);
        System.out.println(resultado);
    }

}

@FunctionalInterface
interface Calculate {
    double calculate(double value1, double value2);
}