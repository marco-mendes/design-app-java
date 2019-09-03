package laboratorio3.exemplos;

import java.net.http.HttpClient;
import java.time.Duration;

public class Exemplo_1 {

    public static void criandoHttpClientDefault() {
        HttpClient client = HttpClient.newHttpClient();
    }

    public static void criandoHttpClientPersonalizado() {
        HttpClient customClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(60))
                .version(HttpClient.Version.HTTP_2)
                .build();
    }

    public static void main(String[] args) {
        criandoHttpClientDefault();
        criandoHttpClientPersonalizado();
    }

}
