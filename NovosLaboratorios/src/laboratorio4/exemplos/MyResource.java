package laboratorio4.exemplos;

public class MyResource implements AutoCloseable {

    public void teste() throws Exception {
        System.out.println("Recurso personalizado para try-with-resouce sendo utilizado!");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Executando método close do recurso personalizado!");
    }
}