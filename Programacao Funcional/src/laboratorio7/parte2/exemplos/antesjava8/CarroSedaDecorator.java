package laboratorio7.parte2.exemplos.antesjava8;

public class CarroSedaDecorator extends CarroDecorator {

    CarroSedaDecorator(Carro carro){
        super(carro);
    }

    @Override
    public String describe(){
        return (super.describe() + " Sedã");
    }

}
