package gabarito.laboratorio2.exercicio2;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;

public class Application {

    public static void main(String[] args) throws InterruptedException {
        SubmissionPublisher<Artigo> publisher = new SubmissionPublisher<>();

        ArtigoCientificoProcessor transformProcessor = new ArtigoCientificoProcessor(artigo -> {
            return new ArtigoCientifico(artigo.getId(), artigo.getTitulo(), artigo.getConteudo());
        });

        ArtigoCientificoSubscriber subscriber = new ArtigoCientificoSubscriber();

        publisher.subscribe(transformProcessor);
        transformProcessor.subscribe(subscriber);

        List<Artigo> artigos = Artigo.obtemArtigos();
        artigos.stream().forEach(artigo -> publisher.submit(artigo));

        while(artigos.size() != subscriber.getCounter()) {
            Thread.sleep(10);
        }

        publisher.close();
        transformProcessor.close();

    }

}
