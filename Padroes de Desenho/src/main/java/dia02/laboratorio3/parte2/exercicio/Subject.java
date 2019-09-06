package dia02.laboratorio3.parte2.exercicio;

public interface Subject {

    void registerObserver(Observer o);
    void notifyObservers(NetflixContent conteudo);

}