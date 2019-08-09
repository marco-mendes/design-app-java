package com.exemplo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutionException;

public class Exemplo_3 {

    public static void requisicaoPostSincrona() throws IOException, InterruptedException {
        var client = HttpClient.newHttpClient();
        String body = "{}";

        var request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts")).build();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        int statusCode = response.statusCode();
        System.out.println(String.format("Status code: %s", statusCode));
    }

    public static void requisicaoPostAssincrona() throws ExecutionException, InterruptedException {
        var client = HttpClient.newHttpClient();
        String body = "{}";
        var request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts")).build();

        var future = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        int statusCode = future.get().statusCode();
        System.out.println(String.format("Status code: %s", statusCode));
    }

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        requisicaoPostSincrona();
        requisicaoPostAssincrona();
    }


}
