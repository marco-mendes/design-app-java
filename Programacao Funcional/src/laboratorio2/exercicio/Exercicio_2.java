package laboratorio2.exercicio;

import java.util.ArrayList;
import java.util.List;

/*

  Com base no código abaixo utilize o método forEach da lista de Pessoas para acessar o método imprimePessoa
  através de Method Reference.

*/

public class Exercicio_2 {

    public static void main(String[] args) {

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Marcio", 30));
        pessoas.add(new Pessoa("Marcela", 26));
        pessoas.add(new Pessoa("João", 29));
        pessoas.add(new Pessoa("Josefina", 21));

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
        String textoAImprimir = String.format("Nome: %s | Idade: %d", this.nome, this.idade);
        System.out.println(textoAImprimir);
    }

}