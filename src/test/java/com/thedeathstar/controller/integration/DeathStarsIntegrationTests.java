package com.thedeathstar.controller.integration;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.thedeathstar.controller.ShipController;
import com.thedeathstar.model.Ship;
import com.thedeathstar.repository.ShipRepositoryImpl;
import com.thedeathstar.repository.ShipsRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Jeremy on 7/10/17.
 */
public class DeathStarsIntegrationTests {

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

        stubFor(get(urlEqualTo("/ships"))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", APPLICATION_JSON_VALUE)
                        .withBody("{\"name\":\"GR-34\",\"id\":3211,\"captain\":\"Mitch StarScreamer\",\"type\":\"Star Destroyer\"}")));

        response = restTemplate.getForEntity("http://localhost:8091/ships", String.class);
        assertThat("Verify Status Code", response.getStatusCode().equals(HttpStatus.OK));

        ShipRepositoryImpl shipRepo = new ShipRepositoryImpl();
        ShipController controller = new ShipController(shipRepo);

        Ship ship = controller.GetShip(3211).getBody();
        String captainName = ship.getCaptain();

        assertThat("Wrong Captain Name", captainName.equals("Mitch StarScreamer"));


    }


}
