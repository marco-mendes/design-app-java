package laboratorio1.exemplos;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ExemploLambda {
    public static void main(String[] args) {
        ordenacaoAntesLambdas();
        ordenacaoComLambdas();
    }

    public static void ordenacaoAntesLambdas(){
        List<String> listaNomes = obtemListaTeste();
        listaNomes.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(listaNomes);

    }

    public static void ordenacaoComLambdas(){
        List<String> listaNomes = obtemListaTeste();
        listaNomes.sort((c1, c2) -> c1.compareTo(c2));
        System.out.println(listaNomes);
    }

    public static List<String> obtemListaTeste(){
        List<String> listaNomes1 = Arrays.asList("Joao", "Maria", "Dalva", "Vilma", "Carlos", "Roberto");
        return listaNomes1;
    }
}
