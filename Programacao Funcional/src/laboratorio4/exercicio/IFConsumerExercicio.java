package laboratorio4.exercicio;

import java.util.function.Consumer;

public class IFConsumerExercicio {

    public static void main(String[] args) {

        // Remova os comentários para iniciar o exercício
        /*

        Consumer<Pessoa> consumerImprimeNome = ??? -> ???;
        Consumer<Pessoa> consumerImprimeNomeEIdade = ??? -> ???;

        Pessoa p = new Pessoa("João", 32);

        consumerImprimeNomeEIdade.accept(p);

         */
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

    public int getIdade() {
        return idade;
    }

}
