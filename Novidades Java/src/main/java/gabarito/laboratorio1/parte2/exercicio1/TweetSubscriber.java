package gabarito.laboratorio1.parte2.exercicio1;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class TweetSubscriber implements Subscriber<Tweet> {

    private Subscription subscription;

    private int counter = 0;

    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("Verificando o que há de novo!");
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(Tweet tweet) {
        System.out.println(String.format("O usuário %s acabou de Tweetar: %s", tweet.getUsuario(), tweet.getTextoTweet()));
        counter++;
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Isso é tudo por hoje!");
    }

    public int getCounter() {
        return counter;
    }

}
