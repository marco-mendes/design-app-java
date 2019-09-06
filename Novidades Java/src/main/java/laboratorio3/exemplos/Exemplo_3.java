package laboratorio3.exemplos;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Exemplo_3 {

    public static void main(String[] args) {
        List<String> listaNomes = List.of("Silvana", "Helena", "Mike", "John");
        String[] arrayNomes = listaNomes.toArray(String[]::new);

        System.out.println(Arrays.toString(arrayNomes));


        Set<Integer> setDeInteiros = Set.of(1,2,3,4,5);
        Integer[] arrayInteiros = setDeInteiros.toArray(Integer[]::new);

        System.out.println(Arrays.toString(arrayInteiros));
    }

}
