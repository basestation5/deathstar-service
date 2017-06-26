package com.thedeathstar.repository;

import com.thedeathstar.model.DeathStar;
import com.thedeathstar.model.DeathStars;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eg5267 on 6/19/17.
 */
@Repository
public  class DeathStarRepositoryImpl implements DeathStarRepository{

    public DeathStars GetDeathstars() {

        DeathStars stars = new DeathStars();

        List<DeathStar> list = new ArrayList<>();

        list.add(GetDS1());
        list.add(GetDS2());

        stars.setDeathStars(list);

        return stars;
    }

    public DeathStar GetDeathstar() {

        return GetDS1();
    }

    private DeathStar GetDS1(){

        DeathStar ds1 = new DeathStar();

        ds1.setId("DS-1");
        ds1.setName("First Death Star");

        return ds1;
    }

    private DeathStar GetDS2(){

        DeathStar ds2 = new DeathStar();

        ds2.setId("DS-2");
        ds2.setName("Second Death Star");

        return ds2;
    }

}