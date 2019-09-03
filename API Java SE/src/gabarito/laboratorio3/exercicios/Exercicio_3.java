package gabarito.laboratorio3.exercicios;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutionException;

/*
Com base no que foi explicado até o momento crie uma requisição do tipo PUT e uma requisição do tipo DELETE consumindo a API da
[Reqres](https://reqres.in/).
* */

public class Exercicio_3 {

    public static void requisicaoPut() throws IOException, InterruptedException {
        // Criando o HttpClient
        HttpClient client = HttpClient.newHttpClient();
        // String no formato Json que irá conter o corpo da requisição PUT
        String body = "{ 'name': 'Maurício', 'job': 'Gerente' }";
        //Criando um HttpRequest do tipo Put, especificando sua URI e atribuindo ao método Put o corpo da requisição
        HttpRequest request = HttpRequest.newBuilder()
                .PUT(HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create("https://reqres.in/api/users/1")).build();

        // Enviando a requisição e recebendo o Objeto de resposta da mesma.
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        // Extraindo status de resposta da requisição Put
        int statusCode = response.statusCode();
        // Imprimindo resultado no console
        System.out.println(String.format("Status code: %s", statusCode));
    }

    public static void requisicaoDelete() throws IOException, InterruptedException {
        // Criando o HttpClient
        HttpClient client = HttpClient.newHttpClient();
        //Criando um HttpRequest do tipo Delete e especificando sua URI
        HttpRequest request = HttpRequest.newBuilder().DELETE().uri(URI.create("https://reqres.in/api/users/1")).build();
        // Enviando a requisição e recebendo o Objeto de resposta da mesma.
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        // Extraindo status de resposta da requisição Delete
        int statusCode = response.statusCode();
        // Imprimindo resultado no console
        System.out.println(statusCode);
    }

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        requisicaoPut();
        requisicaoDelete();
    }

}
