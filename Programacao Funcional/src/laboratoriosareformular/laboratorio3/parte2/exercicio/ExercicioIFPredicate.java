package laboratoriosareformular.laboratorio3.parte2.exercicio;

/*
Com base no código abaixo ajuste a lógica dos 2 Predicates para atender os seguinte requisitos:

 * O primeiro Predicate deve verificar se a Instância do Objeto Pessoa é do sexo MASCULINO.
 * O segundo Predicate deve verificar se a Instância do objeto Pessoa é do sexo MASCULINO e tem idade superior a 20 anos.
 * Utilize o primeiro Predicate para montar o segundo.
* */

public class ExercicioIFPredicate {

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
