package laboratorio2.parte3.exemplo;

public class PrototypePatternMain {

    public static void main(String[] args) {
        try {
            Livro livro = (Livro) PrototypeFactory.getInstance(PrototypeFactory.ModelType.LIVRO);
            System.out.println(livro.toString());

            // Clonando Protótipo Livro
            Livro cloneLivro = livro.clone();
            System.out.println(cloneLivro.toString());

            Jornal jornal = (Jornal) PrototypeFactory.getInstance(PrototypeFactory.ModelType.JORNAL);
            System.out.println(jornal.toString());

            // Clonando Protótipo Jornal
            Jornal cloneJornal = jornal.clone();
            System.out.println(jornal.toString());

            Revista revista = (Revista) PrototypeFactory.getInstance(PrototypeFactory.ModelType.REVISTA);
            System.out.println(revista.toString());

            // Clonando Protótipo Revista
            Revista cloneRevista = revista.clone();
            System.out.println(cloneRevista.toString());

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }

}
