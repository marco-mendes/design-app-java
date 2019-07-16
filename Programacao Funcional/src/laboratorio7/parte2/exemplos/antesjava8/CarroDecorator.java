package laboratorio7.parte2.exemplos.antesjava8;

public abstract class CarroDecorator implements Carro {

    protected Carro carro;

    CarroDecorator(Carro carro){
        this.carro = carro;
    }

    @Override
    public String describe() {
        return carro.describe();
    }

}
