package laboratorio1.parte1.exemplo;

public class PatternVisitorMain {

    public static void main(String[] args) {
        NotaFiscal nota = new NotaFiscal(2000);
        nota.accept(new AplicarImpostoISSVisitor());
        System.out.println(String.format("Valor nota fiscal com o desconto ISS aplicado: %s", nota.getValorLiquido()));

        nota.accept(new AplicarImpostoCOFINSVisitor());
        System.out.println(String.format("Valor nota fiscal com o desconto COFINS aplicado: %s", nota.getValorLiquido()));

        System.out.println("Descontos aplicados na Nota Fiscal:");
        nota.getDescontos().forEach((key, value) -> {
            System.out.println(
                    String.format("Desconto: %s | Valor: %s", key, value)
            );
        });

        System.out.println(String.format("Valor bruto da Nota Fiscal: %s", nota.getValorBruto()));
        System.out.println(String.format("Valor líquido da Nota Fiscal: %s", nota.getValorLiquido()));
    }

}