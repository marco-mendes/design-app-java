package dia02.gabarito.laboratorio1.exercicio3;

public class Retangulo  implements Shape {

    private double altura;
    private double largura;

    public void inserirAltura(double altura)
    {
        this.altura = altura;
    }

    public void inserirLargura(double largura)
    {
        this.largura = largura;
    }

    @Override
    public void desenhar() throws Exception {
        System.out.println("Desenhando Retângulo");
    }
}
