package gabarito.laboratorio3.parte3;

import java.util.function.Consumer;

public class Exercicio_2 {

    public static void main(String[] args) {

        // A resolver
        Consumer<Pessoa> consumerImprimeNome = p -> System.out.println(
                String.format("Nome: %s", p.getNome())
        );
        Consumer<Pessoa> consumerImprimeNomeEIdade = consumerImprimeNome.andThen(p -> System.out.println(
                String.format("Idade: %d", p.getIdade())
                )
        );

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