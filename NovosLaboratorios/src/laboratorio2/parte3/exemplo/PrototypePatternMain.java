package laboratorio2.parte3.exemplo;

public class PrototypePatternMain {

    public static void main(String[] args) {
        try {
            String livro = PrototypeFactory.getInstance(PrototypeFactory.ModelType.LIVRO).toString();
            System.out.println(livro);

            String jornal = PrototypeFactory.getInstance(PrototypeFactory.ModelType.JORNAL).toString();
            System.out.println(jornal);

            String revista = PrototypeFactory.getInstance(PrototypeFactory.ModelType.REVISTA).toString();
            System.out.println(revista);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }

}
