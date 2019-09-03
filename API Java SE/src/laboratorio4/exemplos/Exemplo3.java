package laboratorio4.exemplos;

public class Exemplo3 {

    public static void main(String[] args) {
        try(MyResource myResource = new MyResource()) {

            myResource.teste();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
