package laboratorio1.exemplos.exemplo2;

public class Funcionario {

    private String registro;
    private String nome;
    private String endereco;

    public Funcionario(String registro, String nome, String endereco) {
        this.registro = registro;
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getRegistro() {
        return registro;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }
}
