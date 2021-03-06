## Introdução ao Spring Cloud Gateway

### Material de referência

[O que é um API Gateway?](https://sensedia.com/api/api-gateway-governando-a-arquitetura-de-microservices/)<br/>
[Criando um API Gateway com SpringCloudGateway](https://spring.io/guides/gs/gateway/)<br/>
[Criando um API Gateway de forma programática e via Yaml](https://www.baeldung.com/spring-cloud-gateway)<br/>

### Introdução

Este tutorial explica como usar o Spring Cloud Gateway

### O que você irá construir

Neste laboratório você irá criar um API Gateway utilizando o **Spring Cloud Gateway**.

### O que você irá precisar

- Seu IDE favorito
- JDK 11
- Maven 3.2 ou superior

### Obtendo o código base para este realizar este tutorial

Possuímos um código que pode ser utilizado como base para completar este tutorial, o mesmo pode ser encontrado neste [link](./exemplos/base/) e pode ser importado em seu IDE.<br/>
É importante analisar o arquivo **pom.xml** do projeto para verificar as dependências que estão sendo utilizadas nele.

### Criando uma rota simples

O Spring Cloud Gateway usa rotas para processar requisições de serviços downstream. Neste tutorial, encaminharemos todos os nossos requests para o 
[HTTPBin](https://httpbin.org/). As rotas podem ser configuradas de duas maneiras, sendo elas:
 * Criar as rotas de forma programática: Suas rotas serão criadas de forma programática, ou seja, você terá que criar Beans para definir suas rotas via código Java.
 * Criar as rotas via Yaml utilizando [Route Predicate Factory](https://cloud.spring.io/spring-cloud-gateway/reference/html/#gateway-request-predicates-factories) e 
 [GatewayFilter Factory](https://cloud.spring.io/spring-cloud-gateway/reference/html/#gatewayfilter-factories): 
 Suas configurações de rotas serão criadas através de um arquivo de configuração do SpringBoot que será carregado toda vez que a aplicação for iniciada.

#### Criando uma rota simples de forma programática
Para começar, crie um novo Bean do tipo **RouteLocator** em **Application.java**.

```java
// Localização para criação deste Bean: src/main/java/gateway/Application.java
@Bean
public RouteLocator myRoutes(RouteLocatorBuilder builder) {
    return builder.routes().build();
}
```

O método **myRoutes** acima utiliza um **RouteLocatorBuilder** que pode ser facilmente usado para criar rotas. Além de apenas criar rotas, o **RouteLocatorBuilder** permite adicionar predicates e filtros às suas rotas, para que você possa manipular a rota com base em determinadas condições, bem como alterar a requisição/resposta como achar melhor.

Vamos criar uma rota que encaminha uma requisição para https://httpbin.org/get quando uma requisição é feita ao Gateway utilizando o path **/get**. Em nossa configuração dessa rota, adicionaremos um filtro que adicionará um cabeçalho(RequestHeader) em nossa requisição com o nome "Hello" e com o valor "World", essa operação será realizada antes de nossa requisição ser roteada.

```java
// Esta alteração deve ser realizada no Bean myRoutes que criamos logo acima.
@Bean
public RouteLocator myRoutes(RouteLocatorBuilder builder) {
    return builder.routes()
        .route(p -> p
            .path("/get")
            .filters(f -> f.addRequestHeader("Hello", "World"))
            .uri("http://httpbin.org:80"))
        .build();
}
```

#### Criando uma rota simples utilizando Yaml
Para criarmos uma rota simples utilizando Yaml precisaremos utilizar um arquivo de configuração do SpringBoot, este arquivo geralmente se chama **application.yml** 
e normamlmente fica localizado dentro do seguinte diretório: **src/main/resources/**<br/>
Podemos realizar as mesmas configurações que fizemos no exemplo acima utilizando Yaml, para isso insira o seguinte conteúdo no arquivo de configuração 
**application.yml**:
```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: addrequestheader_route
          uri: http://httpbin.org:80
          predicates:
            - Path=/get
          filters:
            - AddRequestHeader=Hello, World
```
Com apenas este trecho inserido em nosso arquivo application.yml realizamos a mesma configuração que havíamos feito de forma programática no tópico anterior.

**_Observação importante_**: Arquivos com a extensão **.yml** são arquivos sensíveis no qual não podemos em hipótese alguma utilizar o caractere TAB, os espaçamentos devem ser 
todos feitos utilizando o caracter de espaço simples.

#### Testando nosso Gateway
Para testar nosso Gateway é muito simples, basta executar **Application.java**, ele deve ser executado na porta 8080. Depois que o aplicativo estiver em execução, faça uma requisição para http://localhost:8080/get. Você pode fazer isso usando cURL emitindo o seguinte comando no seu terminal.

```java
curl http://localhost:8080/get
```

Você deve receber uma resposta semelhante a esta:

```java
{
  "args": {},
  "headers": {
    "Accept": "*/*",
    "Connection": "close",
    "Forwarded": "proto=http;host=\"localhost:8080\";for=\"0:0:0:0:0:0:0:1:56207\"",
    "Hello": "World",
    "Host": "httpbin.org",
    "User-Agent": "curl/7.54.0",
    "X-Forwarded-Host": "localhost:8080"
  },
  "origin": "0:0:0:0:0:0:0:1, 73.68.251.70",
  "url": "http://localhost:8080/get"
}
```

Observe que **HTTPBin** mostra que o cabeçalho **Hello** com o valor **World** foi enviado na requisição.

### Usando Hystrix

Agora vamos fazer algo um pouco mais interessante. Como os serviços por trás do Gateway podem potencialmente se comportar mal, afetando nossos clientes, podemos querer 
envolver as rotas que criamos com [Circuit Breakers](https://microservices.io/patterns/reliability/circuit-breaker.html). Você pode fazer isso no Spring Cloud Gateway 
usando o Hystrix. Isso é implementado por meio de um filtro simples que você pode adicionar aos seus requests. Vamos criar outra rota para demonstrar isso.

Neste exemplo, aproveitaremos a API de atraso do HTTPBin que aguarda um certo número de segundos antes de enviar uma resposta. Como essa API pode levar muito tempo para 
enviar sua resposta, podemos agrupar a rota que usa essa API em um **HystrixCommand**. 

#### Utilização de forma programática
Adicione uma nova rota ao nosso objeto **RouteLocator** semelhante à seguinte:
```java
// Esta alteração deve ser realizada no Bean myRoutes que criamos na classe Application.java.
@Bean
public RouteLocator myRoutes(RouteLocatorBuilder builder) {
    return builder.routes()
        .route(p -> p
            .path("/get")
            .filters(f -> f.addRequestHeader("Hello", "World"))
            .uri("http://httpbin.org:80"))
        .route(p -> p
            .host("*.hystrix.com")
            .filters(f -> f.hystrix(config -> config.setName("mycmd")))
            .uri("http://httpbin.org:80")).
        build();
}
```

#### Utilização com Yaml
Podemos adicionar uma nova rota em nosso arquivo application.yml da seguinte forma:
```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: addrequestheader_route
          uri: http://httpbin.org:80
          predicates:
            - Path=/get
          filters:
            - AddRequestHeader=Hello, World
        - id: hystrix_route
          uri: http://httpbin.org:80
          predicates:
            - Host=*.hystrix.com
          filters:
            - name: Hystrix
              args:
                name: mycmd
```

Existem algumas diferenças entre essa nova configuração de rota e a anterior que criamos. Por um lado, estamos usando um predicate de Host em vez do predicate de Path. 
Isso significa que, enquanto o host for **hystrix.com**, encaminharemos a requisição para HTTPBin e agruparemos a requisição em um **HystrixCommand**. 
Fazemos isso aplicando um filtro à rota. O filtro Hystrix pode ser configurado usando um objeto de configuração. 
Neste exemplo, estamos apenas dando ao **HystrixCommand** o nome **mycmd**.

Vamos testar esta nova rota. Inicie o aplicativo, mas desta vez vamos fazer uma requisição para **/delay/3**. Também é importante incluir um cabeçalho de host com o host 
**hystrix.com**, caso contrário a requisição não será roteada. Em cURL seria semelhante a isso:

```java
curl --dump-header - --header 'Host: www.hystrix.com' http://localhost:8080/delay/3
```

**Observação:**<br/>
Estamos usando **--dump-header** para ver os cabeçalhos de resposta, o **-** depois de **--dump-header** está dizendo ao cURL para imprimir os cabeçalhos no stdout.

Após executar este comando, você deverá ver o seguinte em seu terminal

```java
HTTP/1.1 504 Gateway Timeout
content-length: 0
```

Como você pode ver, o Hystrix atingiu o tempo limite aguardando a resposta do HTTPBin. Quando o Hystrix atinge o tempo limite, opcionalmente, podemos fornecer um fallback para 
que os clientes não recebam apenas um código **504**, mas algo mais significativo. Em um cenário de produção, você pode retornar alguns dados de um cache, por exemplo, 
mas em nosso exemplo simples, retornamos apenas uma resposta, no lugar disso podemos retornar o corpo de nosso **fallback**.

Para fazer isso, vamos modificar nosso filtro Hystrix para fornecer um URL a ser chamado no caso de um timeout.

#### Utilização de forma programática
```java
// Esta alteração deve ser realizada no Bean myRoutes que criamos na classe Application.java.
@Bean
public RouteLocator myRoutes(RouteLocatorBuilder builder) {
    return builder.routes()
        .route(p -> p
            .path("/get")
            .filters(f -> f.addRequestHeader("Hello", "World"))
            .uri("http://httpbin.org:80"))
        .route(p -> p
            .host("*.hystrix.com")
            .filters(f -> f.hystrix(config -> config
                .setName("mycmd")
                .setFallbackUri("forward:/fallback")))
            .uri("http://httpbin.org:80"))
        .build();
}
```

#### Utilização com Yaml
```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: addrequestheader_route
          uri: http://httpbin.org:80
          predicates:
            - Path=/get
          filters:
            - AddRequestHeader=Hello, World
        - id: hystrix_route
          uri: http://httpbin.org:80
          predicates:
            - Host=*.hystrix.com
          filters:
            - name: Hystrix
              args:
                name: mycmd
                fallbackUri: forward:/fallback
```

Agora, quando o percurso da Hystrix ultrapassar o timeout, ele fará uma chamada a **/fallback** em nossa aplicação Gateway. Vamos adicionar o endpoint **/fallback** ao nosso 
aplicativo.

Em Application.java, adicione a annotation **@RestController** em nível de classe e adicione o seguinte **@RequestMapping** à classe.

```java
// Este método deve ser adicionado em nossa classe Application.java.
@RequestMapping("/fallback")
public Mono<String> fallback() {
    return Mono.just("fallback");
}
```

Nossa classe Application.java ficará semelhante a isso após as alterações:

```java
import reactor.core.publisher.Mono;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder, UriConfiguration uriConfiguration) {
        String httpUri = uriConfiguration.getHttpbin();
        return builder.routes()
            .route(p -> p
                .path("/get")
                .filters(f -> f.addRequestHeader("Hello", "World"))
                .uri(httpUri))
            .route(p -> p
                .host("*.hystrix.com")
                .filters(f -> f
                    .hystrix(config -> config
                        .setName("mycmd")
                        .setFallbackUri("forward:/fallback")))
                .uri(httpUri))
            .build();
    }

    @RequestMapping("/fallback")
    public Mono<String> fallback() {
        return Mono.just("fallback");
    }
}
```
Caso esteja realizando a configuração utilizando Yaml não é necessário criar o Bean **myRoutes**.

Para testar essa nova funcionalidade de fallback, reinicie o aplicativo e emita novamente o seguinte comando cURL:

```java
curl --dump-header - --header 'Host: www.hystrix.com' http://localhost:8080/delay/3
```

Com o fallback no lugar, agora vemos que recebemos o código de resposta 200 do Gateway com o corpo de resposta do fallback.

```java
HTTP/1.1 200 OK
transfer-encoding: chunked
Content-Type: text/plain;charset=UTF-8

fallback
```

### Escrevendo testes

Como bons desenvolvedores, devemos escrever alguns testes para garantir que o nosso Gateway esteja fazendo o que esperamos. Na maioria dos casos, queremos limitar as 
dependências de recursos externos, especialmente em testes de unidade, portanto, não devemos depender do HTTPBin. Uma solução para esse problema é tornar o URI em nossas 
rotas configurável, para que possamos alterar facilmente o URI, se necessário.

#### Implementação programática
Observação importante: Caso esteja utilizando a implementação via Yaml você poderá ir direto para o tópico [Criando a classe de teste](#criando-a-classe-de-teste).

Na classe Application.java, crie uma nova classe chamada **UriConfiguration**.

```java
@ConfigurationProperties
class UriConfiguration {

    private String httpbin = "http://httpbin.org:80";

    public String getHttpbin() {
        return httpbin;
    }

    public void setHttpbin(String httpbin) {
        this.httpbin = httpbin;
    }
}
```

Para habilitar este ConfigurationProperties, também precisamos adicionar uma annotation em nível de classe ao Application.java.

```java
// Adicione essa annotation em nível de classe ao Application.java
@EnableConfigurationProperties(UriConfiguration.class)
```

Vamos utilizar nossa nova classe de configuração no método myRoutes em nossa classe Application.java:

```java
@Bean
public RouteLocator myRoutes(RouteLocatorBuilder builder, UriConfiguration uriConfiguration) {
    String httpUri = uriConfiguration.getHttpbin();
    return builder.routes()
        .route(p -> p
            .path("/get")
            .filters(f -> f.addRequestHeader("Hello", "World"))
            .uri(httpUri))
        .route(p -> p
            .host("*.hystrix.com")
            .filters(f -> f
                .hystrix(config -> config
                    .setName("mycmd")
                    .setFallbackUri("forward:/fallback")))
            .uri(httpUri))
        .build();
}
```

Como você pode ver, em vez de codificar a URL para HTTPBin, estamos obtendo a URL da nossa nova classe de configuração.

No exemplo abaixo possuímos o conteúdo completo de Application.java.

```java
import reactor.core.publisher.Mono;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableConfigurationProperties(UriConfiguration.class)
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder, UriConfiguration uriConfiguration) {
        String httpUri = uriConfiguration.getHttpbin();
        return builder.routes()
            .route(p -> p
                .path("/get")
                .filters(f -> f.addRequestHeader("Hello", "World"))
                .uri(httpUri))
            .route(p -> p
                .host("*.hystrix.com")
                .filters(f -> f
                    .hystrix(config -> config
                        .setName("mycmd")
                        .setFallbackUri("forward:/fallback")))
                .uri(httpUri))
            .build();
    }

    @RequestMapping("/fallback")
    public Mono<String> fallback() {
        return Mono.just("fallback");
    }
}

