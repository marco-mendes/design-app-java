## Introdução à Fluxos Reativos(Reactive Streams)

### Material de preparação
[O que são Reactive Streams](https://www.reactive-streams.org/) <br/>
[Usando Reactive Streams](https://www.journaldev.com/20723/java-9-reactive-streams)
[Mais exemplos de uso](https://www.concretepage.com/java/java-9/java-reactive-streams)

### Introdução

Reactive Streams é um padrão para processamento de fluxo assíncrono com retorno não-bloqueante, este recurso foi introduzido no Java 9 através da API 
**java.util.concurrent.Flow**, no qual suas classes e interfaces principais são explicadas no material de preparação.<br/>

No Java um Reactive Stream é composto por um **Publisher** e um **Subscriber**.<br/>
O **Publisher** é responsável por receber dados e notificar a todos os seus inscritos sobre a existência desses novos dados.<br/>
O **Subscriber** é cadastrado em um **Publisher** e aguarda a notificação de novos dados para que o mesmo possa realizar um processamento sobre eles.<br/>
As vezes é necessário também um **Processor** que é um componente responsável por transformar os dados recebidos do **Publisher** para que o **Subscriber** consiga entendê-los.<br/>



### Implementação básica de uso
Suponhamos que possuímos uma classe chamada **Postagem** que será usada para criar um fluxo de mensagens que serão enviadas do Publisher para o Subscriber, com Reactive Streams poderíamos implementar esse comportamento da seguinte forma:

#### Estrutura da classe Postagem
```java
import java.util.ArrayList;
import java.util.List;

public class Postagem {

    private String titulo;
    private String conteudo;
    private List<String> palavrasChave = new ArrayList<>();

    public Postagem(String titulo, String conteudo, List<String> palavrasChave) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.palavrasChave = palavrasChave;
    }

    public Postagem(String titulo, String conteudo) {
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public List<String> getPalavrasChave() {
        return palavrasChave;
    }

    public void adicionarPalavraChave(String novaPalavraChave) {
        palavrasChave.add(novaPalavraChave);
    }

}
```



#### Criando uma implementação concreta de um Subscriber

```java
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class PostagemSubscriber implements Subscriber<Postagem> {

    private Subscription subscription;

    private int counter = 0;

    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("Inscrito!");
        this.subscription = subscription;
        this.subscription.request(1);
        System.out.println("onSubscribe requisitou 1 item");
    }

    @Override
    public void onNext(Postagem postagem) {
        System.out.println("Nova postagem recebida!");
        System.out.println(String.format("Título: %s, Palavras Chave: %s", postagem.getTitulo(), postagem.getPalavrasChave()));
        counter++;
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Finalizando inscrição!");
    }

    public int getCounter() {
        return counter;
    }

}
```

Um **Subscriber** deve implementar a interface **Subscriber** e sobrescrever seus métodos **onSubscribe**, **onNext**, **onError** e **onComplete**.<br/>
O funcionamento de todos foi abordado no material de preparação.<br/>
Adicionamos também a variável **counter** para nos auxiliar na lógica que irá verificar se os dados recebidos já foram processados.


#### Criando um Publisher

```java
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SubmissionPublisher;

public class ReactiveStreamsApp {

    public static List<Postagem> obtemPostagens() {

        Postagem post1 = new Postagem("Postagem Meio Ambiente", "Alguma coisa sobre meio ambiente");
        post1.adicionarPalavraChave("Meio Ambiente");

        Postagem post2 = new Postagem("Postagem Tecnologia", "Alguma coisa sobre tecnologia");
        post2.adicionarPalavraChave("Tecnologia");

        List<Postagem> postagens = new ArrayList<>();
        postagens.add(post1);
        postagens.add(post2);

        return postagens;
    }
    
    public static void main(String[] args) throws InterruptedException {
        SubmissionPublisher<Postagem> publisher = new SubmissionPublisher<>();
        PostagemSubscriber postagemSubscriber = new PostagemSubscriber();
        publisher.subscribe(postagemSubscriber);
        List<Postagem> postagens = obtemPostagens();
        postagens.stream().forEach(p -> publisher.submit(p));

        while (postagens.size() != postagemSubscriber.getCounter()) {
            Thread.sleep(10);
        }

        publisher.close();

    }
    
}
```

No exemplo acima criamos um **Publisher** utilizando a classe **SubmissionPublisher** da **API Flow** e cadastramos nossa implementação concreta de Subscriber na mesma.

Após isso utilizamos o método **submit** do **Publisher** para notificar à nossa classe **PostagemSubscriber** sobre a existência de novos dados.<br/>
Adicionamos também uma lógica para o método main aguardar o fim de nosso processamento e após isso finalizamos nosso **Publisher** com o método **close**.

Uma observação importante: se não possuirmos uma lógica para o método main aguardar o processamento dos itens obteremos resultados indesejados pois o processamento dos dados 
é feito de forma assíncrona e o mesmo não bloqueia o funcionamento da Thread main enquanto os dados estão sendo processados.

#### Exercício 1
Suponhamos que possuímos uma classe chamada **Tweet**, a mesma irá simular os Tweets de usuários do Twitter, com base nela crie uma implementação simples de Reactive Streams
utilizando o que foi explicado até agora.

No Subscriber da classe Tweet realize as seguintes operações adicionais:
 * Nome método **onSubscribe** imprima a seguinte mensagem: "Verificando o que há de novo!"
 * No método **onNext** imprima a seguinte mensagem: "O usuário NOME_USUARIO acabou de Tweetar: TEXTO_DO_TWEET".
 * No método **onComplete** imprima a seguinte mensagem: "Isso é tudo por hoje!"
 * Considere **NOME_USUARIO** como sendo o atributo **usuario** da Classe **Tweet**.
 * Considere **TEXTO_DO_TWEET** como sendo o atributo **textoTweet** da Classe **Tweet**.
 * Utilize o método **obtemListaFicticiaTweets()** para obter as lista de Tweets que o **Publisher** deve enviar ao seu **Subscriber** através do método **submit()** 
 do **Publisher**;

Código base para este exercício:
```java
import java.util.Arrays;
import java.util.List;

public class Tweet {

    private String usuario;
    private String textoTweet;

    public Tweet(String usuario, String textoTweet) {
        this.usuario = usuario;
        this.textoTweet = textoTweet;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getTextoTweet() {
        return textoTweet;
    }

    public static List<Tweet> obtemListaFicticiaTweets() {
        return Arrays.asList(
                new Tweet("Chica da Silva", "Boa tarde a todos."),
                new Tweet("José Carlos", "Ótima reportagem, abordaram bem o problema."),
                new Tweet("Carlos Silva", "Ótimo dia a todos.")
        );
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "usuario='" + usuario + '\'' +
                ", textoTweet='" + textoTweet + '\'' +
                '}';
    }
}
``` 

### Implementação de uso com Processor
Um processor é utilizado para transformar um objeto de um tipo para outro tipo de forma que o subscriber consiga entender e trabalhar em cima do 
objeto recebido por ele.<br/>
Para implementar um **Processor** possuímos alguns componentes em comum com uma implementação simples, são eles:
 * Uma classe de um objeto base
 * Uma classe **Subscriber**
 * E a implementação de um **Publisher** para enviar os dados ao subscriber
 
Em um **Processor** além dos componentes citados acima possuímos também:
 * Uma nova classe que será o resultado final da conversão.
 * Uma classe com a implementação de um Processor que será responsável pela conversão dos objetos de um tipo para outro.
 

#### Estrutura da classe base Postagem
Utilizaremos a classe Postagem do primeiro exemplo para este exemplo, relembrando a estrutura da mesma:
```java
import java.util.ArrayList;
import java.util.List;

public class Postagem {

    private String titulo;
    private String conteudo;
    private List<String> palavrasChave = new ArrayList<>();

    public Postagem(String titulo, String conteudo, List<String> palavrasChave) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.palavrasChave = palavrasChave;
    }

    public Postagem(String titulo, String conteudo) {
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public List<String> getPalavrasChave() {
        return palavrasChave;
    }

    public void adicionarPalavraChave(String novaPalavraChave) {
        palavrasChave.add(novaPalavraChave);
    }

}
```

#### Estrutura da classe alvo PostagemTwitter no qual o objeto Postagem será convertido
```java
import java.util.ArrayList;
import java.util.List;

public class PostagemTwitter {

    private String conteudo;
    private List<String> hashTags = new ArrayList<>();

    public PostagemTwitter(String conteudo) {
        this.conteudo = conteudo;
    }

    public PostagemTwitter(String conteudo, List<String> hashTags) {
        this.conteudo = conteudo;
        this.hashTags = hashTags;
    }

    public String getConteudo() {
        return conteudo;
    }

    public List<String> getHashTags() {
        return hashTags;
    }

    public void adicionarHashTag(String hashTag) {
        this.hashTags.add(hashTag);
    }

}
```
Nessa classe a propriedade conteudo terá o mesmo valor da propriedade conteudo da classe Postagem.<br/>
O atributo hashTags terá o mesmo valor da propriedade palavrasChave da classe Postagem.<br/>
Com base nisso saberemos como mapear os valores nos campos corretos durante a conversão dos objetos.

#### Implementação concreta do Subscriber
A implementação concreta do subscriber deve ser feita com base na classe alvo da conversão, em nosso caso a mesma será criada com base na classe PostagemTwitter.

```java
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.Flow.Subscriber;

public class PostagemTwitterSubscriber implements Subscriber<PostagemTwitter> {

    private Subscription subscription;

    private int counter = 0;

    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("Inscrito em PostagemTwitter!");
        this.subscription = subscription;
        this.subscription.request(1);
        System.out.println("onSubscribe requisitou 1 item de PostagemTwitter");
    }

    @Override
    public void onNext(PostagemTwitter postagem) {
        System.out.println("Nova Postagem do Twitter recebida!");
        System.out.println(
                String.format("Conteúdo: %s, HashTags: %s", postagem.getConteudo(), postagem.getHashTags())
        );
        counter++;
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Finalizando inscrição em Postagem Twitter!");
    }

    public int getCounter() {
        return counter;
    }


```

#### Estruturando a implementação concreta do Processor
```java
import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

public class MyProcessor extends SubmissionPublisher<PostagemTwitter> implements Processor<Postagem, PostagemTwitter> {

    private Subscription subscription;
    private Function<Postagem, PostagemTwitter> conversorPostagemParaPostagemTwitter;

    public MyProcessor(Function<Postagem, PostagemTwitter> conversor) {
        super();
        this.conversorPostagemParaPostagemTwitter = conversor;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(Postagem postagem) {
        submit((PostagemTwitter) conversorPostagemParaPostagemTwitter.apply(postagem));
        subscription.request(1);
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Feito");
    }
}
```
Nessa classe implementamos a interface **Processor**, a mesma extende a classe Subscriber sendo necessário sobrescrever os métodos 
**onSubscribe**, **onNext**, **onError** e **onComplete**.<br/>
A Function **conversorPostagemParaPostagemTwitter** será usada para realizar a tarefa de converter um objeto do tipo **Postagem** para 
**PostagemTwitter** de acordo com a expressão Lambda recebida no construtor da classe.<br/>
Dentro do método **onNext** realizamos a conversão do objeto e em seguida usamos o método **submit** do **SubmissionPublisher** para enviar o objeto ao **Subscriber**.


#### Criando o Publisher
```java
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SubmissionPublisher;

public class ReactiveStreamProcessorApp {

    public static List<Postagem> obtemPostagens() {

        Postagem post1 = new Postagem("Postagem Meio Ambiente", "Alguma coisa sobre meio ambiente");
        post1.adicionarPalavraChave("Meio Ambiente");

        Postagem post2 = new Postagem("Postagem Tecnologia", "Alguma coisa sobre tecnologia");
        post2.adicionarPalavraChave("Tecnologia");

        List<Postagem> postagens = new ArrayList<>();
        postagens.add(post1);
        postagens.add(post2);

        return postagens;
    }

    public static void main(String[] args) throws InterruptedException {
        // Criando o publisher
        SubmissionPublisher<Postagem> publisher = new SubmissionPublisher<>();

        // Criando o processador que irá realizar a conversão dos objetos e atribuindo ao seu construtor a expressão Lambda responsável pela conversão dos objetos
        MyProcessor transformProcessor = new MyProcessor(p -> {
            return new PostagemTwitter(p.getConteudo(), p.getPalavrasChave());
        });

        // Criando o Subscriber do objeto PostagemTwitter
        PostagemTwitterSubscriber subscriber = new PostagemTwitterSubscriber();

        // Publisher para processor
        publisher.subscribe(transformProcessor);

        // Processor para subscriber
        transformProcessor.subscribe(subscriber);

        // Publicando itens
        List<Postagem> postagens = obtemPostagens();
        postagens.stream().forEach(p -> publisher.submit(p));

        // Lógica para aguardar o processamento ser concluído.
        while(postagens.size() != subscriber.getCounter()) {
            Thread.sleep(10);
        }

        // Finalizando os objetos Publisher e Processor.
        publisher.close();
        transformProcessor.close();

    }

}
```
Leia os comentários do Publisher para compreender o funcionamento corretamente.

#### Exercício 2
O código base para este exercício está contido neste [link](./exercicio/exercicio2/) e sua estrutura é a seguinte:<br/>
<img src="./exercicio/EstruturaProjetoExercicio2.PNG"/>

Neste exercício os objetos da classe **Artigo** devem ser convertidos para objetos do tipo **ArtigoCientifico** utilizando um Processor de forma que nosso 
**ArtigoCientificoSubscriber** consiga interpretar os objetos do tipo **Artigo** enviados a ele através de um **Publisher**.<br/>
As propriedades **id**, **titulo** e **conteudo** da classe **Artigo** correspondem aos parâmetros **id**, **titulo** e **conteudo** da classe **ArtigoCientifico** respectivamente.<br/>
Utilize o método **obtemArtigos()** da classe **Artigo** para obter as lista de Artigos que o **Publisher** deve enviar ao seu **Subscriber** através do método **submit()**.


### Parando de receber mensagens em um Subscriber
Caso seja necessário existe a possibilidade de parar de receber mensagens em um subscriber, basta utilizar o método **cancel** do objeto **Subscription** dentro da 
implementação concreta de um Subscriber.<br/>
Um exemplo seria parar de receber mensagens em caso de erro como no trecho de código abaixo:
```java
    @Override
    public void onError(Throwable e) {
        this.subscription.cancel();
        e.printStackTrace();
    }
```
