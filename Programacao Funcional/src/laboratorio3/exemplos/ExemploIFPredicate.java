package laboratorio3.exemplos;

import java.util.function.Predicate;

public class ExemploIFPredicate {

    public static void main(String[] args) {

        usoBasicoPredicate();
        usoMetodoAnd();
        usoMetodoOr();
        usoMetodoNegate();
        usoMetodoIsEqual();
    }

    public static void usoBasicoPredicate(){
        // Exemplo com Lambda em linha única
        Predicate<Integer> testeMaioridade = n -> (n > 18) ? true : false;

        // Exemplo com Lambda Multilinha
        Predicate<Integer> testeMaioridadeMultilinha = n -> {
            if(n > 18){
                System.out.println("É maior de idade");
                return true;
            } else {
                System.out.println("Não é maior de idade");
                return false;
            }
        };

        System.out.println("É maior de idade? " + testeMaioridade.test(28));
        System.out.println("É maior de idade? " + testeMaioridade.test(17));
        System.out.println("É maior de idade? " + testeMaioridadeMultilinha.test(14));
        System.out.println("É maior de idade? " + testeMaioridadeMultilinha.test(31));
    }

    public static void usoMetodoAnd(){

        Predicate<Integer> testeMaioridade = n -> (n > 18) ? true : false;
        Predicate<Integer> testeMaioridadeENaoIdoso = testeMaioridade.and(n -> (n < 60) ? true : false);
        System.out.println("É maior de idade e não é idoso? " + testeMaioridadeENaoIdoso.test(65));
        System.out.println("É maior de idade e não é idoso? " + testeMaioridadeENaoIdoso.test(42));

    }

    public static void usoMetodoOr(){
        Predicate<String> seChamaJose = nome -> (nome == "Jose") ? true : false;
        Predicate<String> seChamaJoseOuMaria = seChamaJose.or(nome -> (nome == "Maria") ? true : false);
        System.out.println("Se chama Jose ou Maria? " + seChamaJoseOuMaria.test("Jose"));
        System.out.println("Se chama Jose ou Maria? " + seChamaJoseOuMaria.test("Maria"));
        System.out.println("Se chama Jose ou Maria? " + seChamaJoseOuMaria.test("Draven"));
    }

    public static void usoMetodoNegate(){
        Predicate<Integer> maiorQueDez = (i) -> i > 10;

        // Predicate sem negação
        Predicate<Integer> menorQueVinte = (i) -> (i < 20);
        boolean result = maiorQueDez.and(menorQueVinte).test(15);
        System.out.println(result);

        // Predicate com negação
        boolean result2 = maiorQueDez.and(menorQueVinte).negate().test(15);
        System.out.println(result2);
    }

    public static void usoMetodoIsEqual(){
        Predicate<String> isBrasileiro = Predicate.isEqual("Brasileiro");
        System.out.println("É Brasileiro? " + isBrasileiro.test("Brasileiro"));
        System.out.println("É Brasileiro? " + isBrasileiro.test("Argentino"));
    }

}
