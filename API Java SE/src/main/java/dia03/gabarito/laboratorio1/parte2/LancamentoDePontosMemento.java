package dia03.gabarito.laboratorio1.parte2;

import java.util.ArrayList;
import java.util.List;

public final class LancamentoDePontosMemento {

    private final String nomeUsuario;
    private final List<Ponto> pontos = new ArrayList<>();

    public LancamentoDePontosMemento(String nomeUsuario, List<Ponto> pontos) {
        super();
        this.nomeUsuario = nomeUsuario;
        this.pontos.addAll(pontos);
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public List<Ponto> getPontos() {
        return pontos;
    }

}
