## Stream API e melhorias na interface Collection

### Material de Referência
[Stream API](https://blog.tecsinapse.com.br/stream-api-e-fun%C3%A7%C3%B5es-lambda-no-java-8-9941e8ae95d8)

### Introdução
Neste laboratório abordaremos as Streams.<br/>
Streams são um recurso introduzido no Java 8 que nos permite realizar o processamento de dados dentro de uma coleção através de expressões Lambda.<br/>
Utilizaremos a classe Pessoa para os próximos exemplos:
```java
import java.util.Arrays;
import java.util.List;

enum Sexo {
    MASCULINO, FEMININO
}

public class Pessoa {

    String nome;
    Sexo sexo;

    public Pessoa(String nome, Sexo sexo) {
        this.nome = nome;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public static List<Pessoa> obtemListaPessoas(){
        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Marcos", Sexo.MASCULINO),
                new Pessoa("Robério", Sexo.MASCULINO),
                new Pessoa("Maria", Sexo.FEMININO),
                new Pessoa("Carla", Sexo.FEMININO),
                new Pessoa("Marcos", Sexo.MASCULINO),
                new Pessoa("Silvia", Sexo.FEMININO)
        );
        return pessoas;
    }
    
}
```

### Criando uma Stream
Para criar uma Stream utilizamos o método **stream()** presente em classes e interfaces que implementam a interface Collection.<br/>
Exemplo:
```java
import java.util.List;

public class Exemplo_1 {

    public static void main(String[] args) {
        
        List<Pessoa> pessoas = Pessoa.obtemListaPessoas();
        pessoas.stream();
        
    }
    
}
```
Neste exemplo criamos uma Stream a partir da interface List, esta é apenas a forma de se criar uma Stream, porém ainda não iremos conseguir utilizá-la desta forma.<br/>

### Operações Intermediárias e Operações Terminais
Quando trabalhamos com a interface Stream devemos ter em mente que ela nos fornece dois tipos de operações, as operações intermediárias que retornam uma Stream e as operações terminais que retornam um valor ou o objeto esperado.
Alguns exemplos de operações terminais: filter(), map(), flatMap().<br/>
Alguns exemplos de operações terminais: collect(), count(), max(), min(). 


