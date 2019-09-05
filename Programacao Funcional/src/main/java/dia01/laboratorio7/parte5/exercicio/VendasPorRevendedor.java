package dia01.laboratorio7.parte5.exercicio;

public class VendasPorRevendedor implements VendasStrategy {
    @Override
    public void apply() {
        System.out.println("Venda realizada por revendedor!");
    }
}