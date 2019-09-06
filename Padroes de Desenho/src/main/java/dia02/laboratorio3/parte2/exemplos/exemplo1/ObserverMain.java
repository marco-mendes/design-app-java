package dia02.laboratorio3.parte2.exemplos.exemplo1;

public class ObserverMain {

    public static void main(String[] args) {
        Post postagem = new Post();
        postagem.registerObserver(new AreaContabilidade());
        postagem.registerObserver(new AreaRH());
        postagem.registerObserver(new AreaTI());

        postagem.notifyObservers("Postagem sobre contabilidade");
        postagem.notifyObservers("Postagem sobre rh");
        postagem.notifyObservers("Postagem sobre devops");
    }

}
