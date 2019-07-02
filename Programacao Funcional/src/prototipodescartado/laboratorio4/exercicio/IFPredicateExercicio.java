package prototipodescartado.laboratorio4.exercicio;

public class IFPredicateExercicio {

    public static void main(String[] args) {

        // Remova os comentários para iniciar o exercício
        /*

        Predicate<Pessoa> sexoMaculino = ??? -> ???;
        Predicate<Pessoa> sexoMasculinoMaiorDeVinteAnos = ???;

        Pessoa pessoa = new Pessoa("João", Sexo.MASCULINO, 35);
        Pessoa pessoa1 = new Pessoa("João", Sexo.MASCULINO, 16);
        Pessoa pessoa2 = new Pessoa("Maria", Sexo.FEMININO, 25);

        System.out.println("É Homem e maior de 20 anos? " + sexoMasculinoMaiorDeVinteAnos.test(pessoa));
        System.out.println("É Homem e maior de 20 anos? " + sexoMasculinoMaiorDeVinteAnos.test(pessoa1));
        System.out.println("É Homem e maior de 20 anos? " + sexoMasculinoMaiorDeVinteAnos.test(pessoa2));


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