package gabarito.laboratorio3.parte2;

import java.util.function.Predicate;

public class Exercicio_2 {

    public static void main(String[] args) {
        Predicate<Pessoa> sexoMaculino = (pessoa) ->  pessoa.getSexo().equals(Sexo.MASCULINO);
        Predicate<Pessoa> sexoMasculinoOuFeminino = sexoMaculino.or(p -> p.getSexo().equals(Sexo.FEMININO));

        Predicate<Pessoa> maiorDeIdade = (pessoa) -> pessoa.getIdade() > 18;
        Predicate<Pessoa> maiorDeIdadeENaoIdosa = maiorDeIdade.and(pessoa -> pessoa.getIdade() < 65);

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