package laboratorio6.exemplos;

import java.util.Arrays;
import java.util.List;

enum Sexo {
    MASCULINO, FEMININO
}

public class Pessoa {

    String nome;
    Sexo sexo;

    public Pessoa(String nome, Sexo sexo) {
        this.nome = nome;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public static List<Pessoa> obtemListaPessoas(){
        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Marcos", Sexo.MASCULINO),
                new Pessoa("Robério", Sexo.MASCULINO),
                new Pessoa("Maria", Sexo.FEMININO),
                new Pessoa("Carla", Sexo.FEMININO),
                new Pessoa("Marcos", Sexo.MASCULINO),
                new Pessoa("Silvia", Sexo.FEMININO)
        );
        return pessoas;
    }

}
