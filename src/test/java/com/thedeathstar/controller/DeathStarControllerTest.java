package com.thedeathstar.controller;

import com.thedeathstar.model.DeathStar;
import com.thedeathstar.model.DeathStars;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import static org.junit.Assert.*;

/**
 * Created by Jeremy on 6/26/17.
 */
public class DeathStarControllerTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void GetDeathStarAssertId() throws Exception {

        DeathStarController controller = new DeathStarController();
        ResponseEntity<DeathStar> re;
        String id;

        re = controller.GetDeathstar("Ds-1");
        id = re.getBody().getId();

        Assert.isTrue(id == "DS-1", "DS-1 ");


    }

    @Test
    public void GetDeathStarAssertName() throws Exception {

        DeathStarController controller = new DeathStarController();
        ResponseEntity<DeathStar> re;
        String name;

        re = controller.GetDeathstar("Ds-1");
        name = re.getBody().getName();

        Assert.isTrue(name == "First Death Star", "Name Not First Deathstar ");

    }


}