package gabarito.laboratorio2.parte3;

public class Monitor implements PrototypeCapable {

    public Monitor() {}

    @Override
    public PrototypeCapable clone() throws CloneNotSupportedException {
        System.out.println("Clonando Objeto Monitor");
        return (Monitor) super.clone();
    }

    @Override
    public String toString() {
        return "Monitor";
    }

}
