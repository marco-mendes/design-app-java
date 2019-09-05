package dia01.laboratorio3.parte2.exemplos;

import java.util.function.Predicate;

public class Exemplo_3 {

    public static void imprimeResultado(String message, Boolean resultado){
        System.out.println(String.format(message, resultado));
    }

    public static void main(String[] args) {
        Predicate<String> seChamaJose = nome -> (nome == "Jose") ? true : false;
        Predicate<String> seChamaJoseOuMaria = seChamaJose.or(nome -> (nome == "Maria") ? true : false);
        imprimeResultado("Se chama Jose ou Maria? %b", seChamaJoseOuMaria.test("Jose"));
        imprimeResultado("Se chama Jose ou Maria? %b", seChamaJoseOuMaria.test("Maria"));
        imprimeResultado("Se chama Jose ou Maria? %b", seChamaJoseOuMaria.test("Draven"));
    }

}
