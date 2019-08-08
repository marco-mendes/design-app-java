package com.exemplo;

import java.net.http.HttpClient;
import java.time.Duration;

public class Exemplo_1 {

    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();

        HttpClient customClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(60))
                .version(HttpClient.Version.HTTP_2)
                .build();
    }

}
