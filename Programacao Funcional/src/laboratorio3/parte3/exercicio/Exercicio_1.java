package laboratorio3.parte3.exercicio;

import java.util.function.Consumer;

/*

Com base no código abaixo crie um Consumer chamado imprimeCelularConsumer que recebe um objeto do tipo Celular e executa o método imprimeCelular() do objeto recebido.
Após isso execute o consumer criado utilizando cada um dos objetos Celular criados no código base.

* */

public class Exercicio_1 {

    public static void main(String[] args) {

        Celular c1 = new Celular("J5 Prime", "Samsung", "Preto");
        Celular c2 = new Celular("Mi 9", "Xiaomi", "Azul");
        Celular c3 = new Celular("G7", "LG", "Cinza");

        Consumer<Celular> imprimeCelularConsumer = Celular::imprimeCelular;
        imprimeCelularConsumer.accept(c1);
        imprimeCelularConsumer.accept(c2);
        imprimeCelularConsumer.accept(c3);

    }

}

class Celular {

    String modelo;
    String marca;
    String cor;

    public Celular(String modelo, String marca, String cor) {
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getCor() {
        return cor;
    }

    public void imprimeCelular(){
        System.out.println(String.format("Modelo: %s | Marca: %s | Cor: %s", this.modelo, this.marca, this.cor));
    }

}