package laboratorio2.parte3.exemplo;

import java.util.HashMap;
import java.util.Map;

public class PrototypeFactory {

    public static class ModelType {
        public static final String LIVRO = "livro";
        public static final String REVISTA = "revista";
        public static final String JORNAL = "jornal";
    }

    private static Map<String, PrototypeCapable> prototypes = new HashMap<String, PrototypeCapable>();

    static {
        prototypes.put(ModelType.LIVRO, new Livro());
        prototypes.put(ModelType.REVISTA, new Revista());
        prototypes.put(ModelType.JORNAL, new Jornal());
    }

    public static PrototypeCapable getInstance(final String s) throws CloneNotSupportedException {
        return ((PrototypeCapable) prototypes.get(s).clone());
    }

}
