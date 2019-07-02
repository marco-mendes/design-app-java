package laboratorio3.parte3.exercicios;

/*
Como base no código abaixo altere os Consumers presentes no exercício para atenderem as seguintes condições:
 * O consumerImprimeNome deve imprimir o atributo nome da instância do objeto pessoa.
 * O consumerImprimeNomeEIdade deve imprimir os atributos nome e idade da instância do objeto pessoa.
 * O consumerImprimeNomeEIdade deve ser criado usando como base o consumerImprimeNome.
* */

import java.util.function.Consumer;

public class ExercicioIFConsumer {

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
