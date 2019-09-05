package dia01.laboratorio1.exemplos;

import java.util.Arrays;
import java.util.List;

public class Exemplo_2 {

    public static void main(String[] args) {
        usoInterfaceFuncionalComLambda();
    }

    public static void usoInterfaceFuncionalComLambda(){
        TestarAlgo testador = (lista) -> lista.size() > 5;
        List<Integer> listaNumeros = Arrays.asList(1,2,3,4,5,6);

        String resultadoTeste = String.format("A Lista possui mais de 5 elementos? %s", testador.test(listaNumeros));
        System.out.println("Resultado do teste:");
        System.out.println(resultadoTeste);

    }

}

interface TestarAlgo {
    boolean test(List lista);
}