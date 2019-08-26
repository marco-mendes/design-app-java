package laboratorio2.exercicios.exercicio2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercicio2 {

    public static void main(String[] args) {
        List<Funcionario> funcionarios = Arrays.asList(
                new Funcionario("José", "123", Sexo.MASCULINO, 25, 1250.00),
                new Funcionario("Carol", "450", Sexo.FEMININO, 27, 1300.00),
                new Funcionario("Joana", "344", Sexo.FEMININO, 31, 2500.00),
                new Funcionario("Jorge", "678", Sexo.MASCULINO, 23, 1500.00),
                new Funcionario("Aline", "168", Sexo.FEMININO, 24, 1300.00),
                new Funcionario("Gabriel", "234", Sexo.MASCULINO, 28, 1600.00),
                new Funcionario("Raquel", "376", Sexo.FEMININO, 26, 1900.00),
                new Funcionario("Marcos", "345", Sexo.MASCULINO, 32, 2500.00)
        );

        List<Funcionario> funcionariosFiltrados = funcionarios.stream()
                .filter(f -> f.getSexo().equals(Sexo.FEMININO))
                .filter(f -> f.getIdade() >= 24 && f.getIdade() <= 40)
                .filter(f -> f.getSalario() >= 1500.00)
                .sorted((f1, f2) -> f1.getNome().compareTo(f2.getNome()))
                .collect(Collectors.toList());

    }

}
