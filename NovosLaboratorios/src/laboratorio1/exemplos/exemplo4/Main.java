package laboratorio1.exemplos.exemplo4;

public class Main {

    public static void gerarRelatorio(Relatorio relatorio) {
        relatorio.gerarRelatorio();
    }

    public static void main(String[] args) {
        RelatorioExcel relatorioExcel = new RelatorioExcel();
        gerarRelatorio(relatorioExcel);
    }

}
