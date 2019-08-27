package laboratorio2.parte3.exemplo;

public class Jornal implements PrototypeCapable {

    public Jornal() {}

    @Override
    public Jornal clone() throws CloneNotSupportedException {
        System.out.println("Clonando Objeto Jornal");
        return (Jornal) super.clone();
    }

    @Override
    public String toString() {
        return "Jornal";
    }

}
