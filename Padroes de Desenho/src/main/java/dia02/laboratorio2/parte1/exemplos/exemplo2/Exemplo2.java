package dia02.laboratorio2.parte1.exemplos.exemplo2;

public class Exemplo2 {

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa.Builder()
                .primeiroNome("Márcia")
                .ultimoNome("Ribeiro")
                .idade(32)
                .nomeDaMae("Elisa Ribeiro")
                .nomeDoPai("Caio Ribeiro")
                .altura(1.65)
                .peso(72)
                .build();
    }

}
