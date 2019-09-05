package dia01.laboratorio7.parte3.exemplos.depoisjava8;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CarFactory {

    private static final Map<CarType, Supplier<Car>> map = new HashMap<>();
    static {
        map.put(CarType.FERRARI, Ferrari::new);
        map.put(CarType.MERCEDES, Mercedes::new);
    }

    public static Car getCar(CarType carType){
        Supplier<Car> car = map.get(carType);
        if(car != null){
            return car.get();
        } else {
            throw new IllegalArgumentException(String.format("Tipo %s não cadastrado!", carType));
        }
    }

}
