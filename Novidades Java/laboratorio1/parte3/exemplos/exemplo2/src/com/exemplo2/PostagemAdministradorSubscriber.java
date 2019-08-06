package com.exemplo2;

import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.Flow.Subscriber;

public class PostagemAdministradorSubscriber implements Subscriber<PostagemAdministrador> {

    private Subscription subscription;

    private int counter = 0;

    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("Inscrito em PostagemAdministrador!");
        this.subscription = subscription;
        this.subscription.request(1);
        System.out.println("onSubscribe requisitou 1 item de PostagemAdministrador");
    }

    @Override
    public void onNext(PostagemAdministrador postagem) {
        System.out.println("Nova Postagem de Administrador recebida!");
        System.out.println(
                String.format("Administrador: %s Título: %s, Palavras Chave: %s", postagem.getNomeAdministrador(), postagem.getTitulo(), postagem.getPalavrasChave())
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
        System.out.println("Finalizando inscrição em Postagem Administrador!");
    }

    public int getCounter() {
        return counter;
    }

}