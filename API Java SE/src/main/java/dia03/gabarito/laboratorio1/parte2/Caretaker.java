package dia03.gabarito.laboratorio1.parte2;

import java.util.HashMap;
import java.util.Map;

public class Caretaker {

    private Map<String, LancamentoDePontosMemento> mementoList = new HashMap<String, LancamentoDePontosMemento>();


    public void saveMemento(String savePointName, LancamentoDePontosMemento state) {
        this.mementoList.put(savePointName, state);
    }

    public LancamentoDePontosMemento getMemento(String savePointName) {
        return this.mementoList.get(savePointName);
    }

    public void clearSavePoints() {
        this.mementoList.clear();
        System.out.println("Os estados salvos foram limpos com sucesso!");
    }

}
