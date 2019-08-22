package laboratorio1.exemplos.exemplo3;

public class Email {

    private String destinatario;
    private String remetente;

    public Email(String destinatario, String remetente) {
        this.destinatario = destinatario;
        this.remetente = remetente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getRemetente() {
        return remetente;
    }

}
