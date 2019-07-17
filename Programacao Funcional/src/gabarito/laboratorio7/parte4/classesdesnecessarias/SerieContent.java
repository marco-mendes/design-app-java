package gabarito.laboratorio7.parte4.classesdesnecessarias;

import gabarito.laboratorio7.parte4.NetflixContent;
import gabarito.laboratorio7.parte4.NetflixContentType;
import gabarito.laboratorio7.parte4.Observer;

public class SerieContent implements Observer {

    @Override
    public void postContent(NetflixContent content) {
        if(content.getContentType().equals(NetflixContentType.SERIE)){
            System.out.println(String.format("Série %s adicionada ao catálogo!", content.getName()));
        }
    }

}
