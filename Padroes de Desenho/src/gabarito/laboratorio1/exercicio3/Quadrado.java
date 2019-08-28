package gabarito.laboratorio1.exercicio3;

public class Quadrado implements Shape {

    private double altura;
    private double largura;

    public void inserirAltura(double altura)
    {
        this.altura = altura;
        this.largura = altura;
    }

    public void inserirLargura(double largura)
    {
        this.largura = largura;
        this.altura = largura;
    }

    @Override
    public void desenhar() throws Exception {
        if(this.altura == this.largura) {
            System.out.println("Desenhando Quadrado");
        } else {
            throw new Exception("Os dois lados do quadrado precisam ser iguais");
        }
    }
}
