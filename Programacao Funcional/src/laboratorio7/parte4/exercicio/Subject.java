package laboratorio7.parte4.exercicio;

public interface Subject {

    void registerObserver(Observer o);
    void notifyObservers(NetflixContent conteudo);

}