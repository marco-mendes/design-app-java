package gabarito.laboratorio7.parte4;

public interface Subject {

    void registerObserver(Observer o);
    void notifyObservers(NetflixContent conteudo);

}