@ConfigurationProperties
class UriConfiguration {

    private String httpbin = "http://httpbin.org:80";

    public String getHttpbin() {
        return httpbin;
    }

    public void setHttpbin(String httpbin) {
        this.httpbin = httpbin;
    }
}
```

#### Criando a classe de teste
Crie uma nova classe chamada **ApplicationTest** em **src/main/test/java/gateway**. Na nova classe, adicione o seguinte conteúdo.

```java
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		properties = {"httpbin=http://localhost:${wiremock.server.port}"})
@AutoConfigureWireMock(port = 0)
public class ApplicationTest {

	@Autowired
	private WebTestClient webClient;

	@Test
	public void contextLoads() throws Exception {
		stubFor(get(urlEqualTo("/get"))
				.willReturn(aResponse()
					.withBody("{\"headers\":{\"Hello\":\"World\"}}")
					.withHeader("Content-Type", "application/json")));
		stubFor(get(urlEqualTo("/delay/3"))
			.willReturn(aResponse()
				.withBody("no fallback")
				.withFixedDelay(3000)));

		webClient
			.get().uri("/get")
			.exchange()
			.expectStatus().isOk()
			.expectBody()
			.jsonPath("$.headers.Hello").isEqualTo("World");

		webClient
			.get().uri("/delay/3")
			.header("Host", "www.hystrix.com")
			.exchange()
			.expectStatus().isOk()
			.expectBody()
			.consumeWith(
				response -> assertThat(response.getResponseBody()).isEqualTo("fallback".getBytes()));
	}
}

