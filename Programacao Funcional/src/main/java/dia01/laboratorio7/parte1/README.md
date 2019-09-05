## Design Pattern Command utilizando programação funcional

### Material de preparação
[Pattern Command com e sem programação funcional](https://www.baeldung.com/java-command-pattern)

### Visão geral do Pattern Command
O Pattern Command representa uma maneira de escrever e armazenar código genérico que sequencia e executa métodos com base em decisões em tempo de execução.<br/>
Em uma implementação clássica, o padrão de comando requer a implementação de quatro componentes:
 * **Command**: É divido em duas partes, uma interface que define o método que irá executar o comando, e uma ou mais classes com uma implementação concreta baseada em um Receiver.
 * **Receiver**: Normalmente é divido em duas partes, uma interface que define quais comandos serão implementados e uma classe com a implementação concreta de todos os comandos especificados pela interface Receiver.
 * **Invoker**: É uma classe que recebe e utiliza objetos baseados na interface Command, esta pode armazenar e executar todos os comandos que forem passados para ela mesmo não sabendo como é feita sua implementação dos mesmos.
 * **Client**: É uma classe que irá controlar o processo de execução dos comandos, especificando quais comandos executar e em quais estágios do processo executá-los.

A relação entre esses componentes é mostrada abaixo:<br/>
<img src="https://gssachdeva.files.wordpress.com/2015/09/commandpattern.jpg"/>

Vamos ver um exemplo concreto do padrão de Command e após isso ver como ele é melhorado com expressões lambda.

### Implementação orientadas a objetos
Suponha que tenhamos um editor de texto que tenha acões como abrir, salvar e fechar um arquivo, a implementação do Pattern Command neste cenário seria da seguinte forma:<br/>

#### Componente Command
Nosso componente Command seria estruturado da seguinte forma:<br/>
Interface Command:
```java
public interface Command {

    void execute();

}

```

Classes com a implementação concreta de cada command baseadas em um Receiver:
```java
public class OpenCommand implements Command {

    ReceiverInterface receiver;

    public OpenCommand(ReceiverInterface receiver){
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.open();
    }
}
```

```java
public class CloseCommand implements Command {

    ReceiverInterface receiver;

    public CloseCommand(ReceiverInterface receiver){
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.close();
    }
}
```

```java
public class SaveCommand implements Command {

    ReceiverInterface receiver;

    public SaveCommand(ReceiverInterface receiver){
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.save();
    }
}
```

#### Componente Receiver
Nosso componente Receiver seria estruturado da seguinte forma:<br/>
Interface Receiver:
```java
public interface ReceiverInterface {

    void open();
    void close();
    void save();

}
```

Classe com a implementação concreta de todos os métodos da interface Receiver:
```java
public class ReceiverImplementation implements ReceiverInterface {


    @Override
    public void open() {
        System.out.println("Comando open executado com sucesso!");
    }

    @Override
    public void close() {
        System.out.println("Comando close executado com sucesso!");
    }

    @Override
    public void save() {
        System.out.println("Comando save executado com sucesso!");
    }
}
```

#### Componente Invoker
Nosso componente Invoker seria estruturado da seguinte forma:<br/>
Classe Invoker:
```java
import java.util.ArrayList;
import java.util.List;

public class Invoker {

    List<Command> commands;

    public Invoker(){
        commands = new ArrayList<>();
    }

    public void record(Command command){
        commands.add(command);
    }

    public void run(){
        for(Command command : commands){
            command.execute();
        }
    }

}
```

#### Componente Client
Nosso componente Client seria implementado da seguinte forma:<br/>
```java
public class Client {

    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        ReceiverImplementation receiverImplementation = new ReceiverImplementation();
        invoker.record(new OpenCommand(receiverImplementation));
        invoker.record(new CloseCommand(receiverImplementation));
        invoker.record(new SaveCommand(receiverImplementation));
        invoker.run();
    }

}
```

Esta seria a forma de se implementar este Pattern antes da programação funcional.


### Implementação Funcional
Vimos acima como era feita a implemetanção do Pattern Command antes da programação funcional do Java 8, veremos aqui como melhorar essa implementação de forma a simplificar a mesma com o uso de Lambdas e Method Reference.<br/>
Como nossa interface Command pode ser considerada uma interface funcional podemos passar para nosso Invoker expressões Lambda, reduzindo assim a quantia de código e removendo também as classes de implementação concreta dos commands.

Nossa estrutura com a programação funcional seria a seguinte:
 
#### Componente Command
Nosso componente Command seria estruturado apenas com a Interface Command:<br/>
```java
public interface Command {

    void execute();

}

```

Como vimos não é mais necessários criar as classes de implementação concreta dos comandos baseadas em um Receiver.


#### Componente Receiver
Nosso componente Receiver seria estruturado da mesma de antes:<br/>
Interface Receiver:
```java
public interface ReceiverInterface {

    void open();
    void close();
    void save();

}
```

Classe com a implementação concreta de todos os métodos da interface Receiver:
```java
public class ReceiverImplementation implements ReceiverInterface {


    @Override
    public void open() {
        System.out.println("Comando open executado com sucesso!");
    }

    @Override
    public void close() {
        System.out.println("Comando close executado com sucesso!");
    }

    @Override
    public void save() {
        System.out.println("Comando save executado com sucesso!");
    }
}
```

#### Componente Invoker
Nosso componente Invoker seria estruturado da mesma forma de antes:<br/>
Classe Invoker:
```java
import java.util.ArrayList;
import java.util.List;

public class Invoker {

    List<Command> commands;

    public Invoker(){
        commands = new ArrayList<>();
    }

    public void record(Command command){
        commands.add(command);
    }

    public void run(){
        for(Command command : commands){
            command.execute();
        }
    }

}
```

#### Componente Client
Nosso componente Client poderia ser implementado de duas formas:
 * Utilizando Lambdas
 * Utilizando Method Reference
 
No código abaixo vemos como essas duas formas podem ser implementadas:
```java
public class Client {

    public static void usoComLambdas(){
        Invoker invoker = new Invoker();
        ReceiverImplementation receiverImplementation = new ReceiverImplementation();
        invoker.record(() -> receiverImplementation.open());
        invoker.record(() -> receiverImplementation.close());
        invoker.record(() -> receiverImplementation.save());
        invoker.run();
    }

    public static void usoComMethodReference(){
        Invoker invoker = new Invoker();
        ReceiverImplementation receiverImplementation = new ReceiverImplementation();
        invoker.record(receiverImplementation::open);
        invoker.record(receiverImplementation::close);
        invoker.record(receiverImplementation::save);
        invoker.run();
    }

    public static void main(String[] args) {
        usoComLambdas();
        System.out.println("------------------------------------");
        usoComMethodReference();
    }

}
```

### Exercício
Seu objetivo nesse exercício é a melhoria de um código existente que aplica o Pattern Command, você deverá aplicar os recursos da programação funcional abordados nesse laboratório para melhoria do código existente.<br/>
Você encontrará o código deste exercício neste [link](./exercicio) 
