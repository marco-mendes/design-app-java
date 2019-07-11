package laboratorio2.exemplos;

import java.util.Optional;

public class Exemplo_7 {

    public static void main(String[] args) {
        Celular c1 = new Celular("Apple", "Iphone XR", "Novo Iphone XR");

        Optional<Celular> optionalCelular1 = Optional.of(c1);

        Optional<String> marcaOptional = optionalCelular1.map(Celular::getMarca);
        Optional<String> descricaoOptional = optionalCelular1.flatMap(Celular::getDescricao);

        System.out.println(marcaOptional.get());
        System.out.println(descricaoOptional.get());

    }

}

class Celular {

    String marca;
    String modelo;
    String descricao;

    public Celular(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Celular(String marca, String modelo, String descricao) {
        this.marca = marca;
        this.modelo = modelo;
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Optional<String> getDescricao() {
        return Optional.ofNullable(descricao);
    }
}
