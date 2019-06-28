package laboratorio2.exercicio;

public class Exercicio_1_SuporteFuncionalJDK8 implements Calculator {

    public static void main(String[] args) {

    }

    @Override
    public int calculoSimples(int a, int b){
        return a + b;
    }

}

interface Calculator {

    int calculoSimples(int a, int b);

}