package laboratorio5.exemplos;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Exemplo_1 {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Double> calculaPotencia = (numero, potencia) -> {

          Consumer<Double> imprimeResultado = (r) -> {
              System.out.println(
                      String.format("O resultado do número %s elevado à %s foi: %s", numero, potencia, r)
              );
          };
          Double resultado = Math.pow(numero, potencia);
          imprimeResultado.accept(resultado);
          return resultado;
        };

        calculaPotencia.apply(5,2);

    }
}