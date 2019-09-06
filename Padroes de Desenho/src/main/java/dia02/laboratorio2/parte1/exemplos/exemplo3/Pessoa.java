package dia02.laboratorio2.parte1.exemplos.exemplo3;

import java.util.function.Consumer;

public class Pessoa {

    private String primeiroNome;
    private String ultimoNome;
    private int idade;
    private String nomeDaMae;
    private String nomeDoPai;
    private double altura;
    private double peso;

    private Pessoa(){

    }

    public static class Builder {

        public String primeiroNome;
        public String ultimoNome;
        public int idade;
        public String nomeDaMae;
        public String nomeDoPai;
        public double altura;
        public double peso;

        public Builder() {

        }

        public Builder set(Consumer<Builder> builderConsumer) {
            builderConsumer.accept(this);
            return this;
        }

        public Pessoa build() {
            Pessoa pessoa = new Pessoa();
            pessoa.primeiroNome = this.primeiroNome;
            pessoa.ultimoNome = this.ultimoNome;
            pessoa.idade = this.idade;
            pessoa.nomeDaMae = this.nomeDaMae;
            pessoa.nomeDoPai = this.nomeDoPai;
            pessoa.altura = this.altura;
            pessoa.peso = this.peso;
            return pessoa;
        }

    }

    // Getters e Setters
}