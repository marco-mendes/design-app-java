package laboratorio3.parte2.exercicio;

import java.util.function.Predicate;

/*
Com base no código abaixo ajuste a lógica dos 2 Predicates para atender os seguinte requisitos:
 * Utilize o Predicate sexoMaculino para montar o Predicate sexoMasculinoOuFeminino.
 * Utilize o Predicate maiorDeIdade para montar o Predicate maiorDeIdadeENaoIdosa
 * O Predicate sexoMasculinoOuFeminino deve verificar se a Instância do Objeto Pessoa é do sexo MASCULINO ou FEMININO.
 * O Predicate maiorDeIdadeENaoIdosa deve verificar se a idade da Instância do objeto Pessoa é maior que 18 anos E menos que 65 anos.

* */

public class Exercicio_2 {

    public static void main(String[] args) {

        // Remova os comentários abaixo para iniciar o exercicio!

        /*

        Predicate<Pessoa> sexoMaculino = (pessoa) ->  pessoa.getSexo().equals(Sexo.MASCULINO);
        Predicate<Pessoa> sexoMasculinoOuFeminino = ?????;

        Predicate<Pessoa> maiorDeIdade = (pessoa) -> pessoa.getIdade() > 18;
        Predicate<Pessoa> maiorDeIdadeENaoIdosa = ?????;

        Pessoa pessoa = new Pessoa("João", Sexo.MASCULINO, 35);
        Pessoa pessoa1 = new Pessoa("Maria", Sexo.FEMININO, 25);
        Pessoa pessoa2 = new Pessoa("Castiel", Sexo.OUTROS, 28);
        Pessoa pessoa3 = new Pessoa("Pedro", Sexo.OUTROS, 42);
        Pessoa pessoa4 = new Pessoa("Sam", Sexo.OUTROS, 67);

        System.out.println("Sexo Masculino ou Feminino? " + sexoMasculinoOuFeminino.test(pessoa));
        System.out.println("Sexo Masculino ou Feminino? " + sexoMasculinoOuFeminino.test(pessoa1));
        System.out.println("Sexo Masculino ou Feminino? " + sexoMasculinoOuFeminino.test(pessoa2));

        System.out.println("Pessoa maior de idade e não idosa? " + maiorDeIdadeENaoIdosa.test(pessoa3));
        System.out.println("Pessoa maior de idade e não idosa? " + maiorDeIdadeENaoIdosa.test(pessoa4));

        */

    }

}

enum  Sexo {
    MASCULINO, FEMININO, OUTROS
}

class Pessoa {
    String nome;
    Sexo sexo;
    int idade;

    public Pessoa(String nome, Sexo sexo, int idade) {
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

    public int getIdade() {
        return idade;
    }
}