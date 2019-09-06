package dia02.gabarito.laboratorio3.parte2.classesdesnecessarias;

import dia02.gabarito.laboratorio3.parte2.NetflixContent;
import dia02.gabarito.laboratorio3.parte2.NetflixContentType;
import dia02.gabarito.laboratorio3.parte2.Observer;

public class DocumentarioContent implements Observer {

    @Override
    public void postContent(NetflixContent content) {
        if(content.getContentType().equals(NetflixContentType.DOCUMENTARIO)){
            System.out.println(String.format("Documentário %s adicionado ao catálogo!", content.getName()));
        }
    }

}
