package dia03.gabarito.laboratorio1.parte3;

import java.util.ArrayList;
import java.util.List;

public class LocalizarSubstantivoInterpreter implements Expression {

    private String[] palavras;
    private String textoRecebido;
    private List<String> substantivos;


    public LocalizarSubstantivoInterpreter(String texto, List<String> substantivos) {
        this.palavras = texto.toLowerCase().split(" ");
        this.textoRecebido = texto;
        this.substantivos = substantivos;
    }

    @Override
    public void interpret() {
        List<String> substantivos = new ArrayList<>();

        for(String palavra : palavras) {
            if(this.substantivos.contains(palavra)) {
                substantivos.add(palavra);
            }
        }
        System.out.println(String.format("Texto recebido: %s", textoRecebido));
        System.out.println(String.format("Substantivos encontrados: %s", substantivos));

    }

}