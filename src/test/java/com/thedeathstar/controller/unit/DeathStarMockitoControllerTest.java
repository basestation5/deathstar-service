package com.thedeathstar.unit.controller;

import com.thedeathstar.controller.DeathStarController;
import com.thedeathstar.model.DeathStar;
import com.thedeathstar.model.DeathStars;
import com.thedeathstar.repository.DeathStarRepositoryImpl;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Jeremy on 6/26/17.
 */
public class DeathStarMockitoControllerTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void GetDeathStarAssertIdAndName() throws Exception {

        //Setup
        DeathStar mockDs = new DeathStar();
        mockDs.setId("DS-1");
        mockDs.setName("First Death Star");
        DeathStarRepositoryImpl mockRepo = mock(DeathStarRepositoryImpl.class);
        when(mockRepo.GetDeathstar()).thenReturn(mockDs);

        DeathStarController controller = new DeathStarController(mockRepo);
        ResponseEntity<DeathStar> response;
        String id;
        String name;

        //Execute

        response = controller.GetDeathstar("DS-1");
        id = response.getBody().getId();
        name = response.getBody().getName();

        //Assert
        Assert.isTrue(id == "DS-1", "DS-1 not found ");
        Assert.isTrue(name == "First Death Star", "Name not First Death Star ");



    }


    @Test
    public void GetDeathStarsAssertFirstElementName() throws Exception {

        //Setup

        DeathStar mockDeathStar = new DeathStar();
        mockDeathStar.setId("DS-1");
        mockDeathStar.setName("First Death Star");
        
        List<DeathStar> list = new ArrayList<>();
        list.add(mockDeathStar);

        DeathStarRepositoryImpl mockRepo = mock(DeathStarRepositoryImpl.class);
        when(mockRepo.GetDeathstars()).thenReturn(list);

        DeathStarController controller = new DeathStarController(mockRepo);

        //Execute

        ResponseEntity<DeathStars> response = controller.GetDeathstars();
        DeathStars responseStars = response.getBody();

        DeathStar responseStar = responseStars.getDeathStars().get(0);

        //Assert
        Assert.isTrue( responseStar.getName() == "First Death Star", "Name not First Death Star ");

    }


}