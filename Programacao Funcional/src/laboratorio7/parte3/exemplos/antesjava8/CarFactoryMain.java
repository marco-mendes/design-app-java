package laboratorio7.parte3.exemplos.antesjava8;

public class CarFactoryMain {

    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();

        Car c1 = carFactory.getCar(CarType.MERCEDES);
        c1.start();

        Car c2 = carFactory.getCar(CarType.FERRARI);
        c2.start();
    }

}
