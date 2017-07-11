package com.thedeathstar.repository;

import com.thedeathstar.model.DeathStars;
import com.thedeathstar.model.Ship;
import com.thedeathstar.model.Ships;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeremy on 6/30/17.
 */

@Repository
public class ShipRepositoryImpl implements ShipsRepository{

    public List<Ship> GetShips(){

        List<Ship> shipsArray = new ArrayList();
        Ship ship = new Ship();

        ship.setId(3211);
        ship.setName("GR-34");
        ship.setType("Star Destroyer");
        ship.setCaptain("Mitch StarScreamer");

        shipsArray.add(ship);

        return shipsArray;

    }

    public Ship GetShip(int id){

        String url = "http://localhost:8091/ships";

        RestTemplate restTemplate = new RestTemplate();
        Ship ship = restTemplate.getForObject(url, Ship.class);

        return ship;

    }

}
