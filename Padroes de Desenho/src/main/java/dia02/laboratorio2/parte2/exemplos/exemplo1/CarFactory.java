package dia02.laboratorio2.parte2.exemplos.exemplo1;

public class CarFactory {

    public Car getCar(CarType carType){
        switch (carType) {
            case MERCEDES: return new Mercedes();
            case FERRARI: return new Ferrari();
            default: return null;
        }
    }

}
