package laboratorio7.parte2.exemplos.antesjava8;

public class CarroEsportivoDecorator extends CarroDecorator {

    CarroEsportivoDecorator(Carro carro){
        super(carro);
    }

    @Override
    public String describe(){
        return (super.describe() + " Esportivo");
    }

}
