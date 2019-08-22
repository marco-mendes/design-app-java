package laboratorio1.exemplos.exemplo3;

public class EnviarEmailEmpresarial extends EnviarEmail {

    String assinatura;

    public EnviarEmailEmpresarial(Email email, String assinatura) {
        super(email);
        this.assinatura = assinatura;
    }

    public void enviarEmailEmpresarial(String mensagem) {
        System.out.println(String.format("Enviando E-mail empresarial para %s", this.email.destinatario));
        System.out.println(String.format("Remetente: %s", this.email.remetente));
        System.out.println(String.format("Mensagem: %s", mensagem));
        System.out.println(String.format("Assinatura: %s", this.assinatura));
    }

}
