package gabarito.laboratorio7.parte5.classesdesnecessarias;

import gabarito.laboratorio7.parte5.VendasStrategy;

public class VendasPeloSite implements VendasStrategy {
    @Override
    public void apply() {
        System.out.println("Venda realizada pelo Site!");
    }
}
