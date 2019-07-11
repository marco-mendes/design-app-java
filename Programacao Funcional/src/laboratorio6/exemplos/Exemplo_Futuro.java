package laboratorio6.exemplos;

import java.util.List;

public class Exemplo_Futuro {

    public static void main(String[] args) {

        antesStreams();
        depoisStreams();
    }

    public static void antesStreams(){

        List<Pessoa> pessoas = Pessoa.obtemListaPessoas();
        int contagem = 0;
        for(Pessoa pessoa : pessoas){
            if(pessoa.sexo.equals(Sexo.FEMININO)){
                contagem++;
            }
        }
        System.out.println(
                String.format("%d pessoas do sexo Feminino encontradas!", contagem)
        );
    }

    public static void depoisStreams(){

        List<Pessoa> pessoas = Pessoa.obtemListaPessoas();
        Long contagem = pessoas.stream()
                .filter(p -> p.sexo.equals(Sexo.FEMININO))
                .count();
        System.out.println(
                String.format("%d pessoas do sexo Feminino encontradas!", contagem)
        );
    }

}
