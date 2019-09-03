package laboratorio2.exemplos.exemplo1;

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
