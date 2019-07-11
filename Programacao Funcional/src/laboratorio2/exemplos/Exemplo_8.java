package laboratorio2.exemplos;

import java.util.Optional;

public class Exemplo_8 {

    public static void exemploOrElse(){

        Optional<Cachorro> cachorroSemChip = Optional.ofNullable(new Cachorro("Magrelinho"));
        String resultado = cachorroSemChip.flatMap(Cachorro::getChipIdentificacao).orElse("Não possui chip de identificação!");
        System.out.println(resultado);

    }

    public static void exemploOrElseThrow(){

        Optional<Cachorro> cachorroSemChip = Optional.ofNullable(new Cachorro("Magrelinho"));
        try{
            String resultado = cachorroSemChip.flatMap(Cachorro::getChipIdentificacao).orElseThrow(() -> new Exception("Não possui chip de identificação!"));
            System.out.println(resultado);
        } catch (Exception e){
            System.out.print("Ocorreu uma Exception: ");
            System.out.print(e.getMessage());
        }
    }

    public static void main(String[] args) {
        exemploOrElse();
        exemploOrElseThrow();
    }

}

class Cachorro {

    String nome;
    String chipIdentificacao;

    public Cachorro(String nome) {
        this.nome = nome;
    }

    public Cachorro(String nome, String chipIdentificacao) {
        this.nome = nome;
        this.chipIdentificacao = chipIdentificacao;
    }

    public String getNome() {
        return nome;
    }

    public Optional<String> getChipIdentificacao() {
        return Optional.ofNullable(chipIdentificacao);
    }

}