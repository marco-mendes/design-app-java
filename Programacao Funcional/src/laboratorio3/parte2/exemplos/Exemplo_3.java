package laboratorio3.parte2.exemplos;

import java.util.function.Predicate;

public class Exemplo_3 {

    public static void main(String[] args) {
        Predicate<String> seChamaJose = nome -> (nome == "Jose") ? true : false;
        Predicate<String> seChamaJoseOuMaria = seChamaJose.or(nome -> (nome == "Maria") ? true : false);
        System.out.println("Se chama Jose ou Maria? " + seChamaJoseOuMaria.test("Jose"));
        System.out.println("Se chama Jose ou Maria? " + seChamaJoseOuMaria.test("Maria"));
        System.out.println("Se chama Jose ou Maria? " + seChamaJoseOuMaria.test("Draven"));
    }

}
