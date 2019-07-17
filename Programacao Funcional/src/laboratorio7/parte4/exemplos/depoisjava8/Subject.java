package laboratorio7.parte4.exemplos.depoisjava8;

public interface Subject {

    void registerObserver(Observer o);
    void notifyObservers(String postagem);

}
