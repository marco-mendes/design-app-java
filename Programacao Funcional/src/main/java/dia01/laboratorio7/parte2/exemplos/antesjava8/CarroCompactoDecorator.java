package dia01.laboratorio7.parte2.exemplos.antesjava8;

public class CarroCompactoDecorator extends CarroDecorator {

    public CarroCompactoDecorator(Carro carro){
        super(carro);
    }

    @Override
    public String describe() {
        return (super.describe() + " Compacto");
    }
}
