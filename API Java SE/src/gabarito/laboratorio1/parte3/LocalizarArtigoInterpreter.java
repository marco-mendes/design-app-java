package gabarito.laboratorio1.parte3;

import java.util.ArrayList;
import java.util.List;

public class LocalizarArtigoInterpreter implements Expression {

    private String[] palavras;
    private String textoRecebido;
    private List<String> artigos;


    public LocalizarArtigoInterpreter(String texto, List<String> artigos) {
        this.palavras = texto.toLowerCase().split(" ");
        this.textoRecebido = texto;
        this.artigos = artigos;
    }

    @Override
    public void interpret() {
        List<String> artigosEncontrados = new ArrayList<>();

        for(String palavra : palavras) {
            if(artigos.contains(palavra)) {
                artigosEncontrados.add(palavra);
            }
        }
        System.out.println(String.format("Texto recebido: %s", textoRecebido));
        System.out.println(String.format("Artigos encontrados: %s", artigosEncontrados));

    }
}

