package laboratorio7.parte5.exercicio;

public class VendasClient {

    public static void main(String[] args) {
        VendasValidator vendaLojaFisica = new VendasValidator(new VendasLojaFisica());
        vendaLojaFisica.validate();

        VendasValidator vendaPeloSite = new VendasValidator(new VendasPeloSite());
        vendaPeloSite.validate();

        VendasValidator vendaPorRevendedor = new VendasValidator(new VendasPorRevendedor());
        vendaPorRevendedor.validate();
    }

}
