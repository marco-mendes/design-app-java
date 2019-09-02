package gabarito.laboratorio1.parte2;

public class Ponto {

    private String data;
    private String hora;

    public Ponto(String data, String hora) {
        this.data = data;
        this.hora = hora;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    @Override
    public String toString() {
        return "Ponto{" +
                "data=" + data +
                ", hora='" + hora + '\'' +
                '}';
    }

}
