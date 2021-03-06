package laboratorio3.exemplos;

import java.util.stream.Stream;

public class Exemplo_1_Novos_Metodos_String_API {

    public static void metodoRepeat() {
        String valor1 = "La ".repeat(2) + "Land";
        System.out.println(valor1);

        String valor2 = "Hello ".repeat(2) + "World!";
        System.out.println(valor2);
    }

    public static void metodoStrip() {
        String testeStrip = "    Hello    ";
        System.out.println(testeStrip.strip() + " World!");
        System.out.println(testeStrip.stripLeading() + " World!");
        System.out.println(testeStrip.stripTrailing() + " World!");
    }

    public static void metodoIsBlank() {
        String valorVazio = "";
        String valorEmBranco = "          ";
        String valorPreenchido = "Algum valor";

        System.out.println(valorVazio.isBlank());
        System.out.println(valorEmBranco.isBlank());
        System.out.println(valorPreenchido.isBlank());
    }

    public static void metodoLines() {
        String stringMultilinha = "Linha 1 \nLinha 2 \nLinha 3 \nLinha 4";
        Stream<String> streamStringMultilinha = stringMultilinha.lines();

        streamStringMultilinha.forEach(l -> System.out.println(l));
    }

    public static void main(String[] args) {
        metodoRepeat();
        metodoStrip();
        metodoIsBlank();
        metodoLines();
    }

}
