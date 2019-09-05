package dia03.gabarito.laboratorio1.parte3;

import java.util.ArrayList;
import java.util.List;

public class LocalizarAdjetivoInterpreter implements Expression {

    private String[] palavras;
    private String textoRecebido;
    private List<String> adjetivos;


    public LocalizarAdjetivoInterpreter(String texto, List<String> adjetivos) {
        this.palavras = texto.toLowerCase().split(" ");
        this.textoRecebido = texto;
        this.adjetivos = adjetivos;
    }

    @Override
    public void interpret() {
        List<String> adjetivosEncontrados = new ArrayList<>();

        for(String palavra : palavras) {
            if(adjetivos.contains(palavra)) {
                adjetivosEncontrados.add(palavra);
            }
        }
        System.out.println(String.format("Texto recebido: %s", textoRecebido));
        System.out.println(String.format("Adjetivos encontrados: %s", adjetivosEncontrados));

    }

}
