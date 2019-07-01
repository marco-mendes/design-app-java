package laboratorio3.parte1.exemplos;

import java.util.function.Function;

public class ExemplosIFFunction {

    public static void main(String[] args) {
        exemplosUsoFunction();
        System.out.println("----");
        exemploBasicoFunctionComposition();
        System.out.println("----");
        exemploLambdaComoParametroDeMetodo();
        System.out.println("----");
        exemploFuncaoComoParametroDeMetodo();
    }

    public static void exemplosUsoFunction(){

        Function<Integer, Integer> funcaoDobro = n -> n * 2;
        // Imprime 20 = (10 * 2)
        System.out.println(funcaoDobro.apply(10));

        // Uso do método andThen()
        Function<Integer, Integer> funcaoDobroMaisCinco = funcaoDobro.andThen(n -> n + 5);
        // Ambos imprimem 25 = (10 * 2) + 5
        System.out.println(funcaoDobroMaisCinco.apply(10));
        // Forma alternativa andThen()
        System.out.println(funcaoDobro.andThen(n -> n+5).apply(10));

        // Uso do método compose
        Function<Integer, Integer> funcaoNumeroMaisCincoVezesDois = funcaoDobro.compose(n -> n + 5);
        // Imprime 30 = (10 + 5) * 2
        System.out.println(funcaoNumeroMaisCincoVezesDois.apply(10));

    }

    private static void exemploBasicoFunctionComposition() {

        Function<Integer, Integer> calcularDobro = n -> n * 2;
        Function<Integer, Integer> calcularDobroMaisCinco = calcularDobro.andThen(n -> n * 5);
        System.out.println(calcularDobroMaisCinco.apply(5));

    }

    public static void exemploLambdaComoParametroDeMetodo(){
        // Exemplo com Lambda
        System.out.println(calcular(20, (x) -> x * 5));
        System.out.println(calcular(16, (x) -> x + 4));
        System.out.println(calcular(30, (x) -> x - 2));
    }

    public static void exemploFuncaoComoParametroDeMetodo(){
        //Exemplo passando uma função na chamada do método
        Function<Integer, Integer> funcaoDivisao = (value) -> value / 3;
        System.out.println(calcular(60, funcaoDivisao));
    }

    public static int calcular (int valor, Function<Integer, Integer> operation){
        return operation.apply(valor);
    }

}