package dia02.laboratorio3.parte2.exemplos.exemplo1;

public class AreaContabilidade implements Observer {
    @Override
    public void post(String postagem) {
        if(postagem != null && (postagem.contains("contabilidade") || postagem.contains("contábil"))){
            System.out.println("Notificando área de Contabilidade!");
        }
    }
}
