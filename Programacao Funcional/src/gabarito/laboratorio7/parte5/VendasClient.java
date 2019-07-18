package gabarito.laboratorio7.parte5;

import gabarito.laboratorio7.parte5.classesdesnecessarias.VendasLojaFisica;
import gabarito.laboratorio7.parte5.classesdesnecessarias.VendasPeloSite;
import gabarito.laboratorio7.parte5.classesdesnecessarias.VendasPorRevendedor;

public class VendasClient {

    public static void strategyAntesProgramacaoFuncional() {
        VendasValidator vendaLojaFisica = new VendasValidator(new VendasLojaFisica());
        vendaLojaFisica.validate();

        VendasValidator vendaPeloSite = new VendasValidator(new VendasPeloSite());
        vendaPeloSite.validate();

        VendasValidator vendaPorRevendedor = new VendasValidator(new VendasPorRevendedor());
        vendaPorRevendedor.validate();
    }

    public static void strategyDepoisProgramacaoFuncional() {
        VendasValidator vendaLojaFisica = new VendasValidator(() -> {
            System.out.println("Venda realizada pela Loja Física!");
        });
        vendaLojaFisica.validate();

        VendasValidator vendaPeloSite = new VendasValidator(() -> {
            System.out.println("Venda realizada pelo Site!");
        });
        vendaPeloSite.validate();

        VendasValidator vendaPorRevendedor = new VendasValidator(() -> {
            System.out.println("Venda realizada por revendedor!");
        });
        vendaPorRevendedor.validate();
    }

    public static void main(String[] args) {
        strategyAntesProgramacaoFuncional();
        strategyDepoisProgramacaoFuncional();
    }

}
