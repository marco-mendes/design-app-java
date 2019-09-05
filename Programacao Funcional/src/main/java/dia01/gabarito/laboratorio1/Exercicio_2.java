package dia01.gabarito.laboratorio1;

public class Exercicio_2 {

    public static void main(String[] args) {
        TestarAlgo teste = (n) -> (n%2 == 0) ? true : false;
        System.out.println("É um número par? " + teste.test(4));
        System.out.println("É um número par? " + teste.test(7));
    }

}

interface TestarAlgo {
    boolean test(Integer numero);
}