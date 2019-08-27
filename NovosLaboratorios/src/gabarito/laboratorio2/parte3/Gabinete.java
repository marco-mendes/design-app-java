package gabarito.laboratorio2.parte3;

public class Gabinete implements PrototypeCapable {

    public Gabinete() {}

    @Override
    public PrototypeCapable clone() throws CloneNotSupportedException {
        System.out.println("Clonando Objeto Gabinete");
        return (Gabinete) super.clone();
    }

    @Override
    public String toString() {
        return "Gabinete";
    }
}
