package dia01.gabarito.laboratorio6;

enum Tipo {
    ELETRONICOS, ELETRODOMESTICOS, OUTROS
}

public class Produto {

    private String nome;
    private Double preco;
    private Tipo tipo;

    public Produto(String nome, Double preco, Tipo tipo) {
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public Tipo getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", tipo=" + tipo +
                '}';
    }
}