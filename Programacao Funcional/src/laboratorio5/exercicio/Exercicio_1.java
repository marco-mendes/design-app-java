package laboratorio5.exercicio;

/*

Com base no exemplo acima crie um closure seguindo os seguintes passos:
Crie uma Function chamada calculaRaizQuadrada que irá receber um número inteiro como parâmetro e retornar um valor do tipo Double referente a raiz quadrada do mesmo.
Dentro dessa Function crie um Consumer chamado imprimirRaizQuadrada e o invoque dentro da Function calculaRaizQuadrada passando como argumento a raiz quadrada já calculada.
Este consumer deve imprimir a seguinte mensagem no console: "O resultado da raiz quadrada do número VALOR_RECEBIDO_PELO_FUNCTION é: VALOR_RAIZ_QUADRADA_CALCULADO".
Por exemplo, a função calculaRaizQuadrada foi invocada com o valor 25, o valor impresso pelo consumer imprimirRaizQuadrada deve ser semelhante a isso: "O resultado da raiz quadrada do número 25 é: 5".

* */


import java.util.function.Consumer;
import java.util.function.Function;

public class Exercicio_1 {

    public static void main(String[] args) {

        Function<Integer, Double> calculaRaizQuadrada = (valor) -> {

            Consumer<Double> imprimirRaizQuadrada = (raiz) -> System.out.println(
              String.format("O resultado da raiz quadrada do número %s é: %s", valor, raiz)
            );
            Double raizQuadrada = Math.sqrt(valor);
            imprimirRaizQuadrada.accept(raizQuadrada);
            return raizQuadrada;

        };

        calculaRaizQuadrada.apply(25);
        calculaRaizQuadrada.apply(64);

    }

}
