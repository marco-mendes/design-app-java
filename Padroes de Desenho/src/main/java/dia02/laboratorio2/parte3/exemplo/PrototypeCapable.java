package dia02.laboratorio2.parte3.exemplo;

public interface PrototypeCapable extends Cloneable {
    public PrototypeCapable clone() throws CloneNotSupportedException;
}