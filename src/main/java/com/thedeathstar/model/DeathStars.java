package com.thedeathstar.model;

import java.util.List;

/**
 * Created by Jeremy on 6/16/17.
 */
public class DeathStars {

    public List<DeathStar> getDeathstars() {
        return deathStars;
    }

    public void setDeathStars(List<DeathStar> deathStars) {
        this.deathStars = deathStars;
    }

    private List<DeathStar> deathStars;
}