package dia01.laboratorio7.parte4.exemplos.antesjava8;

import java.util.ArrayList;
import java.util.List;

public class Post implements Subject {

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void notifyObservers(String postagem) {
        for(Observer observer : this.observers){
            observer.post(postagem);
        }
    }
}
