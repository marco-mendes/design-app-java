package laboratorio3.parte2.exemplos.exemplo1;

public interface Subject {

    void registerObserver(Observer o);
    void notifyObservers(String postagem);

}
