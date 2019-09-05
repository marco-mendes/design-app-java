package dia01.gabarito.laboratorio2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

enum TipoProduto {
    Congelados, Bebidas, Eletrodomesticos, Eletronicos
}

public class Produto {

    String id;
    String nome;
    TipoProduto tipo;
    String descricao;


    public Produto(String id, String nome, TipoProduto tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
    }

    public Produto(String id, String nome, TipoProduto tipo, String descricao) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public TipoProduto getTipo() {
        return tipo;
    }

    public Optional<String> getDescricao() {
        return Optional.ofNullable(descricao);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", tipo=" + tipo +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    public static List<Produto> obtemProdutos(){
        List<Produto> produtos = Arrays.asList(
                new Produto("1", "Sorvete", TipoProduto.Congelados),
                new Produto("2", "Cerveja", TipoProduto.Bebidas),
                new Produto("3", "Refrigerante", TipoProduto.Bebidas),
                new Produto("4", "Geladeira", TipoProduto.Eletrodomesticos),
                new Produto("5", "Chromecast", TipoProduto.Eletronicos, "Com ele você pode assistir seus filmes e séries em uma TV que não tenha a função Smart")
        );
        return produtos;
    }


}