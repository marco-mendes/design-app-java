package laboratorio3.parte1.exemplos.exemplo1;

public abstract class CarroDecorator implements Carro {

    protected Carro carro;

    public CarroDecorator(Carro carro){
        this.carro = carro;
    }

    @Override
    public String describe() {
        return carro.describe();
    }

}
