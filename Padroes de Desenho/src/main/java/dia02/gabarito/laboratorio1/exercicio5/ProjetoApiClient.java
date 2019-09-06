package dia02.gabarito.laboratorio1.exercicio5;

public class ProjetoApiClient {

    private final BackEndDeveloper backEndDeveloper;
    private final FrontEndDeveloper frontEndDeveloper;

    public ProjetoApiClient(BackEndDeveloper backEndDeveloper, FrontEndDeveloper frontEndDeveloper) {
        this.backEndDeveloper = backEndDeveloper;
        this.frontEndDeveloper = frontEndDeveloper;
    }

    public void implementar() {
        this.backEndDeveloper.writeAPI();
        this.frontEndDeveloper.writeClientConsumer();
    }

    public static void main(String[] args) {
        ProjetoApiClient teste = new ProjetoApiClient(new BackEndDeveloper(), new FrontEndDeveloper());
        teste.implementar();
    }

}
