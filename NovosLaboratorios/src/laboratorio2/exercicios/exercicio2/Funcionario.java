package laboratorio2.exercicios.exercicio2;

enum Sexo {
    MASCULINO, FEMININO ,OUTROS
}

public class Funcionario {

    private String nome;
    private String registro;
    private Sexo sexo;
    private int idade;
    private Double salario;

    public Funcionario(String nome, String registro, Sexo sexo, int idade, Double salario) {
        this.nome = nome;
        this.registro = registro;
        this.sexo = sexo;
        this.idade = idade;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public String getRegistro() {
        return registro;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public int getIdade() {
        return idade;
    }

    public Double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", registro='" + registro + '\'' +
                ", sexo=" + sexo +
                ", idade=" + idade +
                ", salario=" + salario +
                '}';
    }
}
