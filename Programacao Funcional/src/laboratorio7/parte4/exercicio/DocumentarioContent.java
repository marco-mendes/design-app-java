package laboratorio7.parte4.exercicio;

public class DocumentarioContent implements Observer {

    @Override
    public void postContent(NetflixContent content) {
        if(content.getContentType().equals(NetflixContentType.DOCUMENTARIO)){
            System.out.println(String.format("Documentário %s adicionado ao catálogo!", content.getName()));
        }
    }

}
