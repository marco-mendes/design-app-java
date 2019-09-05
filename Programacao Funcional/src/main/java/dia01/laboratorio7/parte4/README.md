## Design Pattern Observer utilizando programação funcional

### Material de preparação
[Pattern Observer com e sem programação funcional](https://www.sourcecodeexamples.net/2018/05/refactoring-observer-design-pattern.html)

### Visão geral do Pattern Observer
O padrão projeto Observer é uma solução comum quando um objeto precisa notificar automaticamente uma lista de outros objetos (chamados de observadores) quando algum evento acontece 
(por exemplo, uma mudança de estado).<br/>
Os principais componentes desse Pattern são:
 * **Observer**: Define uma interface de atualização para objetos que devem ser notificados sobre alterações em um Subject.
 * **ConcreteObserver**: Uma ou mais classes que implementam a interface Observer para receber notificações do Subject.
 * **Subject**: Uma interface para adicionar e notificar objetos Observer.
 * **ConcreteSubject**: Armazena o estado de um objeto ConcreteObserver e envia notificações aos Observers se o estado do mesmo mudar.

Vamos ver um exemplo concreto do padrão de Observer e após isso ver como ele é melhorado com os recursos da programação funcional.

### Implementação orientadas a objetos
Suponhamos que queremos criar um Observer para receber notificações de um blog e notificar para algumas áreas de uma empresa se um post é interessante para aquelas áreas através de algumas palavras chave.<br/>
Podemos fazer isso dessa forma:

#### Implementação Observer
Nosso componente Observer poderia ser implementado da seguinte forma:
```java
public interface Observer {

    void post(String postagem);

}
```

#### Implementação ConcreteObserver
Abaixo alguns exemplos de implementação do componente ConcreteObserver
```java
public class AreaContabilidade implements Observer {
    @Override
    public void post(String postagem) {
        if(postagem != null && (postagem.contains("contabilidade") || postagem.contains("contábil"))){
            System.out.println("Notificando área de Contabilidade!");
        }
    }
}
```

```java
public class AreaRH implements Observer {
    @Override
    public void post(String postagem) {
        if(postagem != null && (postagem.contains("gestão") || postagem.contains("rh"))){
            System.out.println("Notificando área de RH!");
        }
    }
}
```

```java
public class AreaTI implements Observer {
    @Override
    public void post(String postagem) {
        if(postagem != null && (postagem.contains("devops") || postagem.contains("infraestrutura"))){
            System.out.println("Notificando área de TI!");
        }
    }
}
```

#### Implementação Subject
Nosso componente Subject poderia ser implementado da seguinte forma:
```java
public interface Subject {

    void registerObserver(Observer o);
    void notifyObservers(String postagem);

}
```

#### Implementação ConcreteSubject
Nosso componente ConcreteSubject poderia ser implementado da seguinte forma:
```java
import java.util.ArrayList;
import java.util.List;

public class Post implements Subject {

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void notifyObservers(String postagem) {
        for(Observer observer : this.observers){
            observer.post(postagem);
        }
    }
}
```

#### Utilizando nosso Observer
Exemplo de utilização do mesmo:
```java
public class ObserverMain {

    public static void main(String[] args) {
        Post postagem = new Post();
        postagem.registerObserver(new AreaContabilidade());
        postagem.registerObserver(new AreaRH());
        postagem.registerObserver(new AreaTI());
        
        postagem.notifyObservers("Postagem sobre contabilidade");
        postagem.notifyObservers("Postagem sobre rh");
        postagem.notifyObservers("Postagem sobre devops");
    }

}
```

### Implementação Funcional
Vimos acima como era feita a implementanção do Pattern Observer antes da programação funcional do Java 8, 
veremos aqui como melhorar essa implementação com o uso dos recursos da programação funcional.<br/>

Utilizando a programação funcional nossos componenetes **Observer**, **Subject** e **ConcreteSubject** não sofrem modificações.<br/>
Já nossas classes **ConcreteObserver** não tem mais utilizade pois podemos substituí-las facilmente por expressões Lambda durante o registro dos Observers no **ConcreteSubject**.<br/>

#### Utilizando nosso Observer
Exemplo de utilização do mesmo com a programação funcional:
```java
public class ObserverMain {

    public static void main(String[] args) {
        Post postagemBlog = new Post();
        
        postagemBlog.registerObserver((String post) -> {
            if(post != null && (post.contains("contabilidade") || post.contains("contábil"))){
                System.out.println("Notificando área de Contabilidade!");
            }
        });

        postagemBlog.registerObserver((String post) -> {
            if(post != null && (post.contains("gestão") || post.contains("rh"))){
                System.out.println("Notificando área de RH!");
            }
        });

        postagemBlog.registerObserver((String post) -> {
            if(post != null && (post.contains("devops") || post.contains("infraestrutura"))){
                System.out.println("Notificando área de TI!");
            }
        });

        postagemBlog.notifyObservers("Postagem sobre contabilidade");
        postagemBlog.notifyObservers("Postagem sobre rh");
        postagemBlog.notifyObservers("Postagem sobre devops");

    }

}
```

No exemplo acima substituímos as classes **ConcreteObserver** por expressões Lambda durante a invocação do método **registerObserver**.
### Exercício
Seu objetivo nesse exercício é a melhoria de um código existente que aplica o Pattern Observer, você deverá aplicar os recursos da programação funcional abordados nesse laboratório para melhoria do código existente.<br/>
Você encontrará o código deste exercício neste [link](./exercicio)