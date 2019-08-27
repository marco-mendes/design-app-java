package gabarito.laboratorio2.parte3;

public class Teclado implements PrototypeCapable {

    public Teclado() {}

    @Override
    public PrototypeCapable clone() throws CloneNotSupportedException {
        System.out.println("Clonando Objeto Teclado");
        return (Teclado) super.clone();
    }

    @Override
    public String toString() {
        return "Teclado";
    }

}
