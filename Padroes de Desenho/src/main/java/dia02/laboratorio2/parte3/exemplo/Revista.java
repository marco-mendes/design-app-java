package dia02.laboratorio2.parte3.exemplo;

public class Revista implements PrototypeCapable {

    public Revista() {}

    @Override
    public Revista clone() throws CloneNotSupportedException {
        System.out.println("Clonando Objeto Revista");
        return (Revista) super.clone();
    }

    @Override
    public String toString() {
        return "Revista";
    }

}
