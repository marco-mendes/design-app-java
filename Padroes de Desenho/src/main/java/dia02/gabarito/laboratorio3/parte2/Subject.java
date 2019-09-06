package dia02.gabarito.laboratorio3.parte2;

public interface Subject {

    void registerObserver(Observer o);
    void notifyObservers(NetflixContent conteudo);

}