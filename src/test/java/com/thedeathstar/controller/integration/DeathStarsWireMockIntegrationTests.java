package com.thedeathstar.controller.integration;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.thedeathstar.DeathStarApplication;
import com.thedeathstar.controller.ShipController;
import com.thedeathstar.model.Ship;
import com.thedeathstar.model.Ships;
import com.thedeathstar.repository.ShipRepositoryImpl;
import org.junit.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.hamcrest.MatcherAssert.assertThat;


public class DeathStarsWireMockIntegrationTests {

    RestTemplate restTemplate;
    ResponseEntity response;

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(wireMockConfig().port(8091).httpsPort(8443));

    @Before
    public void setup() throws Exception {
        restTemplate = new RestTemplate();
        response = null;
    }

    @Test
    public void GetSingleShipVerifyName(){

        //Setup
        stubFor(get(urlEqualTo("/ships/3211"))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", APPLICATION_JSON_VALUE)
                        .withBody("{\"name\":\"TIE Interceptor 402\",\"id\":402,\"captain\":\"Mitch StarScreamer\",\"type\":\"TIE Interceptor\",\"description\":\"TIE fighter, Dagger-shaped wings, four laser cannons\"}")));

        //Verify Mock
        response = restTemplate.getForEntity("http://localhost:8091/ships/3211", String.class);
        assertThat("Verify Status Code", response.getStatusCode().equals(HttpStatus.OK));

        //Act
        ShipController controller = new ShipController(new ShipRepositoryImpl());
        Ship ship = controller.GetShip(3211).getBody();

        //Assert
        assertThat("Wrong Captain Name", ship.getCaptain().equals("Mitch StarScreamer"));
        assertThat("Wrong Captain Name", ship.getType().equals("TIE Interceptor"));


    }

    @Test
    public void GetShipsVerifyCount(){

        //Setup
        stubFor(get(urlEqualTo("/ships/"))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", APPLICATION_JSON_VALUE)
                        .withBody("[{\"name\":\"TIE Interceptor 402\",\"id\":402,\"captain\":\"Mitch StarScreamer\",\"type\":\"TIE Interceptor\",\"description\":\"TIE fighter, Dagger-shaped wings, four laser cannons\"},{\"name\":\"TIE Fighter 107\",\"id\":107,\"captain\":\"Dan Astroidman\",\"type\":\"TIE Fighter\",\"description\":\"Twin ion engine (TIE), Fighter\"}]")));

        //Verify Mock
        response = restTemplate.getForEntity("http://localhost:8091/ships/", String.class);
        assertThat("Verify Status Code", response.getStatusCode().equals(HttpStatus.OK));

        //Act
        ShipController controller = new ShipController(new ShipRepositoryImpl());
        List<Ship> ships = controller.GetShips().getBody();

        //Assert
        assertThat("Wrong Captain Name", ships.size() == 2);



    }


}
