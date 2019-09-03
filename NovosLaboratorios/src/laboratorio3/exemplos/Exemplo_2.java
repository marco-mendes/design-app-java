package laboratorio3.exemplos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Exemplo_2 {

    public static void requisicaoGetSincrona() throws IOException, InterruptedException {
        // Criando o HttpClient
        HttpClient client = HttpClient.newHttpClient();
        //Criando um HttpRequest do tipo Get e especificando a URI de consulta
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create("https://jsonplaceholder.typicode.com/posts/1")).build();
        // Enviando a requisição e recebendo o Objeto de resposta da mesma.
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        // Extraindo o retorno da requisição
        String body = response.body();
        // Imprimindo o resultado da mesma
        System.out.println(body);
    }

    public static void requisicaoGetAssincrona() throws ExecutionException, InterruptedException {
        // Criando o HttpClient
        HttpClient client = HttpClient.newHttpClient();
        //Criando um HttpRequest do tipo Get e especificando a URI de consulta
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create("https://jsonplaceholder.typicode.com/posts/1")).build();
        // Enviando a requisição de forma assíncrona e armazenando o objeto de resposta em um CompletableFuture
        CompletableFuture<HttpResponse<String>> future = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        // Extraindo o retorno da requisição
        String body = future.get().body();
        // Imprimindo o resultado da mesma
        System.out.println(body);
    }

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        requisicaoGetSincrona();
        requisicaoGetAssincrona();
    }

}
