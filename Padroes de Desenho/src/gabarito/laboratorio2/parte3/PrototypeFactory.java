package gabarito.laboratorio2.parte3;

import java.util.HashMap;
import java.util.Map;

public class PrototypeFactory {

    public static class ModelType {
        public static final String GABINETE = "gabinete";
        public static final String MONITOR = "monitor";
        public static final String TECLADO = "teclado";
    }

    private static Map<String, PrototypeCapable> prototypes = new HashMap<String, PrototypeCapable>();

    static {
        prototypes.put(ModelType.GABINETE, new Gabinete());
        prototypes.put(ModelType.MONITOR, new Monitor());
        prototypes.put(ModelType.TECLADO, new Teclado());
    }

    public static PrototypeCapable getInstance(final String s) throws CloneNotSupportedException {
        return ((PrototypeCapable) prototypes.get(s).clone());
    }

}
