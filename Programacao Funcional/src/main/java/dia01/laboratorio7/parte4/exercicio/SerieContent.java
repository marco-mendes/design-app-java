package dia01.laboratorio7.parte4.exercicio;

public class SerieContent implements Observer {

    @Override
    public void postContent(NetflixContent content) {
        if(content.getContentType().equals(NetflixContentType.SERIE)){
            System.out.println(String.format("Série %s adicionada ao catálogo!", content.getName()));
        }
    }

}
