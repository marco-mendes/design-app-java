package laboratorio3.parte1.exemplos.exemplo1;

public class CarroCompactoDecorator extends CarroDecorator {

    public CarroCompactoDecorator(Carro carro){
        super(carro);
    }

    @Override
    public String describe() {
        return (super.describe() + " Compacto");
    }
}
