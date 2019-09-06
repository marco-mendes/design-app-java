package dia02.gabarito.laboratorio3.parte2;

import dia02.gabarito.laboratorio3.parte2.classesdesnecessarias.*;

public class ObserverMain {

    public static void observerAntesProgramacaoFuncional(){
        PostNetflixContent postContent = new PostNetflixContent();

        postContent.registerObserver(new DocumentarioContent());
        postContent.registerObserver(new FilmeContent());
        postContent.registerObserver(new SerieContent());

        NetflixContent novoDocumentario = new NetflixContent("Steve Jobs: The Lost Interview", NetflixContentType.DOCUMENTARIO);
        NetflixContent novoFilme = new NetflixContent("Vingadores Ultimato", NetflixContentType.FILME);
        NetflixContent novaSerie = new NetflixContent("Stranger Things - 3º Temporada", NetflixContentType.SERIE);

        postContent.notifyObservers(novoDocumentario);
        postContent.notifyObservers(novoFilme);
        postContent.notifyObservers(novaSerie);

    }

    public static void observerDepoisProgramacaoFuncional(){
        PostNetflixContent postNetflixContent = new PostNetflixContent();

        postNetflixContent.registerObserver((NetflixContent content) -> {
            if(content.getContentType().equals(NetflixContentType.DOCUMENTARIO)){
                System.out.println(String.format("Documentário %s adicionado ao catálogo!", content.getName()));
            }
        });

        postNetflixContent.registerObserver((NetflixContent content) -> {
            if(content.getContentType().equals(NetflixContentType.FILME)){
                System.out.println(String.format("Filme %s adicionado ao catálogo!", content.getName()));
            }
        });

        postNetflixContent.registerObserver((NetflixContent content) -> {
            if(content.getContentType().equals(NetflixContentType.SERIE)){
                System.out.println(String.format("Série %s adicionada ao catálogo!", content.getName()));
            }
        });

        NetflixContent novoDocumentario = new NetflixContent("Steve Jobs: The Lost Interview", NetflixContentType.DOCUMENTARIO);
        NetflixContent novoFilme = new NetflixContent("Vingadores Ultimato", NetflixContentType.FILME);
        NetflixContent novaSerie = new NetflixContent("Stranger Things - 3º Temporada", NetflixContentType.SERIE);

        postNetflixContent.notifyObservers(novoDocumentario);
        postNetflixContent.notifyObservers(novoFilme);
        postNetflixContent.notifyObservers(novaSerie);
    }

    public static void main(String[] args) {

        observerAntesProgramacaoFuncional();
        observerDepoisProgramacaoFuncional();

    }

}
