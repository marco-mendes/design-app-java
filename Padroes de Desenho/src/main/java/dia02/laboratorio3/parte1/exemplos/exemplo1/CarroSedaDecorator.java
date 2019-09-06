package dia02.laboratorio3.parte1.exemplos.exemplo1;

public class CarroSedaDecorator extends CarroDecorator {

    public CarroSedaDecorator(Carro carro){
        super(carro);
    }

    @Override
    public String describe(){
        return (super.describe() + " Sedã");
    }

}
