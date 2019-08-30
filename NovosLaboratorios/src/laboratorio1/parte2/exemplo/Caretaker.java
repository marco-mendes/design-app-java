package laboratorio1.parte2.exemplo;

import java.util.HashMap;
import java.util.Map;

public class Caretaker {

    private Map<String, WordDocumentMemento> mementoList = new HashMap();

    public void saveMemento(String savePointName, WordDocumentMemento state) {
        this.mementoList.put(savePointName, state);
    }

    public WordDocumentMemento getMemento(String savePointName) {
        return this.mementoList.get(savePointName);
    }

    public void clearSavePoints() {
        System.out.println("Limpando todos os estados salvos!");
        this.mementoList.clear();
    }

}
