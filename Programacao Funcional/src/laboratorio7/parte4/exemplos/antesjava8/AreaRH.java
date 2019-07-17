package laboratorio7.parte4.exemplos.antesjava8;

public class AreaRH implements Observer {
    @Override
    public void post(String postagem) {
        if(postagem != null && (postagem.contains("gestão") || postagem.contains("rh"))){
            System.out.println("Notificando área de RH!");
        }
    }
}
