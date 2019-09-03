package laboratorio2.exercicio.exercicio2;

import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.Flow.Subscriber;

public class ArtigoCientificoSubscriber implements Subscriber<ArtigoCientifico> {

    private Subscription subscription;

    private int counter = 0;

    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("Inscrito em Artigo Cientifico!");
        this.subscription = subscription;
        this.subscription.request(1);
        System.out.println("onSubscribe requisitou 1 item de Artigo Cientifico");
    }

    @Override
    public void onNext(ArtigoCientifico artigo) {
        System.out.println("Novo Artigo Cientifico recebido!");
        System.out.println(
                String.format("ID: %s, Título: %s, Conteúdo: %s", artigo.getId(), artigo.getTitulo(), artigo.getConteudo())
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
        System.out.println("Finalizando inscrição em Artigo Cientifico!");
    }

    public int getCounter() {
        return counter;
    }

}
