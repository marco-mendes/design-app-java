package gabarito.laboratorio7.parte4.classesdesnecessarias;

import gabarito.laboratorio7.parte4.NetflixContent;
import gabarito.laboratorio7.parte4.NetflixContentType;
import gabarito.laboratorio7.parte4.Observer;

public class DocumentarioContent implements Observer {

    @Override
    public void postContent(NetflixContent content) {
        if(content.getContentType().equals(NetflixContentType.DOCUMENTARIO)){
            System.out.println(String.format("Documentário %s adicionado ao catálogo!", content.getName()));
        }
    }

}
