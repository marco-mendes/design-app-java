## Interface Funcional Predicate

### Material de Preparação
[Como usar Predicates](http://www.edneiparmigiani.com.br/java-8-como-usar-o-predicate/)<br/>
[Predicate com Exemplos](https://www.geeksforgeeks.org/java-8-predicate-with-examples/)<br/>
[Vários exemplos de uso da Interface Funcional Predicate](https://www.programcreek.com/java-api-examples/?api=java.util.function.Predicate)

### Introdução
A interface funcional **Predicate** foi projetada para ser usada em situações em que um teste precisa ser executado e um valor booleano precisa ser retornado.

O método usado para executarmos as funções do tipo Predicate é o método **test()**.<br/>
Exemplo de uso básico desta interface funcional:
```java
import java.util.function.Predicate;

public class Exemplo_1 {

    public static void main(String[] args) {

        Predicate<Integer> testeMaioridade = n -> (n > 18) ? true : false;
        int maiorDeIdade = 28;
        int menorDeIdade = 17;
        System.out.println("É maior de idade? " + testeMaioridade.test(maiorDeIdade));
        System.out.println("É maior de idade? " + testeMaioridade.test(menorDeIdade));

    }
}
```


#### Exercicio 1
Com base no código abaixo crie um Predicate para verificar se uma idade recebida é de uma pessoa idosa.<br/>
Caso o valor recebido seja maior que 65 retorne true, caso contrário retorne false.<br/>
Invoque o predicate criado com um valor para teste e imprima no console o resultado.
```java
import java.util.function.Predicate;

public class Exercicio_1 {

    public static void main(String[] args) {
     
        Predicate<Integer> verificaIdadeIdosa = ?????;
        
    }

}
```

### Método and()
Este método é equivalente ao operador lógico **&&**, o mesmo é executado após o método **test()** ser executado.
<br/>Exemplo: 
```java
Predicate<Integer> testeMaioridade = n -> (n > 18) ? true : false;
Predicate<Integer> testeMaioridadeENaoIdoso = testeMaioridade.and(n -> (n < 60) ? true : false);
System.out.println("É maior de idade e não é idoso? " + testeMaioridadeENaoIdoso.test(65));
System.out.println("É maior de idade e não é idoso? " + testeMaioridadeENaoIdoso.test(42));
```

### Método or()
Este método é equivalente ao operador lógico **||**, o mesmo é executado após o método **test()** ser executado.
<br/>Exemplo:
```java
Predicate<String> seChamaJose = nome -> (nome == "Jose") ? true : false;
Predicate<String> seChamaJoseOuMaria = seChamaJose.or(nome -> (nome == "Maria") ? true : false);
System.out.println("Se chama Jose ou Maria? " + seChamaJoseOuMaria.test("Jose"));
System.out.println("Se chama Jose ou Maria? " + seChamaJoseOuMaria.test("Maria"));
System.out.println("Se chama Jose ou Maria? " + seChamaJoseOuMaria.test("Draven"));
```

#### Exercicio 2
Com base no código abaixo ajuste a lógica dos 2 Predicates para atender os seguinte requisitos:
 * Utilize o Predicate **sexoMaculino** para montar o Predicate **sexoMasculinoOuFeminino**.
 * Utilize o Predicate **maiorDeIdade** para montar o Predicate **maiorDeIdadeENaoIdosa**
 * O Predicate **sexoMasculinoOuFeminino** deve verificar se a Instância do Objeto Pessoa é do sexo Masculino **OU** Feminino.
 * O Predicate **maiorDeIdadeENaoIdosa** deve verificar se a idade da Instância do objeto Pessoa é maior que 18 anos **E** menor que 65 anos. 
```java
import java.util.function.Predicate;

public class Exercicio_2 {

    public static void main(String[] args) {
        Predicate<Pessoa> sexoMaculino = (pessoa) ->  pessoa.getSexo().equals(Sexo.MASCULINO);
        Predicate<Pessoa> sexoMasculinoOuFeminino = ?????;

        Predicate<Pessoa> maiorDeIdade = (pessoa) -> pessoa.getIdade() > 18;
        Predicate<Pessoa> maiorDeIdadeENaoIdosa = ?????;

        Pessoa pessoa = new Pessoa("João", Sexo.MASCULINO, 35);
        Pessoa pessoa1 = new Pessoa("Maria", Sexo.FEMININO, 25);
        Pessoa pessoa2 = new Pessoa("Castiel", Sexo.OUTROS, 28);
        Pessoa pessoa3 = new Pessoa("Pedro", Sexo.OUTROS, 42);
        Pessoa pessoa4 = new Pessoa("Sam", Sexo.OUTROS, 67);

        System.out.println("Sexo Masculino ou Feminino? " + sexoMasculinoOuFeminino.test(pessoa));
        System.out.println("Sexo Masculino ou Feminino? " + sexoMasculinoOuFeminino.test(pessoa1));
        System.out.println("Sexo Masculino ou Feminino? " + sexoMasculinoOuFeminino.test(pessoa2));
        System.out.println("Pessoa maior de idade e não idosa? " + maiorDeIdadeENaoIdosa.test(pessoa3));
        System.out.println("Pessoa maior de idade e não idosa? " + maiorDeIdadeENaoIdosa.test(pessoa4));

    }

}

enum  Sexo {
    MASCULINO, FEMININO, OUTROS
}

class Pessoa {
    String nome;
    Sexo sexo;
    int idade;

    public Pessoa(String nome, Sexo sexo, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public int getIdade() {
        return idade;
    }
}
```

### Método negate()
Este método é equivalente ao operador lógico **!**, o mesmo nega o resultado de algum Predicate.
<br/>Exemplo:
```java
Predicate<Integer> maiorQueDez = (i) -> i > 10;
Predicate<Integer> maiorQueDezNegado = maiorQueDez.negate();
System.out.println(maiorQueDezNegado.test(15));
```

### Método estático Predicate.isEqual()
Este método verifica se uma entrada é equivalente ao esperado.<br/>
Exemplo:
```java
Predicate<String> isBrasileiro = Predicate.isEqual("Brasileiro");
System.out.println(String.format("É Brasileiro? %b", isBrasileiro.test("Brasileiro")));
System.out.println(String.format("É Brasileiro? %b", isBrasileiro.test("Argentino")));
```
