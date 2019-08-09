## Introdução a nova API HttpClient

### Material de preparação
[Introdução a API HttpClient](https://dev.to/andreevich/a-small-introduction-to-java-11-s-httpclient-nhj)

### Introdução
Um dos recursos que vem sendo construído e aprimodado desde o Java 9 é o HttpClient, o mesmo visa substituir a classe **HttpUrlConnection** 
facilitando o uso de requisições Http de forma prática e moderna.

Ciclo de vida da API HttpClient até o momento:
 * Foi introduzida inicialmente no Java 9 no módulo **jdk.incubator.httpclient**.
 * No Java 10 teve seu módulo renomeado para **java.httpclient**.
 * No Java 11 foi introduzida oficialmente como uma API integrada do Java, estando disponível no pacote **java.net.http**, além disso foram 
 realizadas algumas melhorias na API desde a ultima versão da mesma e foram incluídos recursos como total suporte a requisições assincronas
 não blocantes, suporte ao HTTP/2 e suporte nativo a WebSockets.

Abordaremos nesse laboratório uma pequena introdução de uso a essa API com requisições do tipo GET e POST, caso queira se aprofundar melhor 
recomendamos a leitura deste [artigo](https://golb.hplar.ch/2019/01/java-11-http-client.html).

Para nossos exercícios utilizaremos a API da [Reqres](https://reqres.in/) que é uma API gratuita para testar solicitações Http.


### Os principais componentes da Api HttpClient
A Api HttpClient possui 3 componentes principais, são eles:
 * **HttpClient**: É o cliente Http utilizado enviar e obter o retorno de requisições Http.
 * **HttpRequest**: Uma solicitação Http criada por meio de um construtor no qual são informados tipo de requisição, uri de consulta entre outras 
 propriedades.
 * **HttpResponse**: Este componente é resultado do processamento de um HttpRequest, o mesmo contém o retorno da solicitação Http.
 

### Criando um HttpClient padrão e personalizado
A criação de um HttpClient pode ser feita de duas formas: criar um HttpClient com as configurações default do mesmo ou criar um HttpClient com configurações personalizadas.<br/>
Exemplo de uso:
```java
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
```
No exemplo acima durante a criação do HttpClient personalizado especificamos as configurações **connectTimeout** e **version** com seus respectivos 
métodos de configuração, esses são apenas algumas das configurações disponíveis para criação de um HttpClient personalizado, a lista completa 
de configurações pode ser encotrada neste [link](https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpClient.html).

### Enviando uma requisição GET de forma Síncrona e Assíncrona
Exemplo de requisição GET completa de forma Síncrona e Assíncrona:
```java
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutionException;

public class Exemplo_2 {

    public static void requisicaoGetSincrona() throws IOException, InterruptedException {
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder().GET().uri(URI.create("https://jsonplaceholder.typicode.com/posts/1")).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);
    }

    public static void requisicaoGetAssincrona() throws ExecutionException, InterruptedException {
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder().GET().uri(URI.create("https://jsonplaceholder.typicode.com/posts/1")).build();
        var future = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        String body = future.thenApply(HttpResponse::body).get();
        System.out.println(body);
    }

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        requisicaoGetSincrona();
        requisicaoGetAssincrona();
    }

}
```
No exemplo acima definimos um HttpClient com as configurações padrão, em seguida criamos um objeto HttpRequest onde especificamos o método que será usado na requisição, podendo 
ser **GET()**, **POST()** **PUT()** e **DELETE**, especificamos também no objeto HttpRequest a uri da requisição.<br/>
Para enviar uma requisição de forma síncrona utilizamos o método **send()** do HttpClient, o mesmo recebe como parâmetro um objeto HttpRequest e um objeto HttpResponse no qual 
especificamos o tipo de retorno para String.

Para executar a mesma operação de forma assíncrona basta utilizar o método **sendAssync()** de nosso HttpClient, a única diferença é que este método nos retorna um objeto do tipo 
**ComputableFuture**.<br/>

#### Exercício 1
Com base no que foi explicado até o momento crie uma requisição GET() de forma síncrona e assíncrona utilizando a API da 
[Reqres](https://reqres.in/).


### Enviando uma requisição POST de forma Síncrona e Assíncrona
Exemplo de requisição POST completa de forma Síncrona e Assíncrona:
```java
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
```
Como podemos ver neste exemplo uma requisição do tipo POST recebe um argumento do tipo HttpRequest.BodyPublihsers, em nosso exemplo 
passamos como parâmetro uma String no formato JSON vazia.

#### Exercício 2
Com base no que foi explicado até o momento crie uma requisição POST() de forma síncrona e assíncrona utilizando a API da 
[Reqres](https://reqres.in/). 