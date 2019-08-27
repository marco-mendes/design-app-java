package gabarito.laboratorio2.parte3;

public class PrototypePatternMain {

    public static void main(String[] args) {
        try {
            String gabinete = PrototypeFactory.getInstance(PrototypeFactory.ModelType.GABINETE).toString();
            System.out.println(gabinete);

            String monitor = PrototypeFactory.getInstance(PrototypeFactory.ModelType.MONITOR).toString();
            System.out.println(monitor);

            String teclado = PrototypeFactory.getInstance(PrototypeFactory.ModelType.TECLADO).toString();
            System.out.println(teclado);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }

}