package dia01.laboratorio1.exemplos;

public class ExemploLambdaComException {

    public static void main(String[] args) {

        CalculoComum calculoComum = (numero1, numero2) -> {

            try {
                int resultado = numero1 / numero2;
                System.out.println(resultado);
            } catch (ArithmeticException e) {
                System.out.println("Operação inválida: " + e.getMessage());
                e.printStackTrace();
            }

        };

        calculoComum.calculaEImprimeResultado(10,2);
        calculoComum.calculaEImprimeResultado(5,0);

    }

}

interface CalculoComum {

    void calculaEImprimeResultado(int numero1, int numero2) throws ArithmeticException;

}