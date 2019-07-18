package gabarito.laboratorio7.parte5;

public class VendasValidator {

    private final VendasStrategy strategy;

    VendasValidator(VendasStrategy strategy){
        this.strategy = strategy;
    }

    public void validate(){
        strategy.apply();
    }

}
