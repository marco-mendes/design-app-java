package gabarito.laboratorio3.parte3;

import java.util.function.Consumer;

public class ExercicioIFConsumer {

    public static void main(String[] args) {

        //Resolvido
        Consumer<Pessoa> consumerImprimeNome = p -> System.out.print("Nome: " + p.getNome() + " - ");
        Consumer<Pessoa> consumerImprimeNomeEIdade = consumerImprimeNome.andThen(p -> System.out.print("Idade: " + p.getIdade()));

        Pessoa p = new Pessoa("João", 32);

        consumerImprimeNomeEIdade.accept(p);
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
