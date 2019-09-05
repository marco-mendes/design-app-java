package dia01.laboratorio3.parte2.exemplos;

import java.util.function.Predicate;

public class Exemplo_2 {

    public static void imprimeResultado(String message, Boolean resultado){
        System.out.println(String.format(message, resultado));
    }

    public static void main(String[] args) {

        Carro c1 = new Carro("BMW", "Azul");
        Carro c2 = new Carro("BMW", "Amarelo");

        Predicate<Carro> predicateBmw = (carro) -> carro.modelo.equals("BMW") ? true : false;
        Predicate<Carro> predicateBmwAzul = predicateBmw.and(carro -> carro.getCor().equals("Azul") ? true : false);

        imprimeResultado("É uma BMW Azul? %b", predicateBmwAzul.test(c1));
        imprimeResultado("É uma BMW Azul? %b", predicateBmwAzul.test(c2));

    }

}

class Carro {

    String modelo;
    String cor;

    public Carro(String modelo, String cor) {
        this.modelo = modelo;
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }
}