package dia01.laboratorio6.exemplos;

import java.util.Arrays;
import java.util.List;

enum Sexo {
    MASCULINO, FEMININO
}

public class Pessoa {

    String nome;
    Sexo sexo;
    Integer idade;

    public Pessoa(String nome, Sexo sexo, Integer idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public Integer getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", sexo=" + sexo +
                ", idade=" + idade +
                '}';
    }

    public static List<Pessoa> obtemListaPessoas(){
        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Marcos", Sexo.MASCULINO, 32),
                new Pessoa("Robério", Sexo.MASCULINO, 29),
                new Pessoa("Maria", Sexo.FEMININO, 31),
                new Pessoa("Carla", Sexo.FEMININO, 26),
                new Pessoa("Marcos", Sexo.MASCULINO, 35),
                new Pessoa("Silvia", Sexo.FEMININO, 40)
        );
        return pessoas;
    }

}
