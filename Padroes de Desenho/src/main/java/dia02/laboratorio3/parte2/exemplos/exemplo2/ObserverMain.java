package dia02.laboratorio3.parte2.exemplos.exemplo2;

public class ObserverMain {

    public static void main(String[] args) {
        Post postagemBlog = new Post();

        postagemBlog.registerObserver((String post) -> {
            if(post != null && (post.contains("contabilidade") || post.contains("contábil"))){
                System.out.println("Notificando área de Contabilidade!");
            }
        });

        postagemBlog.registerObserver((String post) -> {
            if(post != null && (post.contains("gestão") || post.contains("rh"))){
                System.out.println("Notificando área de RH!");
            }
        });

        postagemBlog.registerObserver((String post) -> {
            if(post != null && (post.contains("devops") || post.contains("infraestrutura"))){
                System.out.println("Notificando área de TI!");
            }
        });

        postagemBlog.notifyObservers("Postagem sobre contabilidade");
        postagemBlog.notifyObservers("Postagem sobre rh");
        postagemBlog.notifyObservers("Postagem sobre devops");

    }

}
