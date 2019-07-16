package laboratorio7.parte2.exemplos.depoisjava8;

import java.util.ArrayList;
import java.util.List;

public class CarroDescriptionMain {

    public static void main(String[] args) {
        CarroBasico carroBasico = new CarroBasico();
        Carro carroCompacto = () -> carroBasico.describe() + " Compacto";
        Carro carroEsportivo = () -> carroBasico.describe() + " Esportivo";
        Carro carroSeda = () -> carroBasico.describe() + " Sedã";

        List<Carro> carroList = new ArrayList<>();
        carroList.add(carroCompacto);
        carroList.add(carroEsportivo);
        carroList.add(carroSeda);

        carroList.forEach(c -> System.out.println(c.describe()));
    }

}
