package laboratorio2.exemplos.exemplo2;

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
