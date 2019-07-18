package laboratorio7.parte5.exercicio;

public class VendasPeloSite implements VendasStrategy {
    @Override
    public void apply() {
        System.out.println("Venda realizada pelo Site!");
    }
}
