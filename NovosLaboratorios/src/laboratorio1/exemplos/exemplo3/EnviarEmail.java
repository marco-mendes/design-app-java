package laboratorio1.exemplos.exemplo3;

public class EnviarEmail {

    Email email;

    public EnviarEmail(Email email) {
        this.email = email;
    }

    public void enviarEmail(String mensagem) {
        System.out.println(String.format("Enviando email para %s", this.email.destinatario));
        System.out.println(String.format("Remetente: %s", this.email.remetente));
        System.out.println(String.format("Mensagem: %s", mensagem));
    }

}
