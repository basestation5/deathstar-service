package com.thedeathstar.unit.controller;

import com.thedeathstar.controller.ShipController;
import com.thedeathstar.model.Ship;
import com.thedeathstar.repository.ShipRepositoryImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Jeremy on 6/30/17.
 */


public class ShipMockitoControllerTest {


    @Test
    public void GetShipsAssertName()
    {
        //Setup
        List<Ship> ships = new ArrayList();
        Ship ship = new Ship();

        ship.setId(2234);
        ship.setName("SD-101");
        ship.setType("Star Destroyer");
        ship.setCaptain("Caption D. Laserman");

        ships.add(ship);

        ShipRepositoryImpl repo = mock(ShipRepositoryImpl.class);
        when(repo.GetShips()).thenReturn(ships);

        ShipController controller = new ShipController(repo);

        ResponseEntity<List<Ship>> response = controller.GetShips();

        Assert.isTrue(response.getBody().get(0).getName() == "SD-101" );
        Assert.isTrue(response.getBody().get(0).getId() == 2234 );
        Assert.isTrue(response.getBody().get(0).getCaptain() == "Caption D. Laserman" );


    }
}
