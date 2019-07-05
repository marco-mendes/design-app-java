package laboratorio1.exemplos;

public class Exemplo_3 {

    public static <T> T calcular(Operator<T> operacao, T value1, T value2){
        return operacao.apply(value1,value2);
    }

    public static void main(String[] args) {
        System.out.println(calcular((a, b) -> a + b, 5, 20));
    }

}

interface Operator<T> {

    T apply(T a, T b);

}