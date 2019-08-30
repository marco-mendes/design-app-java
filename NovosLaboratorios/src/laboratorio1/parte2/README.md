## Design Pattern Memento

### Material de preparação
[Pattern Memento](https://howtodoinjava.com/design-patterns/behavioral/memento-design-pattern/)

### Introdução geral ao Pattern Memento
Este Pattern tem por objetivo capturar e externalizar um estado interno de um objeto, de forma que o mesmo possa ser restaurado para este estado posteriormente sem violar 
o encapsulamento do objeto.<br/>

Este Pattern é composto pelos seguintes componentes:
 * Memento: Este componente armazena o estado interno de um objeto Originator, a princípio este componente deve ser objeto imutável para que ninguém possa mudar seu estado 
 depois de criado.
 * Originator: Este componente cria um memento contendo seu estado interno corrente, o mesmo utiliza um outro memento para restaurar seu estado interno capturado pelo memento 
 recebido como parâmetro.
 * CareTaker: Este componente é responsável por armazenar um ou mais mementos com os estados salvos de um Originator.
 
### Problema a ser resolvido
Considere a classe WordDocument abaixo:
```java
public class WordDocument {

    private String criador;
    private String titulo;
    private String conteudo;

    public WordDocument(String criador, String titulo, String conteudo) {
        super();
        this.criador = criador;
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    public String getCriador() {
        return criador;
    }

    public void setCriador(String criador) {
        this.criador = criador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        return "WordDocument{" +
                "criador='" + criador + '\'' +
                ", titulo='" + titulo + '\'' +
                ", conteudo='" + conteudo + '\'' +
                '}';
    }
}
```
Esta classe armazena as informações de um documento do Word e gostaríamos de salvar seu estado interno de forma que seu encapsulamento não seja comprometido e nos permita 
restaurar o objeto para um estado anterior do mesmo.<br/>
Veremos no próximo tópico a resolução deste problema utilizando o Pattern Memento.

### Implementação com o Pattern Memento
Como vimos o Pattern Memento é dividido em 3 componentes, abordaremos a implementação de cada um deles neste tópico.

#### Implementando o componente Memento
Conforme foi abordado acima, em princípio o Memento deveria ser um objeto imutável após sua criação, poderíamos montar o Memento da classe **WordDocument** da seguinte forma:
```java
public final class WordDocumentMemento {

    private final String criador;
    private final String titulo;
    private final String conteudo;

    public WordDocumentMemento(String criador, String titulo, String conteudo) {
        super();
        this.criador = criador;
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    public String getCriador() {
        return criador;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getConteudo() {
        return conteudo;
    }



}
```

Observe que a classe **WordDocumentMemento** foi criada utilizando todos os atributos da classe **WordDocument**, observe também que ela e seus atributos foram criados com 
o modificador de acesso **final**, o objetivo disso é tornar o objeto imutável após sua criação.

#### Implementando o componente Originator
Nosso componente Originator será basicamente nossa clase **WordDocument** com algumas modificações conforme o exemplo abaixo:
```java
public class WordDocument {

    private String criador;
    private String titulo;
    private String conteudo;

    public WordDocument(String criador, String titulo, String conteudo) {
        super();
        this.criador = criador;
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    public String getCriador() {
        return criador;
    }

    public void setCriador(String criador) {
        this.criador = criador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public WordDocumentMemento createMemento() {
        WordDocumentMemento memento = new WordDocumentMemento(criador, titulo, conteudo);
        return memento;
    }

    public void restoreMemento(WordDocumentMemento memento) {
        this.criador = memento.getCriador();
        this.titulo = memento.getTitulo();
        this.conteudo = memento.getConteudo();
    }

    @Override
    public String toString() {
        return "WordDocument{" +
                "criador='" + criador + '\'' +
                ", titulo='" + titulo + '\'' +
                ", conteudo='" + conteudo + '\'' +
                '}';
    }
}
```
Observe que o que difere a classe **WordDocument** atual de sua versão anterior é o fato da mesma possuir dois novos métodos, sendo eles: **createMemento()** e **restoreMemento()**.<br/>
Estes métodos tem por objetivo registrar e restaurar o estado interno da classe **WordDocument** respectivamente.

#### Criando o componente CareTaker
Conforme foi abordado no início deste laboratório, o componente CareTaker é responsável por armazenar nossos Mementos, podemos implementá-lo de forma que o mesmo possa armazenar 
vários estados de um mesmo Memento conforme o exemplo abaixo:
```java
import java.util.HashMap;
import java.util.Map;

public class CareTaker {

    private Map<String, WordDocumentMemento> mementoList = new HashMap();

    public void saveMemento(String savePointName, WordDocumentMemento state) {
        this.mementoList.put(savePointName, state);
    }

    public WordDocumentMemento getMemento(String savePointName) {
        return this.mementoList.get(savePointName);
    }

    public void clearSavePoints() {
        System.out.println("Limpando todos os estados salvos!");
        this.mementoList.clear();
    }

}
```
É importante observar que o CareTaker nunca opera ou examina sobre os conteúdos de um Memento.

#### Testando nossa implementação
Podemos utilizar nosso Memento da seguinte forma:
```java
public class PatternMementoMain {

    public static void main(String[] args) {
        CareTaker careTaker = new CareTaker();
        WordDocument document = new WordDocument("Marcio", "Meu novo documento", "");
        System.out.println(String.format("Estrutura inicial WordDocument: %s", document.toString()));

        document.setTitulo("Savepoint 1");
        document.setConteudo("Dentro do Savepoint 1");
        careTaker.saveMemento("Savepoint 1", document.createMemento());
        System.out.println(String.format("Salvando primeiro estado: %s", document.toString()));

        document.setTitulo("Savepoint 2");
        document.setConteudo("Dentro do Savepoint 2");
        careTaker.saveMemento("Savepoint 2", document.createMemento());
        System.out.println(String.format("Salvando segundo estado: %s", document.toString()));

        document.setTitulo("Savepoint 3");
        document.setConteudo("Dentro do Savepoint 3");
        careTaker.saveMemento("Savepoint 3", document.createMemento());
        System.out.println(String.format("Salvando terceiro estado: %s", document.toString()));

        System.out.println("Restaurando para o primeiro estado!");
        document.restoreMemento(careTaker.getMemento("Savepoint 1"));
        System.out.println(String.format("Estado restaurado para: %s", document));

        System.out.println("Restaurando para o segundo estado!");
        document.restoreMemento(careTaker.getMemento("Savepoint 2"));
        System.out.println(String.format("Estado restaurado para: %s", document));

        System.out.println("Restaurando para o terceiro estado!");
        document.restoreMemento(careTaker.getMemento("Savepoint 3"));
        System.out.println(String.format("Estado restaurado para: %s", document));

    }

}
```
