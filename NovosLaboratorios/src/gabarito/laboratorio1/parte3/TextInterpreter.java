package gabarito.laboratorio1.parte3;

import java.util.ArrayList;
import java.util.List;

public class TextInterpreter implements Expression {

    private String[] palavras;
    private String textoRecebido;
    private List<String> adjetivos;
    private List<String> substantivos;
    private List<String> artigos;


    public TextInterpreter(String texto, List<String> adjetivos, List<String> artigos, List<String> substantivos) {
        this.palavras = texto.toLowerCase().split(" ");
        this.textoRecebido = texto;
        this.adjetivos = adjetivos;
        this.artigos = artigos;
        this.substantivos = substantivos;
    }

    @Override
    public void interpret() {
        List<String> adjetivosEncontrados = new ArrayList<>();
        List<String> substantivosEncontrados = new ArrayList<>();
        List<String> artigosEncontrados = new ArrayList<>();


        for(String palavra : palavras) {
            if(adjetivos.contains(palavra)) {
                adjetivosEncontrados.add(palavra);
            } else if(artigos.contains(palavra)) {
                artigosEncontrados.add(palavra);
            } else if(substantivos.contains(palavra)) {
                substantivosEncontrados.add(palavra);
            }
        }
        System.out.println(String.format("Texto recebido: %s", textoRecebido));
        System.out.println(String.format("Artigos encontrados: %s", artigosEncontrados));
        System.out.println(String.format("Adjetivos encontrados: %s", adjetivosEncontrados));
        System.out.println(String.format("Substantivo encontrados: %s", substantivosEncontrados));

    }
}
