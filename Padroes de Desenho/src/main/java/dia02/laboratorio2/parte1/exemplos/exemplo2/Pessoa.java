package dia02.laboratorio2.parte1.exemplos.exemplo2;

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

        private String primeiroNome;
        private String ultimoNome;
        private int idade;
        private String nomeDaMae;
        private String nomeDoPai;
        private double altura;
        private double peso;

        public Builder() {

        }

        public Builder primeiroNome(String primeiroNome) {
            this.primeiroNome = primeiroNome;
            return this;
        }

        public Builder ultimoNome(String ultimoNome) {
            this.ultimoNome = ultimoNome;
            return this;
        }

        public Builder idade(int idade) {
            this.idade = idade;
            return this;
        }

        public Builder nomeDaMae(String nomeDaMae) {
            this.nomeDaMae = nomeDaMae;
            return this;
        }

        public Builder nomeDoPai(String nomeDoPai) {
            this.nomeDoPai = nomeDoPai;
            return this;
        }

        public Builder altura(double altura) {
            this.altura = altura;
            return this;
        }

        public Builder peso(double peso) {
            this.peso = peso;
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
