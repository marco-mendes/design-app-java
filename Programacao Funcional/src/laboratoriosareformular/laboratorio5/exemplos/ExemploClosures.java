package laboratoriosareformular.laboratorio5.exemplos;

import java.util.function.Function;

public class ExemploClosures {

    public static void main(String[] args) {

        String[] diasSemana = { "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo" };
        String dia = getTextOfWeekday(diasSemana).apply(5);
        System.out.println(dia);
        System.out.println(getTextOfWeekday().apply(6));

        // Acessando escopo do método no qual está inserido
        Function<Integer, String> obtemDiaSemana = num -> {
            return (num > 0 && num <= diasSemana.length) ? diasSemana[num-1] : null;
        };
        System.out.println(obtemDiaSemana.apply(3));



    }

    // Acessando escopo pai dentro da função
    static Function<Integer, String> getTextOfWeekday(String[] weeks){
        return num -> (num > 0 && num <= weeks.length) ? weeks[num-1] : null;
    }

    // Acesso escopo interno da função de um ambiente externo a ela
    static Function<Integer, String> getTextOfWeekday(){
        String[] weeks = { "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo" };
        return num -> (num > 0 && num <= weeks.length) ? weeks[num-1] : null;
    }

}