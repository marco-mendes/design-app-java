package laboratorio2.exercicio.exercicio1;

import java.util.Arrays;
import java.util.List;

public class Tweet {

    private String usuario;
    private String textoTweet;

    public Tweet(String usuario, String textoTweet) {
        this.usuario = usuario;
        this.textoTweet = textoTweet;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getTextoTweet() {
        return textoTweet;
    }

    public static List<Tweet> obtemListaFicticiaTweets() {
        return Arrays.asList(
                new Tweet("Chica da Silva", "Boa tarde a todos."),
                new Tweet("José Carlos", "Ótima reportagem, abordaram bem o problema."),
                new Tweet("Carlos Silva", "Ótimo dia a todos.")
        );
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "usuario='" + usuario + '\'' +
                ", textoTweet='" + textoTweet + '\'' +
                '}';
    }
}