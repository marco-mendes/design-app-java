package dia01.laboratorio7.parte5.exercicio;

public class VendasLojaFisica implements VendasStrategy {
    @Override
    public void apply() {
        System.out.println("Venda realizada pela Loja Física!");
    }
}