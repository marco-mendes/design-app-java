package laboratorio1.exercicios.exercicio5;

public class ProjetoApiClient {

    private final BackEndDeveloper backEndDeveloper;
    private final FrontEndDeveloper frontEndDeveloper;

    public ProjetoApiClient() {
        this.backEndDeveloper = new BackEndDeveloper();
        this.frontEndDeveloper = new FrontEndDeveloper();
    }

    public void implementar() {
        this.backEndDeveloper.writeAPI();
        this.frontEndDeveloper.writeClientConsumer();
    }

    public static void main(String[] args) {
        ProjetoApiClient projeto = new ProjetoApiClient();
        projeto.implementar();
    }

}
