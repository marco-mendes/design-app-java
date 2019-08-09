## Introdução a nova API HttpClient

### Material de preparação
[Introdução a API HttpClient](https://dev.to/andreevich/a-small-introduction-to-java-11-s-httpclient-nhj)


### Introdução
Um dos recursos que vem sendo construído e aprimodado desde o Java 9 é o HttpClient, o mesmo visa substituir a classe **HttpUrlConnection** 
facilitando o uso de requisições Http de forma fácil, prática e moderna.

Ciclo de vida da API HttpClient até o momento:
 * Foi introduzida inicialmente no Java 9 no módulo **jdk.incubator.httpclient**.
 * No Java 10 teve seu módulo renomeado para **java.httpclient**.
 * No Java 11 foi introduzida oficialmente como uma API integrada do Java, estando disponível no pacote **java.net.http**, além disso foram 
 realizadas algumas melhorias na API desde a ultima versão da mesma e foram incluídos recursos como total suporte a requisições assincronas
 não blocantes, suporte ao HTTP/2 e suporte nativo a WebSockets.

Abordaremos nesse laboratório uma pequena introdução de uso a essa API, caso queira se aprofundar melhor recomendamos a leitura 
deste [artigo](https://golb.hplar.ch/2019/01/java-11-http-client.html).

Iremos consumir a API [JsonPlaceholder](https://jsonplaceholder.typicode.com/guide.html) para testar nossos exemplos e em nossos 
exercícios iremos consumir a API [Reqres](https://reqres.in/).<br/>
**Observação importante**: Essas duas APIs servem apenas para simularmos nossas requisições Http em uma API fictícia, os dados da mesma 
não são verdadeiramente atualizados com nossas requisições.

### Os principais componentes da Api HttpClient
A Api HttpClient possui 3 componentes principais, são eles:
 * **HttpClient**: É o cliente Http utilizado enviar e obter o retorno de requisições Http.
 * **HttpRequest**: Uma solicitação Http criada por meio de um construtor no qual são informados tipo de requisição, uri de consulta entre outras 
 propriedades.
 * **HttpResponse**: Este componente é resultado do processamento de um HttpRequest, o mesmo contém o retorno da solicitação Http.
 

### Criando um HttpClient
Podemos criar um HttpClient de suas formas, com as configurações default ou com configurações personalizadas.<br/>
Exemplo:
```java
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
```
No exemplo acima durante a criação do HttpClient personalizado especificamos as configurações **connectTimeout** e **version** com seus respectivos 
métodos de configuração, essas são apenas algumas das configurações disponíveis para criação de um HttpClient personalizado, a lista completa 
de configurações pode ser encotrada neste [link](https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpClient.html).

### Enviando uma requisição GET de forma Síncrona e Assíncrona
Exemplo de requisição GET completa de forma Síncrona e Assíncrona com explicação:
```java
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
```
Para enviar uma requisição de forma síncrona utilizamos o método **send()** do HttpClient, o mesmo recebe como parâmetro um objeto HttpRequest e um objeto HttpResponse no qual 
especificamos o tipo de retorno da requisição no formato de uma String.

Para executar a mesma operação de forma assíncrona basta utilizar o método **sendAssync()** de nosso HttpClient, a única diferença é que este método nos retorna um objeto do tipo 
**CompletableFuture**.<br/>
**Observação**: Leia os comentários do código para melhor compreensão do mesmo.

#### Exercício 1
Com base no que foi explicado até o momento crie uma requisição do tipo GET de forma síncrona e assíncrona consumindo a API da 
[Reqres](https://reqres.in/).


### Enviando uma requisição POST de forma Síncrona e Assíncrona
Exemplo de requisição POST completa de forma Síncrona e Assíncrona com explicação:
```java
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Exemplo_3 {

    public static void requisicaoPostSincrona() throws IOException, InterruptedException {
        // Criando o HttpClient
        HttpClient client = HttpClient.newHttpClient();
        // String no formato Json que irá conter o corpo da requisição POST
        String body = "{ 'id': 1, 'title': 'Teste', 'body': 'testePostSíncrono'  }";
        //Criando um HttpRequest do tipo Post, especificando sua URI e atribuindo ao método Post o corpo da requisição
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts")).build();

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
        String body = "{ 'id': 1, 'title': 'Teste', 'body': 'testePostAssíncrono' }";
        //Criando um HttpRequest do tipo Post, especificando sua URI e atribuindo ao método Post o corpo da requisição
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts")).build();

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
```

Como podemos ver neste exemplo, uma requisição do tipo POST recebe um argumento do tipo **HttpRequest.BodyPublishers** no qual devemos 
especificar o corpo de nossa requisição POST, neste exemplo utilizamos como parâmetro para ele uma String no formato JSON.<br/>
**Observação**: Leia os comentários do código para melhor compreensão do mesmo.

#### Exercício 2
Com base no que foi explicado até o momento crie uma requisição do tipo POST de forma síncrona e assíncrona consumindo a API da 
[Reqres](https://reqres.in/).


### Enviando requisições PUT e DELETE
O envio de requisições PUT e DELETE não é muito diferente das requisições GET e POST.<br/>
Mostraremos aqui apenas um exemplo dessas duas requisições de forma síncrona, a requisição de forma assíncrona pode ser feita da mesma 
forma que fizemos com as requisições GET e POST.

Exemplo de uso requisições PUT e DELETE:
```java
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutionException;

public class Exemplo_4 {

    public static void requisicaoPut() throws IOException, InterruptedException {
        // Criando o HttpClient
        HttpClient client = HttpClient.newHttpClient();
        // String no formato Json que irá conter o corpo da requisição PUT
        String body = "{ 'id': 1, 'title': 'Teste', 'body': 'testePutSíncrono'  }";
        //Criando um HttpRequest do tipo Put, especificando sua URI e atribuindo ao método Put o corpo da requisição
        HttpRequest request = HttpRequest.newBuilder()
                .PUT(HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1")).build();

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
        HttpRequest request = HttpRequest.newBuilder().DELETE().uri(URI.create("https://jsonplaceholder.typicode.com/posts/1")).build();
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
```
**Observação**: Leia os comentários do código para melhor compreensão do mesmo.

#### Exercício 3
Com base no que foi explicado até o momento crie uma requisição do tipo PUT e uma requisição do tipo DELETE consumindo a API da 
[Reqres](https://reqres.in/).