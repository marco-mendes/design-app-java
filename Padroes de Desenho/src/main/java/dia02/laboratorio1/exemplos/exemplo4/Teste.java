package dia02.laboratorio1.exemplos.exemplo4;

public class Teste {

    static void verifica(Retangulo r) {
        r.inserirLargura(5);
        r.inserirAltura(4);
        assert(r.altura * r.largura == 20);  // Falha se passamos um objeto quadrado como parametro!!!
    }

    public static void main(String[] args) {
        verifica(new Retangulo());
    }

}
