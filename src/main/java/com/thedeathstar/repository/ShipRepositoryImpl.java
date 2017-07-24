package com.thedeathstar.repository;

import com.thedeathstar.model.Ship;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jeremy on 6/30/17.
 */

@Repository
public class ShipRepositoryImpl implements ShipsRepository{

    @Value("${shipservice.url}")
    private String url = "http://localhost:8091";

    public List<Ship> GetShips(){

        String shipUrl = url + "/ships/";

        RestTemplate restTemplate = new RestTemplate();

        Ship[] shipsArray = restTemplate.getForObject(shipUrl, Ship[].class);

        List<Ship> shipList = Arrays.asList(shipsArray);

        return shipList ;

    }

    //In this use case, for whatever reason I wanted to get ships from another service.
    //This may break some microservice rules...but this is a demo
    public Ship GetShip(int id){

        RestTemplate restTemplate = new RestTemplate();

        String shipUrl = url + "/ships/" + id;

        Ship ship = restTemplate.getForObject(shipUrl, Ship.class);

        return ship;

    }

}
