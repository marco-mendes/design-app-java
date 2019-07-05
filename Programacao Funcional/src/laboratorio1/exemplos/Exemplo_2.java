package laboratorio1.exemplos;

import java.util.Arrays;
import java.util.List;

public class Exemplo_2 {

    public static void main(String[] args) {
        usoInterfaceFuncionalComLambda();
    }

    public static void usoInterfaceFuncionalComLambda(){
        TestarAlgo testador = (lista) -> lista.size() > 5;
        List<Integer> listaNumeros = Arrays.asList(1,2,3,4,5,6);

        System.out.println("Resultado do teste: ");
        System.out.println("A Lista possui mais de 5 elementos? " + testador.test(listaNumeros));
    }

}

interface TestarAlgo {
    boolean test(List lista);
}