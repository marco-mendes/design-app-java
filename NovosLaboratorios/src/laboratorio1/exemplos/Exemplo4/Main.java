package laboratorio1.exemplos.Exemplo4;

public class Main {

    public static void fazerBarunho(Animal animal) {
        animal.facaBarulho();
    }

    public static void main(String[] args) {
        Cachorro cachorro = new Cachorro();
        fazerBarunho(cachorro);
    }

}
