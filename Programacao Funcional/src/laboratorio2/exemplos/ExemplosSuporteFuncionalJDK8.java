package laboratorio2.exemplos;

import java.util.Arrays;
import java.util.List;

public class ExemplosSuporteFuncionalJDK8 {

    public static void main(String[] args) {
        usoMetodoDefault();
        usoBasicoMethodReference();

    }

    public static void usoMetodoDefault(){
        UsoDefaultExemplo usoDefaultExemplo = new UsoDefaultExemplo();
        usoDefaultExemplo.meuNovoMetodo();
    }

    public static void usoBasicoMethodReference(){
        List<String> nomes = Arrays.asList("Marry", "Jhon", "Natasha");
        nomes.forEach(ExemplosSuporteFuncionalJDK8::imprimeValorMaiusculo);
    }

    public static void imprimeValorMaiusculo(String value){
        System.out.println(value.toUpperCase());
    }

}

class UsoDefaultExemplo implements IntefaceComDefault {

    public UsoDefaultExemplo() {

    }
}

interface IntefaceComDefault {

    default void meuNovoMetodo(){
        System.out.println("Novo método");
    }

}
