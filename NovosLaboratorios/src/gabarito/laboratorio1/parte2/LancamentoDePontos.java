package gabarito.laboratorio1.parte2;

import java.util.ArrayList;
import java.util.List;

public class LancamentoDePontos {

    private String nomeUsuario;
    private List<Ponto> pontos;

    public LancamentoDePontos(String nomeUsuario) {
        super();
        this.nomeUsuario = nomeUsuario;
        this.pontos = new ArrayList<>();
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public List<Ponto> getPontos() {
        return this.pontos;
    }

    public void setPontos(List<Ponto> pontos) {
        this.pontos = pontos;
    }

    public void lancarPonto(Ponto ponto) {
        pontos.add(ponto);
    }

    public void removerPonto(Ponto ponto) {
        this.pontos.remove(ponto);
    }

    public LancamentoDePontosMemento createMemento() {
        return new LancamentoDePontosMemento(nomeUsuario, pontos);
    }

    public void restoreMemento(LancamentoDePontosMemento memento) {
        this.nomeUsuario = memento.getNomeUsuario();
        this.pontos = memento.getPontos();
    }

    @Override
    public String toString() {
        return "LancamentoDePontos{" +
                "nomeUsuario='" + nomeUsuario + '\'' +
                ", pontos=" + pontos +
                '}';
    }
}
