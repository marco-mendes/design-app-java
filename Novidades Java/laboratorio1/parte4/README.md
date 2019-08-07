## Pequenas modificações na linguagem

### Material de preparação
[Métodos privados em interfaces](https://howtodoinjava.com/java9/java9-private-interface-methods/)<br/>
[Novos Factory Methods para criação de coleções imutáveis](https://www.baeldung.com/java-9-collections-factory-methods)<br/>
[Melhoria na instrução Try With Resources](https://www.tutorialspoint.com/java9/java9_try_with_resources_improvement)

### Introdução
A partir do Java 9 foram introduzidas algumas pequenas modificações na linguagem Java, dentre elas se destacam:
 * Possibilidade de criar implementações de métodos privados em Interfaces.
 * Novos Factory Methods para criação de coleções imutáveis
 * Melhoria no Try With Resources

Abordaremos cada uma dessas modificações com exemplos de uso.

### Métodos privados em Interfaces
Com a introdução do modificador **default** no Java 8 foi adicionada a possibilidade de criar implementações concretas dentro de uma Interface, essa é uma possibilidade bem 
interessante porém não era possível reutilizar código dentro de uma Interface sem expor a implementação do código que seria reutilizado.<br/>
No Java 9 foi adicionada a possibilidade de criarmos implementações de métodos privados dentro de uma Interface de forma a possibilitar o reaproveitamento de código em métodos 
default.<br/>
Exemplo de uso:
```java
import java.util.Arrays;
import java.util.List;

public class Exemplo_1 {

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        int media = calculadora.calculaMedia(Arrays.asList(1,2,3,4,5));
    }

}

class Calculadora implements Calculator {

    @Override
    public int calculoSimples(int a, int b) {
        return a + b;
    }

}

interface Calculator {

    int calculoSimples(int a, int b);

    default int calculaMedia(List<Integer> valores){
        int totalElementos = valores.size();
        int media = somaValores(valores) / totalElementos; 
        return media;
    }

    private int somaValores(List<Integer> valores) {
        int soma = valores.stream()
                .reduce(0, (a, b) -> a + b);
        return soma;
    }

}
```

#### Exercício 1
Com base no código acima crie um método privado na Interface Calculator chamado **imprimeResultado**, este método deve receber como parâmetro um valor inteiro e deve 
imprimir uma mensagem informando o resultado da operação, exemplo: "Resultado da operação: 15".<br/>
O método **imprimeResultado** deve ser invocado dentro do método **calculaMedia** recebendo como parâmetro a média calculada.

### Novos Factory Methods para Coleções
No Java 9 foi introduzido o método estático **of** nas interfaces **List**, **Set** e **Map** para facilitar a criação de Coleções Imutáveis.<br/>
Exemplo de uso:<br/>
```java
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Exemplo_2 {

    public static void main(String[] args) {
        List<String> listaImutavel = List.of("João", "Maria", "Luiza");
        Set<String> setImutavel = Set.of("João", "Maria", "Luiza");
        Map<String, String> mapImutavel = Map.of("Chave 1", "Valor 1", "Chave 2", "Valor 2", "Chave 3", "Valor 3");
    }

}
```

Conforme mostrado no exemplo acima para criar um List e um Set imutável basta utilizar o método estático **of** de cada um deles e especificar os elementos da coleção.<br/>
Já para a criação de um Map imutável precisamos especificar 2 elementos por vez, sendo eles chave e valor respectivamente.

#### Exercício 2
Para exercitar o que foi mostrado acima crie 3 coleções imutáveis utilizando List, Set e Map para uma lista de 5 números inteiros.

### Melhoria na instrução Try With Resource
A instrução Try With resources é uma variação da instrução Try no qual podemos atribuir a ela qualquer objeto que implemente as interfaces java.lang.AutoCloseable ou 
java.io.Closeable para que quando o bloco de código Try finalizar sua execução os objetos declarados dentro do Try possam executar o método close.<br/>
Esse não é um recurso novo do Java, ele apenas foi melhorado no Java 9.

Antes do Java 9 era necessário declarar o recurso que seria usado dentro do bloco do **try**, já no Java 9 isso não é mais necessário.<br/>
Exemplo de uso:
```java
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
public class Exemplo_4 {

    public static void antesJava9() {
        try(FileOutputStream fileStream=new FileOutputStream("javatpoint.txt");){
            String greeting = "Welcome to javaTpoint.";
            byte b[] = greeting.getBytes();
            fileStream.write(b);
            System.out.println("File written");
        }catch(Exception e) {
            System.out.println(e);
        }
    }

    public static void depoisJava9() throws FileNotFoundException {
        FileOutputStream fileStream=new FileOutputStream("javatpoint.txt");
        try(fileStream){
            String greeting = "Welcome to javaTpoint.";
            byte b[] = greeting.getBytes();
            fileStream.write(b);
            System.out.println("File written");
        }catch(Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        antesJava9();
        depoisJava9();
    }

}
```
