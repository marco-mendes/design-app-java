package gabarito.laboratorio7.parte4.classesdesnecessarias;

import gabarito.laboratorio7.parte4.NetflixContent;
import gabarito.laboratorio7.parte4.NetflixContentType;
import gabarito.laboratorio7.parte4.Observer;

public class FilmeContent implements Observer {

    @Override
    public void postContent(NetflixContent content) {
        if(content.getContentType().equals(NetflixContentType.FILME)){
            System.out.println(String.format("Filme %s adicionado ao catálogo!", content.getName()));
        }
    }

}
