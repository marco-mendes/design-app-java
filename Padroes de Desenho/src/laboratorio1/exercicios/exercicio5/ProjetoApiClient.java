package laboratorio1.exercicios.exercicio5;

public class ProjetoApiClient {

    private final BackEndDeveloper backEndDeveloper = new BackEndDeveloper();
    private final FrontEndDeveloper frontEndDeveloper = new FrontEndDeveloper();

    public void implementar() {
        this.backEndDeveloper.writeAPI();
        this.frontEndDeveloper.writeClientConsumer();
    }

}
