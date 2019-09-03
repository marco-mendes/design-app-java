package laboratorio2.exemplos.exemplo2;

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

}