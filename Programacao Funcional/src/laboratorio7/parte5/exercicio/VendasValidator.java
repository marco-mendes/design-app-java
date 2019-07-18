package laboratorio7.parte5.exercicio;

public class VendasValidator {

    private final VendasStrategy strategy;

    VendasValidator(VendasStrategy strategy){
        this.strategy = strategy;
    }

    public void validate(){
        strategy.apply();
    }

}
