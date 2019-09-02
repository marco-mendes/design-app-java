package gabarito.laboratorio3.exercicios;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/*
Com base no que foi explicado até o momento crie uma requisição do tipo POST de forma síncrona e assíncrona consumindo a API da
[Reqres](https://reqres.in/).
* */

public class Exercicio_2 {

    public static void requisicaoPostSincrona() throws IOException, InterruptedException {
        // Criando o HttpClient
        HttpClient client = HttpClient.newHttpClient();
        // String no formato Json que irá conter o corpo da requisição POST
        String body = "{ 'name': 'Joao', 'job': 'Programador' }";
        //Criando um HttpRequest do tipo Post, especificando sua URI e atribuindo ao método Post o corpo da requisição
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create("https://reqres.in/api/users")).build();

        // Enviando a requisição e recebendo o Objeto de resposta da mesma.
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        // Extraindo status de resposta da requisição Post
        int statusCode = response.statusCode();
        // Imprimindo resultado no console
        System.out.println(String.format("Status code: %s", statusCode));
    }

    public static void requisicaoPostAssincrona() throws ExecutionException, InterruptedException {
        // Criando o HttpClient
        HttpClient client = HttpClient.newHttpClient();
        // String no formato Json que irá conter o corpo da requisição POST
        String body = "{ 'name': 'Maria', 'job': 'Gerente de Projetos' }";
        //Criando um HttpRequest do tipo Post, especificando sua URI e atribuindo ao método Post o corpo da requisição
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create("https://reqres.in/api/users")).build();

        // Enviando a requisição de forma assíncrona e armazenando o objeto de resposta em um CompletableFuture
        CompletableFuture<HttpResponse<String>> future = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        // Extraindo status de resposta da requisição Post
        int statusCode = future.get().statusCode();
        // Imprimindo resultado no console
        System.out.println(String.format("Status code: %s", statusCode));
    }

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        requisicaoPostSincrona();
        requisicaoPostAssincrona();
    }

}
