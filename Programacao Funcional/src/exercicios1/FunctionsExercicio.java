package exercicios1;

import exercicios1.classes.Pessoa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionsExercicio {

    public static void main(String[] args){


        // Crie um método que retorno uma lista de String com todos os nomes obtidos no método obtemListaTeste.
        // utilize a Function para isso
        teste(obtemListaTeste());



    }


    public static List<Pessoa> obtemListaTeste(){
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Marcio", 30));
        pessoas.add(new Pessoa("Maria", 28));
        pessoas.add(new Pessoa("Joana d'Arc", 32));
        pessoas.add(new Pessoa("Alberto", 36));
        pessoas.add(new Pessoa("Carlos", 31));
        pessoas.add(new Pessoa("César", 22));

        return pessoas;
    }

    public static void teste(List<Pessoa> lista){

        lista.forEach(p -> System.out.println(p.getNome()));
        lista.forEach(new Consumer(){

            @Override
            public void accept(Object o) {
                Pessoa p =(Pessoa) o;
                System.out.println(p.getNome());
            }
        });

        Iterator iterator = lista.iterator();
        while(iterator.hasNext()){
            Pessoa p = (Pessoa) iterator.next();
            System.out.println(p.getNome());
        }

    }

}
