package dia02.laboratorio3.parte2.exercicio;

public class ObserverMain {

    public static void main(String[] args) {
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

}
