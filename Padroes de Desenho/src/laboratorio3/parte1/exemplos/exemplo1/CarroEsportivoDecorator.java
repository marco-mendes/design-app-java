package laboratorio3.parte1.exemplos.exemplo1;

public class CarroEsportivoDecorator extends CarroDecorator {

    public CarroEsportivoDecorator(Carro carro){
        super(carro);
    }

    @Override
    public String describe(){
        return (super.describe() + " Esportivo");
    }

}
