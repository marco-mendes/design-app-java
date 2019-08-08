## Introdução a nova API HttpClient

### Material de preparação
[Introdução a API HttpClient](https://dev.to/andreevich/a-small-introduction-to-java-11-s-httpclient-nhj)

### Introdução
Um dos recursos que veio sendo construído e aprimodado desde o Java 9 é o HttpClient, o mesmo visa substituir a classe **HttpUrlConnection** 
que está presente desde as primeiras versões do Java.<br/>
A Api **HttpUrlConnection** possui uma série de problemas que motivaram a criação de uma [proposta de melhoria](http://openjdk.java.net/jeps/110#Motivation) 
para essa Api, essa proposta vem sendo implementada desde o Java 9 e vem sendo melhorada até o Java 11.<br/>
Os principais problemas da Api **HttpUrlConnection** é que ela é muito antiga e dificil de usar, a Api **HttpClient** busca facilitar a utilização 
de requisições Http no Java de forma prática e moderna.

Ciclo de vida da API HttpClient até o momento:
 * Foi introduzida inicialmente no Java 9 no módulo **jdk.incubator.httpclient**.
 * No Java 10 teve seu módulo renomeado para **java.httpclient**.
 * No Java 11 foi introduzida oficialmente como uma API integrada do Java, estando disponível no pacote **java.net.http**, além disso foram 
 realizadas algumas melhorias na API desde a ultima versão da mesma e foram incluídos recursos como total suporte a requisições assincronas
 não blocantes, suporte ao HTTP/2 e suporte nativo a WebSockets.

Abordaremos nesse laboratório uma pequena introdução de uso a essa API, se quiser se aprofundar melhor recomendamos a leitura deste 
[artigo](https://golb.hplar.ch/2019/01/java-11-http-client.html).

Para nossos exercícios utilizaremos a API da [Reqres](https://reqres.in/) que é uma API gratuita para testar solicitações Http.


### Os principais componentes da Api HttpClient
A Api HttpClient possui 3 componentes principais, são eles:
 * **HttpClient**: É o cliente Http utilizado enviar e obter o retorno de requisições Http.
 * **HttpRequest**: Uma solicitação Http criada por meio de um construtor no qual são informados tipo de requisição, uri de consulta entre outras 
 propriedades.
 * **HttpResponse**: Este componente é resultado do processamento de um HttpRequest, o mesmo contém o retorno da solicitação Http.
 

### Criando um HttpClient
A criação de um HttpClient pode ser feita de duas formas, sendo elas criar um HttpClient com as configurações default do mesmo ou criar 
um HttpClient com configurações personalizadas.<br/>
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

Como vimos no exemplo acima para criar um HttpClient basta invocar o método estático **newHttpClient()** da classe **HttpClient**.<br/>
Para criar um HttpClient personalizado invocamos o método estático **newBuilder()** da classe **HttpClient**, ao utilizar o método **newBuilder()** precisamos especificar 
as configurações do mesmo, no exemplo acima especificamos as configurações **connectTimeout** e **version** com seus respectivos métodos de configuração, em seguida 
utilizamos o método **build()** para finalizar a criação do HttpClient personalizado.<br/>
Esses dois parâmetros são auto descritivos, além desses existem diversos outros parâmetros que podem ser incluídos na criação de um HttpClient personalizado, a lista completa 
desses parâmetros pode ser encotrada nesse [link](https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpClient.html).


