package laboratorio2.exemplos.exemplo1;

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
