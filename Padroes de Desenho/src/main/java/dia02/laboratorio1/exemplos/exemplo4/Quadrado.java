package dia02.laboratorio1.exemplos.exemplo4;

public class Quadrado extends Retangulo {
    public void inserirAltura(double altura) {
        this.altura = altura;
        this.largura = altura;
    }

    public void inserirLargura(double largura) {
        this.largura = largura;
        this.altura = largura;
    }
}