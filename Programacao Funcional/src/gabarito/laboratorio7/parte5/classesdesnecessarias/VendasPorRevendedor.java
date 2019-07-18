package gabarito.laboratorio7.parte5.classesdesnecessarias;

import gabarito.laboratorio7.parte5.VendasStrategy;

public class VendasPorRevendedor implements VendasStrategy {
    @Override
    public void apply() {
        System.out.println("Venda realizada por revendedor!");
    }
}