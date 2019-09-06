package gabarito.laboratorio1.parte2.exercicio2;

import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

public class ArtigoCientificoProcessor extends SubmissionPublisher<ArtigoCientifico> implements Processor<Artigo, ArtigoCientifico> {
    private Subscription subscription;
    private Function<Artigo, ArtigoCientifico> conversorArtigoParaArtigoCientifico;

    public ArtigoCientificoProcessor(Function<Artigo, ArtigoCientifico> conversor) {
        super();
        this.conversorArtigoParaArtigoCientifico = conversor;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(Artigo artigo) {
        submit((ArtigoCientifico) conversorArtigoParaArtigoCientifico.apply(artigo));
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