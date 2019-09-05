package dia01.laboratorio7.parte2.exemplos.antesjava8;

public class CarroEsportivoDecorator extends CarroDecorator {

    public CarroEsportivoDecorator(Carro carro){
        super(carro);
    }

    @Override
    public String describe(){
        return (super.describe() + " Esportivo");
    }

}
