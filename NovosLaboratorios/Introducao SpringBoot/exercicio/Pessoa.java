import java.util.Objects;

import java.util.Arrays;
import java.util.List;

public class Pessoa {


    private int id;
    private String nome;

    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public static List<Pessoa> obterPessoas() {
        return Arrays.asList(
                new Pessoa(1, "Marcos"),
                new Pessoa(2, "Joana d'Arc"),
                new Pessoa(3, "Ester"),
                new Pessoa(4, "Raquel"),
                new Pessoa(5, "Arthur")
        );
    }

}