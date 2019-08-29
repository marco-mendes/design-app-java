package laboratorio1.parte1.exemplo;

public class PatternVisitorMainFuncional {

    public static void aplicarImpostoCofins(NotaFiscal notaFiscal) {
        double percentualDesconto = 0.03;
        double valorDesconto = notaFiscal.getValorBruto() * percentualDesconto;
        notaFiscal.adicionarDesconto("CONFINS", valorDesconto);
        System.out.println(String.format("Adicionando desconto COFINS no valor de %s", valorDesconto));
    }

    public static void aplicarDescontoISS(NotaFiscal notaFiscal) {
        double percentualDesconto = 0.02;
        double valorDesconto = notaFiscal.getValorBruto() * percentualDesconto;
        notaFiscal.adicionarDesconto("ISS", valorDesconto);
        System.out.println(String.format("Adicionando desconto ISS no valor de %s", valorDesconto));
    }

    public static void formaMethodReference() {
        NotaFiscal nota = new NotaFiscal(2000);
        nota.accept(PatternVisitorMainFuncional::aplicarDescontoISS);

        System.out.println(String.format("Valor nota fiscal com o desconto ISS aplicado: %s", nota.getValorLiquido()));

        nota.accept(PatternVisitorMainFuncional::aplicarImpostoCofins);
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

    public static void formaComLamdaAnonimo() {
        NotaFiscal nota = new NotaFiscal(2000);
        nota.accept((notaFiscal) -> {
            double percentualDesconto = 0.02;
            double valorDesconto = notaFiscal.getValorBruto() * percentualDesconto;
            notaFiscal.adicionarDesconto("ISS", valorDesconto);
            System.out.println(String.format("Adicionando desconto ISS no valor de %s", valorDesconto));
        });

        System.out.println(String.format("Valor nota fiscal com o desconto ISS aplicado: %s", nota.getValorLiquido()));

        nota.accept((notaFiscal) -> {
            double percentualDesconto = 0.03;
            double valorDesconto = notaFiscal.getValorBruto() * percentualDesconto;
            notaFiscal.adicionarDesconto("COFINS", valorDesconto);
            System.out.println(String.format("Adicionando desconto COFINS no valor de %s", valorDesconto));
        });

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

    public static void main(String[] args) {
        formaMethodReference();
        System.out.println("--------------------");
        formaComLamdaAnonimo();
    }

}
