package dia01.laboratorio7.parte3.exemplos.depoisjava8;

public class CarFactoryMain {

    public static void main(String[] args) {

        Car c1 = CarFactory.getCar(CarType.MERCEDES);
        c1.start();

        Car c2 = CarFactory.getCar(CarType.FERRARI);
        c2.start();
    }

}
