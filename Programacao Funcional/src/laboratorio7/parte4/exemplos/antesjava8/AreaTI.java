package laboratorio7.parte4.exemplos.antesjava8;

public class AreaTI implements Observer {
    @Override
    public void post(String postagem) {
        if(postagem != null && (postagem.contains("devops") || postagem.contains("infraestrutura"))){
            System.out.println("Notificando área de TI!");
        }
    }
}
