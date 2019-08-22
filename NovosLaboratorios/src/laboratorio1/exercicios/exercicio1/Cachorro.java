package laboratorio1.exercicios.exercicio1;

public class Cachorro {

    private String nome;
    private String raca;

    public Cachorro(String nome, String raca) {
        this.nome = nome;
        this.raca = raca;
    }

    public String getNome() {
        return nome;
    }

    public String getRaca() {
        return raca;
    }

    public void tosarCachorro() {
        System.out.println(String.format("Tosando: %s | Raça: %s", this.nome, this.raca));
    }

    // Métodos que estão diretamente relacionados as propriedades de Cachorro
    public void comer() {
        System.out.println(String.format("%s está comendo!", this.nome));
    }

    public void latir() {
        System.out.println(String.format("%s está latindo!", this.nome));
    }

    public void brincar() {
        System.out.println(String.format("%s está brincando!", this.nome));
    }

}
