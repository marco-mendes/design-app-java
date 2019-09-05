package dia01.gabarito.laboratorio7.parte4.classesdesnecessarias;

import dia01.gabarito.laboratorio7.parte4.NetflixContent;
import dia01.gabarito.laboratorio7.parte4.NetflixContentType;
import dia01.gabarito.laboratorio7.parte4.Observer;

public class SerieContent implements Observer {

    @Override
    public void postContent(NetflixContent content) {
        if(content.getContentType().equals(NetflixContentType.SERIE)){
            System.out.println(String.format("Série %s adicionada ao catálogo!", content.getName()));
        }
    }

}
