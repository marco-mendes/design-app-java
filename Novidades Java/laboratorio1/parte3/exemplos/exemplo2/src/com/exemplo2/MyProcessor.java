package com.exemplo2;

import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

public class MyProcessor extends SubmissionPublisher<PostagemAdministrador> implements Processor<Postagem, PostagemAdministrador> {

    private Subscription subscription;
    private Function<Postagem, PostagemAdministrador> conversorPostagemParaPostagemAdministrador;

    public MyProcessor(Function<Postagem, PostagemAdministrador> conversor) {
        super();
        this.conversorPostagemParaPostagemAdministrador = conversor;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(Postagem postagem) {
        submit((PostagemAdministrador) conversorPostagemParaPostagemAdministrador.apply(postagem));
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
