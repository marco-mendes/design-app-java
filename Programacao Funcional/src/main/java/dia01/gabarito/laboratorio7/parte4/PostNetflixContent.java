package dia01.gabarito.laboratorio7.parte4;

import java.util.ArrayList;
import java.util.List;

public class PostNetflixContent implements Subject {

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void notifyObservers(NetflixContent conteudo) {
        for(Observer observer : this.observers){
            observer.postContent(conteudo);
        }
    }

}