```

Na verdade, nosso teste está aproveitando o WireMock do Spring Cloud Contract para suportar um servidor que pode simular as APIs do HTTPBin. A primeira coisa a observar é o uso do **@AutoConfigureWireMock(port = 0)**. Esta annotation iniciará o WireMock em uma porta aleatória para nós.

Em seguida, observe que estamos aproveitando nossa classe **UriConfiguration** e configurando a propriedade **httpbin** na annotation **@SpringBootTest** para o servidor 
WireMock em execução localmente. No teste, configuramos "stubs" para as APIs HTTPBin que chamamos via Gateway e mock do comportamento que esperamos. 
Finalmente, usamos o **WebTestClient** para realmente fazer requisições ao Gateway e validar as respostas.

### Mais alguns exemplos
Abordaremos neste tópico mais alguns exemplos utilizando Route Predicate Factories e GatewayFilter Factories.

#### Header Route Predicate Factory
O Header Route Predicate Factory usa dois parâmetros: o nome do cabeçalho e uma expressão regular. Esse predicate corresponde a um cabeçalho que corresponde à expressão regular:
```yaml
spring:
  cloud:
    gateway:
      routes:
      - id: header_route
        uri: http://example.com
        predicates:
        - Header=X-Request-Id, \d+
```

A configuração programática pode ser feita da seguinte forma:
```java
//..route definition
.route(r -> r.header("X-Request-Id", "\\d+")
.id("header_route")
.uri("http://example.com")
```

#### Host Route Predicate Factory
O Host Route Predicate Factory usa um parâmetro: o padrão do nome do host. O padrão é um padrão no estilo Ant com "." Como separador.
```yaml
spring:
  cloud:
    gateway:
      routes:
      - id: host_route
        uri: http://example.com
        predicates:
        - Host=**.example.com
```

A configuração programática pode ser feita da seguinte forma:
```java
//..route definition
.route(r -> r.host("**.example.com")
.id("host_route")
.uri("http://example.com")
```

#### Path Route Predicate Factory
O Path Route Predicate Factory usa um parâmetro: um padrão Spring PathMatcher:
```yaml
spring:
  cloud:
    gateway:
      routes:
      - id: path_route
        uri: http://baeldung.com
        predicates:
        - Path=/articles/{articleId}
```

A configuração programática pode ser feita da seguinte forma:
```java
//..route definition
.route(r -> r.path("/articles/"+articleId)
.id("path_route")
.uri("http://example.com")
```

#### AddRequestParameter GatewayFilter Factory
O AddRequestParameter GatewayFilter Factory usa um parâmetro de nome e valor:
```yaml
spring:
  cloud:
    gateway:
      routes:
      - id: addrequestparameter_route
        uri: http://baeldung.com
        predicates:
        - Path=/articles
        filters:
        - AddRequestParameter=foo, bar
```

A configuração programática pode ser feita da seguinte forma:
```java
//...route definition
.route(r -> r.path("/articles")
  .filters(f -> f.addRequestParameter("foo", "bar"))
  .uri("http://example.com")
  .id("addrequestparameter_route")
```

#### AddResponseHeader GatewayFilter Factory
O AddResponseHeader GatewayFilter Factory usa um parâmetro de nome e valor:
```yaml
spring:
  cloud:
    gateway:
      routes:
      - id: addrequestheader_route
        uri: http://baeldung.com
        predicates:
        - Path=/articles
        filters:
        - AddResponseHeader=X-SomeHeader, Bar
```

A configuração programática pode ser feita da seguinte forma:
```java
//...route definition
.route(r -> r.path("/articles")
  .filters(f -> f.addResponseHeader("X-SomeHeader", "Bar"))
  .uri("http://example.com")
  .id("addresponseheader_route")
```

### Conclusão

Parabéns! Você acabou de criar seu primeiro aplicativo Spring Cloud Gateway!<br/>
Além do que foi mostrado neste laboratório existem vários Route Predicate Factories e GatewayFilter Factories que podemos utilizar, caso queira conferir a lista completa 
você pode encontrá-la neste [link](https://cloud.spring.io/spring-cloud-gateway/reference/html/).<br/>
Caso queira verificar o código completo você pode encontrá-lo neste [link](./exemplos/completo/).
