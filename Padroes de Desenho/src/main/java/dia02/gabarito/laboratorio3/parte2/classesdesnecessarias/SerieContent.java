package dia02.gabarito.laboratorio3.parte2.classesdesnecessarias;

import dia02.gabarito.laboratorio3.parte2.NetflixContent;
import dia02.gabarito.laboratorio3.parte2.NetflixContentType;
import dia02.gabarito.laboratorio3.parte2.Observer;

public class SerieContent implements Observer {

    @Override
    public void postContent(NetflixContent content) {
        if(content.getContentType().equals(NetflixContentType.SERIE)){
            System.out.println(String.format("Série %s adicionada ao catálogo!", content.getName()));
        }
    }

}
