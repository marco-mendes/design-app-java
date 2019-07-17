package laboratorio7.parte4.exemplos.depoisjava8;

import java.util.ArrayList;
import java.util.List;

public class Post implements Subject {

    List<Observer> observers = new ArrayList<>();

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
