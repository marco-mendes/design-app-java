## Introdução ao recurso try-with-resource

### Material de preparação
[Introdução ao recurso try-with-resource](https://www.baeldung.com/java-try-with-resources)<br/>
[Melhoria na instrução Try With Resources no Java 9](https://www.tutorialspoint.com/java9/java9_try_with_resources_improvement)

### Introdução
O try-with-resource teve seu suporte adicionado a partir do Java 7, seu principal objetivo é substituir o bloco de código try-catch-finally.<br/>
Na maioria das vezes utilizávamos o recurso try-catch-finally quando era necessário finalizar algum recurso inicializado dentro do bloco try, na maioria das vezes esses recursos 
eram finalizados com o método **close()** e era necessário adicionar esse fechamento de recurso no bloco finally.

O requisito para utilizar este recurso é que a(s) classe(s) o usarão implemente(m) a interface **AutoCloseable**, se a classe implementar essa interface o próprio Java fica 
responsável por finalizar o recurso declarado.

Abaixo possuímos um exemplo de implementação anterior ao try-with-resources no qual era necessário invocar o método close no bloco finally:
```java
Scanner scanner = null;
try {
    scanner = new Scanner(new File("test.txt"));
    while (scanner.hasNext()) {
        System.out.println(scanner.nextLine());
    }
} catch (FileNotFoundException e) {
    e.printStackTrace();
} finally {
    if (scanner != null) {
        scanner.close();
    }
}
```

Utilizando o try-with-resources podemos remover o bloco de código finally pois o Java ficará reponsável por executá-lo após o fim da operação.<br/>
Com o try-with-resoucers a implementação acima ficaria semelhante a isso:
```java
try (Scanner scanner = new Scanner(new File("test.txt"))) {
    while (scanner.hasNext()) {
        System.out.println(scanner.nextLine());
    }
} catch (FileNotFoundException fnfe) {
    fnfe.printStackTrace();
}
```

Confome vimos no exemplo acima abrimo um parêntese na declaração try e declaramos nossa instância que contêm uma implementação da interface **AutoCloseable**, observe que não 
foi necessário declarar o bloco finally pois o Java encerra o objeto Scanner automáticamente.

Uma observação importante é que até o Java 8 era necessário declarar o recurso que seria usado no try-with-resource dentro dos parênteres da declaração try, o seguinte bloco de 
código resultaria em um erro:
```java
FileOutputStream fileStream = new FileOutputStream("./src/laboratorio4/test.txt");
try(fileStream){
    String greeting = "Hello try-with-resource in Java 9";
    byte b[] = greeting.getBytes();
    fileStream.write(b);
    System.out.println("File written");
}catch(Exception e) {
    System.out.println(e);
}
```
A partir do Java 9 a declaração acima se tornou válida.<br/>
Caso deseje saber mais sobre isso você pode ler o este [artigo](https://www.tutorialspoint.com/java9/java9_try_with_resources_improvement).


#### Exercício 1
Refatore o código abaixo utilizando o recurso try-with-resource
```java
import java.io.FileOutputStream;

public class Exercicio1 {
    public static void main(String args[]){
        
        FileOutputStream fileOutputStream = null;
        try{
            fileOutputStream = new FileOutputStream("./src/laboratorio4/test.txt");
            String msg = "Hello try-with-resouce";
            byte byteArray[] = msg.getBytes(); //converting string into byte array
            fileOutputStream.write(byteArray);
            System.out.println("Message written to file successfuly!");
        }catch(Exception exception){
            System.out.println(exception);
        }
    }
}
``` 

### Criando um recurso personalizado com a interface AutoCloseable
Para construir um recurso personalizado que será tratado corretamente por um bloco try-with-resources, a classe deve implementar as interfaces **Closeable** ou **AutoCloseable** 
e sobrescrever o método **close()** conforme o exemplo abaixo:
```java
public class MyResource implements AutoCloseable {

    public void teste() throws Exception {
        System.out.println("Recurso personalizado para try-with-resouce sendo utilizado!");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Executando método close do recurso personalizado!");
    }
}
```

Testando o recurso criado:
```java
public class Exemplo3 {

    public static void main(String[] args) {
        try(MyResource myResource = new MyResource()) {

            myResource.teste();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
```

#### Exercício 2
Crie um recurso personalizado chamado **RecursoExercicio2** que em seu método close imprima a seguinte mensagem: "Meu primeiro recurso personalizado do try-with-resouce", 
este recurso deve possuir também um método chamado executaAlgo(), este método deve imprimir a mensagem: "Executando alguma ação que pode retornar uma exception!", este método 
deve lançar um Exception na assinatura do método com a declaração throws.<br/>
Após criar a classe **RecursoExercicio2** crie uma classe chamada **Exercicio2** no qual você deve testar o recurso criado.

