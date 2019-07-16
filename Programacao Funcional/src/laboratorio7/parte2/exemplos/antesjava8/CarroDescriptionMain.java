package laboratorio7.parte2.exemplos.antesjava8;

import java.util.ArrayList;
import java.util.List;

public class CarroDescriptionMain {

    public static void main(String[] args) {
        CarroBasico carroBasico = new CarroBasico();
        CarroCompactoDecorator carroCompacto = new CarroCompactoDecorator(carroBasico);
        CarroEsportivoDecorator carroEsportivo = new CarroEsportivoDecorator(carroBasico);
        CarroSedaDecorator carroSeda = new CarroSedaDecorator(carroBasico);

        List<Carro> carroList = new ArrayList<Carro>();
        carroList.add(carroCompacto);
        carroList.add(carroEsportivo);
        carroList.add(carroSeda);

        for(Carro carro : carroList){
            System.out.println(carro.describe());
        }

    }

}
