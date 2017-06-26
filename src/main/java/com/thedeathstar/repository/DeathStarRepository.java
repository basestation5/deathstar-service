package com.thedeathstar.repository;

import com.thedeathstar.model.DeathStar;
import com.thedeathstar.model.DeathStars;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eg5267 on 6/19/17.
 */
public  class DeathStarRepository {

    public DeathStars GetDeathstars() {

        DeathStars stars = new DeathStars();

        List<DeathStar> list = new ArrayList<DeathStar>();

        list.add(GetDS1());

        stars.setDeathstars(list);

        return stars;
    }

    public DeathStar GetDS1(){

        DeathStar ds1 = new DeathStar();

        ds1.setId("DS-1");
        ds1.setName("First Death Star");

        return ds1;
    }

}