package laboratorio7.parte3.exemplos.antesjava8;

public class CarFactory {

    public Car getCar(CarType carType){
        switch (carType) {
            case MERCEDES: return new Mercedes();
            case FERRARI: return new Ferrari();
            default: return null;
        }
    }

}
