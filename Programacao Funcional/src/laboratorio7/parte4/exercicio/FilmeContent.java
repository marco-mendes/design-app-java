package laboratorio7.parte4.exercicio;

public class FilmeContent implements Observer {

    @Override
    public void postContent(NetflixContent content) {
        if(content.getContentType().equals(NetflixContentType.FILME)){
            System.out.println(String.format("Filme %s adicionado ao catálogo!", content.getName()));
        }
    }

}
