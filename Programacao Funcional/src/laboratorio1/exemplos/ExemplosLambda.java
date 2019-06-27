package laboratorio1.exemplos;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ExemplosLambda {
    public static void main(String[] args) {
        ordenacaoAntesLambdas();
        ordenacaoComLambdas();
        funcaoPura();
        funcaoImpura();
        usoInterfaceFuncionalComLambda();
        exemploInferenciaTipos();
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

    public static void funcaoPura(){
        List<Integer> lista = Arrays.asList(1,2,3,4,5);

        lista.forEach((v) -> System.out.println(v * 2));
    }

    public static void funcaoImpura(){
        List<Integer> lista = Arrays.asList(1,2,3,4,5);

        int multiplicador = 5;

        lista.forEach((v) -> System.out.println(v * multiplicador));
    }

    public static void usoInterfaceFuncionalComLambda(){
        TestaAlgo<List<Integer>> testador = (lista) -> lista.size() > 5;
        List<Integer> listaNumeros = Arrays.asList(1,2,3,4,5,6);

        System.out.println("Resultado do teste: ");
        System.out.println("A Lista possui mais de 5 elementos? " + testador.test(listaNumeros));
    }

    public static void exemploInferenciaTipos(){
        System.out.println(Calculadora.calcular((a, b) -> a + b, 5, 20));
    }

}

class Calculadora {

    public static <T> T calcular(Operator<T> operacao, T value1, T value2){
        return operacao.apply(value1,value2);
    }

}

interface Operator<T> {

    T apply(T a, T b);

}

interface TestaAlgo<T> {
    boolean test(T t);
}