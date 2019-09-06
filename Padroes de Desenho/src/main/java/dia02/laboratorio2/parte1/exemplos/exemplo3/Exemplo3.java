package dia02.laboratorio2.parte1.exemplos.exemplo3;

public class Exemplo3 {

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa.Builder()
                .set(p -> {
                    p.primeiroNome = "Márcia";
                    p.ultimoNome = "Ribeiro";
                    p.idade = 32;
                    p.nomeDaMae = "Elisa Ribeiro";
                    p.nomeDoPai = "Caio Ribeiro";
                    p.altura = 1.65;
                    p.peso = 72;
                }).build();
    }

}
