package laboratorio1.exemplos.exemplo3;

public class Email {

    String destinatario;
    String remetente;

    public Email(String destinatario, String remetente) {
        this.destinatario = destinatario;
        this.remetente = remetente;
    }

    public void enviarEmail(String mensagem) {
        System.out.println(String.format("Enviando email para %s", this.destinatario));
        System.out.println(String.format("Remetente: %s", this.remetente));
        System.out.println(String.format("Mensagem: %s", mensagem));
    }

    // Getters e Setters

}
