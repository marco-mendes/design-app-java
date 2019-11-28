package example.weather;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;

import com.github.tomakehurst.wiremock.WireMockServer;

import example.helper.FileLoader;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WeatherAcceptanceTest {

    @LocalServerPort
    private int port;

    private WireMockServer wireMockServer;

    @BeforeEach
    public void configureSystemUnderTest() {
        this.wireMockServer = new WireMockServer(options()
                .port(8089)
        );
        this.wireMockServer.start();
        configureFor(this.wireMockServer.port());
    }

    @AfterEach
    public void stopWireMockServer() {
        this.wireMockServer.stop();
    }

    @Test
    public void shouldReturnYesterdaysWeather() throws Exception {
    	wireMockServer.stubFor(get(urlPathEqualTo("/some-test-api-key/53.5511,9.9937"))
                .willReturn(aResponse()
                        .withBody(FileLoader.read("classpath:weatherApiResponse.json"))
                        .withHeader(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withStatus(200)));

        when()
                .get(String.format("http://localhost:%s/weather", port))
                .then()
                .statusCode(is(200))
                .body(containsString("Rain"));
    }
}
