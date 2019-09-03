package laboratorio2.exemplos.exemplo2;

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
