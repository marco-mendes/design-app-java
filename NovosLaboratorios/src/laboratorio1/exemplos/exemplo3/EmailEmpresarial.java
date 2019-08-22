package laboratorio1.exemplos.exemplo3;

public class EmailEmpresarial extends Email {

    String assinatura;

    public EmailEmpresarial(String destinatario, String remetente, String assinatura) {
        super(destinatario, remetente);
        this.assinatura = assinatura;
    }

    public void enviarEmailEmpresarial(String mensagem) {
        System.out.println(String.format("Enviando E-mail empresarial para %s", this.destinatario));
        System.out.println(String.format("Remetente: %s", this.remetente));
        System.out.println(String.format("Mensagem: %s", mensagem));
        System.out.println(String.format("Assinatura: %s", this.assinatura));
    }

}
