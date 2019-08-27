package laboratorio2.parte3.exemplo;

public class Livro implements PrototypeCapable {

    public Livro() {}

    @Override
    public Livro clone() throws CloneNotSupportedException {
        System.out.println("Clonando Objeto Livro");
        return (Livro) super.clone();
    }

    @Override
    public String toString() {
        return "Livro";
    }

}
