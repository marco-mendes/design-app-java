package gabarito.laboratorio2;

import java.util.ArrayList;
import java.util.List;

public class Exercicio_2_SuporteFuncionalJDK8 {

    public static void main(String[] args) {

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Marcio", 30));
        pessoas.add(new Pessoa("Marcela", 26));
        pessoas.add(new Pessoa("João", 29));
        pessoas.add(new Pessoa("Josefina", 21));

        pessoas.forEach(Pessoa::imprimePessoa);

    }

}

class Pessoa {

    String nome;
    int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void imprimePessoa(){
        System.out.println("Nome: " + this.nome + " | Idade: " + this.idade);
    }

}