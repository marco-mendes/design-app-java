package dia01.laboratorio7.parte4.exemplos.antesjava8;

public class AreaContabilidade implements Observer {
    @Override
    public void post(String postagem) {
        if(postagem != null && (postagem.contains("contabilidade") || postagem.contains("contábil"))){
            System.out.println("Notificando área de Contabilidade!");
        }
    }
}
