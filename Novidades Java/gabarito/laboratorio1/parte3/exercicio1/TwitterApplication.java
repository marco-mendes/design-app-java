package gabarito.laboratorio1.parte3.exercicio1;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;

public class TwitterApplication {

    public static void main(String[] args) throws InterruptedException {
        SubmissionPublisher<Tweet> publisher = new SubmissionPublisher<>();
        TweetSubscriber tweetSubscriber = new TweetSubscriber();
        publisher.subscribe(tweetSubscriber);

        List<Tweet> listaTweets = Tweet.obtemListaFicticiaTweets();
        listaTweets.stream().forEach(t -> publisher.submit(t));

        while (listaTweets.size() != tweetSubscriber.getCounter()) {
            Thread.sleep(10);
        }

        publisher.close();

    }

}
