package laboratorio1.exercicio;

/*
 * Com base no código abaixo crie uma interface funcional chamada ComplexOperator, essa interface deve possuir um método chamado apply que recebe um valor genérico
   e retorna um valor genérico.
   Na classe Exercicio_3 Crie um método chamado calculoComplexo que receba como parâmetro um ComplexOperator, um parâmetro genérico e retorne um valor genérico.
   Invoque este método de forma a conseguir calcular a raiz quadrada do número passado como parâmetro.
   Utilize o valor 25.0 para fins de teste

*/
public class Exercicio_3 {

    public static void main(String[] args) {
        System.out.println(calcular((a, b) -> a + b, 5, 20));
    }

    public static <T> T calcular(Operator<T> operacao, T value1, T value2){
        return operacao.apply(value1,value2);
    }

}

interface Operator<T> {

    T apply(T a, T b);

}
